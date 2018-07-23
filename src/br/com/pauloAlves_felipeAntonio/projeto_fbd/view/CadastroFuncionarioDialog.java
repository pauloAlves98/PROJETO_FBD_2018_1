package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CadastroFuncionarioDialog extends JDialog {
	private JTextField codField;
	private JTextField nomeField;
	private JFormattedTextField  cpfField;
	private JTextField senhaField;
	private JTextField loginField;
	private JFormattedTextField  nascField;
	private JTextField rgField,complementoField,bairroField,cidadeField,ruaField,numeroField,logradouroField;
	private JComboBox estadoBox,paisBox,admBox;
	private JFormattedTextField  telField;
	private JFormattedTextField cepField;
	private JButton btnSalvar;
	private JTextField cargoField;
	private JTextArea descricaoArea;
	public CadastroFuncionarioDialog() {
		setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		setSize(660,558);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setBounds(0, 0, 644, 81);
		getContentPane().add(panel);
				panel.setLayout(null);
		
				JLabel lblCadastroDePacientes = new JLabel("Cadastro de Funcionario");
				lblCadastroDePacientes.setForeground(Color.WHITE);
				lblCadastroDePacientes.setBounds(10, 11, 446, 70);
				panel.add(lblCadastroDePacientes);
				lblCadastroDePacientes.setBackground(Color.WHITE);
				lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		JLabel lblProntuario = new JLabel("Cod");
		lblProntuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblProntuario.setBounds(10, 92, 72, 16);
		getContentPane().add(lblProntuario);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNome.setBounds(116, 93, 94, 14);
		getContentPane().add(lblNome);

		codField = new JTextField();
		codField.setBackground(new Color(255, 255, 255));
		codField.setEditable(false);
		codField.setBounds(10, 109, 80, 32);
		getContentPane().add(codField);
		codField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(116, 109, 226, 32);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCpf.setBounds(351, 92, 46, 14);
		getContentPane().add(lblCpf);
		
		cpfField = new  JFormattedTextField();
		cpfField.setBounds(352, 109, 132, 32);
		this.mascaraCPF();
		getContentPane().add(cpfField);
		cpfField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblSenha.setBounds(306, 157, 72, 14);
		getContentPane().add(lblSenha);
		
		senhaField = new JTextField();
		senhaField.setBounds(307, 182, 152, 32);
		getContentPane().add(senhaField);
		senhaField.setColumns(10);
		
		JLabel lblAdm = new JLabel("Adm");
		lblAdm.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblAdm.setBounds(468, 158, 46, 14);
		getContentPane().add(lblAdm);
		
		admBox = new JComboBox();
		admBox.setBounds(468, 182, 72, 32);
		admBox.addItem("Não");
		admBox.addItem("Sim");
		getContentPane().add(admBox);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblLogin.setBounds(147, 157, 46, 14);
		getContentPane().add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(145, 182, 152, 32);
		getContentPane().add(loginField);
		loginField.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data nascimento");
		lblDataNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblDataNascimento.setBounds(550, 158, 147, 14);
		getContentPane().add(lblDataNascimento);
		
		nascField = new JFormattedTextField ();
		nascField.setBounds(550, 182, 94, 32);
		this.mascaraData();
		getContentPane().add(nascField);
		nascField.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRg.setBounds(489, 92, 46, 14);
		getContentPane().add(lblRg);
		
		rgField = new JTextField();
		rgField.setBounds(486, 109, 158, 32);
		getContentPane().add(rgField);
		rgField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblTelefone.setBounds(10, 152, 72, 31);
		getContentPane().add(lblTelefone);
		
		telField = new JFormattedTextField ();
		telField.setBounds(10, 182, 126, 32);
		this.mascaraTelefone();
		getContentPane().add(telField);
		telField.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblEndereco.setBounds(10, 290, 153, 26);
		getContentPane().add(lblEndereco);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCep.setBounds(10, 317, 46, 14);
		getContentPane().add(lblCep);

		cepField = new JFormattedTextField ();
		this.mascaraCep();
		cepField.setBounds(10, 342, 132, 32);
		getContentPane().add(cepField);
		cepField.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblComplemento.setBounds(154, 315, 131, 14);
		getContentPane().add(lblComplemento);

		complementoField = new JTextField();
		complementoField.setBounds(152, 342, 191, 32);
		getContentPane().add(complementoField);
		complementoField.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblBairro.setBounds(353, 317, 46, 14);
		getContentPane().add(lblBairro);

		bairroField = new JTextField();
		bairroField.setBounds(353, 342, 164, 32);
		getContentPane().add(bairroField);
		bairroField.setColumns(10);

		estadoBox = new JComboBox();
		estadoBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		estadoBox.addItem("PE");
		estadoBox.setBounds(434, 404, 87, 32);
		getContentPane().add(estadoBox);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblEstado.setBounds(434, 379, 46, 14);
		getContentPane().add(lblEstado);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRua.setBounds(10, 379, 46, 14);
		getContentPane().add(lblRua);

		ruaField = new JTextField();
		ruaField.setBounds(10, 404, 131, 32);
		getContentPane().add(ruaField);
		ruaField.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCidade.setBounds(147, 379, 46, 14);
		getContentPane().add(lblCidade);

		cidadeField = new JTextField();
		cidadeField.setBounds(147, 404, 145, 32);
		getContentPane().add(cidadeField);
		cidadeField.setColumns(10);

		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblPais.setBounds(302, 379, 46, 14);
		getContentPane().add(lblPais);

		paisBox = new JComboBox();
		paisBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		paisBox.addItem("Brasil");
		paisBox.setBounds(302, 404, 122, 32);
		getContentPane().add(paisBox);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNumero.setBounds(529, 379, 58, 14);
		getContentPane().add(lblNumero);

		numeroField = new JTextField();
		numeroField.setBounds(531, 404, 113, 32);
		getContentPane().add(numeroField);
		numeroField.setColumns(10);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblLogradouro.setBounds(529, 317, 91, 14);
		getContentPane().add(lblLogradouro);

		logradouroField = new JTextField();
		logradouroField.setBounds(527, 342, 115, 32);
		getContentPane().add(logradouroField);
		logradouroField.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnSalvar.setBounds(10, 452, 131, 37);
		getContentPane().add(btnSalvar);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCargo.setBounds(10, 223, 46, 14);
		getContentPane().add(lblCargo);
		
		cargoField = new JTextField();
		cargoField.setBounds(10, 237, 126, 32);
		getContentPane().add(cargoField);
		cargoField.setColumns(10);
		
		JLabel lblDecrioDoCargo = new JLabel("Decri\u00E7\u00E3o do Cargo");
		lblDecrioDoCargo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblDecrioDoCargo.setBounds(146, 223, 139, 14);
		getContentPane().add(lblDecrioDoCargo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 237, 498, 67);
		getContentPane().add(scrollPane);
		
		descricaoArea = new JTextArea();
		descricaoArea.setWrapStyleWord(true);
		descricaoArea.setLineWrap(true);
		descricaoArea.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(descricaoArea);
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
	public JComboBox getEstadoBox() {
		return estadoBox;
	}
	public void setEstadoBox(JComboBox estadoBox) {
		this.estadoBox = estadoBox;
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
	
}
