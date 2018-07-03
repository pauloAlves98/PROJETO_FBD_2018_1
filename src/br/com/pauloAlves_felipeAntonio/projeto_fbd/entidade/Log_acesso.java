package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.sql.Date;

public class Log_acesso {
	private int id;
	private Date data_acesso;
	private String nome_usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData_acesso() {
		return data_acesso;
	}
	public void setData_acesso(Date data_acesso) {
		this.data_acesso = data_acesso;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	
	
}
