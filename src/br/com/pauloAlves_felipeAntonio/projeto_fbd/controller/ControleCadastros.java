package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastrosPanel;

public class ControleCadastros {
	public ControleCadastros(CadastrosPanel cadastrosPanel) {
		cadastrosPanel.getFornecedorButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrosPanel.getTelaServico().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(false);
				cadastrosPanel.getTelaFornecedor().setVisible(true);
				
			}
		});
		
		cadastrosPanel.getServicoButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrosPanel.getTelaFornecedor().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(false);
				cadastrosPanel.getTelaServico().setVisible(true);
				
			}
		});
		
		cadastrosPanel.getPacienteButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrosPanel.getTelaFornecedor().setVisible(false);
				cadastrosPanel.getTelaServico().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(true);
				
				
			}
		});
	}
}
