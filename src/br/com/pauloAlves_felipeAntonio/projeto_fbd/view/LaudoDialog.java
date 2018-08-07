package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LaudoDialog extends JDialog{
	private JTextField codLaudoField;
	private JTextField dataField;
	private JTextField medicoField;
	private JTextField codMedField;
	private JTextField codPacienteField;
	private JTextField pacienteField;
	private JButton btnSalvar;
	private JTextArea descricaoArea;
	private JButton baixarButton;
	public LaudoDialog(){
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		setSize(450,600);
		setResizable(false);
		setLocationRelativeTo(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 451, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laudo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 33));
		lblNewLabel.setBounds(10, 11, 259, 79);
		panel.add(lblNewLabel);
		
		JLabel lblCod = new JLabel("Cod");
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCod.setBounds(10, 112, 71, 14);
		getContentPane().add(lblCod);
		
		codLaudoField = new JTextField();
		codLaudoField.setBackground(Color.WHITE);
		codLaudoField.setEditable(false);
		codLaudoField.setBounds(10, 128, 53, 32);
		getContentPane().add(codLaudoField);
		codLaudoField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(73, 112, 83, 14);
		getContentPane().add(lblData);
		
		dataField = new JTextField();
		dataField.setBackground(Color.WHITE);
		dataField.setEditable(false);
		dataField.setBounds(73, 128, 134, 32);
		getContentPane().add(dataField);
		dataField.setColumns(10);
		
		JLabel lblMedico = new JLabel("M\u00E9dico");
		lblMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMedico.setBounds(10, 175, 145, 20);
		getContentPane().add(lblMedico);
		
		medicoField = new JTextField();
		medicoField.setBackground(Color.WHITE);
		medicoField.setEditable(false);
		medicoField.setBounds(58, 193, 366, 32);
		getContentPane().add(medicoField);
		medicoField.setColumns(10);
		
		codMedField = new JTextField();
		codMedField.setBackground(Color.WHITE);
		codMedField.setEditable(false);
		codMedField.setBounds(10, 193, 46, 32);
		getContentPane().add(codMedField);
		codMedField.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaciente.setBounds(10, 242, 134, 14);
		getContentPane().add(lblPaciente);
		
		codPacienteField = new JTextField();
		codPacienteField.setBackground(Color.WHITE);
		codPacienteField.setForeground(Color.BLACK);
		codPacienteField.setEditable(false);
		codPacienteField.setBounds(10, 257, 46, 32);
		getContentPane().add(codPacienteField);
		codPacienteField.setColumns(10);
		
		pacienteField = new JTextField();
		pacienteField.setBackground(Color.WHITE);
		pacienteField.setEditable(false);
		pacienteField.setBounds(58, 257, 366, 32);
		getContentPane().add(pacienteField);
		pacienteField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 322, 414, 170);
		getContentPane().add(scrollPane);
		
		descricaoArea = new JTextArea();
		descricaoArea.setLineWrap(true);
		scrollPane.setViewportView(descricaoArea);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrio.setBounds(10, 297, 97, 14);
		getContentPane().add(lblDescrio);
		
	    btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBounds(10, 504, 112, 32);
		getContentPane().add(btnSalvar);
		
		baixarButton = new JButton(new ImageIcon("Res/download.png"));
		baixarButton.setBackground(new Color(0, 0, 255));
		baixarButton.setBounds(132, 503, 32, 32);
		getContentPane().add(baixarButton);
		
		setModal(true);
		
	}
	public JTextField getCodLaudoField() {
		return codLaudoField;
	}
	public void setCodLaudoField(JTextField codLaudoField) {
		this.codLaudoField = codLaudoField;
	}
	public JTextField getDataField() {
		return dataField;
	}
	public void setDataField(JTextField dataField) {
		this.dataField = dataField;
	}
	public JTextField getMedicoField() {
		return medicoField;
	}
	public void setMedicoField(JTextField medicoField) {
		this.medicoField = medicoField;
	}
	public JTextField getCodMedField() {
		return codMedField;
	}
	public void setCodMedField(JTextField codMedField) {
		this.codMedField = codMedField;
	}
	public JTextField getCodPacienteField() {
		return codPacienteField;
	}
	public void setCodPacienteField(JTextField codPacienteField) {
		this.codPacienteField = codPacienteField;
	}
	public JTextField getPacienteField() {
		return pacienteField;
	}
	public void setPacienteField(JTextField pacienteField) {
		this.pacienteField = pacienteField;
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
	public JTextArea getDescricaoArea() {
		return descricaoArea;
	}
	public void setDescricaoArea(JTextArea descricaoArea) {
		this.descricaoArea = descricaoArea;
	}
	public JButton getBaixarButton() {
		return baixarButton;
	}
	public void setBaixarButton(JButton baixarButton) {
		this.baixarButton = baixarButton;
	}
	
}
