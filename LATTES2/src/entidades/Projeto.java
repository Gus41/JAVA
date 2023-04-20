package entidades;
import java.util.ArrayList;

public class Projeto {
	
	private String titulo;
	private String descricao;
	private String dataInicio;
	private String dataFim;
	private ArrayList<Pesquisador>envolvidos;
	//--------------------------------

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
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public ArrayList<Pesquisador> getEnvolvidos() {
		return envolvidos;
	}
	public void setEnvolvidos(ArrayList<Pesquisador> envolvidos) {
		this.envolvidos = envolvidos;
	}
	

}
