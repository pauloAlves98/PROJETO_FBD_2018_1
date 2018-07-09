package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Clinica {
	private int id,telefone;
	private String nome,cnpj,descricao_complemento;
	private Endereco endereco;
	
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
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getDescricao_complemento() {
		return descricao_complemento;
	}
	public void setDescricao_complemento(String descricao_complemento) {
		this.descricao_complemento = descricao_complemento;
	}
}
