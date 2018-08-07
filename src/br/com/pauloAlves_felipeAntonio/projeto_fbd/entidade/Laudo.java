package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.Date;

public class Laudo {
	private int id,id_paciente,id_medico;
	private Date _data;
	private String horario,descricao;
	private Medico medico;
	private Paciente paciente;
	
	
	public Laudo() {
		super();
		this.medico = new Medico();
		this.paciente = new Paciente();
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	public Date get_data() {
		return _data;
	}
	public void set_data(Date _data) {
		this._data = _data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
