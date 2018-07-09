package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Estoque {
	private int id,total_produtos;
	private Produto produto;
	private Fornecedor fornecedor;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getTotal_produtos() {
		return total_produtos;
	}

	public void setTotal_produtos(int total_produtos) {
		this.total_produtos = total_produtos;
	}
}
