package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.EstoquePanel;

public class ControleEstoque {
	public ControleEstoque(EstoquePanel estoquePanel) {
		estoquePanel.getBtnMovimentacao().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				estoquePanel.getPanel_7().setVisible(false);
				estoquePanel.getPanel_8().setVisible(true);
				estoquePanel.add(estoquePanel.getPanel_8(),BorderLayout.CENTER);
			}
		});
		estoquePanel.getBtnProdutos().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				estoquePanel.getPanel_7().setVisible(true);
				estoquePanel.getPanel_8().setVisible(false);
				estoquePanel.add(estoquePanel.getPanel_7(),BorderLayout.CENTER);
				
			}
		});
	}
}
