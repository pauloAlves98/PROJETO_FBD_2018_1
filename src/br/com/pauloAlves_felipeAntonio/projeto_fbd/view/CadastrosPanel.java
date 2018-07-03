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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CadastrosPanel extends JPanel{
	PacientesPanel telaPacientes;
	JPanel panel_3;
	JTable table;
	JTextField filtroField,descricaoField,textField_2;
	JButton btnNewButton,btnNewButton_1,btnNewButton_2;
	
	public CadastrosPanel() {
		setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 140, 493);
		panel_3.setLayout(null);
		add(panel_3);
		
		JButton btnNewButton = new JButton("Pacientes");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 58, 120, 33);
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Serviços");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 91, 120, 33);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFocusPainted(false);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fornecedores");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(10, 124, 120, 33);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFocusPainted(false);
		
		panel_3.add(btnNewButton_2);
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCadastros.setBounds(20, 11, 110, 24);
		panel_3.add(lblCadastros);
		
		telaPacientes = new PacientesPanel();
		telaPacientes.setBounds(141, 0, 657, 493);
		//telaPacientes.setLayout(null);
		add(telaPacientes);
		
		
	}
}
