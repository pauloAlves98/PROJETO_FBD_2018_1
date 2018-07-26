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
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		setSize(660,558);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{96, 38, 147, 4, 32, 71, 23, 13, 41, 117, 0};
		gridBagLayout.rowHeights = new int[]{81, 16, 32, 14, 32, 17, 32, 26, 14, 32, 14, 32, 37, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 10;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
				JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
				lblCadastroDePacientes.setForeground(Color.WHITE);
				panel.add(lblCadastroDePacientes);
				lblCadastroDePacientes.setBackground(Color.WHITE);
				lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		JLabel lblProntuario = new JLabel("Prontu\u00E1rio");
		lblProntuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		GridBagConstraints gbc_lblProntuario = new GridBagConstraints();
		gbc_lblProntuario.weightx = 1.0;
		gbc_lblProntuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProntuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblProntuario.gridx = 0;
		gbc_lblProntuario.gridy = 1;
		getContentPane().add(lblProntuario, gbc_lblProntuario);
																
																		JLabel lblNome = new JLabel("Nome");
																		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
																		GridBagConstraints gbc_lblNome = new GridBagConstraints();
																		gbc_lblNome.weightx = 1.0;
																		gbc_lblNome.anchor = GridBagConstraints.SOUTHWEST;
																		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
																		gbc_lblNome.gridwidth = 2;
																		gbc_lblNome.gridx = 1;
																		gbc_lblNome.gridy = 1;
																		getContentPane().add(lblNome, gbc_lblNome);
														
																JLabel lblTelefone = new JLabel("Telefone");
																lblTelefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
																GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
																gbc_lblTelefone.weightx = 1.0;
																gbc_lblTelefone.anchor = GridBagConstraints.SOUTHWEST;
																gbc_lblTelefone.insets = new Insets(0, 0, 5, 0);
																gbc_lblTelefone.gridwidth = 2;
																gbc_lblTelefone.gridx = 8;
																gbc_lblTelefone.gridy = 1;
																getContentPane().add(lblTelefone, gbc_lblTelefone);
												
														prontuarioField = new JTextField();
														GridBagConstraints gbc_prontuarioField = new GridBagConstraints();
														gbc_prontuarioField.weighty = 1.0;
														gbc_prontuarioField.weightx = 1.0;
														gbc_prontuarioField.anchor = GridBagConstraints.EAST;
														gbc_prontuarioField.fill = GridBagConstraints.BOTH;
														gbc_prontuarioField.insets = new Insets(0, 0, 5, 5);
														gbc_prontuarioField.gridx = 0;
														gbc_prontuarioField.gridy = 2;
														getContentPane().add(prontuarioField, gbc_prontuarioField);
														prontuarioField.setColumns(10);
										
												nomeField = new JTextField();
												GridBagConstraints gbc_nomeField = new GridBagConstraints();
												gbc_nomeField.weighty = 1.0;
												gbc_nomeField.weightx = 1.0;
												gbc_nomeField.fill = GridBagConstraints.BOTH;
												gbc_nomeField.insets = new Insets(0, 0, 5, 5);
												gbc_nomeField.gridwidth = 7;
												gbc_nomeField.gridx = 1;
												gbc_nomeField.gridy = 2;
												getContentPane().add(nomeField, gbc_nomeField);
												nomeField.setColumns(10);
										
												telField = new JFormattedTextField();
												GridBagConstraints gbc_telField = new GridBagConstraints();
												gbc_telField.weighty = 1.0;
												gbc_telField.weightx = 1.0;
												gbc_telField.fill = GridBagConstraints.BOTH;
												gbc_telField.insets = new Insets(0, 0, 5, 0);
												gbc_telField.gridwidth = 2;
												gbc_telField.gridx = 8;
												gbc_telField.gridy = 2;
												getContentPane().add(telField, gbc_telField);
												telField.setColumns(10);
										
												JLabel lblSexo = new JLabel("Sexo");
												lblSexo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												GridBagConstraints gbc_lblSexo = new GridBagConstraints();
												gbc_lblSexo.weightx = 1.0;
												gbc_lblSexo.fill = GridBagConstraints.HORIZONTAL;
												gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
												gbc_lblSexo.gridx = 0;
												gbc_lblSexo.gridy = 3;
												getContentPane().add(lblSexo, gbc_lblSexo);
												JLabel lblNascimento = new JLabel("Nascimento");
												lblNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												GridBagConstraints gbc_lblNascimento = new GridBagConstraints();
												gbc_lblNascimento.weightx = 1.0;
												gbc_lblNascimento.fill = GridBagConstraints.HORIZONTAL;
												gbc_lblNascimento.insets = new Insets(0, 0, 5, 5);
												gbc_lblNascimento.gridx = 2;
												gbc_lblNascimento.gridy = 3;
												getContentPane().add(lblNascimento, gbc_lblNascimento);
										
										
												JLabel lblRg = new JLabel("RG");
												lblRg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												GridBagConstraints gbc_lblRg = new GridBagConstraints();
												gbc_lblRg.weightx = 1.0;
												gbc_lblRg.fill = GridBagConstraints.HORIZONTAL;
												gbc_lblRg.insets = new Insets(0, 0, 5, 5);
												gbc_lblRg.gridwidth = 3;
												gbc_lblRg.gridx = 3;
												gbc_lblRg.gridy = 3;
												getContentPane().add(lblRg, gbc_lblRg);
								
										JLabel lblCpf = new JLabel("CPF");
										lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
										GridBagConstraints gbc_lblCpf = new GridBagConstraints();
										gbc_lblCpf.weightx = 1.0;
										gbc_lblCpf.fill = GridBagConstraints.HORIZONTAL;
										gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
										gbc_lblCpf.gridwidth = 2;
										gbc_lblCpf.gridx = 7;
										gbc_lblCpf.gridy = 3;
										getContentPane().add(lblCpf, gbc_lblCpf);
												
														sexoBox = new JComboBox();
														sexoBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
														sexoBox.addItem("Masculino");
														sexoBox.addItem("Feminino");
														GridBagConstraints gbc_sexoBox = new GridBagConstraints();
														gbc_sexoBox.weighty = 1.0;
														gbc_sexoBox.weightx = 1.0;
														gbc_sexoBox.fill = GridBagConstraints.BOTH;
														gbc_sexoBox.insets = new Insets(0, 0, 5, 5);
														gbc_sexoBox.gridwidth = 2;
														gbc_sexoBox.gridx = 0;
														gbc_sexoBox.gridy = 4;
														getContentPane().add(sexoBox, gbc_sexoBox);
										
												nascField = new JFormattedTextField ();
												GridBagConstraints gbc_nascField = new GridBagConstraints();
												gbc_nascField.weighty = 1.0;
												gbc_nascField.weightx = 1.0;
												gbc_nascField.fill = GridBagConstraints.BOTH;
												gbc_nascField.insets = new Insets(0, 0, 5, 5);
												gbc_nascField.gridx = 2;
												gbc_nascField.gridy = 4;
												getContentPane().add(nascField, gbc_nascField);
												nascField.setColumns(10);
										
												rgField = new JFormattedTextField ();
												GridBagConstraints gbc_rgField = new GridBagConstraints();
												gbc_rgField.weighty = 1.0;
												gbc_rgField.weightx = 1.0;
												gbc_rgField.fill = GridBagConstraints.BOTH;
												gbc_rgField.insets = new Insets(0, 0, 5, 5);
												gbc_rgField.gridwidth = 4;
												gbc_rgField.gridx = 3;
												gbc_rgField.gridy = 4;
												getContentPane().add(rgField, gbc_rgField);
										
												cpfField = new JFormattedTextField ();
												GridBagConstraints gbc_cpfField = new GridBagConstraints();
												gbc_cpfField.weighty = 1.0;
												gbc_cpfField.weightx = 1.0;
												gbc_cpfField.fill = GridBagConstraints.BOTH;
												gbc_cpfField.insets = new Insets(0, 0, 5, 0);
												gbc_cpfField.gridwidth = 3;
												gbc_cpfField.gridx = 7;
												gbc_cpfField.gridy = 4;
												getContentPane().add(cpfField, gbc_cpfField);
												cpfField.setColumns(10);
								
										JLabel lblNomeDoPai = new JLabel("Nome do Pai");
										lblNomeDoPai.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
										GridBagConstraints gbc_lblNomeDoPai = new GridBagConstraints();
										gbc_lblNomeDoPai.weightx = 1.0;
										gbc_lblNomeDoPai.fill = GridBagConstraints.HORIZONTAL;
										gbc_lblNomeDoPai.insets = new Insets(0, 0, 5, 5);
										gbc_lblNomeDoPai.gridx = 0;
										gbc_lblNomeDoPai.gridy = 5;
										getContentPane().add(lblNomeDoPai, gbc_lblNomeDoPai);
						
								JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e");
								lblNomeDaMe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								GridBagConstraints gbc_lblNomeDaMe = new GridBagConstraints();
								gbc_lblNomeDaMe.weightx = 1.0;
								gbc_lblNomeDaMe.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblNomeDaMe.anchor = GridBagConstraints.SOUTHWEST;
								gbc_lblNomeDaMe.insets = new Insets(0, 0, 5, 5);
								gbc_lblNomeDaMe.gridwidth = 2;
								gbc_lblNomeDaMe.gridx = 4;
								gbc_lblNomeDaMe.gridy = 5;
								getContentPane().add(lblNomeDaMe, gbc_lblNomeDaMe);
						
								nomePField = new JTextField();
								GridBagConstraints gbc_nomePField = new GridBagConstraints();
								gbc_nomePField.weighty = 1.0;
								gbc_nomePField.weightx = 1.0;
								gbc_nomePField.fill = GridBagConstraints.BOTH;
								gbc_nomePField.insets = new Insets(0, 0, 5, 5);
								gbc_nomePField.gridwidth = 4;
								gbc_nomePField.gridx = 0;
								gbc_nomePField.gridy = 6;
								getContentPane().add(nomePField, gbc_nomePField);
								nomePField.setColumns(10);
				
						nomeMField = new JTextField();
						GridBagConstraints gbc_nomeMField = new GridBagConstraints();
						gbc_nomeMField.weighty = 1.0;
						gbc_nomeMField.weightx = 1.0;
						gbc_nomeMField.fill = GridBagConstraints.BOTH;
						gbc_nomeMField.insets = new Insets(0, 0, 5, 0);
						gbc_nomeMField.gridwidth = 6;
						gbc_nomeMField.gridx = 4;
						gbc_nomeMField.gridy = 6;
						getContentPane().add(nomeMField, gbc_nomeMField);
						nomeMField.setColumns(10);
				
				
				
						JLabel lblEndereco = new JLabel("Endere\u00E7o");
						lblEndereco.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
						GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
						gbc_lblEndereco.weightx = 1.0;
						gbc_lblEndereco.anchor = GridBagConstraints.WEST;
						gbc_lblEndereco.fill = GridBagConstraints.VERTICAL;
						gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
						gbc_lblEndereco.gridwidth = 3;
						gbc_lblEndereco.gridx = 0;
						gbc_lblEndereco.gridy = 7;
						getContentPane().add(lblEndereco, gbc_lblEndereco);
										
												JLabel lblComplemento = new JLabel("Complemento");
												lblComplemento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
												GridBagConstraints gbc_lblComplemento = new GridBagConstraints();
												gbc_lblComplemento.weightx = 1.0;
												gbc_lblComplemento.anchor = GridBagConstraints.SOUTH;
												gbc_lblComplemento.fill = GridBagConstraints.HORIZONTAL;
												gbc_lblComplemento.insets = new Insets(0, 0, 5, 5);
												gbc_lblComplemento.gridheight = 2;
												gbc_lblComplemento.gridx = 2;
												gbc_lblComplemento.gridy = 7;
												getContentPane().add(lblComplemento, gbc_lblComplemento);
								
										JLabel lblCep = new JLabel("CEP");
										lblCep.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
										GridBagConstraints gbc_lblCep = new GridBagConstraints();
										gbc_lblCep.weightx = 1.0;
										gbc_lblCep.fill = GridBagConstraints.HORIZONTAL;
										gbc_lblCep.insets = new Insets(0, 0, 5, 5);
										gbc_lblCep.gridx = 0;
										gbc_lblCep.gridy = 8;
										getContentPane().add(lblCep, gbc_lblCep);
						
								JLabel lblBairro = new JLabel("Bairro");
								lblBairro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								GridBagConstraints gbc_lblBairro = new GridBagConstraints();
								gbc_lblBairro.weightx = 1.0;
								gbc_lblBairro.anchor = GridBagConstraints.WEST;
								gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
								gbc_lblBairro.gridx = 5;
								gbc_lblBairro.gridy = 8;
								getContentPane().add(lblBairro, gbc_lblBairro);
						
								JLabel lblLogradouro = new JLabel("Logradouro");
								lblLogradouro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								GridBagConstraints gbc_lblLogradouro = new GridBagConstraints();
								gbc_lblLogradouro.weightx = 1.0;
								gbc_lblLogradouro.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblLogradouro.insets = new Insets(0, 0, 5, 0);
								gbc_lblLogradouro.gridx = 9;
								gbc_lblLogradouro.gridy = 8;
								getContentPane().add(lblLogradouro, gbc_lblLogradouro);
				
						cepField = new JFormattedTextField ();
						GridBagConstraints gbc_cepField = new GridBagConstraints();
						gbc_cepField.weighty = 1.0;
						gbc_cepField.weightx = 1.0;
						gbc_cepField.fill = GridBagConstraints.BOTH;
						gbc_cepField.insets = new Insets(0, 0, 5, 5);
						gbc_cepField.gridwidth = 2;
						gbc_cepField.gridx = 0;
						gbc_cepField.gridy = 9;
						getContentPane().add(cepField, gbc_cepField);
						cepField.setColumns(10);
		
				complementoField = new JTextField();
				GridBagConstraints gbc_complementoField = new GridBagConstraints();
				gbc_complementoField.weightx = 1.0;
				gbc_complementoField.weighty = 1.0;
				gbc_complementoField.fill = GridBagConstraints.BOTH;
				gbc_complementoField.insets = new Insets(0, 0, 5, 5);
				gbc_complementoField.gridwidth = 3;
				gbc_complementoField.gridx = 2;
				gbc_complementoField.gridy = 9;
				getContentPane().add(complementoField, gbc_complementoField);
				complementoField.setColumns(10);
						
								bairroField = new JTextField();
								GridBagConstraints gbc_bairroField = new GridBagConstraints();
								gbc_bairroField.weighty = 1.0;
								gbc_bairroField.weightx = 1.0;
								gbc_bairroField.fill = GridBagConstraints.BOTH;
								gbc_bairroField.insets = new Insets(0, 0, 5, 5);
								gbc_bairroField.gridwidth = 4;
								gbc_bairroField.gridx = 5;
								gbc_bairroField.gridy = 9;
								getContentPane().add(bairroField, gbc_bairroField);
								bairroField.setColumns(10);
								
										logradouroField = new JTextField();
										GridBagConstraints gbc_logradouroField = new GridBagConstraints();
										gbc_logradouroField.weightx = 1.0;
										gbc_logradouroField.weighty = 1.0;
										gbc_logradouroField.anchor = GridBagConstraints.WEST;
										gbc_logradouroField.fill = GridBagConstraints.BOTH;
										gbc_logradouroField.insets = new Insets(0, 0, 5, 0);
										gbc_logradouroField.gridx = 9;
										gbc_logradouroField.gridy = 9;
										getContentPane().add(logradouroField, gbc_logradouroField);
										logradouroField.setColumns(10);
						
								JLabel lblRua = new JLabel("Rua");
								lblRua.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								GridBagConstraints gbc_lblRua = new GridBagConstraints();
								gbc_lblRua.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblRua.weightx = 1.0;
								gbc_lblRua.insets = new Insets(0, 0, 5, 5);
								gbc_lblRua.gridx = 0;
								gbc_lblRua.gridy = 10;
								getContentPane().add(lblRua, gbc_lblRua);
				
						JLabel lblCidade = new JLabel("Cidade");
						lblCidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						GridBagConstraints gbc_lblCidade = new GridBagConstraints();
						gbc_lblCidade.weightx = 1.0;
						gbc_lblCidade.anchor = GridBagConstraints.WEST;
						gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
						gbc_lblCidade.gridx = 2;
						gbc_lblCidade.gridy = 10;
						getContentPane().add(lblCidade, gbc_lblCidade);
						
								JLabel lblPais = new JLabel("Pa\u00EDs");
								lblPais.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								GridBagConstraints gbc_lblPais = new GridBagConstraints();
								gbc_lblPais.weightx = 1.0;
								gbc_lblPais.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblPais.insets = new Insets(0, 0, 5, 5);
								gbc_lblPais.gridwidth = 2;
								gbc_lblPais.gridx = 3;
								gbc_lblPais.gridy = 10;
								getContentPane().add(lblPais, gbc_lblPais);
				
						JLabel lblEstado = new JLabel("Estado");
						lblEstado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						GridBagConstraints gbc_lblEstado = new GridBagConstraints();
						gbc_lblEstado.weightx = 1.0;
						gbc_lblEstado.fill = GridBagConstraints.HORIZONTAL;
						gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
						gbc_lblEstado.gridwidth = 2;
						gbc_lblEstado.gridx = 6;
						gbc_lblEstado.gridy = 10;
						getContentPane().add(lblEstado, gbc_lblEstado);
				
						JLabel lblNumero = new JLabel("N\u00FAmero");
						lblNumero.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						GridBagConstraints gbc_lblNumero = new GridBagConstraints();
						gbc_lblNumero.weightx = 1.0;
						gbc_lblNumero.anchor = GridBagConstraints.WEST;
						gbc_lblNumero.insets = new Insets(0, 0, 5, 0);
						gbc_lblNumero.gridx = 9;
						gbc_lblNumero.gridy = 10;
						getContentPane().add(lblNumero, gbc_lblNumero);
				
						ruaField = new JTextField();
						GridBagConstraints gbc_ruaField = new GridBagConstraints();
						gbc_ruaField.weighty = 1.0;
						gbc_ruaField.weightx = 1.0;
						gbc_ruaField.fill = GridBagConstraints.BOTH;
						gbc_ruaField.insets = new Insets(0, 0, 5, 5);
						gbc_ruaField.gridwidth = 2;
						gbc_ruaField.gridx = 0;
						gbc_ruaField.gridy = 11;
						getContentPane().add(ruaField, gbc_ruaField);
						ruaField.setColumns(10);
		
				cidadeField = new JTextField();
				GridBagConstraints gbc_cidadeField = new GridBagConstraints();
				gbc_cidadeField.weighty = 1.0;
				gbc_cidadeField.weightx = 1.0;
				gbc_cidadeField.fill = GridBagConstraints.BOTH;
				gbc_cidadeField.insets = new Insets(0, 0, 5, 5);
				gbc_cidadeField.gridx = 2;
				gbc_cidadeField.gridy = 11;
				getContentPane().add(cidadeField, gbc_cidadeField);
				cidadeField.setColumns(10);
						
								paisBox = new JComboBox();
								paisBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
								paisBox.addItem("Brasil");
								GridBagConstraints gbc_paisBox = new GridBagConstraints();
								gbc_paisBox.fill = GridBagConstraints.BOTH;
								gbc_paisBox.insets = new Insets(0, 0, 5, 5);
								gbc_paisBox.gridwidth = 3;
								gbc_paisBox.gridx = 3;
								gbc_paisBox.gridy = 11;
								getContentPane().add(paisBox, gbc_paisBox);
				
						estadoBox = new JComboBox();
						estadoBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						estadoBox.addItem("PE");
						GridBagConstraints gbc_estadoBox = new GridBagConstraints();
						gbc_estadoBox.fill = GridBagConstraints.BOTH;
						gbc_estadoBox.insets = new Insets(0, 0, 5, 5);
						gbc_estadoBox.gridwidth = 3;
						gbc_estadoBox.gridx = 6;
						gbc_estadoBox.gridy = 11;
						getContentPane().add(estadoBox, gbc_estadoBox);
				
						numeroField = new JTextField();
						GridBagConstraints gbc_numeroField = new GridBagConstraints();
						gbc_numeroField.weightx = 1.0;
						gbc_numeroField.weighty = 1.0;
						gbc_numeroField.anchor = GridBagConstraints.WEST;
						gbc_numeroField.fill = GridBagConstraints.BOTH;
						gbc_numeroField.insets = new Insets(0, 0, 5, 0);
						gbc_numeroField.gridx = 9;
						gbc_numeroField.gridy = 11;
						getContentPane().add(numeroField, gbc_numeroField);
						numeroField.setColumns(10);
		
				btnSalvar = new JButton("Salvar");
				btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
				GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
				gbc_btnSalvar.weighty = 1.0;
				gbc_btnSalvar.weightx = 1.0;
				gbc_btnSalvar.fill = GridBagConstraints.BOTH;
				gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
				gbc_btnSalvar.gridwidth = 2;
				gbc_btnSalvar.gridx = 0;
				gbc_btnSalvar.gridy = 12;
				getContentPane().add(btnSalvar, gbc_btnSalvar);
		setLocationRelativeTo(null);
		this.mascaraData();
		this.mascaraTelefone();
		this.mascaraCPF();
		this.mascaraCep();
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
