package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.sql.Date;

public class Despesa {
	private int id;
	private String categoria;
	private float valor;
	private Date data_vencimento;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	

}
