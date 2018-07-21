package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;


public class CadastroFornecedoresFrame extends JFrame {
	private JTextField codigoField;
	private JTextField nomeField;
	private JFormattedTextField telefoneField;
	private JTextField textField_3;
	private JTextField InscEstadualField;
	private JTextField InscMunicipalField;
	private JFormattedTextField cpfField;
	private JFormattedTextField cepField;
	private JTextField logradouroField;
	private JTextField numeroField;
	private JTextField complementoField;
	private JTextField ruaField;
	private JTextField textField_12;
	private JTextField bairroField;
	private JTextField textField_14;
	private JComboBox ufBox,cidadeBox,paisBox;
	private JButton btnSalvar,buscarButton;

	/**
	 * Create the panel.
	 */
	public CadastroFornecedoresFrame() {
		setLayout(null);
		setSize(660,558);
		setLocationRelativeTo(null);
		Panell panel = new Panell(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setBounds(0, 0, 644, 81);
		add(panel);
			panel.setLayout(null);
			JLabel lblCadastroDeFornecedores = new JLabel("Cadastro de Fornecedores");
			lblCadastroDeFornecedores.setForeground(Color.WHITE);
			lblCadastroDeFornecedores.setBounds(10, 11, 446, 70);
			panel.add(lblCadastroDeFornecedores);
			lblCadastroDeFornecedores.setBackground(Color.WHITE);
			lblCadastroDeFornecedores.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCdigo.setBounds(10, 92, 72, 16);
		add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNome.setBounds(106, 94, 94, 14);
		add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblTelefone.setBounds(480, 94, 77, 14);
		add(lblTelefone);
		
		
		
		JLabel lblInscEstadual = new JLabel("Insc. Estadual");
		lblInscEstadual.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblInscEstadual.setBounds(10, 152, 97, 14);
		add(lblInscEstadual);
		
		JLabel lblInscMunicipal = new JLabel("Insc. Municipal");
		lblInscMunicipal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblInscMunicipal.setBounds(154, 152, 97, 14);
		add(lblInscMunicipal);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCpf.setBounds(304,152, 97, 14);
		add(lblCpf);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblEndereco.setBounds(10, 212, 153, 26);
		add(lblEndereco);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCep.setBounds(278, 249, 46, 14);
		add(lblCep);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblLogradouro.setBounds(446, 248, 79, 16);
		add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNumero.setBounds(446, 320, 46, 14);
		add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblComplemento.setBounds(10, 320, 83, 14);
		add(lblComplemento);
		
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblBairro.setBounds(10, 249, 46, 14);
		add(lblBairro);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblUf.setBounds(205, 320, 46, 14);
		getContentPane().add(lblUf);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCidade.setBounds(278, 320, 46, 14);
		add(lblCidade);
		
		codigoField = new JTextField();
		codigoField.setBounds(10, 109, 86, 32);
		add(codigoField);
		codigoField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(106, 109, 364, 32);
		add(nomeField);
		nomeField.setColumns(10);
		
		telefoneField = new JFormattedTextField();
		this.mascaraTelefone();
		telefoneField.setBounds(480, 109, 140, 32);
		add(telefoneField);
		telefoneField.setColumns(10);
		
		InscEstadualField = new JTextField();
		InscEstadualField.setBounds(10, 171, 140, 32);
		add(InscEstadualField);
		InscEstadualField.setColumns(10);
		
		InscMunicipalField = new JTextField();
		InscMunicipalField.setBounds(153, 171, 140, 32);
		add(InscMunicipalField);
		InscMunicipalField.setColumns(10);
		
		cpfField = new JFormattedTextField();
		this.mascaraCPF();
		cpfField.setBounds(304, 171, 153, 32);
		getContentPane().add(cpfField);
		cpfField.setColumns(10);
		
		cepField = new JFormattedTextField();
		this.mascaraCep();
		cepField.setBounds(278, 265, 113, 32);
		add(cepField);
		cepField.setColumns(10);
		
		buscarButton = new JButton("New button");
		buscarButton.setBounds(401, 265, 27, 32);
		getContentPane().add(buscarButton);
		
		logradouroField = new JTextField("123");
		logradouroField.setBounds(446, 265, 174, 32);
		add(logradouroField);
		logradouroField.setColumns(10);
		
		numeroField = new JTextField();
		numeroField.setBounds(446, 337, 174, 32);
		getContentPane().add(numeroField);
		numeroField.setColumns(10);
		
		complementoField = new JTextField("ssdd");
		complementoField.setBounds(10, 337, 185, 32);
		add(complementoField);
		complementoField.setColumns(10);
		
		
		bairroField = new JTextField();
		bairroField.setBounds(10, 265, 258, 32);
		add(bairroField);
		bairroField.setColumns(10);
		
		ufBox = new JComboBox(new String[]{
				"PE"
		});
		ufBox.setBounds(205, 337, 66, 32);
		add(ufBox);
		
		JLabel ruaLabel = new JLabel("Rua");
		ruaLabel.setBounds(10,380,46,14);
		add(ruaLabel);
		
		ruaField = new JTextField();
		ruaField.setBounds(10,400, 258, 32);
		add(ruaField);
		ruaField.setColumns(10);
		
		JLabel paisLabel = new JLabel("Pais");
		paisLabel.setBounds(288,380,46,14);
		add(paisLabel);
		
		paisBox = new JComboBox<>(new String[]{
				"Brasil"
		});
		paisBox.setBounds(288, 400, 80, 32);
		add(paisBox);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 450, 89, 35);
		add(btnSalvar);
		
		cidadeBox =  new JComboBox(new String[]{
				"Carnaiba"
		});
		cidadeBox.setBounds(278, 337, 150, 32);
		add(cidadeBox);
		setBackground(Color.WHITE);

	}
	
