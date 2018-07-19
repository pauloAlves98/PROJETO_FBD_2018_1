package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PacientesPanel extends JPanel{
	private JTextField filtroField,descricaoField,textField_2;
	private JTable table;
	private JButton pacienteButton,buscaButton ;
	public PacientesPanel() {
    	//setBounds(141, 0, 657, 493);
 		setLayout(null); 
 		
 		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
 		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
 		lblCadastroDePacientes.setBounds(3, 11, 365, 27);
 		add(lblCadastroDePacientes);
 		
 		pacienteButton = new JButton("Novo Paciente");
 		pacienteButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		pacienteButton.setBackground(Color.WHITE);
 		pacienteButton.setBounds(3, 39, 208, 43);
 		pacienteButton.setBorder(null);
 		pacienteButton.setFocusPainted(false);
 		add(pacienteButton);
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
 		lblFiltro.setBounds(10, 93, 46, 32);
 		add(lblFiltro);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(66, 95, 145, 32);
 		add(filtroField);
 		setBackground(Color.WHITE);
 		filtroField.setColumns(10);
 		
 		descricaoField = new JTextField();
 		descricaoField.setBounds(221, 95, 176, 32);
 		add(descricaoField);
 		descricaoField.setColumns(10);
 		
 		textField_2 = new JTextField();
 		textField_2.setBounds(407, 95, 176, 32);
 		add(textField_2);
 		textField_2.setColumns(10);
 		
 		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		
 		buscaButton.setBounds(600, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		add(buscaButton);
 		
 		table = new JTable();
 		table.setBackground(Color.WHITE);
 		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.setShowGrid(true);
 		table.setModel(new DefaultTableModel(
 			new Object[][] {
 			},
 			new String[] {
 				"Nome", "CPF", "Telefone", "RG", "Cadastro"
 			}
 		));
 		table.setBounds(10, 146, 737, 100);
 		add(table);
 		
 		JScrollPane scrollPane = new JScrollPane(table);
 		scrollPane.setBounds(10, 146, 737, 200);
 		add(scrollPane);
 	}
	public JTextField getFiltroField() {
		return filtroField;
	}
	public void setFiltroField(JTextField filtroField) {
		this.filtroField = filtroField;
	}
	public JTextField getDescricaoField() {
		return descricaoField;
	}
	public void setDescricaoField(JTextField descricaoField) {
		this.descricaoField = descricaoField;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JButton getBtnNewButton_3() {
		return pacienteButton;
	}
	public void setBtnNewButton_3(JButton btnNewButton_3) {
		this.pacienteButton = btnNewButton_3;
	}
	public JButton getPacienteButton() {
		return pacienteButton;
	}
	public void setPacienteButton(JButton pacienteButton) {
		this.pacienteButton = pacienteButton;
	}
	public JButton getBuscaButton() {
		return buscaButton;
	}
	public void setBuscaButton(JButton buscaButton) {
		this.buscaButton = buscaButton;
	}
	
	
}
