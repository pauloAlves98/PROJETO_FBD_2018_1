package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Fornecedor {//Endereco
	private int id,incs_municipal,insc_estadual;  
	private String cnpj,nome,telefone;
	private Endereco endereco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIncs_municipal() {
		return incs_municipal;
	}
	public void setIncs_municipal(int incs_municipal) {
		this.incs_municipal = incs_municipal;
	}
	public int getInsc_estadual() {
		return insc_estadual;
	}
	public void setInsc_estadual(int insc_estadual) {
		this.insc_estadual = insc_estadual;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
