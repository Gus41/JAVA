package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import entidades.Data;
import entidades.Artigo;
import entidades.Pesquisador;
import entidades.Projeto;

public class PersistidorTXT implements Persistencia{


	@Override
	public void GuardaDados(Dado d) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Lattes-Reestruturado.txt"));
			ArrayList<Pesquisador> pesquisadores = d.getPesquisadores();
			ArrayList<Projeto> projetos = d.getProjetos();
			ArrayList<Artigo> artigos = d.getArtigos();
			
			for( Pesquisador p : pesquisadores ) {
				bw.write("#Pesquisador");
				bw.newLine();
				bw.write("Nome: " + p.getNome());
				bw.newLine();
				bw.write("Universidade: " + p.getUniversidade());
				bw.newLine();
			}
			for ( Projeto p : projetos ) {
				bw.write("#Projeto");
				bw.newLine();
				bw.write("Data Início: " + p.getDataInicio().getDia() + "/" + p.getDataInicio().getMes() + "/" + p.getDataInicio().getAno());
				bw.newLine();
				bw.write("Data Fim: " + p.getDataFim().getDia() + "/" + p.getDataFim().getMes() + "/" + p.getDataFim().getAno() );
				bw.newLine();
				bw.write("Titulo: " + p.getTitulo());
				bw.newLine();
				bw.write("Descrição: " + p.getDescricao());
				bw.newLine();
				String envolvidos = "";
				for(Pesquisador pes : p.getEnvolvidos()) {
					envolvidos += pes.getNome() + "; ";
				}
				bw.write("Pesquisadores: "+ envolvidos);
			}
			for( Artigo a : artigos ) {
				bw.write("#Artigo");
				bw.newLine();
				bw.write("Titulo: "+ a.getTitulo());
				bw.newLine();
				bw.write("Ano: "+a.getAno());
				bw.newLine();
				bw.write("Revista: "+a.getTituloREV());
				bw.newLine();
				String envolvidos = "";
				for(Pesquisador p : a.getEnvolvidos()) {
					envolvidos += p.getNome() + "; ";
				}
				bw.write("Pesquisadores: "+ envolvidos);
				bw.newLine();
			}
		
			bw.flush();
			bw.close();
			System.out.println("-----DADOS SALVCOS COM SUCESSO-----");
		}
		catch(IOException e) {
			
		}
		
	}

	@Override
	public Dado RetornaDados() {
		ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
		ArrayList<Projeto> projetos = new ArrayList<>();
		ArrayList<Artigo> artigos  = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Lattes-Reestruturado.txt"));
			String linha,nome,titulo,titulorev,desc,uni;
			Data data_inicio;
			Data data_final;
			linha = br.readLine();
			while ( linha != null ) {
				if( linha.equals("#Pesquisador") ) {
					linha = br.readLine();
					String[] campos = linha.split(": ");
					nome = campos[1];
					linha = br.readLine();
					campos = linha.split(": ");
					uni = campos[1];
					pesquisadores.add(new Pesquisador(nome,uni));
				}else if ( linha.equals("#Projeto") ) {
					linha = br.readLine();
					String[] campos = linha.split(": ");
					String[] dt = campos[1].split("/");
					String dia_str = dt[0];
					String mes_str = dt[1];
					String ano_str = dt[2];
					data_inicio = new Data();
					data_inicio.setDia(Integer.parseInt(dia_str));
					data_inicio.setMes(Integer.parseInt(mes_str));
					data_inicio.setAno(Integer.parseInt(ano_str));
					linha = br.readLine();
					campos = linha.split(": ");
					dt = campos[1].split("/");
					dia_str = dt[0];
					mes_str = dt[1];
					ano_str = dt[2];
					data_final = new Data();
					data_final.setDia(Integer.parseInt(dia_str));
					data_final.setMes(Integer.parseInt(mes_str));
					data_final.setAno(Integer.parseInt(ano_str));
					linha = br.readLine();
					campos = linha.split(": ");
					titulo = campos[1];
					linha = br.readLine();
					campos = linha.split(": ");
					desc = campos[1];
					linha = br.readLine();
					campos = linha.split(": ");
					String envolvidos = campos[1];
					String[] nomes = envolvidos.split("; ");
					int i=0;
					ArrayList<Pesquisador> Envolvidos_arr = new ArrayList<>();
					
					while ( i < nomes.length ) {
						for( Pesquisador p : pesquisadores ) {
							if( p.getNome().equals(nomes[i]) ){
								Envolvidos_arr.add(p);
							}
						}
						i++;
					}
					projetos.add(new Projeto(titulo,Envolvidos_arr,data_inicio,data_final,desc));
					
					
				}else if( linha.equals("#Artigo") ) {
					linha = br.readLine();
					String[] campos = linha.split(": ");
					titulo = campos[1];
					linha = br.readLine();
					campos = linha.split(": ");
					int ano = Integer.parseInt(campos[1]);
					linha = br.readLine();
					campos = linha.split(": ");
					titulorev = campos[1];
					linha = br.readLine();
					campos = linha.split(": ");
					String envolvidos = campos[1];
					String[] nomes = envolvidos.split("; ");
					int i=0;
					ArrayList<Pesquisador> Envolvidos_arr = new ArrayList<>();
					
					while ( i < nomes.length ) {
						for( Pesquisador p : pesquisadores ) {
							if( p.getNome().equals(nomes[i]) ){
								Envolvidos_arr.add(p);
							}
						}
						i++;
					}
					artigos.add(new Artigo(titulo,ano,titulorev,Envolvidos_arr));
				}
				linha = br.readLine();
			}
			br.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}
		catch(IOException e) {
			System.out.println("Erro de IO!");
		}
		Dado d = new Dado(pesquisadores,artigos,projetos);
		return d;
	}


	

}
