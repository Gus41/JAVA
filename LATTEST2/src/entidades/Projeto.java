package entidades;
import java.util.ArrayList;

public class Projeto {
	
	private String titulo;
	private String descricao;
	private Data dataInicio;
	private Data dataFim;
	private ArrayList<Pesquisador>envolvidos;
	

	public Projeto(String titulo, ArrayList<Pesquisador> envolvidos, Data inicio, Data fim,String desc ) {
		this.titulo = titulo;
		this.envolvidos = envolvidos;
		this.dataFim = fim;
		this.dataInicio = inicio;
		this.descricao = desc;
	}


	public Projeto(String titulo, Data inicio, Data fim, String desc) {
		this.titulo = titulo;
		this.dataInicio = inicio;
		this.dataFim = fim;
		this.descricao = desc;
	}
	//--------------------------------

	public Data getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Data dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Data getDataFim() {
		return dataFim;
	}
	public void setDataFim(Data dataFim) {
		this.dataFim = dataFim;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ArrayList<Pesquisador> getEnvolvidos() {
		return envolvidos;
	}
	public void setEnvolvidos(ArrayList<Pesquisador> envolvidos) {
		this.envolvidos = envolvidos;
	}
	

}
