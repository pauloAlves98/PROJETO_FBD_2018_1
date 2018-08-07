package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.Date;

public class Funcionario {
	int id,id_clinicas,id_cargos;
	private String nome,cpf,admim,senha,nome_usuario,rg,telefone;
	private Date data_acesso;
	private Endereco endereco;
	private Cargo cargo;
	private int id_endereco;
	
	public Funcionario(){
		endereco = new Endereco();
		cargo = new Cargo();
	}
	
	public int getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_clinicas() {
		return id_clinicas;
	}
	public void setId_clinicas(int id_clinicas) {
		this.id_clinicas = id_clinicas;
	}
	public int getId_cargos() {
		return id_cargos;
	}
	public void setId_cargos(int id_cargos) {
		this.id_cargos = id_cargos;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAdmim() {
		return admim;
	}
	public void setAdmim(String admim) {
		this.admim = admim;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData_acesso() {
		return data_acesso;
	}
	public void setData_acesso(Date data_acesso) {
		this.data_acesso = data_acesso;
	}
}
