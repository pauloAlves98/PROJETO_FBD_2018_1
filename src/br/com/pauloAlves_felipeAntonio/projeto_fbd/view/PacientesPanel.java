package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton btnNewButton_3,btnNewButton_4 ;
	public PacientesPanel() {
    	//setBounds(141, 0, 657, 493);
 		setLayout(null);
 		
 		
 		JLabel lblCadastroDePacientes = new JLabel("Cadastro De Pacientes");
 		lblCadastroDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		lblCadastroDePacientes.setBounds(54, 32, 337, 27);
 		add(lblCadastroDePacientes);
 		
 		btnNewButton_3 = new JButton("Novo Paciente");
 		btnNewButton_3.setBackground(Color.WHITE);
 		btnNewButton_3.setBounds(423, 29, 208, 43);
 		btnNewButton_3.setBorder(null);
 		btnNewButton_3.setFocusPainted(false);
 		add(btnNewButton_3);
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setBounds(225, 98, 46, 14);
 		add(lblFiltro);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(264, 95, 86, 20);
 		add(filtroField);
 		setBackground(new Color(0,128,255));
 		filtroField.setColumns(10);
 		
 		descricaoField = new JTextField();
 		descricaoField.setBounds(360, 95, 139, 20);
 		add(descricaoField);
 		descricaoField.setColumns(10);
 		
 		textField_2 = new JTextField();
 		textField_2.setBounds(509, 95, 86, 20);
 		add(textField_2);
 		textField_2.setColumns(10);
 		
 		btnNewButton_4 = new JButton("");
 		
 		btnNewButton_4.setBounds(612, 92, 35, 23);
 		add(btnNewButton_4);
 		
 		table = new JTable();
 		table.setModel(new DefaultTableModel(
 			new Object[][] {
 			},
 			new String[] {
 				"Ativo", "Prontuario", "Nome", "Nascimento", "Cadastro"
 			}
 		));
 		table.setBounds(10, 146, 637, 242);
 		add(table);
 		
 		JScrollPane scrollPane = new JScrollPane(table);
 		scrollPane.setBounds(10, 146, 637, 336);
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
		return btnNewButton_3;
	}
	public void setBtnNewButton_3(JButton btnNewButton_3) {
		this.btnNewButton_3 = btnNewButton_3;
	}
	
}
