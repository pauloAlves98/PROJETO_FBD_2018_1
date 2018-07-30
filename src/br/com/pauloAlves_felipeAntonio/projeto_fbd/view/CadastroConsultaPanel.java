package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class CadastroConsultaPanel extends JPanel{
	
	private JTextField pacienteField;
	private JTextField medicoField;
	private JDateChooser dataC;
	private JButton concluirButton ;
	private JComboBox horarioBox;
	private JButton buscarPacienteButton ;
	private JButton buscarMedicoButton;
	private JTextField codPacienteField;
	private JTextField codMedicoField;
	
	public CadastroConsultaPanel(){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(1000,600));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1000,600));
		
		JLabel lblCadastroDeConsultas = new JLabel("Cadastro de Consulta");
		lblCadastroDeConsultas.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
		lblCadastroDeConsultas.setBounds(10, 11, 336, 23);
		panel.add(lblCadastroDeConsultas);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblPaciente.setBounds(1, 107, 81, 31);
		panel.add(lblPaciente);
		
		pacienteField = new JTextField();
		pacienteField.setBackground(Color.WHITE);
		pacienteField.setEditable(false);
		pacienteField.setFont(new Font("Arial", Font.PLAIN, 13));
		pacienteField.setBounds(126, 108, 213, 32);
		panel.add(pacienteField);
		pacienteField.setColumns(10);
		
		buscarPacienteButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		buscarPacienteButton.setBounds(344, 107, 32, 32);
		buscarPacienteButton.setBackground(Color.white);
		panel.add(buscarPacienteButton);
		
		JLabel lblMdico = new JLabel("M\u00E9dico");
		lblMdico.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblMdico.setBounds(1, 158, 72, 32);
		panel.add(lblMdico);
		
		medicoField = new JTextField();
		medicoField.setEditable(false);
		medicoField.setBackground(Color.WHITE);
		medicoField.setFont(new Font("Arial", Font.PLAIN, 13));
		medicoField.setBounds(126, 160, 213, 32);
		panel.add(medicoField);
		medicoField.setColumns(10);
		
		buscarMedicoButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		buscarMedicoButton.setBackground(Color.WHITE);
		buscarMedicoButton.setBounds(344, 160, 32, 32);
		panel.add(buscarMedicoButton);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblData.setBounds(1, 206, 81, 31);
		panel.add(lblData);
		
		dataC = new JDateChooser(new Date());
		dataC.setBounds(71,203, 305, 32);
		panel.add(dataC);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio ");
		lblHorrio.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblHorrio.setBounds(1, 248, 81, 32);
		panel.add(lblHorrio);
		
		concluirButton = new JButton("Concluir");
		concluirButton.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		concluirButton.setBackground(Color.WHITE);
		concluirButton.setBounds(245, 248, 131, 32);
		panel.add(concluirButton);
		
		horarioBox = new JComboBox();
		horarioBox.setBackground(Color.WHITE);
		horarioBox.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		horarioBox.setBounds(71, 247, 171, 32);
		panel.add(horarioBox);
		
		codPacienteField = new JTextField();
		codPacienteField.setForeground(Color.BLACK);
		codPacienteField.setEditable(false);
		codPacienteField.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		codPacienteField.setBounds(71, 108, 55, 32);
		panel.add(codPacienteField);
		codPacienteField.setColumns(10);
		
		codMedicoField = new JTextField();
		codMedicoField.setForeground(Color.BLACK);
		codMedicoField.setEditable(false);
		codMedicoField.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		codMedicoField.setBounds(71, 160, 55, 32);
		panel.add(codMedicoField);
		codMedicoField.setColumns(10);
	}

	public JTextField getPacienteField() {
		return pacienteField;
	}

	public void setPacienteField(JTextField pacienteField) {
		this.pacienteField = pacienteField;
	}

	public JTextField getMedicoField() {
		return medicoField;
	}

	public void setMedicoField(JTextField medicoField) {
		this.medicoField = medicoField;
	}

	public JDateChooser getDataC() {
		return dataC;
	}

	public void setDataC(JDateChooser dataC) {
		this.dataC = dataC;
	}

	public JComboBox getHorarioBox() {
		return horarioBox;
	}

	public void setHorarioBox(JComboBox horarioBox) {
		this.horarioBox = horarioBox;
	}

	public JButton getConcluirButton() {
		return concluirButton;
	}

	public void setConcluirButton(JButton concluirButton) {
		this.concluirButton = concluirButton;
	}

	public JButton getBuscarPacienteButton() {
		return buscarPacienteButton;
	}

	public void setBuscarPacienteButton(JButton buscarPacienteButton) {
		this.buscarPacienteButton = buscarPacienteButton;
	}

	public JButton getBuscarMedicoButton() {
		return buscarMedicoButton;
	}

	public void setBuscarMedicoButton(JButton buscarMedicoButton) {
		this.buscarMedicoButton = buscarMedicoButton;
	}

	public JTextField getCodPacienteField() {
		return codPacienteField;
	}

	public void setCodPacienteField(JTextField codPacienteField) {
		this.codPacienteField = codPacienteField;
	}

	public JTextField getCodMedicoField() {
		return codMedicoField;
	}

	public void setCodMedicoField(JTextField codMedicoField) {
		this.codMedicoField = codMedicoField;
	}
	
}
