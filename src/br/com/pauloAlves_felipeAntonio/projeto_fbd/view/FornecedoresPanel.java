package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.app.App;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FornecedoresPanel extends JPanel {
	private JTableButton table;
	private JTextField textField;
	private JButton buscaButton,NovoFornecedorButton;

	/**
	 * Create the panel.
	 */
	public FornecedoresPanel() {
			
		setLayout(new BorderLayout(0, 0));
		JPanel panelNorth = new JPanel();
 		panelNorth.setBackground(Color.WHITE);
 		add(panelNorth,BorderLayout.NORTH);
 		panelNorth.setPreferredSize(new Dimension(600,150));
 		panelNorth.setLayout(null);
		
		JLabel lblCadastroDeFornecedores = new JLabel("Cadastro De Fornecedores");
		lblCadastroDeFornecedores.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
		lblCadastroDeFornecedores.setBounds(3, 11, 365, 27);
		panelNorth.add(lblCadastroDeFornecedores);
		
		NovoFornecedorButton = new JButton("Novo Fornecedor");
		NovoFornecedorButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		NovoFornecedorButton.setBackground(Color.WHITE);
		NovoFornecedorButton.setBounds(3, 39, 208, 43);
		NovoFornecedorButton.setBorder(null);
		NovoFornecedorButton.setFocusPainted(false);
		panelNorth.add(NovoFornecedorButton);
		
		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		
 		buscaButton.setBounds(221, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		panelNorth.add(buscaButton);
		
 		JTableButtonModel jtableButtonModel= new JTableButtonModel();
 		jtableButtonModel.adcionar(new Object[][] {
		},new String[] {
				"Nome", "CNPJ", "Incs. municipal","Telefone", "Cadastro"
			});
		table = new JTableButton(jtableButtonModel);
		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		
		table.getTable().setRowHeight(40);
		add(table.getScrollPane());
		JPanel panelTabela = new JPanel();
 		panelTabela.setBackground(Color.WHITE);
 	
 		panelTabela.setPreferredSize(new Dimension(600,150));;
 		panelTabela.setLayout(new BorderLayout(0, 0));
 		table.getScrollPane().setBounds(10, 146, 737, 200);
 		
 		panelTabela.add(table.getScrollPane(),BorderLayout.CENTER);
 		add(panelTabela,BorderLayout.CENTER);
 		
		
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(10, 146, 737, 200);
//		add(scrollPane);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblFiltro.setBounds(10, 93, 46, 32);
		panelNorth.add(lblFiltro);
		
		textField = new JTextField();
		textField.setBounds(66, 95, 145, 32);
		panelNorth.add(textField);
		textField.setColumns(10);
		//App.lookNimbus();
		

	}
	

	public JButton getNovoFornecedorButton() {
		return NovoFornecedorButton;
	}


	

	public JTableButton getTable() {
		return table;
	}


	public void setTable(JTableButton table) {
		this.table = table;
	}


	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	
	public JButton getBuscaButton() {
		return buscaButton;
	}

	public void setBuscaButton(JButton buscaButton) {
		this.buscaButton = buscaButton;
	}
	
	
}
