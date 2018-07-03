package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Fornecedor {//Endereco
	private int id,incs_municipal,insc_estadual,telefone;   
	private String cidade,bairro,uf,cnpj,nome,cep;
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
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
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
