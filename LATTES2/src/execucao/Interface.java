package execucao;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Artigo;
import entidades.Pesquisador;
import entidades.Projeto;

public class Interface {
	private ArrayList<Pesquisador>Pesquisadores;
	private ArrayList<Artigo>Artigos;
	private ArrayList<Projeto> Projetos;
	private GeraDados gerador = new GeraDados();
	
	
	
	public void execute() {
		int n = -1,i;
		Scanner ler = new Scanner(System.in);
		int nPN,flag;
		String aux;
		Pesquisadores = gerador.getPesquisadores();
		Artigos = gerador.getArtigos();
		Projetos = gerador.getProjetos();
		while ( n != 0 ) {
			n = menu(ler);
			ler.nextLine();
			if ( n == 1 ) {
				System.out.println("=========");
				System.out.println("Digite quantos dos pesquisadores envolvidos NÃO estão registrados no sistema");
				System.out.println("(caso todos estejam, digite 0");
				nPN = ler.nextInt();
				ler.nextLine();
				for ( i = 0 ; i < nPN; i ++ ) {
					Pesquisadores.add(registraP(ler));
				}
				Artigos.add(registraA(ler));
				System.out.println("----ARTIGO REGISTRADO COM SUCESSO----");
			}else if( n == 2 ) {
				System.out.println("=========");
				System.out.println("Digite quantos pesquisadores nao estao registrados no sistema ");
				System.out.println("(caso todos estejam, digite 0");
				nPN = ler.nextInt();
				ler.nextLine();
				for ( i = 0 ; i < nPN ; i ++ ) {
					Pesquisadores.add(registraP(ler));
				}
				Projetos.add(registraPRO(ler));
				System.out.println("----PROJETO REGISTRADO COM SUCESSO----");
				
			}else if( n == 3 ) {
				System.out.println("======PESQUISADORES=====");
				for( Pesquisador a : Pesquisadores ) {
					System.out.println("Nome: " + a.getNome());
				}
			}else if( n == 4 ) {
				System.out.println("---LISTAR PESQUISADORES DE UMA MESMA UNIVERSIDADE---");
				System.out.println("Digite o nome da univesidade: ");
				aux = ler.nextLine();
				flag = 0;
				for( Pesquisador a : Pesquisadores ) {
					if(a.getUniversidade().equals(aux)) {
						System.out.println("Nome: " + a.getNome());
						flag = 1;
					}
				}
				if( flag == 0 ) {
					System.out.println("Nenhum pesquisador no sistema esta nessa universidade");
				}
				System.out.println("------------------");
			}else if( n == 5 ) {
				System.out.println("====LISTAR PESQUISADORES DE UM DETERMINADO PROJETO====");
				System.out.println("Digite o titulo do projeto: ");
				aux = ler.nextLine();
				System.out.println("---PESQUISADORES---");
				for( Projeto a : Projetos ) {
					if ( a.getTitulo().equals(aux)) {
						for ( Pesquisador b : a.getEnvolvidos() ) {
							System.out.println("Nome: " + b.getNome());
						}
						break;
					}
				}
				
			}else if( n == 6 ) {
				System.out.println("====LISTAR PESQUISADORES DE UM DETERMINADO ARTIGO====");
				System.out.println("Digite o titulo do artigo");
				aux = ler.nextLine();
				for ( Artigo a : Artigos ) {
					if(a.getTitulo().equals(aux)) {
						System.out.println("--PESQUISADORES--");
						for ( Pesquisador b : a.getEnvolvidos() ) {
							System.out.println("Nome : " + b.getNome());
						}
					}
				}
				
			}else if( n == 7 ) {
				System.out.println("====LISTAR TODOS OS PROJETOS DE UM DETERMINADO PESQUISADOR====");
				System.out.println("Digite o nome do pesquisador");
				aux = ler.nextLine();
				flag = 0;
				for ( Pesquisador a : Pesquisadores ) {
					if(a.getNome().equals(aux)) {
						flag = 1;
					}
				}
				if ( flag == 0 ) {
					System.out.println("Pesquisador nao encontrado no sistema!");
				}else {
					System.out.println("====PROJETOS====");
					int f = 0;
					for ( Projeto a : Projetos ) {
						for ( Pesquisador b : a.getEnvolvidos() ) {
							if(b.getNome().equals(aux) ) {
								System.out.println("Titulo: " + a.getTitulo());
								f = 1;
								break;
							}
						}
					}
					if( f == 0 ) {
						System.out.println("Nenhum projeto encontrado");
					}
					System.out.println("====ARTIGOS====");
					f = 0;
					for ( Artigo a : Artigos ) {
						for( Pesquisador b : a.getEnvolvidos() ) {
							if(b.getNome().equals(aux) ) {
								System.out.println("Titulo : " + a.getTitulo());
								f = 1;
								break;
							}
							
						}
					}
					if ( flag == 0 ) {
						System.out.println("Nenhum artigo encontrado");
					}
				}
				
			}else {
				System.out.println("OBRIGADO POR UTILIZAR O SISTEMA");
			}
		}
	}
	
