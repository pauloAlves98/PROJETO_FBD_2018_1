package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.sql.Date;

public class Prontuario {
	private int id; 
	private Date data_exame, data_inicio,data_final;
	private String descricao_resultado, observacao;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData_exame() {
		return data_exame;
	}
	public void setData_exame(Date data_exame) {
		this.data_exame = data_exame;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public String getDescricao_resultado() {
		return descricao_resultado;
	}
	public void setDescricao_resultado(String descricao_resultado) {
		this.descricao_resultado = descricao_resultado;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


}
