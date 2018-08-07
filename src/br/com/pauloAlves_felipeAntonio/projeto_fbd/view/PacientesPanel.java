package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class PacientesPanel extends JPanel{
	private JTextField filtroField,descricaoField,textField_2;
	private JTableButton table;
	private JButton pacienteButton,buscaButton ;
	public PacientesPanel() {
    	setBounds(141, 0, 657, 493);
		setLayout(new BorderLayout(0, 0));
		JPanel panelNorth = new JPanel();
 		panelNorth.setBackground(Color.WHITE);
 		add(panelNorth,BorderLayout.NORTH);
 		panelNorth.setPreferredSize(new Dimension(600,150));
 		panelNorth.setLayout(null); 
 		
 		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
 		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
 		lblCadastroDePacientes.setBounds(3, 11, 365, 27);
 		panelNorth.add(lblCadastroDePacientes);
 		
 		pacienteButton = new JButton("Novo Paciente");
 		pacienteButton.setFont(Propiedade.FONT2);
 		pacienteButton.setBackground(Color.WHITE);
 		pacienteButton.setBounds(3, 39, 208, 43);
 		pacienteButton.setBorder(null);
 		pacienteButton.setFocusPainted(false);
 		panelNorth.add(pacienteButton);
 		
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
					"Nome","RG", "CPF", "Telefone", "Nascimento"
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
	
	public JTableButton getTable() {
		return table;
	}
	public void setTable(JTableButton table) {
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
