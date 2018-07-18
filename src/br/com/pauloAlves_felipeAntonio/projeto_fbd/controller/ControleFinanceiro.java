package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.FinanceiroPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.VendaFrame;

public class ControleFinanceiro {
	public ControleFinanceiro(FinanceiroPanel financeiroPanel,VendaFrame vendaFrame) {
		financeiroPanel.getBtnNovaVenda().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vendaFrame.setVisible(true);
				
			}
		});
	}
}
