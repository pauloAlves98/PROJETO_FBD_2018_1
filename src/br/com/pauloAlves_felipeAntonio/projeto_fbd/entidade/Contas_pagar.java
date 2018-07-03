package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Contas_pagar {
	private int id,id_caixas,id_dispesas;
	private float valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_caixas() {
		return id_caixas;
	}
	public void setId_caixas(int id_caixas) {
		this.id_caixas = id_caixas;
	}
	public int getId_dispesas() {
		return id_dispesas;
	}
	public void setId_dispesas(int id_dispesas) {
		this.id_dispesas = id_dispesas;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}	
}
