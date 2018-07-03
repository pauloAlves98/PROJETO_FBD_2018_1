package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConsultaPanel extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public ConsultaPanel() {
		getContentPane().setLayout(null);
		setSize(528,379);
		
		JLabel lblSegDe = new JLabel("Seg, 21 de Maio as 08:00");
		lblSegDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSegDe.setBounds(10, 11, 231, 22);
		getContentPane().add(lblSegDe);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(10, 52, 46, 14);
		getContentPane().add(lblPaciente);
		
		textField = new JTextField();
		textField.setBounds(10, 66, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 66, 189, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(107, 65, 38, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(351, 65, 38, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(390, 65, 41, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(432, 65, 42, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblPlanoDeSade = new JLabel("Plano de Sa\u00FAde");
		lblPlanoDeSade.setBounds(10, 97, 86, 14);
		getContentPane().add(lblPlanoDeSade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 116, 464, 20);
		getContentPane().add(comboBox);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setBounds(10, 147, 46, 14);
		getContentPane().add(lblServio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 164, 197, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(219, 147, 46, 14);
		getContentPane().add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 164, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQtd = new JLabel("Qtd");
		lblQtd.setBounds(311, 147, 46, 14);
		getContentPane().add(lblQtd);
		
		textField_3 = new JTextField();
		textField_3.setBounds(313, 164, 46, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFolha = new JLabel("Folha");
		lblFolha.setBounds(370, 147, 46, 14);
		getContentPane().add(lblFolha);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(369, 164, 47, 20);
		getContentPane().add(comboBox_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(426, 163, 42, 23);
		getContentPane().add(btnNewButton_4);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 195, 46, 14);
		getContentPane().add(lblTelefone);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 209, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(107, 209, 86, 20);
		getContentPane().add(comboBox_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 240, 464, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(10, 289, 74, 52);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(400, 289, 74, 52);
		getContentPane().add(btnNewButton_6);
		
		JLabel lblSms = new JLabel("SMS 0/0");
		lblSms.setBounds(400, 271, 46, 14);
		getContentPane().add(lblSms);
		
		setVisible(true);

	}

}
