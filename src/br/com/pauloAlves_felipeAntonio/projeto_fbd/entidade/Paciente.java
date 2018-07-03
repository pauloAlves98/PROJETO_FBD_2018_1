package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

public class Paciente {
	private int id,telefone,id_prontuario,id_convenio; 
	private String nome,rg,cpf,nome_mae,nome_pai;
	private Prontuario prontuario;
	private Convenio convenio;
	
	public Convenio getConvenio() {
		return convenio;
	}
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	public Prontuario getProntuario() {
		return prontuario;
	}
	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_convenio() {
		return id_convenio;
	}
	public void setId_convenio(int id_convenio) {
		this.id_convenio = id_convenio;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getId_prontuario() {
		return id_prontuario;
	}
	public void setId_prontuario(int id_prontuario) {
		this.id_prontuario = id_prontuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome_mae() {
		return nome_mae;
	}
	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}
	public String getNome_pai() {
		return nome_pai;
	}
	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}
	
}
