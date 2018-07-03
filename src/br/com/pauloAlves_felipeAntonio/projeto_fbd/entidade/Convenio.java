package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.sql.Date;

public class Convenio {
	private  int id;
	private String descricao_regiao,nome;
	private Date data_inicio;
	
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao_regiao() {
		return descricao_regiao;
	}
	public void setDescricao_regiao(String descricao_cargo) {
		this.descricao_regiao = descricao_cargo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
