package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class FornecedoresPanel extends JPanel {
	private JTableButton table;
	private JTextField textField;
	private JTextField textField_1;
	private JButton buscaButton,NovoFornecedorButton;

	/**
	 * Create the panel.
	 */
	public FornecedoresPanel() {
		setLayout(null);
		
		JLabel lblCadastroDeFornecedores = new JLabel("Cadastro De Fornecedores");
		lblCadastroDeFornecedores.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
		lblCadastroDeFornecedores.setBounds(3, 11, 365, 27);
		add(lblCadastroDeFornecedores);
		
		NovoFornecedorButton = new JButton("Novo Fornecedor");
		NovoFornecedorButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		NovoFornecedorButton.setBackground(Color.WHITE);
		NovoFornecedorButton.setBounds(3, 39, 208, 43);
		NovoFornecedorButton.setBorder(null);
		NovoFornecedorButton.setFocusPainted(false);
		add(NovoFornecedorButton);
		
		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		
 		buscaButton.setBounds(407, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		add(buscaButton);
		
 		JTableButtonModel jtableButtonModel= new JTableButtonModel();
 		jtableButtonModel.adcionar(new Object[][] {
		},new String[] {
				"Nome", "CPF", "Incs. municipal","Telefone", "Cadastro"
			});
		table = new JTableButton(jtableButtonModel);
		table.getScrollPane().setBounds(10, 146, 737, 200);
		add(table.getScrollPane());
		
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(10, 146, 737, 200);
//		add(scrollPane);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblFiltro.setBounds(10, 93, 46, 32);
		add(lblFiltro);
		
		textField = new JTextField();
		textField.setBounds(66, 95, 145, 32);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(221, 95, 176, 32);
		add(textField_1);
		textField_1.setColumns(10);
		

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

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JButton getBuscaButton() {
		return buscaButton;
	}

	public void setBuscaButton(JButton buscaButton) {
		this.buscaButton = buscaButton;
	}
	
	
}
