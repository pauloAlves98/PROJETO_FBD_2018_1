package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.Date;

public class ItemProduto {
	private Produto produto;
	private Date dataCompra,vencimento;
	private float precoCompra;
	private int quantidade,id,id_produto;
	
	public ItemProduto() {
		
	}

	
	


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public float getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(float precoCompra) {
		this.precoCompra = precoCompra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}





	public int getId_produto() {
		return id_produto;
	}





	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	
}
