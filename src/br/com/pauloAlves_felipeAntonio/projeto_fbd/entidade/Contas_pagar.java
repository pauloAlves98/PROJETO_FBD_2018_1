package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.Date;

public class Contas_pagar {
	private int id,id_caixas,id_item_produto,quantidade,parcela,parecelasTotais;
	private float valor,valorPago;
	private String nomeFornecedor,nomeProduto;
	private Date vencimento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_caixas() {
		return id_caixas;
	}
	public void setId_caixas(int id_caixas) {
		this.id_caixas = id_caixas;
	}
	public int getId_item_produto() {
		return id_item_produto;
	}
	public void setId_dispesas(int id_item_produto) {
		this.id_item_produto = id_item_produto;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getParcela() {
		return parcela;
	}
	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
	public float getValorPago() {
		return valorPago;
	}
	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setId_item_produto(int id_item_produto) {
		this.id_item_produto = id_item_produto;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public int getParecelasTotais() {
		return parecelasTotais;
	}
	public void setParecelasTotais(int parecelasTotais) {
		this.parecelasTotais = parecelasTotais;
	}
	
	
}
