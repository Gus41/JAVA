package execucao;

import java.util.ArrayList;
import java.util.Scanner;

import Persistencia.Dado;
import Persistencia.PersistidorTXT;
import entidades.Artigo;
import entidades.Data;
import entidades.Pesquisador;
import entidades.Projeto;

public class Interface {
	private ArrayList<Pesquisador>Pesquisadores;
	private ArrayList<Artigo>Artigos;
	private ArrayList<Projeto> Projetos;
	
	
	
	public void execute() {
		int n = -1,i;
		Scanner ler = new Scanner(System.in);
		int nPN,flag;
		String aux;
		PersistidorTXT Persistidor = new PersistidorTXT();
		Dado d = Persistidor.RetornaDados();
		Pesquisadores = d.getPesquisadores();
		Artigos = d.getArtigos();
		Projetos = d.getProjetos();
		
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
					System.out.println("-------------------------------------");
					System.out.println("Nome: " + a.getNome());
					System.out.println("Univeridade: " + a.getUniversidade());
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
				System.out.println("====LISTAR PESQUISADORES DE UM DETERMINADO ARTIGO====");
				System.out.println("Digite o titulo do artigo");
				aux = ler.nextLine();
				for ( Artigo a : Artigos ) {
					if(a.getTitulo().equals(aux)) {
						System.out.println("--PESQUISADORES--");
						for ( Pesquisador b : a.getEnvolvidos() ) {
							System.out.println("Nome : " + b.getNome());
						}
						break;
					}
				}
				
			}else if( n == 6 ) {
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
					System.out.println("====ARTIGOS====");
					int f = 0;
					for ( Artigo a : Artigos ) {
						for ( Pesquisador b : a.getEnvolvidos() ) {
							if(b.getNome().equals(aux) ) {
								System.out.println("Titulo: " + a.getTitulo());
								f = 1;
								break;
							}
						}
					}
						if ( f == 0 ) {
							System.out.println("Nenhum artigo encontrado");
						}
						
						
				//-----
						System.out.println("====PROJETOS====");
						f = 0;
						for ( Projeto a : Projetos ) {
							for ( Pesquisador b : a.getEnvolvidos() ) {
								if(b.getNome().equals(aux) ) {
									System.out.println("Titulo: " + a.getTitulo());
									f = 1;
									break;
								}
							}
						}
							if ( f == 0 ) {
								System.out.println("Nenhum Projeto encontrado encontrado");
							}
				}
				
			}else if( n == 7 ) {
				Data atual = new Data();
				System.out.println("======PROJETOS JA FINALIZADOS======");
				for ( Projeto a: Projetos ) {
					if( a.getDataFim().getAno() < atual.getAno() ) {
						System.out.println("--------------------------------------------------------------------------");
						System.out.println("Titulo: " + a.getTitulo());
						System.out.println("Data de inicio: " +a.getDataInicio().getDia() +"/" +a.getDataInicio().getMes() + "/" +a.getDataInicio().getAno());
						System.out.println("Data de conclusao: "+a.getDataFim().getDia() + "/" + a.getDataFim().getMes() + "/" + a.getDataFim().getAno());
						System.out.println("Descricao: " + a.getDescricao());
						System.out.println("--------------------------------------------------------------------------");
					}else if( a.getDataFim().getAno() == atual.getAno() && a.getDataFim().getMes() < atual.getMes() ) {
						System.out.println("--------------------------------------------------------------------------");
						System.out.println("Titulo: " + a.getTitulo());
						System.out.println("Data de inicio: " +a.getDataInicio().getDia() +"/" +a.getDataInicio().getMes() + "/" +a.getDataInicio().getAno());
						System.out.println("Data de conclusao: "+a.getDataFim().getDia() + "/" + a.getDataFim().getMes() + "/" + a.getDataFim().getAno());
						System.out.println("Descricao: " + a.getDescricao());
						System.out.println("--------------------------------------------------------------------------");
					}else if( a.getDataFim().getAno() == atual.getAno() && a.getDataFim().getMes() == atual.getMes() && a.getDataFim().getDia() < atual.getDia() ) {
						System.out.println("--------------------------------------------------------------------------");
						System.out.println("Titulo: " + a.getTitulo());
						System.out.println("Data de inicio: " +a.getDataInicio().getDia() +"/" +a.getDataInicio().getMes() + "/" +a.getDataInicio().getAno());
						System.out.println("Data de conclusao: "+a.getDataFim().getDia() + "/" + a.getDataFim().getMes() + "/" + a.getDataFim().getAno());
						System.out.println("Descricao: " + a.getDescricao());
						System.out.println("--------------------------------------------------------------------------");

					}
				}
			}
			
			
			
			
			else {
				System.out.println("Deseja salvar as alteracções feitas?");
				System.out.println("1 - SIM");
				System.out.println("0 - NÂO");
				int resposta = ler.nextInt();
				if(resposta == 1 ) {
					Dado salvar = new Dado(Pesquisadores,Artigos,Projetos);
					Persistidor.GuardaDados(salvar);
				}
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
		System.out.println("5 - LISTAR PESQUISADORES DE UM DETERMINADO ARTIGO"); // *
		System.out.println("6 - LISTAR TODOS OS PROJETOS DE UM DETERMINADO PESQUISADOR (artigos)");//*
		System.out.println("7 - LISTAR PROJETOS JÁ FINALIZADOS"); //*


		
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
		int flag,ano;
		String nome,rev;
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
		System.out.println("Digite o ano do artigo: ");
		ano = ler.nextInt();
		ler.nextLine();
		System.out.println("Digite o titulo de revista do artigo: ");
		rev = ler.nextLine();
		Artigo ret = new Artigo(titulo,ano,rev,pesq);
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
		System.out.println("Digite apenas o dia em que o projeto foi iniciado :");
		int dia = ler.nextInt();
		System.out.println("Digite apenas o mes em que o projeto foi iniciado :");
		int mes = ler.nextInt();
		System.out.println("Digite apenas o ano em que o projeto foi iniciado :");
		int ano = ler.nextInt();
		Data dataInicio = new Data(dia,mes,ano);
		System.out.println("Digite apenas o dia em que o projeto foi/será finalizado :");
		dia = ler.nextInt();
		System.out.println("Digite apenas o mes em que o projeto foi/será finalizado :");
		mes = ler.nextInt();
		System.out.println("Digite apenas o ano em que o projeto foi/será finalizado :");
		ano = ler.nextInt();
		ler.nextLine();
		Data dataFim = new Data(dia,mes,ano);
		System.out.println("Digite a descricao do seu projeto: ");
		String Descricao = ler.nextLine();
		Projeto ret = new Projeto(titulo,pesq,dataInicio,dataFim,Descricao);
		return ret;
	}

}
