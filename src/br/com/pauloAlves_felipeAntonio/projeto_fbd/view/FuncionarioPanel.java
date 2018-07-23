package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class FuncionarioPanel extends JPanel{
	private JTextField filtroField,cpfPesqField,terceiroField;
	private JTableButton table;
	private JButton funcionarioButton,buscaButton ;
	public FuncionarioPanel() {
    	setBounds(0, 0, 657, 493);
 		setLayout(null); 
 		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Funcionário");
 		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
 		lblCadastroDePacientes.setBounds(3, 11, 365, 27);
 		add(lblCadastroDePacientes);
 		
 		funcionarioButton = new JButton("Novo Funcionário");
 		funcionarioButton.setFont(Propiedade.FONT2);
 		funcionarioButton.setBackground(Color.WHITE);
 		funcionarioButton.setBounds(3, 39, 208, 43);
 		funcionarioButton.setBorder(null);
 		funcionarioButton.setFocusPainted(false);
 		add(funcionarioButton);
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
 		lblFiltro.setBounds(10, 93, 46, 32);
 		add(lblFiltro);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(66, 95, 145, 32);
 		add(filtroField);
 		setBackground(Color.WHITE);
 		filtroField.setColumns(10);
 		
 		cpfPesqField = new JTextField();
 		cpfPesqField.setBounds(221, 95, 176, 32);
 		add(cpfPesqField);
 		cpfPesqField.setColumns(10);
 		
 		terceiroField = new JTextField();
 		terceiroField.setBounds(407, 95, 176, 32);
 		add(terceiroField);
 		terceiroField.setColumns(10);
 		
 		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		
 		buscaButton.setBounds(600, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		add(buscaButton);
 		
 		JTableButtonModel jTableButtonModel = new JTableButtonModel();
 		jTableButtonModel.adcionar(new Object[][] {
			},
			new String[] {
					"Nome","RG", "CPF", "Telefone", "Nascimento"
			});
 		table = new JTableButton(jTableButtonModel);
 		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		
 		table.getScrollPane().setBounds(10, 146, 737, 200);
 		add(table.getScrollPane());
 		
// 		JScrollPane scrollPane = new JScrollPane(table);
// 		scrollPane.setBounds(10, 146, 737, 200);
// 		add(scrollPane);
 		setVisible(false);
 	}
	public JTextField getFiltroField() {
		return filtroField;
	}
	public void setFiltroField(JTextField filtroField) {
		this.filtroField = filtroField;
	}
	public JTextField getCpfPesqField() {
		return cpfPesqField;
	}
	public void setCpfPesqField(JTextField cpfPesqField) {
		this.cpfPesqField = cpfPesqField;
	}
	public JTextField getTerceiroField() {
		return terceiroField;
	}
	public void setTerceiroField(JTextField terceiroField) {
		this.terceiroField = terceiroField;
	}
	public JTableButton getTable() {
		return table;
	}
	public void setTable(JTableButton table) {
		this.table = table;
	}
	public JButton getFuncionarioButton() {
		return funcionarioButton;
	}
	public void setFuncionarioButton(JButton pacienteButton) {
		this.funcionarioButton = pacienteButton;
	}
	public JButton getBuscaButton() {
		return buscaButton;
	}
	public void setBuscaButton(JButton buscaButton) {
		this.buscaButton = buscaButton;
	}
	
}
