package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Produto {
	private int id,unidade_entrada,unidade_saida,quantidade; 
	private String tipo,nome;
	private float preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id; 
	}
	public int getUnidade_entrada() {
		return unidade_entrada;
	}
	public void setUnidade_entrada(int unidade_entrada) {
		this.unidade_entrada = unidade_entrada;
	}
	public int getUnidade_saida() {
		return unidade_saida;
	}
	public void setUnidade_saida(int unidade_saida) {
		this.unidade_saida = unidade_saida;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
	

}
