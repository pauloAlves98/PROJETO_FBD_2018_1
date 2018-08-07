package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LoginFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.TelaPrincipal;

public class ControleTelaPrincipal {
	public ControleTelaPrincipal(TelaPrincipal telaPrincipal,LoginFrame loginFrame) {
		telaPrincipal.getSairButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.setVisible(false);
				loginFrame.getLoginField().setText("");
				loginFrame.getLoginField().grabFocus();
				loginFrame.getSenhaField().setText("");
				loginFrame.setVisible(true);
			}
		});
		telaPrincipal.getBtnEstoque().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.getTabbedPane().setSelectedIndex(2);
				
			}
		});
		telaPrincipal.getBtnFinanceiro().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.getTabbedPane().setSelectedIndex(1);
				
			}
		});
		telaPrincipal.getBtnCadastros().addActionListener(new ActionListener() {
	
		@Override
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.getTabbedPane().setSelectedIndex(0);
				
			}
		});
		telaPrincipal.getBtnAgenda().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.getTabbedPane().setSelectedIndex(3);
				
			}
		});
		
		}
	
	}
