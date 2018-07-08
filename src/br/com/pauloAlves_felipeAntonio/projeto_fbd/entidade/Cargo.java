package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.List;

public class Cargo {//ComumDao para Funcionario!!!
	private int id;
	private  String descricao_cargo,nome;
	private List<Funcionario>funcionarios;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao_cargo() {
		return descricao_cargo;
	}
	public void setDescricao_cargo(String descricao_cargo) {
		this.descricao_cargo = descricao_cargo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	 
}
