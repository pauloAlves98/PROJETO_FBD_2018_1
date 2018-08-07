package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoPanel extends JPanel {
	private JTextField filtroField;
	private JButton btnNovoProduto,buscaButton;
	//private JTable
	private JTableButton table;
	
	public ProdutoPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		JPanel panelNorth = new JPanel();
 		panelNorth.setBackground(Color.WHITE);
 		panelNorth.setPreferredSize(new Dimension(600,150));
 		add(panelNorth,BorderLayout.NORTH);
 		
 		panelNorth.setLayout(null);
 		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		
		lblCadastroDeProdutos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
		lblCadastroDeProdutos.setBounds(3, 11, 365, 27);
		panelNorth.add(lblCadastroDeProdutos);
		
		btnNovoProduto = new JButton("Novo Produto");
		
		btnNovoProduto.setFont(Propiedade.FONT2);
		btnNovoProduto.setBackground(Color.WHITE);
		btnNovoProduto.setBounds(3, 39, 208, 43);
		btnNovoProduto.setBorder(null);
		btnNovoProduto.setFocusPainted(false);
		panelNorth.add(btnNovoProduto);
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
 		lblFiltro.setBounds(10, 93, 46, 32);
 		panelNorth.add(lblFiltro);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(66, 95, 145, 32);
 		panelNorth.add(filtroField);
 		setBackground(Color.WHITE);
 		filtroField.setColumns(10);
 		
 		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		
 		buscaButton.setBounds(221, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		panelNorth.add(buscaButton);
 		
 		JTableButtonModel jTableButtonModel = new JTableButtonModel();
 		jTableButtonModel.adcionar(new Object[][] {
			},
			new String[] {
					"Nome","Tipo","Fornecedor","Cadastro"
			});
 		table = new JTableButton(jTableButtonModel);
 		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		
 		table.getScrollPane().setBounds(10, 146, 737, 200);
 		JPanel panelTabela = new JPanel();
 		panelTabela.setBackground(Color.WHITE);
 	
 		panelTabela.setPreferredSize(new Dimension(600,150));;
 		panelTabela.setLayout(new BorderLayout(0, 0));
 		panelTabela.add(table.getScrollPane(),BorderLayout.CENTER);
 		add(panelTabela,BorderLayout.CENTER);
 		
		
		
	}

	public JTextField getFiltroField() {
		return filtroField;
	}

	
	public JButton getBtnNovoProduto() {
		return btnNovoProduto;
	}

	public JButton getBuscaButton() {
		return buscaButton;
	}

	public JTableButton getTable() {
		return table;
	}
	
	

}