	private class Panell extends JGradientePanel{

		public Panell(Color initialColor, Color finalColor) {
			super(initialColor,finalColor);
		
		}
		
	}
	private void mascaraCep() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("#####-###");
			format_textField4.install(cepField);
		}catch (Exception e){}
	}
	
	private void mascaraTelefone() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##) # ####-####");
			format_textField4.install(telefoneField);
		}catch (Exception e){}
	}
	private void mascaraCPF() {

		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			format_textField4.install(cpfField);
		}catch (Exception e){}
	}
	public JTextField getCodigoField() {
		return codigoField;
	}

	public void setCodigoField(JTextField codigoField) {
		this.codigoField = codigoField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getTelefoneField() {
		return telefoneField;
	}

	public void setTelefoneField(JFormattedTextField telefoneField) {
		this.telefoneField = telefoneField;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getInscEstadualField() {
		return InscEstadualField;
	}

	public void setInscEstadualField(JTextField inscEstadualField) {
		InscEstadualField = inscEstadualField;
	}

	public JTextField getInscMunicipalField() {
		return InscMunicipalField;
	}

	public void setInscMunicipalField(JTextField inscMunicipalField) {
		InscMunicipalField = inscMunicipalField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JFormattedTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTextField getCepField() {
		return cepField;
	}

	public void setCepField(JFormattedTextField cepField) {
		this.cepField = cepField;
	}

	public JTextField getLogradouroField() {
		return logradouroField;
	}

	public void setLogradouroField(JTextField logradouroField) {
		this.logradouroField = logradouroField;
	}

	public JTextField getNumeroField() {
		return numeroField;
	}

	public void setNumeroField(JTextField numeroField) {
		this.numeroField = numeroField;
	}

	public JTextField getComplementoField() {
		return complementoField;
	}

	public void setComplementoField(JTextField complementoField) {
		this.complementoField = complementoField;
	}

	

	public JTextField getRuaField() {
		return ruaField;
	}

	public void setRuaField(JTextField ruaField) {
		this.ruaField = ruaField;
	}

	public JComboBox getPaisBox() {
		return paisBox;
	}

	public void setPaisBox(JComboBox paisBox) {
		this.paisBox = paisBox;
	}

	public JTextField getTextField_12() {
		return textField_12;
	}

	public void setTextField_12(JTextField textField_12) {
		this.textField_12 = textField_12;
	}

	public JTextField getBairroField() {
		return bairroField;
	}

	public void setBairroField(JTextField bairroField) {
		this.bairroField = bairroField;
	}

	public JTextField getTextField_14() {
		return textField_14;
	}

	public void setTextField_14(JTextField textField_14) {
		this.textField_14 = textField_14;
	}

	public JComboBox getUfBox() {
		return ufBox;
	}

	public void setUfBox(JComboBox ufBox) {
		this.ufBox = ufBox;
	}

	public JComboBox getCidadeBox() {
		return cidadeBox;
	}

	public void setCidadeBox(JComboBox cidadeBox) {
		this.cidadeBox = cidadeBox;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBuscarButton() {
		return buscarButton;
	}

	

}
