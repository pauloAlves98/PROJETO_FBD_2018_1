package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setSize(528,452);
		
		JLabel lblSegDe = new JLabel("Seg, 21 de Maio as 08:00");
		lblSegDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSegDe.setBounds(10, 11, 231, 22);
		getContentPane().add(lblSegDe);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(10, 52, 46, 14);
		getContentPane().add(lblPaciente);
		
		textField = new JTextField();
		textField.setBounds(10, 77, 86, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 77, 189, 31);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(107, 76, 38, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(347, 76, 38, 32);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(393, 77, 41, 31);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(444, 76, 42, 32);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblPlanoDeSade = new JLabel("Plano de Sa\u00FAde");
		lblPlanoDeSade.setBounds(10, 119, 86, 14);
		getContentPane().add(lblPlanoDeSade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 134, 476, 32);
		getContentPane().add(comboBox);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setBounds(10, 177, 46, 14);
		getContentPane().add(lblServio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 202, 197, 32);
		getContentPane().add(comboBox_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(217, 177, 46, 14);
		getContentPane().add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 202, 86, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQtd = new JLabel("Qtd");
		lblQtd.setBounds(311, 177, 46, 14);
		getContentPane().add(lblQtd);
		
		textField_3 = new JTextField();
		textField_3.setBounds(311, 202, 46, 32);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFolha = new JLabel("Folha");
		lblFolha.setBounds(369, 177, 46, 14);
		getContentPane().add(lblFolha);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(369, 202, 47, 32);
		getContentPane().add(comboBox_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(432, 202, 42, 33);
		getContentPane().add(btnNewButton_4);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 245, 46, 14);
		getContentPane().add(lblTelefone);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 270, 86, 31);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(108, 270, 86, 31);
		getContentPane().add(comboBox_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 312, 464, 32);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(10, 362, 74, 41);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(400, 362, 74, 41);
		getContentPane().add(btnNewButton_6);
		
		JLabel lblSms = new JLabel("SMS 0/0");
		lblSms.setBounds(400, 345, 46, 14);
		getContentPane().add(lblSms);
		
		setVisible(true);

	}

}
