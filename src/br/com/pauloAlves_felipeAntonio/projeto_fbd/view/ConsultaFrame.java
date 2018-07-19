package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class ConsultaFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public ConsultaFrame() {
		getContentPane().setLayout(null);
		setSize(528,507);
		
		JLabel lblSegDe = new JLabel("Seg, 21 de Maio as 08:00");
		lblSegDe.setForeground(Color.WHITE);
		lblSegDe.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 26));
		lblSegDe.setBounds(10, 11, 401, 62);
		getContentPane().add(lblSegDe);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblPaciente.setBounds(10, 104, 46, 14);
		getContentPane().add(lblPaciente);
		
		textField = new JTextField();
		textField.setBounds(10, 128, 86, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 128, 189, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(107, 128, 38, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(350, 128, 38, 32);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(394, 128, 41, 32);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(445, 128, 42, 32);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblPlanoDeSade = new JLabel("Plano de Sa\u00FAde");
		lblPlanoDeSade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblPlanoDeSade.setBounds(10, 161, 86, 14);
		getContentPane().add(lblPlanoDeSade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 186, 477, 32);
		getContentPane().add(comboBox);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblServio.setBounds(10, 229, 46, 14);
		getContentPane().add(lblServio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 254, 197, 32);
		getContentPane().add(comboBox_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblValor.setBounds(217, 229, 46, 14);
		getContentPane().add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 254, 86, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQtd = new JLabel("Qtd");
		lblQtd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblQtd.setBounds(304, 229, 46, 14);
		getContentPane().add(lblQtd);
		
		textField_3 = new JTextField();
		textField_3.setBounds(304, 254, 55, 32);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFolha = new JLabel("Folha");
		lblFolha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblFolha.setBounds(370, 229, 46, 14);
		getContentPane().add(lblFolha);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(369, 254, 74, 32);
		getContentPane().add(comboBox_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(445, 254, 42, 32);
		getContentPane().add(btnNewButton_4);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblTelefone.setBounds(10, 297, 97, 14);
		getContentPane().add(lblTelefone);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 314, 86, 32);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(106, 314, 86, 32);
		getContentPane().add(comboBox_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 357, 464, 29);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(10, 406, 74, 52);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(400, 406, 74, 52);
		getContentPane().add(btnNewButton_6);
		
		JLabel lblSms = new JLabel("SMS 0/0");
		lblSms.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblSms.setBounds(400, 393, 46, 14);
		getContentPane().add(lblSms);
		
		getContentPane().setBackground(Color.WHITE);
		
		PaneGradiente panel = new PaneGradiente (Propiedade.cor1,Color.black);
		panel.setBounds(0, 0, 565, 99);
		getContentPane().add(panel);
	//	setVisible(true);

	}

}
