package br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.enums;

public enum EnumAgendaView {
	VISUALIZAR("Visualizar"),CONSULTA("Consulta");
	
	private String valor;
	
	EnumAgendaView (String valor){
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
