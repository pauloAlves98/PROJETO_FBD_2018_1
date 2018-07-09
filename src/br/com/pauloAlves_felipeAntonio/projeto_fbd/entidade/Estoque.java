package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Estoque {
	private int id,id_fornecedores,id_produtos,total_produtos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_fornecedores() {
		return id_fornecedores;
	}

	public void setId_fornecedores(int id_fornecedores) {
		this.id_fornecedores = id_fornecedores;
	}

	public int getId_produtos() {
		return id_produtos;
	}

	public void setId_produtos(int id_produtos) {
		this.id_produtos = id_produtos;
	}

	public int getTotal_produtos() {
		return total_produtos;
	}

	public void setTotal_produtos(int total_produtos) {
		this.total_produtos = total_produtos;
	}
}
