package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;



import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class CadastroMedicoDialog extends JDialog {
	private JTextField codField;
	private JTextField nomeField;
	private JFormattedTextField  cpfField;
	private JTextField senhaField;
	private JTextField loginField;
	private JTextField rgField,complementoField,bairroField,cidadeField,ruaField,numeroField,logradouroField;
	private JComboBox paisBox,admBox;
	private JFormattedTextField cepField;
	private JButton btnSalvar;
	private JTextField areaField;
	private JTextField especialidadeField;
	private JTextField estadoField;
	JButton buscarCepButton ;
	public CadastroMedicoDialog() {
		setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		setSize(660,558);
		setLocationRelativeTo(null);
		setResizable(false);
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setBounds(0, 0, 800, 81);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroDePacientes = new JLabel("Cadastro de M\u00E9dico");
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
		codField.setEditable(false);
		codField.setBackground(new Color(255, 255, 255));
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
		lblSenha.setBounds(290, 157, 72, 14);
		getContentPane().add(lblSenha);

		senhaField = new JTextField();
		senhaField.setBounds(290, 182, 194, 32);
		getContentPane().add(senhaField);
		senhaField.setColumns(10);

		JLabel lblAdm = new JLabel("Adm");
		lblAdm.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblAdm.setBounds(496, 157, 46, 14);
		getContentPane().add(lblAdm);

		admBox = new JComboBox();
		admBox.setBounds(495, 182, 149, 32);
		admBox.addItem("Não");
		admBox.addItem("Sim");
		getContentPane().add(admBox);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblLogin.setBounds(10, 157, 46, 14);
		getContentPane().add(lblLogin);

		loginField = new JTextField();
		loginField.setBounds(10, 182, 252, 32);
		getContentPane().add(loginField);
		loginField.setColumns(10);
		this.mascaraData();

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRg.setBounds(489, 92, 46, 14);
		getContentPane().add(lblRg);

		rgField = new JTextField();
		rgField.setBounds(486, 109, 158, 32);
		getContentPane().add(rgField);
		rgField.setColumns(10);
		this.mascaraTelefone();

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
		cepField.setBounds(10, 342, 113, 32);
		getContentPane().add(cepField);
		cepField.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblComplemento.setBounds(164, 327, 131, 14);
		getContentPane().add(lblComplemento);

		complementoField = new JTextField();
		complementoField.setBounds(164, 342, 179, 32);
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

		JLabel lblEstado = new JLabel("UF");
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
		btnSalvar.setBackground(Color.white);
		getContentPane().add(btnSalvar);
		getContentPane().setBackground(Color.WHITE);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblArea.setBounds(10, 226, 46, 14);
		getContentPane().add(lblArea);

		areaField = new JTextField();
		areaField.setBounds(10, 242, 252, 32);
		getContentPane().add(areaField);
		areaField.setColumns(10);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblEspecialidade.setBounds(290, 225, 147, 14);
		getContentPane().add(lblEspecialidade);

		especialidadeField = new JTextField();
		especialidadeField.setBounds(292, 242, 352, 32);
		getContentPane().add(especialidadeField);
		especialidadeField.setColumns(10);

		buscarCepButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		buscarCepButton.setBounds(122, 342, 32, 32);
		buscarCepButton.setBackground(Color.WHITE);
		getContentPane().add(buscarCepButton);
		
		estadoField = new JTextField();
		estadoField.setBounds(434, 404, 86, 32);
		getContentPane().add(estadoField);
		estadoField.setColumns(10);
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
		}catch (Exception e){}
	}
	private void mascaraTelefone() {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##) # ####-####");
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

	public JTextField getAreaField() {
		return areaField;
	}
	public void setAreaField(JTextField areaField) {
		this.areaField = areaField;
	}
	public JTextField getEspecialidadeField() {
		return especialidadeField;
	}
	public void setEspecialidadeField(JTextField especialidadeField) {
		this.especialidadeField = especialidadeField;
	}
	public JTextField getEstadoField() {
		return estadoField;
	}
	public void setEstadoField(JTextField estadoField) {
		this.estadoField = estadoField;
	}
	public JComboBox getPaisBox() {
		return paisBox;
	}
	public void setPaisBox(JComboBox paisBox) {
		this.paisBox = paisBox;
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
	public JComboBox getAdmBox() {
		return admBox;
	}
	public void setAdmBox(JComboBox admBox) {
		this.admBox = admBox;
	}
	public JTextField getRgField() {
		return rgField;
	}
	public JButton getBuscarCepButton() {
		return buscarCepButton;
	}
	public void setBuscarCepButton(JButton buscarCepButton) {
		this.buscarCepButton = buscarCepButton;
	}
	
}