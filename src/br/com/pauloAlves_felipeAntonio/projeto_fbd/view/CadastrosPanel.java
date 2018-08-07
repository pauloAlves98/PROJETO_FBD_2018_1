package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrosPanel extends JPanel{
	private PacientesPanel telaPacientes;
	private ProdutoPanel telaProduto;
	private ServicoPanel telaServico;
	private FornecedoresPanel telaFornecedor;
	private FuncionarioPanel funcionarioPanel;
	private JPanel menuCadastro;
	private MedicoPanel medicoPanel;
	private JButton pacienteButton,servicoButton,fornecedorButton,medicoButton;
	
	private  JButton funcionarioButton;
	public CadastrosPanel() {
		setLayout(new BorderLayout());
		
		menuCadastro = new PaneGradiente(Propiedade.cor1,Color.black);
		menuCadastro.setBackground(Color.BLUE);
		menuCadastro.setBounds(0, 0, 1000, 99);
		menuCadastro.setPreferredSize(new Dimension(1000,99));
		add(menuCadastro,BorderLayout.NORTH);
		menuCadastro.setLayout(null);
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setBounds(10, 0, 201, 59);
		lblCadastros.setForeground(Color.WHITE);
		lblCadastros.setBackground(new Color(255, 255, 255));
		lblCadastros.setFont(new Font("Franklin Gothic Book", Font.BOLD, 24));
		menuCadastro.add(lblCadastros);
		
		fornecedorButton = new JButton("  Fornecedores");
		fornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		fornecedorButton.setBounds(5, 55, 138, 33);
		fornecedorButton.setFont(Propiedade.FONT2);
		fornecedorButton.setHorizontalAlignment(SwingConstants.LEFT);
		fornecedorButton.setBackground(Color.WHITE);
		fornecedorButton.setBorder(null);
		fornecedorButton.setFocusPainted(false);
		menuCadastro.add(fornecedorButton);
		
		servicoButton = new JButton("  Serviços");
		servicoButton.setBounds(147, 55, 125, 33);
		servicoButton.setFont(Propiedade.FONT2);
		servicoButton.setHorizontalAlignment(SwingConstants.LEFT);
		servicoButton.setBackground(Color.WHITE);
		servicoButton.setBorder(null);
		servicoButton.setFocusPainted(false);
		menuCadastro.add(servicoButton);
		
		pacienteButton = new JButton("Pacientes");
		pacienteButton.setBounds(278, 55, 145, 33);
		pacienteButton.setFont( Propiedade.FONT2);
		pacienteButton.setHorizontalAlignment(SwingConstants.CENTER);
		pacienteButton.setBackground(Color.WHITE);
		pacienteButton.setBorder(null);
		pacienteButton.setFocusPainted(false);
		menuCadastro.add(pacienteButton);
		
		funcionarioButton = new JButton("Funcionarios");
		funcionarioButton.setBounds(429, 55, 154, 33);
		funcionarioButton .setFont( Propiedade.FONT2);
		funcionarioButton .setHorizontalAlignment(SwingConstants.CENTER);
		funcionarioButton .setBackground(Color.WHITE);
		funcionarioButton.setBorder(null);
		funcionarioButton .setFocusPainted(false);
		menuCadastro.add(funcionarioButton);
		
		medicoButton = new JButton("Médicos");
		medicoButton.setBounds(595, 55, 154, 33);
		medicoButton .setFont( Propiedade.FONT2);
		medicoButton .setHorizontalAlignment(SwingConstants.CENTER);
		medicoButton .setBackground(Color.WHITE);
		medicoButton.setBorder(null);
		medicoButton .setFocusPainted(false);
		menuCadastro.add(medicoButton);
	    
		
		
		telaPacientes = new PacientesPanel();
		telaPacientes.getBtnNewButton_3().setLocation(10, 41);
		telaPacientes.setBackground(Color.WHITE);
		telaPacientes.getBtnNewButton_3().setFont(Propiedade.FONT2);
		//telaPacientes.getTable().setBounds(11, 172, 635, 32);
		telaPacientes.setBounds(0, 96, 796, 493);
		
		//telaPacientes.setLayout(null);
		add(telaPacientes);
		funcionarioPanel = new FuncionarioPanel();
		funcionarioPanel.setPreferredSize(new Dimension(1000,200));
		funcionarioPanel .setBackground(Color.WHITE);
		funcionarioPanel.setBounds(0, 96, 796, 493);
		add(funcionarioPanel,BorderLayout.CENTER);
		telaServico = new ServicoPanel();
		telaServico.setBackground(Color.WHITE);
		telaServico.setBounds(0, 96, 796, 493);
		add(telaServico);
		
	
		
		medicoPanel = new MedicoPanel();
		medicoPanel.setPreferredSize(new Dimension(1000,200));
		add(medicoPanel);medicoPanel.setVisible(false);
		telaFornecedor = new FornecedoresPanel();
		telaFornecedor.setBackground(Color.WHITE);
		telaFornecedor.setBounds(0, 96, 796, 493);
		add(telaFornecedor,BorderLayout.CENTER);
	}

	public MedicoPanel getMedicoPanel() {
		return medicoPanel;
	}

	public void setMedicoPanel(MedicoPanel medicoPanel) {
		this.medicoPanel = medicoPanel;
	}

	public JButton getMedicoButton() {
		return medicoButton;
	}

	public void setMedicoButton(JButton medicoButton) {
		this.medicoButton = medicoButton;
	}

	public PacientesPanel getTelaPacientes() {
		return telaPacientes;
	}

	public ProdutoPanel getTelaProduto() {
		return telaProduto;
	}

	public JPanel getPanel_3() {
		return menuCadastro;
	}

	public JButton getPacienteButton() {
		return pacienteButton;
	}

	public JButton getServicoButton() {
		return servicoButton;
	}

	public JButton getFornecedorButton() {
		return fornecedorButton;
	}

	public ServicoPanel getTelaServico() {
		return telaServico;
	}

	public FornecedoresPanel getTelaFornecedor() {
		return telaFornecedor;
	}

	public FuncionarioPanel getFuncionarioPanel() {
		return funcionarioPanel;
	}

	public void setFuncionarioPanel(FuncionarioPanel funcionarioPanel) {
		this.funcionarioPanel = funcionarioPanel;
	}

	public JPanel getMenuCadastro() {
		return menuCadastro;
	}

	public void setMenuCadastro(JPanel menuCadastro) {
		this.menuCadastro = menuCadastro;
	}

	public JButton getFuncionarioButton() {
		return funcionarioButton;
	}

	public void setFuncionarioButton(JButton funcionarioButton) {
		this.funcionarioButton = funcionarioButton;
	}

	public void setTelaPacientes(PacientesPanel telaPacientes) {
		this.telaPacientes = telaPacientes;
	}

	public void setTelaProduto(ProdutoPanel telaProduto) {
		this.telaProduto = telaProduto;
	}

	public void setTelaServico(ServicoPanel telaServico) {
		this.telaServico = telaServico;
	}

	public void setTelaFornecedor(FornecedoresPanel telaFornecedor) {
		this.telaFornecedor = telaFornecedor;
	}

	public void setPacienteButton(JButton pacienteButton) {
		this.pacienteButton = pacienteButton;
	}

	public void setServicoButton(JButton servicoButton) {
		this.servicoButton = servicoButton;
	}

	public void setFornecedorButton(JButton fornecedorButton) {
		this.fornecedorButton = fornecedorButton;
	}
	
}
