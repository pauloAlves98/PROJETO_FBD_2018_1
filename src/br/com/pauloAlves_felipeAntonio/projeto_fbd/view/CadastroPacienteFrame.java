package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class CadastroPacienteFrame extends JFrame {
	private JTextField prontuarioField;
	private JTextField nomeField;
	private JFormattedTextField  nascField;
	private JFormattedTextField telField;
	//	private JTextField textField_4;
	//	private JTextField textField_5;
	//	private JTextField textField_6;
	//private JTextField textField_6;
	//	private JTextField textField_7;
	//	private JTextField textField_8;
	//	private JTextField textField_9;
	//	private JTextField textField_10;
	//	private JTextField textField_11;
	//	private JTextField textField_12;
	//	private JTextField textField_13;
	//	private JTextField textField_14;
	//	private JTextField textField_15;
	//	private JTextField textField_16;
	private JPanel getContentPane;
	private JFormattedTextField cpfField,rgField;
	private JTextField nomePField;
	private JTextField nomeMField;
	private JFormattedTextField  cepField;
	private JTextField complementoField;
	private JTextField bairroField;
	private JTextField ruaField;
	private JTextField cidadeField;
	private JTextField numeroField;
	private JTextField logradouroField;
	private JButton btnSalvar;
	private JComboBox paisBox,estadoBox,sexoBox ;
	/**
	 * Create the panel.
	 */
	public CadastroPacienteFrame() {
		
		setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		setSize(660,558);
		
		Panell panel = new Panell(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setBounds(0, 0, 644, 81);
		getContentPane().add(panel);
				panel.setLayout(null);
		
				JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
				lblCadastroDePacientes.setForeground(Color.WHITE);
				lblCadastroDePacientes.setBounds(10, 11, 446, 70);
				panel.add(lblCadastroDePacientes);
				lblCadastroDePacientes.setBackground(Color.WHITE);
				lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		JLabel lblProntuario = new JLabel("Prontu\u00E1rio");
		lblProntuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblProntuario.setBounds(10, 92, 72, 16);
		getContentPane().add(lblProntuario);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNome.setBounds(106, 94, 94, 14);
		getContentPane().add(lblNome);

		prontuarioField = new JTextField();
		prontuarioField.setBounds(10, 109, 86, 32);
		getContentPane().add(prontuarioField);
		prontuarioField.setColumns(10);

		nomeField = new JTextField();
		nomeField.setBounds(106, 109, 364, 32);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblSexo.setBounds(10, 152, 46, 14);
		getContentPane().add(lblSexo);

		sexoBox = new JComboBox();
		sexoBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		sexoBox.addItem("Masculino");
		sexoBox.addItem("Feminino");
		sexoBox.setBounds(10, 171, 134, 32);
		getContentPane().add(sexoBox);
		setLocationRelativeTo(null);
		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNascimento.setBounds(154, 152, 97, 14);
		getContentPane().add(lblNascimento);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblTelefone.setBounds(480, 94, 77, 14);
		getContentPane().add(lblTelefone);

		nascField = new JFormattedTextField ();
		this.mascaraData();
		nascField.setBounds(154, 171, 140, 32);
		getContentPane().add(nascField);
		nascField.setColumns(10);

		telField = new JFormattedTextField();
		this.mascaraTelefone();
		telField.setBounds(480, 109, 140, 32);
		getContentPane().add(telField);
		telField.setColumns(10);

		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e");
		lblNomeDaMe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNomeDaMe.setBounds(316, 222, 86, 14);
		getContentPane().add(lblNomeDaMe);

		nomeMField = new JTextField();
		nomeMField.setBounds(316, 247, 304, 32);
		getContentPane().add(nomeMField);
		nomeMField.setColumns(10);


		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRg.setBounds(304, 152, 86, 14);
		getContentPane().add(lblRg);

		rgField = new JFormattedTextField ();
		//mascaraRg
		rgField.setBounds(304, 171, 153, 32);
		getContentPane().add(rgField);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCpf.setBounds(467, 152, 46, 14);
		getContentPane().add(lblCpf);

		cpfField = new JFormattedTextField ();
		this.mascaraCPF();
		cpfField.setBounds(467, 171, 153, 32);
		getContentPane().add(cpfField);
		cpfField.setColumns(10);

		JLabel lblNomeDoPai = new JLabel("Nome do Pai");
		lblNomeDoPai.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNomeDoPai.setBounds(10, 219, 72, 17);
		getContentPane().add(lblNomeDoPai);

		nomePField = new JTextField();
		nomePField.setBounds(10, 247, 296, 32);
		getContentPane().add(nomePField);
		nomePField.setColumns(10);



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
		numeroField.setBounds(531, 404, 89, 32);
		getContentPane().add(numeroField);
		numeroField.setColumns(10);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblLogradouro.setBounds(529, 317, 91, 14);
		getContentPane().add(lblLogradouro);

		logradouroField = new JTextField();
		logradouroField.setBounds(527, 342, 94, 32);
		getContentPane().add(logradouroField);
		logradouroField.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnSalvar.setBounds(10, 452, 131, 37);
		getContentPane().add(btnSalvar);
		getContentPane().setBackground(Color.WHITE);
		//setVisible(true);
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
	public JTextField getProntuarioField() {
		return prontuarioField;
	}
	public JTextField getNomeField() {
		return nomeField;
	}
	public JTextField getNascField() {
		return nascField;
	}
	public JTextField getTelField() {
		return telField;
	}

	public JPanel getGetContentPane() {
		return getContentPane;
	}
	public JTextField getCpfField() {
		return cpfField;
	}
	public JTextField getRgField() {
		return rgField;
	}
	public JTextField getNomePField() {
		return nomePField;
	}
	public JTextField getNomeMField() {
		return nomeMField;
	}
	public JTextField getCepField() {
		return cepField;
	}
	public JTextField getComplementoField() {
		return complementoField;
	}
	public JTextField getBairroField() {
		return bairroField;
	}
	public JTextField getRuaField() {
		return ruaField;
	}
	public JTextField getCidadeField() {
		return cidadeField;
	}
	public JTextField getNumeroField() {
		return numeroField;
	}
	public JTextField getLogradouroField() {
		return logradouroField;
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	public JComboBox getPaisBox() {
		return paisBox;
	}
	public JComboBox getEstadoBox() {
		return estadoBox;
	}
	public JComboBox getSexoBox() {
		return sexoBox;
	}
	
	private class Panell extends JGradientePanel{

		public Panell(Color initialColor, Color finalColor) {
			super(initialColor,finalColor);
		
		}
		
	}
}
