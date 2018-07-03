package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacientePanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PacientesPanel;



public class ControlePacientesPanel {
	public ControlePacientesPanel(PacientesPanel telaPaciente,CadastroPacientePanel pacienteCdastro) {
		telaPaciente.getBtnNewButton_3().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pacienteCdastro.setVisible(true);
			}
		});
	}
}
