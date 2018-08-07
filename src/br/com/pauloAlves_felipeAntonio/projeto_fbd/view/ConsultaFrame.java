package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import javax.swing.JFormattedTextField;

public class ConsultaFrame extends JDialog{
	private JTextField pacienteField;
	private JTextField medicoField;
	private JTextField tipoField;
	private JTextField statusField;
	private JTextField espField;
	private JTextField codField;
	private JButton btnCancelar;
	private JButton remarcarButton;
	private JButton btnConcluir;
	private JFormattedTextField dataField;
	/**
	 * Create the panel.
	 */
	JLabel lblSegDe;
	

	public ConsultaFrame() {
		getContentPane().setLayout(null);
		setSize(440,400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblSegDe = new JLabel("Detalhes");
		lblSegDe.setForeground(Color.WHITE);
		lblSegDe.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 26));
		lblSegDe.setBounds(10, 11, 401, 62);
		getContentPane().add(lblSegDe);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaciente.setBounds(10, 110, 164, 14);
		getContentPane().add(lblPaciente);
		
		pacienteField = new JTextField();
		pacienteField.setBackground(Color.WHITE);
		pacienteField.setEditable(false);
		pacienteField.setBounds(10, 135, 234, 32);
		getContentPane().add(pacienteField);
		pacienteField.setColumns(10);
		
		getContentPane().setBackground(Color.WHITE);
		
		PaneGradiente panel = new PaneGradiente (Propiedade.cor1,Color.black);
		panel.setBounds(0, 0, 565, 99);
		getContentPane().add(panel);
		
		JLabel lblMedico = new JLabel("M\u00E9dico");
		lblMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMedico.setBounds(10, 171, 182, 14);
		getContentPane().add(lblMedico);
		
		medicoField = new JTextField();
		medicoField.setBackground(Color.WHITE);
		medicoField.setEditable(false);
		medicoField.setBounds(10, 187, 182, 32);
		getContentPane().add(medicoField);
		medicoField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Horário");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(10, 225, 46, 14);
		getContentPane().add(lblTipo);
		
		tipoField = new JTextField();
		tipoField.setBackground(Color.WHITE);
		tipoField.setEditable(false);
		tipoField.setBounds(10, 244, 110, 32);
		getContentPane().add(tipoField);
		tipoField.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(150, 225, 46, 14);
		getContentPane().add(lblStatus);
		
		statusField = new JTextField();
		statusField.setBackground(Color.WHITE);
		statusField.setEditable(false);
		statusField.setBounds(150, 244, 124, 32);
		getContentPane().add(statusField);
		statusField.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(284, 225, 46, 14);
		getContentPane().add(lblData);
		
		espField = new JTextField();
		espField.setBackground(Color.WHITE);
		espField.setEditable(false);
		espField.setBounds(202, 187, 224, 32);
		getContentPane().add(espField);
		espField.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspecialidade.setBounds(202, 171, 174, 14);
		getContentPane().add(lblEspecialidade);
		
		dataField = new JFormattedTextField();
		dataField.setBackground(Color.WHITE);
		dataField.setEditable(false);
		dataField.setBounds(284, 244, 142, 32);
		this.mascaraData();
		getContentPane().add(dataField);
		
		 remarcarButton = new JButton("Remarcar");
		 remarcarButton.setForeground(Color.WHITE);
		 remarcarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		 remarcarButton.setBackground(new Color(0, 102, 204));
		remarcarButton.setBounds(10, 329, 110, 32);
		getContentPane().add(remarcarButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(284, 329, 142, 32);
		getContentPane().add(btnCancelar);
		
		JLabel lblCod = new JLabel("CPF");
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCod.setBounds(255, 110, 46, 14);
		getContentPane().add(lblCod);
		
		codField = new JTextField();
		codField.setBackground(Color.WHITE);
		codField.setForeground(Color.BLACK);
		codField.setEditable(false);
		codField.setBounds(254, 135, 172, 32);
		getContentPane().add(codField);
		codField.setColumns(10);
		
		btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(Color.WHITE);
		btnConcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConcluir.setBackground(new Color(51, 255, 102));
		btnConcluir.setBounds(144, 329, 130, 32);
		getContentPane().add(btnConcluir);
		
		JLabel lblOpesDaConsulta = new JLabel("Op\u00E7\u00F5es da Consulta");
		lblOpesDaConsulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOpesDaConsulta.setBounds(10, 299, 215, 19);
		getContentPane().add(lblOpesDaConsulta);
		
		setModal(true);
	//	setVisible(true);

	}
	private void mascaraData() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			format_textField4.install(dataField );
		}catch (Exception e){}
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
	public JTextField getTipoField() {
		return tipoField;
	}
	public void setTipoField(JTextField tipoField) {
		this.tipoField = tipoField;
	}
	public JTextField getStatusField() {
		return statusField;
	}
	public void setStatusField(JTextField statusField) {
		this.statusField = statusField;
	}
	public JTextField getEspField() {
		return espField;
	}
	public void setEspField(JTextField espField) {
		this.espField = espField;
	}
	public JTextField getCodField() {
		return codField;
	}
	public void setCodField(JTextField codField) {
		this.codField = codField;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	public JButton getRemarcarButton() {
		return remarcarButton;
	}
	public void setRemarcarButton(JButton remarcarButton) {
		this.remarcarButton = remarcarButton;
	}
	public JButton getBtnConcluir() {
		return btnConcluir;
	}
	public void setBtnConcluir(JButton btnConcluir) {
		this.btnConcluir = btnConcluir;
	}
	public JFormattedTextField getDataField() {
		return dataField;
	}
	public void setDataField(JFormattedTextField dataField) {
		this.dataField = dataField;
	}
}
