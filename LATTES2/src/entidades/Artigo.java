package entidades;

import java.util.ArrayList;

public class Artigo {
	private String titulo;
	private String tituloREV;
	private int ano;
	private ArrayList<Pesquisador> envolvidos;
	//--------------------------------

	public ArrayList<Pesquisador> getEnvolvidos() {
		return envolvidos;
	}
	public void setEnvolvidos(ArrayList<Pesquisador> envolvidos) {
		this.envolvidos = envolvidos;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTituloREV() {
		return tituloREV;
	}
	public void setTituloREV(String tituloREV) {
		this.tituloREV = tituloREV;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}
