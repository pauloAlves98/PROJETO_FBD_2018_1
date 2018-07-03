package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Local_end {//Endereco associação!!!
	private int id,telefone,id_exame;
	private String rua,nome_clinica,bairro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getId_exame() {
		return id_exame;
	}
	public void setId_exame(int id_exame) {
		this.id_exame = id_exame;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNome_clinica() {
		return nome_clinica;
	}
	public void setNome_clinica(String nome_clinica) {
		this.nome_clinica = nome_clinica;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
}
