package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroFornecedoresPanel extends JFrame {
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

	/**
	 * Create the panel.
	 */
	public CadastroFornecedoresPanel() {
		setLayout(null);
		
		JLabel lblCadastroDeFornecedores = new JLabel("Cadastro de Fornecedores");
		lblCadastroDeFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroDeFornecedores.setBounds(10, 11, 216, 14);
		add(lblCadastroDeFornecedores);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 46, 46, 14);
		add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(106, 46, 46, 14);
		add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 98, 46, 14);
		add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(106, 98, 46, 14);
		add(lblEmail);
		
		JLabel lblInscEstadual = new JLabel("Insc. Estadual");
		lblInscEstadual.setBounds(390, 98, 73, 14);
		add(lblInscEstadual);
		
		JLabel lblInscMunicipal = new JLabel("Insc. Municipal");
		lblInscMunicipal.setBounds(513, 98, 79, 14);
		add(lblInscMunicipal);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(10, 147, 67, 14);
		add(lblCpfcnpj);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(143, 147, 46, 14);
		add(lblCep);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(274, 147, 79, 14);
		add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(373, 147, 46, 14);
		add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(440, 147, 83, 14);
		add(lblComplemento);
		
		JLabel lblQuadra = new JLabel("Quadra");
		lblQuadra.setBounds(533, 147, 46, 14);
		add(lblQuadra);
		
		JLabel lblLote = new JLabel("Lote");
		lblLote.setBounds(599, 147, 46, 14);
		add(lblLote);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 195, 46, 14);
		add(lblBairro);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(133, 195, 46, 14);
		add(lblUf);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(189, 195, 46, 14);
		add(lblCidade);
		
		textField = new JTextField();
		textField.setBounds(10, 67, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 67, 270, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 119, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 119, 270, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(390, 119, 113, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(513, 119, 113, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 164, 113, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(143, 164, 92, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(240, 163, 27, 23);
		add(btnNewButton);
		
		textField_8 = new JTextField();
		textField_8.setBounds(274, 164, 86, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(373, 164, 58, 20);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(440, 164, 86, 20);
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(533, 164, 58, 20);
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(599, 164, 35, 20);
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(10, 212, 113, 20);
		add(textField_13);
		textField_13.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 212, 46, 20);
		add(comboBox);
		
		textField_14 = new JTextField();
		textField_14.setBounds(189, 212, 106, 20);
		add(textField_14);
		textField_14.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 243, 89, 35);
		add(btnSalvar);

	}

}
