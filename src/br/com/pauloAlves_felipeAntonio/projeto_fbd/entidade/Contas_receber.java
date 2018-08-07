package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Contas_receber {
	private int id,id_caixas,id_paciente,parcelas;
	private float valor,valorPago,saldo;
	private String nome;
	
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

	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public float getValorPago() {
		return valorPago;
	}
	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
	
}
