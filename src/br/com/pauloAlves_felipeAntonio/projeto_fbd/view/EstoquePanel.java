package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EstoquePanel extends JPanel {
	private JPanel panel_6;
	private JButton btnProdutos;
	
	public EstoquePanel() {
		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 0, 145, 493);
		add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEstoque.setBounds(36, 11, 84, 27);
		panel_6.add(lblEstoque);
		
		btnProdutos = new JButton("Produtos");
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setBackground(Color.WHITE);
		btnProdutos.setBounds(10, 48, 125, 33);
		btnProdutos.setFocusPainted(false);
		btnProdutos.setBorder(null);
		panel_6.add(btnProdutos);
		
		ProdutoPanel panel_7 = new ProdutoPanel();
		panel_7.setBackground(new Color(0, 128, 255));
		panel_7.setBounds(142, 0, 656, 493);
		add(panel_7);
		panel_7.setLayout(null);
		
		
	}

	public JButton getBtnProdutos() {
		return btnProdutos;
	}
	
	
}
