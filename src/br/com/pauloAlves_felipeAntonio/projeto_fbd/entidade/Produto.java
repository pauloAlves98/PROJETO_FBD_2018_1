package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Produto {
	private int id,idFornecedor,vendaAtacado,vendaVarejo; 
	private String tipo,nome;
	private float preco;
	private Fornecedor fornecedor;
	
	
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public int getVendaAtacado() {
		return vendaAtacado;
	}
	public void setVendaAtacado(int vendaAtacado) {
		this.vendaAtacado = vendaAtacado;
	}
	public int getVendaVarejo() {
		return vendaVarejo;
	}
	public void setVendaVarejo(int vendaVarejo) {
		this.vendaVarejo = vendaVarejo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	 
	

}
