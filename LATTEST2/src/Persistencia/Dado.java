package Persistencia;
import java.util.ArrayList;

import entidades.Artigo;
import entidades.Pesquisador;
import entidades.Projeto;

public class Dado {
	
	private ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
	private ArrayList<Projeto> projetos = new ArrayList<>();
	private ArrayList<Artigo> artigos = new ArrayList<>();
	
	
	public Dado(ArrayList<Pesquisador> p, ArrayList<Artigo> a, ArrayList<Projeto> pr){
		this.pesquisadores = p;
		this.artigos = a;
		this.projetos = pr;
	}


	public ArrayList<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}


	public void setPesquisadores(ArrayList<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}


	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}


	public void setProjetos(ArrayList<Projeto> projetos) {
		this.projetos = projetos;
	}


	public ArrayList<Artigo> getArtigos() {
		return artigos;
	}


	public void setArtigos(ArrayList<Artigo> artigos) {
		this.artigos = artigos;
	}
	
	

}
