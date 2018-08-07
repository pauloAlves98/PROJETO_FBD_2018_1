package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.util.Date;

public class Consulta {
	
	private int id,id_paciente,id_medico;
	private String tipo,horario;
	private Date _data;
	private String situacao;
	private Paciente paciente;
	private Medico medico;
	public Consulta(){
		paciente = new Paciente();
		medico = new Medico();
	}
	//Só não precisa registra no Objeto!!
	//private Paciente paciente;
	//private Medico medico;
	
	
public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	//	public Medico getMedico() {
//		return medico;
//	}
//	public void setMedico(Medico medico) {
//		this.medico = medico;
//	}
	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Date get_data() {
		return _data;
	}
	public void set_data(Date _data) {
		this._data = _data;
	}
	public String isSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	

}
