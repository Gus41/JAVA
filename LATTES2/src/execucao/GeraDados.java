package execucao;

import java.util.ArrayList;

import entidades.Artigo;
import entidades.Pesquisador;
import entidades.Projeto;

public class GeraDados {
	
	private ArrayList<Pesquisador>Pesquisadores = new ArrayList<Pesquisador>();
	private ArrayList<Artigo>Artigos = new ArrayList<Artigo>();
	private ArrayList<Projeto> Projetos = new ArrayList<Projeto>();
	
	public GeraDados() {
		Pesquisadores.add(new Pesquisador("Anderson","UCS") );
		Pesquisadores.add(new Pesquisador("Jefferson","UCS") );
		Pesquisadores.add(new Pesquisador("Maximiliano","FSG") );
		Pesquisadores.add(new Pesquisador("Arthur","FSG") );
		Pesquisadores.add(new Pesquisador("Lucas","UCS") );
		Pesquisadores.add(new Pesquisador("Julia","UCS") );
		Pesquisadores.add(new Pesquisador("Andreia","FSG") );
		Pesquisadores.add(new Pesquisador("Amarildo","FSG") );
		Pesquisadores.add(new Pesquisador("Enzo","UCS") );
		Pesquisadores.add(new Pesquisador("Davi","UCS") );
		Pesquisadores.add(new Pesquisador("Luis","UCS") );
		Pesquisadores.add(new Pesquisador("Anderson","FSG") );
		Pesquisadores.add(new Pesquisador("Anthony","FSG") );
		Pesquisadores.add(new Pesquisador("Mario","UCS") );
		Pesquisadores.add(new Pesquisador("Andre","UCS") );
		Pesquisadores.add(new Pesquisador("Maria","FSG") );
		Pesquisadores.add(new Pesquisador("Sandra","FSG") );
		Pesquisadores.add(new Pesquisador("Vanessa","FSG") );
		Pesquisadores.add(new Pesquisador("Amanda","FSG") );
		Pesquisadores.add(new Pesquisador("Chris","UCS") );
		
		//-------------------------------------------------- 20 Pesquisadores /10 da ucs/ 10 da fsg
		ArrayList<Pesquisador> envolvidos = new ArrayList<>();
		envolvidos.add(Pesquisadores.get(0));
		envolvidos.add(Pesquisadores.get(1));
		envolvidos.add(Pesquisadores.get(2));
		envolvidos.add(Pesquisadores.get(3));
		Artigos.add(new Artigo("Teste1",envolvidos));
		ArrayList<Pesquisador> envolvidos2 = new ArrayList<>();
		envolvidos2.add(Pesquisadores.get(4));
		envolvidos2.add(Pesquisadores.get(5));
		envolvidos2.add(Pesquisadores.get(6));
		envolvidos2.add(Pesquisadores.get(7));
		Artigos.add(new Artigo("Teste2",envolvidos2));
		ArrayList<Pesquisador> envolvidos3 = new ArrayList<>();
		envolvidos3.add(Pesquisadores.get(8));
		envolvidos3.add(Pesquisadores.get(9));
		envolvidos3.add(Pesquisadores.get(10));
		Artigos.add(new Artigo("Teste3",envolvidos3));
		ArrayList<Pesquisador> envolvidos4 = new ArrayList<>();
		envolvidos4.add(Pesquisadores.get(11));
		envolvidos4.add(Pesquisadores.get(12));
		envolvidos4.add(Pesquisadores.get(13));
		envolvidos4.add(Pesquisadores.get(14));
		envolvidos4.add(Pesquisadores.get(15));
		Artigos.add(new Artigo("Teste4",envolvidos4));
		ArrayList<Pesquisador> envolvidos5 = new ArrayList<>();
		envolvidos5.add(Pesquisadores.get(0));
		envolvidos5.add(Pesquisadores.get(7));
		envolvidos5.add(Pesquisadores.get(4));
		envolvidos5.add(Pesquisadores.get(12));
		envolvidos5.add(Pesquisadores.get(6));
		Artigos.add(new Artigo("Teste5",envolvidos5));
		//------------------------------------------------ 5 Artigos
		ArrayList<Pesquisador> p1 = new ArrayList<>();
		p1.add(Pesquisadores.get(0));
		p1.add(Pesquisadores.get(1));
		p1.add(Pesquisadores.get(2));
		p1.add(Pesquisadores.get(3));
		Projetos.add(new Projeto("Projeto1",p1));
		ArrayList<Pesquisador> p2 = new ArrayList<>();
		p2.add(Pesquisadores.get(4));
		p2.add(Pesquisadores.get(5));
		p2.add(Pesquisadores.get(6));
		p2.add(Pesquisadores.get(7));
		Projetos.add(new Projeto("Projeto2",p2));
		ArrayList<Pesquisador> p3 = new ArrayList<>();
		p3.add(Pesquisadores.get(2));
		p3.add(Pesquisadores.get(8));
		p3.add(Pesquisadores.get(10));
		p3.add(Pesquisadores.get(17));
		Projetos.add(new Projeto("Projeto3",p3));
		ArrayList<Pesquisador> p4 = new ArrayList<>();
		p4.add(Pesquisadores.get(11));
		p4.add(Pesquisadores.get(9));
		p4.add(Pesquisadores.get(10));
		p4.add(Pesquisadores.get(13));
		Projetos.add(new Projeto("Projeto4",p4));
		ArrayList<Pesquisador> p5 = new ArrayList<>();
		p5.add(Pesquisadores.get(2));
		p5.add(Pesquisadores.get(15));
		Projetos.add(new Projeto("Projeto5",p5));
		//--------------------------------------- 5 Projetos
		
	}

	public ArrayList<Pesquisador> getPesquisadores() {
		return Pesquisadores;
	}

	public ArrayList<Artigo> getArtigos() {
		return Artigos;
	}

	public ArrayList<Projeto> getProjetos() {
		return Projetos;
	}
	
	
	
}
