package gerenciamento;
import java.util.Scanner;
import entidades.Artigo;
import entidades.Pesquisador;
import entidades.Projeto;

public class Interface {
	int P, A = 0; 
	private Pesquisador pesquisadores[] = new Pesquisador[100];
	private Artigo artigos[] = new Artigo[50];
	private Projeto projetos[] = new Projeto[50];
	private Artigo aux = new Artigo();
	Pesquisador retornavel;

	
	public void execute() {
		Scanner ler = new Scanner(System.in);
		int j,flag=0,i,qntPES,Nregistrados,n = -1;
		String nome,uni;
		
		while ( n != 0 ) {
			n = menu(ler);
			ler.nextLine();
			if ( n == 1 ) {
				artigos[A] = new Artigo();
				System.out.println("Diga a quantidade de pesquisadores envolvidos: ");
				qntPES = ler.nextInt();
				artigos[A].inicializaEnvolvidos(qntPES);
				System.out.println("DIGITE QUANTOS PESQUISADORES NÃO SÃO REGISTRADOS NO SISTEMA");
				System.out.println("(Caso todos estejam, digite 0)");
				Nregistrados = ler.nextInt();
				ler.nextLine();

				for ( i = 0 ; i < Nregistrados ; i ++ ) {
				
					pesquisadores[P] = teste(ler);
					P++;
				}
				
				System.out.println("=========FAZER BUSCA DOS PESQUISADORES=======");
				for ( i = 0 ; i < qntPES ; i ++) {
					System.out.println("DIGITE O NOME DO PESQUISADOR");
					nome = ler.nextLine();
					flag = 0;
					for( j = 0 ; j < P ; j ++) {
						if(nome.equals(pesquisadores[j].getNome())) {
							retornavel = pesquisadores[j];
							artigos[A].setEnvolvidos(retornavel);
							System.out.println("====PESQUISADOR ENCONTRADO====");
							flag = 1;
						}
						
					}
					if ( flag != 1 ) {
						System.out.println("====PESQUISADOR NÃO ENCONTRADO=====");
						i--;
					}
				}
				System.out.println("DIGITE O TITULO DO ARTIGO: ");
				artigos[A].setTituloArt(ler.nextLine());
				System.out.println("DIGITE O TITULO DA REVISTA: ");
				artigos[A].setTituloRev(ler.nextLine());
				System.out.println("DIGITE O ANO: ");
				artigos[A].setAno(ler.nextInt());
				A++;
				System.out.println("==============================");
				System.out.println("=ARTIGO REGISTRADO COM SUCESSO=");
				System.out.println("==============================");

				
			} else if( n == 2 ) {
				// RREGISTRAR PROJETO
				System.out.println("Diga a quantidade de pesquisadores envolvidos: ");
				qntPES = ler.nextInt();
				aux.inicializaEnvolvidos(qntPES);
				System.out.println("DIGITE QUANTOS PESQUISADORES NÃO SÃO REGISTRADOS NO SISTEMA");
				System.out.println("(Caso todos estejam, digite 0)");
				Nregistrados = ler.nextInt();
				ler.nextLine();
				
				for ( i = 0 ; i < Nregistrados ; i ++ ) {
					pesquisadores[P] = teste(ler);
					P++;
				}
				System.out.println("=========FAZER BUSCA DOS PESQUISADORES NO BANCO DE DADOS=======");
				for ( i = 0 ; i < qntPES ; i ++) {
					System.out.println("DIGITE O NOME DO PESQUISADOR");
					nome = ler.nextLine();
					flag = 0;
					for( j = 0 ; j < P ; j ++) {
						if(nome.equals(pesquisadores[j].getNome())) {
							// COLOCAR OS PESQUISADORES DENTRO DO ARRAY DE PESQUISADORES DO PROJETO
							System.out.println("====PESQUISADOR ENCONTRADO====");
							flag = 1;
							break;
						}
						
					}
					if ( flag != 1 ) {
						System.out.println("====PESQUISADOR NÃO ENCONTRADO=====");
						i--;
					}
				}
			}else if(n == 3 ) {
				// LISTAR PESQUISADORES DA MESMA FACULDADE
				System.out.println("Digite o nome da universidade: ");
				uni = ler.nextLine();
				flag = 0;
				for( i = 0 ; i < P ; i ++ ) {
					if ( pesquisadores[i].getUniversidade().equals(uni)) {
						flag = 1;
						System.out.println("Pesquisador: " + pesquisadores[i].getNome());
					}
				}
				if( flag == 0 ) {
					System.out.println("Nenhum pesquisador encontrado na universidade " + uni );
				}
			}else if(n == 4 ) {
				//  LISTAR AUTORES DE UM DETERMINADO ARTIGO
			}else if(n == 5 ) {
				// LISTAR PESQUISADORES DE UM DETERMINADO PROJETO
			}else if( n == 6 ) {
				// LISTAR TODOS OS PROJETOS DE UM DETERMINADO PESQUISADOR 
			}else if(n == 7) {
				// LISTAR TODOS OS PESQUISADORES
				System.out.println("=====PESQUISADORES=====");
				for ( i = 0 ; i < P ; i ++ ) {
					System.out.println("Nome: " + pesquisadores[i].getNome());
				}
			}
		}
		
	}

	private int menu(Scanner ler) {
		int n;
		System.out.println("=====MENU=====");
		System.out.println("0 - SAIR");//*
		System.out.println("1 - REGISTRAR ARTIGO");//
		System.out.println("2 - REGISTRAR PROJETO");
		System.out.println("3 - LISTAR PESQUISADORES DE UMA MESMA FACULDADE");//*
		System.out.println("4 - LISTAR OS AUTORES DE UM DETERMINADO ARTIGO");
		System.out.println("5- LISTAR PESQUISADORES DE UM DETERMINADO PROJETO");
		System.out.println("6 - LISTAR TODOS OS PROJETOS DE UM DETERMINADO PESQUISADOR");
		System.out.println("7 - LISTAR PESQUISADORES");//*


		n = ler.nextInt();
		return n;
	}
	private Pesquisador teste(Scanner ler) {
		Pesquisador ret = new Pesquisador();
		System.out.println("====REGISTRO DE PESQUISADOR====");
		System.out.println("DIGITE O NOME DO PESQUISADOR: ");
		ret.setNome(ler.nextLine());
		System.out.println("DIGITE A AREA: ");
		ret.setArea(ler.nextLine());
		System.out.println("DIGITE A UNIVERSIDADE: ");
		ret.setUniversidade(ler.nextLine());
		System.out.println("==============================");
		System.out.println("=PESQUISADOR REGISTRADO COM SUCESSO=");
		System.out.println("==============================");
		
		return ret;

	}


}
