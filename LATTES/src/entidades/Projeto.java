package entidades;

public class Projeto {
	
	private static int qntd;
	private Pesquisador envolvidos[];
	private String titulo;
	private String DataInicio;
	private String DataFim;
	private String descrição;
	//--------------------------- Getters/Setters

	public static int getQntd() {
		return qntd;
	}
	public static void setQntd(int qntd) {
		Projeto.qntd = qntd;
	}
	public Pesquisador[] getEnvolvidos() {
		return envolvidos;
	}
	public void setEnvolvidos(Pesquisador[] envolvidos) {
		this.envolvidos = envolvidos;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(String dataInicio) {
		DataInicio = dataInicio;
	}
	public String getDataFim() {
		return DataFim;
	}
	public void setDataFim(String dataFim) {
		DataFim = dataFim;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

}
