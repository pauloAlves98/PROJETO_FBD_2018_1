package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class EstoquePanel extends JPanel {
	private  PaneGradiente panel_6;
	private JButton btnProdutos,btnMovimentacao;
	private ProdutoPanel panel_7;
	private MovimentacaoPanel panel_8;
	
	public EstoquePanel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		panel_6 = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 0, 798, 100);
		panel_6.setPreferredSize(new Dimension(1000,99));
		panel_6.setLayout(null);
		add(panel_6,BorderLayout.NORTH);
		
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setForeground(Color.WHITE);
		lblEstoque.setFont(new Font("Franklin Gothic Book", Font.BOLD, 27));
		lblEstoque.setBounds(10, 11, 201, 31);
		panel_6.add(lblEstoque);
		
		btnProdutos = new JButton("Produtos");
		btnProdutos.setFont(Propiedade.FONT2);
		btnProdutos.setBackground(Color.WHITE);
		btnProdutos.setBounds(10, 55, 120, 33);
		btnProdutos.setFocusPainted(false);
		btnProdutos.setBorder(null);
		panel_6.add(btnProdutos);
		
		btnMovimentacao = new JButton("Movimentacao");
		btnMovimentacao.setFont(Propiedade.FONT2);
		btnMovimentacao.setBackground(Color.WHITE);
		btnMovimentacao.setBounds(147, 55, 135, 33);
		btnMovimentacao.setFocusPainted(false);
		btnMovimentacao.setBorder(null);
		panel_6.add(btnMovimentacao);
		
		panel_7 = new ProdutoPanel();
		//panel_7.getFiltroField().setSize(181, 32);
	//	panel_7.getFiltroField().setLocation(257, 139);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 98,  745, 397);
		add(panel_7);
		panel_7.setLayout(null);
		
		panel_8 = new MovimentacaoPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(0, 98,  745, 397);
		add(panel_8);
		
	}

	public JButton getBtnProdutos() {
		return btnProdutos;
	}

	public JButton getBtnMovimentacao() {
		return btnMovimentacao;
	}

	public ProdutoPanel getPanel_7() {
		return panel_7;
	}

	public MovimentacaoPanel getPanel_8() {
		return panel_8;
	}
	
	
	
}
