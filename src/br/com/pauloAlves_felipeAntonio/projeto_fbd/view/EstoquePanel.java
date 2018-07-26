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
	private JButton btnProdutos;
	
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
		btnProdutos.setBounds(10, 53, 120, 33);
		btnProdutos.setFocusPainted(false);
		btnProdutos.setBorder(null);
		panel_6.add(btnProdutos);
		
		ProdutoPanel panel_7 = new ProdutoPanel();
		panel_7.getTipoField().setSize(181, 32);
		panel_7.getTipoField().setLocation(257, 139);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 98, 656, 397);
		add(panel_7,BorderLayout.CENTER);
		panel_7.setLayout(null);
		
		
	}

	public JButton getBtnProdutos() {
		return btnProdutos;
	}
	
	
}
