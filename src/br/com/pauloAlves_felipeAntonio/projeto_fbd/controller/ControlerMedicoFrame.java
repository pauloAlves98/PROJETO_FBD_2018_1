package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.enums.EnumAgendaView;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.MedicoFrame;

public class ControlerMedicoFrame {
	private MedicoFrame medicoFrame;
	public ControlerMedicoFrame(MedicoFrame medicoFrame){
		this.medicoFrame = medicoFrame;

		//Eventos
		this.medicoFrame.getAgendaB().addActionListener((ActionEvent e)->{
			medicoFrame.getCard().show(medicoFrame.getPanelCenter(),EnumAgendaView.AGENDA.getValor());
		});
		this.medicoFrame.getPacientes().addActionListener((ActionEvent e)->{
			medicoFrame.getCard().show(medicoFrame.getPanelCenter(),EnumAgendaView.LAUDO.getValor());
		});
	}
}
