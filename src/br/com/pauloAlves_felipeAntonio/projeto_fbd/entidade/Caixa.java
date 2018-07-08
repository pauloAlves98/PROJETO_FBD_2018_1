package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.List;

public class Caixa {
	private int id;
	private float saldo;
	private String nome;
	private List<Contas_receber> contasReceber;
	private List<Contas_pagar> contasPagar;
	
	public List<Contas_pagar> getContasPagar() {
		return contasPagar;
	}
	public void setContasPagar(List<Contas_pagar> contasPagar) {
		this.contasPagar = contasPagar;
	}
	public List<Contas_receber> getContasReceber() {
		return contasReceber;
	}
	public void setContasReceber(List<Contas_receber> contasReceber) {
		this.contasReceber = contasReceber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
