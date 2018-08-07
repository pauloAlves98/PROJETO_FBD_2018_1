package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class CadastroFuncionarioDialog extends JDialog {
	private JTextField codField;
	private JTextField nomeField;
	private JFormattedTextField  cpfField;
	private JTextField senhaField;
	private JTextField loginField,estadoField;
	private JFormattedTextField  nascField;
	private JTextField rgField,complementoField,bairroField,cidadeField,ruaField,numeroField,logradouroField;
	private JComboBox paisBox,admBox;
	private JFormattedTextField  telField;
	private JFormattedTextField cepField;
	private JButton buscaCepButton;
	private JButton btnSalvar;
	private JTextField cargoField;
	
	private JTextArea descricaoArea;
	public CadastroFuncionarioDialog() {
		setBackground(Color.CYAN);
		setSize(660,558);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{90, 26, 0, 0, 152, 46, 73, 25, 16, 35, 13, 147, 0};
		gridBagLayout.rowHeights = new int[]{81, 16, 32, 20, 32, 14, 32, 2, 1, 14, 32, 14, 32, 37, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 12;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(null);

		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Funcionario");
		lblCadastroDePacientes.setForeground(Color.WHITE);
		lblCadastroDePacientes.setBounds(10, 11, 446, 70);
		panel.add(lblCadastroDePacientes);
		lblCadastroDePacientes.setBackground(Color.WHITE);
		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		JLabel lblProntuario = new JLabel("Cod");
		lblProntuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblProntuario = new GridBagConstraints();
		gbc_lblProntuario.weightx = 1.0;
		gbc_lblProntuario.fill = GridBagConstraints.BOTH;
		gbc_lblProntuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblProntuario.gridx = 0;
		gbc_lblProntuario.gridy = 1;
		getContentPane().add(lblProntuario, gbc_lblProntuario);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.weightx = 1.0;
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridwidth = 4;
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		getContentPane().add(lblNome, gbc_lblNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.weightx = 1.0;
		gbc_lblCpf.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 6;
		gbc_lblCpf.gridy = 1;
		getContentPane().add(lblCpf, gbc_lblCpf);

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblRg = new GridBagConstraints();
		gbc_lblRg.weightx = 1.0;
		gbc_lblRg.anchor = GridBagConstraints.NORTH;
		gbc_lblRg.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRg.insets = new Insets(0, 0, 5, 5);
		gbc_lblRg.gridwidth = 2;
		gbc_lblRg.gridx = 9;
		gbc_lblRg.gridy = 1;
		getContentPane().add(lblRg, gbc_lblRg);

		codField = new JTextField();
		codField.setBackground(new Color(255, 255, 255));
		codField.setEditable(false);
		GridBagConstraints gbc_codField = new GridBagConstraints();
		gbc_codField.weighty = 1.0;
		gbc_codField.weightx = 1.0;
		gbc_codField.anchor = GridBagConstraints.EAST;
		gbc_codField.fill = GridBagConstraints.BOTH;
		gbc_codField.insets = new Insets(0, 0, 5, 5);
		gbc_codField.gridx = 0;
		gbc_codField.gridy = 2;
		getContentPane().add(codField, gbc_codField);
		codField.setColumns(10);

		nomeField = new JTextField();
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.weighty = 1.0;
		gbc_nomeField.weightx = 1.0;
		gbc_nomeField.fill = GridBagConstraints.BOTH;
		gbc_nomeField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeField.gridwidth = 5;
		gbc_nomeField.gridx = 1;
		gbc_nomeField.gridy = 2;
		getContentPane().add(nomeField, gbc_nomeField);
		nomeField.setColumns(10);

		cpfField = new  JFormattedTextField();
		GridBagConstraints gbc_cpfField = new GridBagConstraints();
		gbc_cpfField.weighty = 1.0;
		gbc_cpfField.weightx = 1.0;
		gbc_cpfField.fill = GridBagConstraints.BOTH;
		gbc_cpfField.insets = new Insets(0, 0, 5, 5);
		gbc_cpfField.gridwidth = 3;
		gbc_cpfField.gridx = 6;
		gbc_cpfField.gridy = 2;
		getContentPane().add(cpfField, gbc_cpfField);
		cpfField.setColumns(10);

		rgField = new JTextField();
		GridBagConstraints gbc_rgField = new GridBagConstraints();
		gbc_rgField.weighty = 1.0;
		gbc_rgField.weightx = 1.0;
		gbc_rgField.fill = GridBagConstraints.BOTH;
		gbc_rgField.insets = new Insets(0, 0, 5, 0);
		gbc_rgField.gridwidth = 3;
		gbc_rgField.gridx = 9;
		gbc_rgField.gridy = 2;
		getContentPane().add(rgField, gbc_rgField);
		rgField.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.weightx = 1.0;
		gbc_lblTelefone.anchor = GridBagConstraints.NORTH;
		gbc_lblTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridheight = 2;
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		getContentPane().add(lblTelefone, gbc_lblTelefone);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.weightx = 1.0;
		gbc_lblLogin.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 4;
		gbc_lblLogin.gridy = 3;
		getContentPane().add(lblLogin, gbc_lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.weightx = 1.0;
		gbc_lblSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSenha.anchor = GridBagConstraints.SOUTH;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridwidth = 2;
		gbc_lblSenha.gridx = 5;
		gbc_lblSenha.gridy = 3;
		getContentPane().add(lblSenha, gbc_lblSenha);

		JLabel lblAdm = new JLabel("Adm");
		lblAdm.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAdm = new GridBagConstraints();
		gbc_lblAdm.anchor = GridBagConstraints.SOUTH;
		gbc_lblAdm.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAdm.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdm.gridwidth = 2;
		gbc_lblAdm.gridx = 8;
		gbc_lblAdm.gridy = 3;
		getContentPane().add(lblAdm, gbc_lblAdm);

		JLabel lblDataNascimento = new JLabel("Data nascimento");
		lblDataNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDataNascimento = new GridBagConstraints();
		gbc_lblDataNascimento.weightx = 1.0;
		gbc_lblDataNascimento.anchor = GridBagConstraints.SOUTH;
		gbc_lblDataNascimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDataNascimento.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataNascimento.gridx = 11;
		gbc_lblDataNascimento.gridy = 3;
		getContentPane().add(lblDataNascimento, gbc_lblDataNascimento);

		telField = new JFormattedTextField ();
		GridBagConstraints gbc_telField = new GridBagConstraints();
		gbc_telField.weightx = 1.0;
		gbc_telField.weighty = 1.0;
		gbc_telField.fill = GridBagConstraints.BOTH;
		gbc_telField.insets = new Insets(0, 0, 5, 5);
		gbc_telField.gridwidth = 4;
		gbc_telField.gridx = 0;
		gbc_telField.gridy = 4;
		getContentPane().add(telField, gbc_telField);
		telField.setColumns(10);

		loginField = new JTextField();
		GridBagConstraints gbc_loginField = new GridBagConstraints();
		gbc_loginField.weighty = 1.0;
		gbc_loginField.weightx = 1.0;
		gbc_loginField.fill = GridBagConstraints.BOTH;
		gbc_loginField.insets = new Insets(0, 0, 5, 5);
		gbc_loginField.gridx = 4;
		gbc_loginField.gridy = 4;
		getContentPane().add(loginField, gbc_loginField);
		loginField.setColumns(10);

		senhaField = new JTextField();
		GridBagConstraints gbc_senhaField = new GridBagConstraints();
		gbc_senhaField.weighty = 1.0;
		gbc_senhaField.weightx = 1.0;
		gbc_senhaField.fill = GridBagConstraints.BOTH;
		gbc_senhaField.insets = new Insets(0, 0, 5, 5);
		gbc_senhaField.gridwidth = 3;
		gbc_senhaField.gridx = 5;
		gbc_senhaField.gridy = 4;
		getContentPane().add(senhaField, gbc_senhaField);
		senhaField.setColumns(10);

		admBox = new JComboBox();
		admBox.addItem("Não");
		admBox.addItem("Sim");
		GridBagConstraints gbc_admBox = new GridBagConstraints();
		gbc_admBox.weighty = 1.0;
		gbc_admBox.weightx = 1.0;
		gbc_admBox.fill = GridBagConstraints.BOTH;
		gbc_admBox.insets = new Insets(0, 0, 5, 5);
		gbc_admBox.gridwidth = 3;
		gbc_admBox.gridx = 8;
		gbc_admBox.gridy = 4;
		getContentPane().add(admBox, gbc_admBox);

		nascField = new JFormattedTextField ();
		GridBagConstraints gbc_nascField = new GridBagConstraints();
		gbc_nascField.weighty = 1.0;
		gbc_nascField.weightx = 1.0;
		gbc_nascField.anchor = GridBagConstraints.WEST;
		gbc_nascField.fill = GridBagConstraints.BOTH;
		gbc_nascField.insets = new Insets(0, 0, 5, 0);
		gbc_nascField.gridx = 11;
		gbc_nascField.gridy = 4;
		getContentPane().add(nascField, gbc_nascField);
		nascField.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCargo = new GridBagConstraints();
		gbc_lblCargo.weightx = 1.0;
		gbc_lblCargo.weighty = 1.0;
		gbc_lblCargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargo.gridx = 0;
		gbc_lblCargo.gridy = 5;
		getContentPane().add(lblCargo, gbc_lblCargo);

		JLabel lblDecrioDoCargo = new JLabel("Decri\u00E7\u00E3o do Cargo");
		lblDecrioDoCargo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDecrioDoCargo = new GridBagConstraints();
		gbc_lblDecrioDoCargo.weightx = 1.0;
		gbc_lblDecrioDoCargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDecrioDoCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDecrioDoCargo.gridx = 4;
		gbc_lblDecrioDoCargo.gridy = 5;
		getContentPane().add(lblDecrioDoCargo, gbc_lblDecrioDoCargo);

		cargoField = new JTextField();
		GridBagConstraints gbc_cargoField = new GridBagConstraints();
		gbc_cargoField.weighty = 1.0;
		gbc_cargoField.weightx = 1.0;
		gbc_cargoField.fill = GridBagConstraints.BOTH;
		gbc_cargoField.insets = new Insets(0, 0, 5, 5);
		gbc_cargoField.gridwidth = 4;
		gbc_cargoField.gridx = 0;
		gbc_cargoField.gridy = 6;
		getContentPane().add(cargoField, gbc_cargoField);
		cargoField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.anchor = GridBagConstraints.WEST;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 6;
		getContentPane().add(scrollPane, gbc_scrollPane);

		descricaoArea = new JTextArea();
		descricaoArea.setWrapStyleWord(true);
		descricaoArea.setLineWrap(true);
		descricaoArea.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(descricaoArea);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.weightx = 1.0;
		gbc_lblEndereco.anchor = GridBagConstraints.WEST;
		gbc_lblEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridheight = 2;
		gbc_lblEndereco.gridwidth = 5;
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 7;
		getContentPane().add(lblEndereco, gbc_lblEndereco);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCep.weightx = 1.0;
		gbc_lblCep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCep.gridx = 0;
		gbc_lblCep.gridy = 9;
		getContentPane().add(lblCep, gbc_lblCep);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblComplemento = new GridBagConstraints();
		gbc_lblComplemento.weightx = 1.0;
		gbc_lblComplemento.anchor = GridBagConstraints.NORTH;
		gbc_lblComplemento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblComplemento.insets = new Insets(0, 0, 5, 5);
		gbc_lblComplemento.gridx = 4;
		gbc_lblComplemento.gridy = 9;
		getContentPane().add(lblComplemento, gbc_lblComplemento);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.weightx = 1.0;
		gbc_lblBairro.weighty = 1.0;
		gbc_lblBairro.anchor = GridBagConstraints.WEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 6;
		gbc_lblBairro.gridy = 9;
		getContentPane().add(lblBairro, gbc_lblBairro);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblLogradouro = new GridBagConstraints();
		gbc_lblLogradouro.anchor = GridBagConstraints.WEST;
		gbc_lblLogradouro.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogradouro.gridwidth = 2;
		gbc_lblLogradouro.gridx = 10;
		gbc_lblLogradouro.gridy = 9;
		getContentPane().add(lblLogradouro, gbc_lblLogradouro);

		cepField = new JFormattedTextField ();
		GridBagConstraints gbc_cepField = new GridBagConstraints();
		gbc_cepField.weighty = 1.0;
		gbc_cepField.weightx = 1.0;
		gbc_cepField.fill = GridBagConstraints.BOTH;
		gbc_cepField.insets = new Insets(0, 0, 5, 5);
		gbc_cepField.gridwidth = 2;
		gbc_cepField.gridx = 0;
		gbc_cepField.gridy = 10;
		getContentPane().add(cepField, gbc_cepField);
		cepField.setColumns(10);
		
		 buscaCepButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		 buscaCepButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_buscaCepButton = new GridBagConstraints();
		gbc_buscaCepButton.fill = GridBagConstraints.BOTH;
		gbc_buscaCepButton.insets = new Insets(0, 0, 5, 5);
		gbc_buscaCepButton.gridx = 2;
		gbc_buscaCepButton.gridy = 10;
		getContentPane().add(buscaCepButton, gbc_buscaCepButton);
		
				complementoField = new JTextField();
				GridBagConstraints gbc_complementoField = new GridBagConstraints();
				gbc_complementoField.weighty = 1.0;
				gbc_complementoField.weightx = 1.0;
				gbc_complementoField.fill = GridBagConstraints.BOTH;
				gbc_complementoField.insets = new Insets(0, 0, 5, 5);
				gbc_complementoField.gridwidth = 3;
				gbc_complementoField.gridx = 3;
				gbc_complementoField.gridy = 10;
				getContentPane().add(complementoField, gbc_complementoField);
				complementoField.setColumns(10);

		bairroField = new JTextField();
		GridBagConstraints gbc_bairroField = new GridBagConstraints();
		gbc_bairroField.weightx = 1.0;
		gbc_bairroField.weighty = 1.0;
		gbc_bairroField.fill = GridBagConstraints.BOTH;
		gbc_bairroField.insets = new Insets(0, 0, 5, 5);
		gbc_bairroField.gridwidth = 4;
		gbc_bairroField.gridx = 6;
		gbc_bairroField.gridy = 10;
		getContentPane().add(bairroField, gbc_bairroField);
		bairroField.setColumns(10);

		logradouroField = new JTextField();
		GridBagConstraints gbc_logradouroField = new GridBagConstraints();
		gbc_logradouroField.weighty = 1.0;
		gbc_logradouroField.weightx = 1.0;
		gbc_logradouroField.anchor = GridBagConstraints.WEST;
		gbc_logradouroField.fill = GridBagConstraints.BOTH;
		gbc_logradouroField.insets = new Insets(0, 0, 5, 0);
		gbc_logradouroField.gridwidth = 2;
		gbc_logradouroField.gridx = 10;
		gbc_logradouroField.gridy = 10;
		getContentPane().add(logradouroField, gbc_logradouroField);
		logradouroField.setColumns(10);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblRua = new GridBagConstraints();
		gbc_lblRua.weightx = 1.0;
		gbc_lblRua.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRua.insets = new Insets(0, 0, 5, 5);
		gbc_lblRua.gridx = 0;
		gbc_lblRua.gridy = 11;
		getContentPane().add(lblRua, gbc_lblRua);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.WEST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 4;
		gbc_lblCidade.gridy = 11;
		getContentPane().add(lblCidade, gbc_lblCidade);

		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPais = new GridBagConstraints();
		gbc_lblPais.weightx = 1.0;
		gbc_lblPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPais.insets = new Insets(0, 0, 5, 5);
		gbc_lblPais.gridx = 5;
		gbc_lblPais.gridy = 11;
		getContentPane().add(lblPais, gbc_lblPais);

		JLabel lblEstado = new JLabel("UF");
		lblEstado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.weightx = 1.0;
		gbc_lblEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridwidth = 2;
		gbc_lblEstado.gridx = 7;
		gbc_lblEstado.gridy = 11;
		getContentPane().add(lblEstado, gbc_lblEstado);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.WEST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumero.gridwidth = 2;
		gbc_lblNumero.gridx = 10;
		gbc_lblNumero.gridy = 11;
		getContentPane().add(lblNumero, gbc_lblNumero);

		ruaField = new JTextField();
		GridBagConstraints gbc_ruaField = new GridBagConstraints();
		gbc_ruaField.weighty = 1.0;
		gbc_ruaField.weightx = 1.0;
		gbc_ruaField.fill = GridBagConstraints.BOTH;
		gbc_ruaField.insets = new Insets(0, 0, 5, 5);
		gbc_ruaField.gridwidth = 4;
		gbc_ruaField.gridx = 0;
		gbc_ruaField.gridy = 12;
		getContentPane().add(ruaField, gbc_ruaField);
		ruaField.setColumns(10);

		cidadeField = new JTextField();
		GridBagConstraints gbc_cidadeField = new GridBagConstraints();
		gbc_cidadeField.weightx = 1.0;
		gbc_cidadeField.weighty = 1.0;
		gbc_cidadeField.fill = GridBagConstraints.BOTH;
		gbc_cidadeField.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeField.gridx = 4;
		gbc_cidadeField.gridy = 12;
		getContentPane().add(cidadeField, gbc_cidadeField);
		cidadeField.setColumns(10);

		paisBox = new JComboBox();
		paisBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		paisBox.addItem("Brasil");
		GridBagConstraints gbc_paisBox = new GridBagConstraints();
		gbc_paisBox.weighty = 1.0;
		gbc_paisBox.weightx = 1.0;
		gbc_paisBox.fill = GridBagConstraints.BOTH;
		gbc_paisBox.insets = new Insets(0, 0, 5, 5);
		gbc_paisBox.gridwidth = 2;
		gbc_paisBox.gridx = 5;
		gbc_paisBox.gridy = 12;
		getContentPane().add(paisBox, gbc_paisBox);

		estadoField = new JTextField();
		estadoField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_estadoBox = new GridBagConstraints();
		gbc_estadoBox.weighty = 1.0;
		gbc_estadoBox.weightx = 1.0;
		gbc_estadoBox.fill = GridBagConstraints.BOTH;
		gbc_estadoBox.insets = new Insets(0, 0, 5, 5);
		gbc_estadoBox.gridwidth = 3;
		gbc_estadoBox.gridx = 7;
		gbc_estadoBox.gridy = 12;
		getContentPane().add(estadoField,gbc_estadoBox);

		numeroField = new JTextField();
		GridBagConstraints gbc_numeroField = new GridBagConstraints();
		gbc_numeroField.weighty = 1.0;
		gbc_numeroField.weightx = 1.0;
		gbc_numeroField.anchor = GridBagConstraints.WEST;
		gbc_numeroField.fill = GridBagConstraints.BOTH;
		gbc_numeroField.insets = new Insets(0, 0, 5, 0);
		gbc_numeroField.gridwidth = 2;
		gbc_numeroField.gridx = 10;
		gbc_numeroField.gridy = 12;
		getContentPane().add(numeroField, gbc_numeroField);
		numeroField.setColumns(10);
		this.mascaraCPF();
		this.mascaraData();
		this.mascaraTelefone();
		this.mascaraCep();
		getContentPane().setBackground(Color.WHITE);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.weighty = 1.0;
		gbc_btnSalvar.weightx = 1.0;
		gbc_btnSalvar.fill = GridBagConstraints.BOTH;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridwidth = 2;
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 13;
		getContentPane().add(btnSalvar, gbc_btnSalvar);
		setVisible(false);

	}
	private void mascaraCPF() {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			format_textField4.install(cpfField);
		}catch (Exception e){}
	}
	private void mascaraCep() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("#####-###");
			format_textField4.install(cepField);
		}catch (Exception e){}
	}
	private void mascaraData() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			format_textField4.install(nascField);
		}catch (Exception e){}
	}
	private void mascaraTelefone() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##) # ####-####");
			format_textField4.install(telField);
		}catch (Exception e){}
	}
	public JTextField getCodField() {
		return codField;
	}
	public void setCodField(JTextField codField) {
		this.codField = codField;
	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}
	public JFormattedTextField getCpfField() {
		return cpfField;
	}
	public void setCpfField(JFormattedTextField cpfField) {
		this.cpfField = cpfField;
	}
	public JTextField getSenhaField() {
		return senhaField;
	}
	public void setSenhaField(JTextField senhaField) {
		this.senhaField = senhaField;
	}
	public JTextField getLoginField() {
		return loginField;
	}
	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}
	public JFormattedTextField getNascField() {
		return nascField;
	}
	public void setNascField(JFormattedTextField nascField) {
		this.nascField = nascField;
	}
	public JTextField getRgField() {
		return rgField;
	}
	public void setRgField(JTextField rgField) {
		this.rgField = rgField;
	}
	public JTextField getComplementoField() {
		return complementoField;
	}
	public void setComplementoField(JTextField complementoField) {
		this.complementoField = complementoField;
	}
	public JTextField getBairroField() {
		return bairroField;
	}
	public void setBairroField(JTextField bairroField) {
		this.bairroField = bairroField;
	}
	public JTextField getCidadeField() {
		return cidadeField;
	}
	public void setCidadeField(JTextField cidadeField) {
		this.cidadeField = cidadeField;
	}
	public JTextField getRuaField() {
		return ruaField;
	}
	public void setRuaField(JTextField ruaField) {
		this.ruaField = ruaField;
	}
	public JTextField getNumeroField() {
		return numeroField;
	}
	public void setNumeroField(JTextField numeroField) {
		this.numeroField = numeroField;
	}
	public JTextField getLogradouroField() {
		return logradouroField;
	}
	public void setLogradouroField(JTextField logradouroField) {
		this.logradouroField = logradouroField;
	}
	public JTextField getEstadoField() {
		return estadoField;
	}
	public void setEstadoField(JTextField estadoBox) {
		this.estadoField = estadoBox;
	}
	public JComboBox getPaisBox() {
		return paisBox;
	}
	public void setPaisBox(JComboBox paisBox) {
		this.paisBox = paisBox;
	}
	public JFormattedTextField getTelField() {
		return telField;
	}
	public void setTelField(JFormattedTextField telField) {
		this.telField = telField;
	}
	public JFormattedTextField getCepField() {
		return cepField;
	}
	public void setCepField(JFormattedTextField cepField) {
		this.cepField = cepField;
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
	public JTextField getCargoField() {
		return cargoField;
	}
	public void setCargoField(JTextField textField) {
		this.cargoField = textField;
	}
	public JComboBox getAdmBox() {
		return admBox;
	}
	public void setAdmBox(JComboBox admBox) {
		this.admBox = admBox;
	}
	public JTextArea getDescricaoArea() {
		return descricaoArea;
	}
	public void setDescricaoArea(JTextArea descricaoArea) {
		this.descricaoArea = descricaoArea;
	}
	public JButton getBuscaCepButton() {
		return buscaCepButton;
	}
	public void setBuscaCepButton(JButton buscaCepButton) {
		this.buscaCepButton = buscaCepButton;
	}
}
