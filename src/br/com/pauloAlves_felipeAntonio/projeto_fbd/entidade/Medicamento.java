package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Medicamento {
	private int id;
	private String descricao_laboratorio,desricao_generica,
	descricao_substancia,nome;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao_laboratorio() {
		return descricao_laboratorio;
	}
	public void setDescricao_laboratorio(String descricao_laboratorio) {
		this.descricao_laboratorio = descricao_laboratorio;
	}
	public String getDesricao_generica() {
		return desricao_generica;
	}
	public void setDesricao_generica(String desricao_generica) {
		this.desricao_generica = desricao_generica;
	}
	public String getDescricao_substancia() {
		return descricao_substancia;
	}
	public void setDescricao_substancia(String descricao_substancia) {
		this.descricao_substancia = descricao_substancia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
