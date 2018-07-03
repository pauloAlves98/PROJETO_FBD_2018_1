package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class CadastroPacientePanel extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Create the panel.
	 */
	public CadastroPacientePanel() {
		setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		setSize(660,558);
		JLabel lblProntuario = new JLabel("Prontuario");
		lblProntuario.setBounds(117, 39, 72, 14);
		getContentPane().add(lblProntuario);
		
		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
		lblCadastroDePacientes.setBackground(Color.LIGHT_GRAY);
		lblCadastroDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCadastroDePacientes.setBounds(10, 11, 389, 17);
		getContentPane().add(lblCadastroDePacientes);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(230, 39, 46, 14);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(117, 61, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 61, 366, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(117, 92, 46, 14);
		getContentPane().add(lblSexo);
		
		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(230, 92, 64, 14);
		getContentPane().add(lblNascimento);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(316, 92, 46, 14);
		getContentPane().add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(414, 92, 46, 14);
		getContentPane().add(lblCelular);
		
		JLabel lblOperadora = new JLabel("Operadora");
		lblOperadora.setBounds(510, 92, 56, 14);
		getContentPane().add(lblOperadora);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 111, 76, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(316, 111, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(414, 111, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(510, 111, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(10, 152, 46, 14);
		getContentPane().add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 171, 179, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setBounds(10, 202, 72, 14);
		getContentPane().add(lblObservao);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 227, 586, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.CYAN);
		tabbedPane.setBounds(10, 271, 630, 208);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblPlanoDeSade = new JLabel("Plano de Sa\u00FAde");
		lblPlanoDeSade.setBounds(10, 11, 119, 14);
		panel.add(lblPlanoDeSade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 25, 181, 20);
		panel.add(comboBox);
		
		JLabel lblNumeroDeCarteira = new JLabel("Numero de Carteira");
		lblNumeroDeCarteira.setBounds(204, 11, 101, 14);
		panel.add(lblNumeroDeCarteira);
		
		textField_8 = new JTextField();
		textField_8.setBounds(201, 25, 239, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblValidCarteira = new JLabel("Valid Carteira");
		lblValidCarteira.setBounds(448, 11, 113, 14);
		panel.add(lblValidCarteira);
		
		textField_9 = new JTextField();
		textField_9.setBounds(450, 25, 119, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(10, 66, 93, 20);
		panel.add(lblEndereo);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(10, 93, 46, 14);
		panel.add(lblCep);
		
		textField_10 = new JTextField();
		textField_10.setBounds(10, 107, 86, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblQuadra = new JLabel("Quadra");
		lblQuadra.setBounds(10, 130, 46, 14);
		panel.add(lblQuadra);
		
		textField_11 = new JTextField();
		textField_11.setBounds(10, 149, 46, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblLote = new JLabel("Lote");
		lblLote.setBounds(71, 130, 46, 14);
		panel.add(lblLote);
		
		textField_12 = new JTextField();
		textField_12.setBounds(66, 149, 69, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(145, 130, 46, 14);
		panel.add(lblBairro);
		
		textField_13 = new JTextField();
		textField_13.setBounds(145, 149, 181, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(145, 93, 101, 14);
		panel.add(lblLogradouro);
		
		textField_14 = new JTextField();
		textField_14.setBounds(145, 107, 191, 20);
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(346, 93, 46, 14);
		panel.add(lblNumero);
		
		textField_15 = new JTextField();
		textField_15.setBounds(346, 107, 69, 20);
		panel.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(422, 93, 93, 14);
		panel.add(lblComplemento);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(336, 130, 46, 14);
		panel.add(lblPais);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(336, 149, 69, 20);
		panel.add(comboBox_2);
		
		JLabel lblEstadoECidade = new JLabel("Estado e Cidade");
		lblEstadoECidade.setBounds(422, 130, 93, 14);
		panel.add(lblEstadoECidade);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(422, 149, 46, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(474, 149, 141, 20);
		panel.add(comboBox_4);
		
		textField_16 = new JTextField();
		textField_16.setBounds(422, 107, 190, 20);
		panel.add(textField_16);
		textField_16.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(117, 111, 86, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 490, 89, 23);
		getContentPane().add(btnSalvar);

		//setVisible(true);
	}
}
