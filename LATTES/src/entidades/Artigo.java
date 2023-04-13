package entidades;

public class Artigo {
	
	private static int qntd=0;
	private Pesquisador envolvidos[];
	private String TituloArt;
	private String TituloRev;
	private int ano;
	//---------------------------- INICIALIZA VETOR COM ENVOLVIDOS
	public void inicializaEnvolvidos(int n) {
		envolvidos = new Pesquisador[n];
	}
	
	//--------------------------- Getters/Setters

	public static int getQntd() {
		return qntd;
	}
	public static void setQntd(int qntd) {
		Artigo.qntd = qntd;
	}
	public Pesquisador[] getEnvolvidos() {
		return envolvidos;
	}
	public void setEnvolvidos(Pesquisador nome) {
		this.envolvidos[qntd] = nome;
		qntd++;
	}
	public String getTituloArt() {
		return TituloArt;
	}
	public void setTituloArt(String tituloArt) {
		TituloArt = tituloArt;
	}
	public String getTituloRev() {
		return TituloRev;
	}
	public void setTituloRev(String tituloRev) {
		TituloRev = tituloRev;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	


}
