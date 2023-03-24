package entidades;

public class ContaC {
	
	private int numero;
	private double saldo = 100;
	public Cliente cl = new Cliente();
	
	
	public void depositar(double valor) {
		saldo =+ valor;
	}
	public void sacar(double valor) {
		saldo =- valor;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

}
