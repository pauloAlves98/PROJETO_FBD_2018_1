package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.sql.Date;

public class Venda {
	private int id,nota_fiscal,	id_pacientes;
	private Date data;
	private boolean status;
	private float total,desconto,valor_recebido,troco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(int nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}
	public int getId_pacientes() {
		return id_pacientes;
	}
	public void setId_pacientes(int id_pacientes) {
		this.id_pacientes = id_pacientes;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public float getValor_recebido() {
		return valor_recebido;
	}
	public void setValor_recebido(float valor_recebido) {
		this.valor_recebido = valor_recebido;
	}
	public float getTroco() {
		return troco;
	}
	public void setTroco(float troco) {
		this.troco = troco;
	}
	
	
}