	private int menu(Scanner ler) {
		int n;
		
		System.out.println("======MENU=====");
		System.out.println("0 - SAIR"); // *
		System.out.println("1 - REGISTRAR ARTIGO"); // *
		System.out.println("2 - REGISTRAR PROJETO"); // *
		System.out.println("3 - LISTAR TODOS PESQUISADORES");// *
		System.out.println("4 - LISTAR PESQUISADORES DE UMA MESMA FACULDADE ");// *
		System.out.println("5 - LISTAR OS PESQUISADORES DE UM DETERMINADO PROJETO"); //
		System.out.println("6 - LISTAR PESQUISADORES DE UM DETERMINADO ARTIGO"); //
		System.out.println("7 - LISTAR TODOS OS PROJETOS DE UM DETERMINADO PESQUISADOR");


		
		n = ler.nextInt();
		return n;
	}
	private Pesquisador registraP(Scanner ler) {
		System.out.println("==========REGISTRO DE PESQUISADOR=========");
		System.out.println("Digite seu nome: ");
		String nome = (ler.nextLine());
		System.out.println("Digite a universidade: ");
		Pesquisador ret = new Pesquisador(nome, ler.nextLine());
		System.out.println("Digite a area de atuacao: ");
		ret.setArea(ler.nextLine());

		
		return ret;
		
	}
	private Artigo registraA(Scanner ler) {
		System.out.println("==========REGISTRO DE ARTIGOS========");
		System.out.println("Digite o titulo do artigo: ");
		String titulo = ler.nextLine();
		System.out.println("Digite o titulo de revista: ");
		String tituloREV = ler.nextLine();
		
		System.out.println("----LINKANDO OS PESQUISADORES AO ARTIGO-----");
		System.out.println("Digite quantos pesquisadores estao envolvidos no artigo: ");
		int i,nP = ler.nextInt();
		ler.nextLine();
		int flag;
		String nome;
		ArrayList<Pesquisador>pesq = new ArrayList<Pesquisador>();
		for ( i = 0 ; i < nP ; i ++ ) {
			flag = 0;
			System.out.println("-----------------");
			System.out.println("Digite o nome EXATO do pesquisador");
			nome = ler.nextLine();
			for(Pesquisador a : Pesquisadores) {
				if(a.getNome().equals(nome)) {
					System.out.println("PESQUISADOR ENCONTRADO E LINKADO AO ARTIGO");
					flag = 1;
					pesq.add(a);
					break;
				}
			}
			if( flag == 0 ) {
				System.out.println("Pesqusiador não encontrado");
				i--;
			}
			
		}
		Artigo ret = new Artigo(titulo,pesq);
		ret.setTituloREV(tituloREV);
		System.out.println("Digite o ano que o artigo foi feito: ");
		ret.setAno(ler.nextInt());
		ler.nextLine();
		
		
		
		return ret;
	}
	private Projeto registraPRO(Scanner ler) {
		System.out.println("========REGISTRO DE PROJETO=====");
		System.out.println("Digite o titulo do projeto: ");
		String titulo = (ler.nextLine());
		int i,flag;
		String nome;
		System.out.println("----LINKANDO PESQUISADORES AO PROJETO----");
		System.out.println("Digite quantos pesquisadores fazem parte do projeto");
		int nP = ler.nextInt();
		ler.nextLine();
		ArrayList<Pesquisador>pesq = new ArrayList<Pesquisador>();
		for ( i = 0 ; i < nP ; i ++ ) {
			System.out.println("Digite o nome EXATO do pesquisador: ");
			nome = ler.nextLine();
			flag = 0;
			for ( Pesquisador a : Pesquisadores ) {
				if(a.getNome().equals(nome)) {
					System.out.println("--PESQUISADOR ENCONTRADO--");
					pesq.add(a);
					flag = 1;
				}
			}
			if( flag == 0 ) {
				System.out.println("--PESQUISADOR NAO ENCONTRADO--");
				i--;
			}
			
		}
		Projeto ret = new Projeto(titulo,pesq);

		ret.setDescricao(ler.nextLine());
		System.out.println("Digite a data de inicio: dd/mm/aa ");
		ret.setDataInicio(ler.nextLine());
		System.out.println("Digite a data final : dd/mm/aa ");
		ret.setDataFim(ler.nextLine());		
		return ret;
	}

}
