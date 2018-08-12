package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class CadastroPacienteFrame extends JDialog {
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
	private JTextField ruaField,estadoField;
	private JTextField cidadeField;
	private JTextField numeroField;
	private JTextField logradouroField;
	private JButton btnSalvar,buscarCEPButton;
	private JComboBox paisBox,sexoBox ;
	
	/**
	 * Create the panel.
	 */
	public CadastroPacienteFrame() {
		
		setBackground(Color.CYAN);
		setSize(700,558);
		getContentPane().setLayout(null);
		setResizable(false);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBounds(2, 1, 730, 76);
		panel.setBackground(Propiedade.cor1);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
				JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
				lblCadastroDePacientes.setForeground(Color.WHITE);
				panel.add(lblCadastroDePacientes);
				lblCadastroDePacientes.setBackground(Color.WHITE);
				lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		JLabel lblProntuario = new JLabel("Prontu\u00E1rio");
		lblProntuario.setBounds(2, 82, 94, 15);
		lblProntuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		getContentPane().add(lblProntuario);
																
																		JLabel lblNome = new JLabel("Nome");
																		lblNome.setBounds(101, 82, 32, 15);
																		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
																		getContentPane().add(lblNome);
														
																JLabel lblTelefone = new JLabel("Telefone");
																lblTelefone.setBounds(489, 82, 45, 15);
																lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
																getContentPane().add(lblTelefone);
												
														prontuarioField = new JTextField();
														prontuarioField.setBounds(2, 102, 94, 32);
														getContentPane().add(prontuarioField);
														prontuarioField.setColumns(10);
										
												nomeField = new JTextField();
												nomeField.setBounds(101, 102, 383, 32);
												getContentPane().add(nomeField);
												nomeField.setColumns(10);
										
												telField = new JFormattedTextField();
												telField.setBounds(489, 102, 153, 32);
												getContentPane().add(telField);
												telField.setColumns(10);
										
												JLabel lblSexo = new JLabel("Sexo");
												lblSexo.setBounds(2, 153, 94, 15);
												lblSexo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												getContentPane().add(lblSexo);
												JLabel lblNascimento = new JLabel("Nascimento");
												lblNascimento.setBounds(139, 153, 145, 15);
												lblNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												getContentPane().add(lblNascimento);
										
										
												JLabel lblRg = new JLabel("RG");
												lblRg.setBounds(289, 153, 132, 15);
												lblRg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												getContentPane().add(lblRg);
								
										JLabel lblCpf = new JLabel("CPF");
										lblCpf.setBounds(456, 153, 61, 15);
										lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
										getContentPane().add(lblCpf);
												
														sexoBox = new JComboBox();
														sexoBox.setBounds(2, 173, 132, 32);
														sexoBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
														sexoBox.addItem("Masculino");
														sexoBox.addItem("Feminino");
														getContentPane().add(sexoBox);
										
												nascField = new JFormattedTextField ();
												nascField.setBounds(139, 173, 145, 32);
												getContentPane().add(nascField);
												nascField.setColumns(10);
										
												rgField = new JFormattedTextField ();
												rgField.setBounds(289, 173, 162, 32);
												getContentPane().add(rgField);
										
												cpfField = new JFormattedTextField ();
												cpfField.setBounds(456, 173, 186, 32);
												getContentPane().add(cpfField);
												cpfField.setColumns(10);
								
										JLabel lblNomeDoPai = new JLabel("Nome do Pai");
										lblNomeDoPai.setBounds(2, 224, 94, 15);
										lblNomeDoPai.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
										getContentPane().add(lblNomeDoPai);
						
								JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e");
								lblNomeDaMe.setBounds(319, 224, 102, 15);
								lblNomeDaMe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								getContentPane().add(lblNomeDaMe);
						
								nomePField = new JTextField();
								nomePField.setBounds(2, 244, 312, 32);
								getContentPane().add(nomePField);
								nomePField.setColumns(10);
				
						nomeMField = new JTextField();
						nomeMField.setBounds(319, 244, 323, 32);
						getContentPane().add(nomeMField);
						nomeMField.setColumns(10);
				
				
				
						JLabel lblEndereco = new JLabel("Endere\u00E7o");
						lblEndereco.setBounds(2, 295, 69, 21);
						lblEndereco.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
						getContentPane().add(lblEndereco);
										
												JLabel lblComplemento = new JLabel("Complemento");
												lblComplemento.setBounds(187, 321, 145, 15);
												lblComplemento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												getContentPane().add(lblComplemento);
								
										JLabel lblCep = new JLabel("CEP");
										lblCep.setBounds(2, 321, 94, 15);
										lblCep.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
										getContentPane().add(lblCep);
						
								JLabel lblBairro = new JLabel("Bairro");
								lblBairro.setBounds(405, 321, 32, 15);
								lblBairro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								getContentPane().add(lblBairro);
						
								JLabel lblLogradouro = new JLabel("Logradouro");
								lblLogradouro.setBounds(526, 321, 120, 15);
								lblLogradouro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								getContentPane().add(lblLogradouro);
				
						cepField = new JFormattedTextField ();
						cepField.setBounds(2, 341, 132, 32);
						getContentPane().add(cepField);
						cepField.setColumns(10);
		
				complementoField = new JTextField();
				complementoField.setBounds(187, 341, 208, 32);
				getContentPane().add(complementoField);
				complementoField.setColumns(10);
						
								bairroField = new JTextField();
								bairroField.setBounds(405, 341, 111, 32);
								getContentPane().add(bairroField);
								bairroField.setColumns(10);
								
										logradouroField = new JTextField();
										logradouroField.setBounds(526, 341, 116, 32);
										getContentPane().add(logradouroField);
										logradouroField.setColumns(10);
						
								JLabel lblRua = new JLabel("Rua");
								lblRua.setBounds(2, 392, 94, 15);
								lblRua.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								getContentPane().add(lblRua);
				
						JLabel lblCidade = new JLabel("Cidade");
						lblCidade.setBounds(139, 392, 37, 15);
						lblCidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						getContentPane().add(lblCidade);
						
								JLabel lblPais = new JLabel("Pa\u00EDs");
								lblPais.setBounds(289, 392, 58, 15);
								lblPais.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								getContentPane().add(lblPais);
				
						JLabel lblEstado = new JLabel("UF");
						lblEstado.setBounds(426, 392, 58, 15);
						lblEstado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						getContentPane().add(lblEstado);
				
						JLabel lblNumero = new JLabel("N\u00FAmero");
						lblNumero.setBounds(522, 392, 43, 15);
						lblNumero.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						getContentPane().add(lblNumero);
				
						ruaField = new JTextField();
						ruaField.setBounds(2, 412, 132, 32);
						getContentPane().add(ruaField);
						ruaField.setColumns(10);
		
				cidadeField = new JTextField();
				cidadeField.setBounds(139, 412, 145, 32);
				getContentPane().add(cidadeField);
				cidadeField.setColumns(10);
						
								paisBox = new JComboBox();
								paisBox.setBounds(289, 412, 132, 32);
								paisBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								paisBox.addItem("Brasil");
								getContentPane().add(paisBox);
				
						estadoField = new JTextField();
						estadoField.setBounds(426, 412, 91, 32);
						estadoField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						
						getContentPane().add(estadoField);
				
						numeroField = new JTextField();
						numeroField.setBounds(522, 412, 120, 32);
						getContentPane().add(numeroField);
						numeroField.setColumns(10);
		
				btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(2, 463, 132, 32);
				btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
				getContentPane().add(btnSalvar);
		setLocationRelativeTo(null);
		this.mascaraData();
		this.mascaraTelefone();
		this.mascaraCPF();
		this.mascaraCep();
		getContentPane().setBackground(Color.WHITE);
		
		buscarCEPButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		buscarCEPButton.setBounds(139, 341, 32, 32);
		getContentPane().add(buscarCEPButton);
		//setVisible(true);
		setModal(true);
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

	public JTextField getEstadoField() {
		return estadoField;
	}
	public void setEstadoField(JTextField estadoField) {
		this.estadoField = estadoField;
	}
	public JComboBox getSexoBox() {
		return sexoBox;
	}
	
	
	public JButton getBuscarCEPButton() {
		return buscarCEPButton;
	}


	private class Panell extends JGradientePanel{

		public Panell(Color initialColor, Color finalColor) {
			super(initialColor,finalColor);
		
		}
		
	}
}
