package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroAdcionarNoEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField dataCompraField;
	private JTextField vencimentoField;
	private JTextField precoCompraField;
	private JTextField quantidadeField;
	private JComboBox produtoBox;
	private JButton btnSalvar;


	public CadastroAdcionarNoEstoque() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setLayout(null);
		panel.setBounds(0, 0, 644, 81);
		setBounds(100, 100, 561, 312);
		
		JLabel AdcionarProdutosNoEstoque = new JLabel("Adicionar Produtos ");
		AdcionarProdutosNoEstoque.setForeground(Color.WHITE);
		AdcionarProdutosNoEstoque.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		AdcionarProdutosNoEstoque.setBounds(10, 11, 446, 70);
		panel.add(AdcionarProdutosNoEstoque);
		//AdcionarProdutosNoEstoque.setBackground(Color.WHITE);
		
		contentPane.add(panel);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblProduto.setBounds(10, 97, 82, 32);
		contentPane.add(lblProduto);
		
		produtoBox = new JComboBox();
		produtoBox.setBounds(10, 121, 321, 32);
		contentPane.add(produtoBox);
		
		dataCompraField = new JTextField();
		dataCompraField.setBounds(372, 121, 139, 32);
		contentPane.add(dataCompraField);
		dataCompraField.setColumns(10);
		
		JLabel lblDataDaCompra = new JLabel("Data da Compra");
		lblDataDaCompra.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblDataDaCompra.setBounds(372, 97, 139, 32);
		contentPane.add(lblDataDaCompra);
		
		vencimentoField = new JTextField();
		vencimentoField.setBounds(10, 188, 139, 32);
		contentPane.add(vencimentoField);
		vencimentoField.setColumns(10);
		
		JLabel lblVencimento = new JLabel("Vencimento");
		lblVencimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblVencimento.setBounds(10, 167, 163, 14);
		contentPane.add(lblVencimento);
		
		JLabel lblPrecoDaCompra = new JLabel("Preco Da Compra");
		lblPrecoDaCompra.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblPrecoDaCompra.setBounds(192, 164, 139, 20);
		contentPane.add(lblPrecoDaCompra);
		
		precoCompraField = new JTextField();
		precoCompraField.setBounds(192, 188, 139, 32);
		contentPane.add(precoCompraField);
		precoCompraField.setColumns(10);
		
		quantidadeField = new JTextField();
		quantidadeField.setBounds(372, 188, 139, 32);
		contentPane.add(quantidadeField);
		quantidadeField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblQuantidade.setBounds(372, 164, 139, 20);
		contentPane.add(lblQuantidade);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		btnSalvar.setBounds(10, 232, 139, 39);
		contentPane.add(btnSalvar);
	}


	public JTextField getDataCompraField() {
		return dataCompraField;
	}


	public JTextField getVencimentoField() {
		return vencimentoField;
	}


	public JTextField getPrecoCompraField() {
		return precoCompraField;
	}


	public JTextField getQuantidadeField() {
		return quantidadeField;
	}


	public JComboBox getProdutoBox() {
		return produtoBox;
	}


	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	
	
}
