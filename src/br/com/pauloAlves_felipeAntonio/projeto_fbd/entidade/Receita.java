package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Receita {
	private int  id,id_medicamentos,id_medico;
	private String observacoes,nome_clinica;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_medicamentos() {
		return id_medicamentos;
	}
	public void setId_medicamentos(int id_medicamentos) {
		this.id_medicamentos = id_medicamentos;
	}
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getNome_clinica() {
		return nome_clinica;
	}
	public void setNome_clinica(String nome_clinica) {
		this.nome_clinica = nome_clinica;
	}
	
	

}
