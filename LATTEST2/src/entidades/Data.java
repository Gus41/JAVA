package entidades;

import java.util.Calendar;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	
	public Data(int dia, int mes, int ano) {
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}
	public Data() {
		Calendar calendario = Calendar.getInstance();
		this.dia = calendario.get(Calendar.DATE);
		this.mes = calendario.get(Calendar.MONTH) + 1;
		this.ano = calendario.get(Calendar.YEAR);

	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	

}
