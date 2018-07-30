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
		
		vendaFrame.getBtnFinalizarVenda().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				//quando ela for finalizada ela tem q verificar se a pessoa pagou e armazenar no caixa 
				//caso tenha sido parcelada tera q ser armazenada na tela de contas a receber e o que foi pago vai pro caixa
				
				
			}
		});
	}
}
