package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class CadastrosPanel extends JPanel{
	private PacientesPanel telaPacientes;
	private ProdutoPanel telaProduto;
	private JPanel menuCadastro;
	private JButton pacienteButton,servicoButton,fornecedorButton;
	
	public CadastrosPanel() {
		setLayout(null);
		
		menuCadastro = new PaneGradiente(Propiedade.cor1,Color.black);
		menuCadastro.setBackground(Color.BLUE);
		menuCadastro.setBounds(0, 0, 809, 99);
		menuCadastro.setLayout(null);
		add(menuCadastro);
		
		pacienteButton = new JButton("  Pacientes");
		pacienteButton.setFont( Propiedade.FONT2);
		pacienteButton.setHorizontalAlignment(SwingConstants.LEFT);
		pacienteButton.setBackground(Color.WHITE);
		pacienteButton.setBounds(280, 53, 154, 33);
		pacienteButton.setBorder(null);
		pacienteButton.setFocusPainted(false);
		menuCadastro.add(pacienteButton);
		
		servicoButton = new JButton("  Serviços");
		servicoButton.setFont(Propiedade.FONT2);
		servicoButton.setHorizontalAlignment(SwingConstants.LEFT);
		servicoButton.setBackground(Color.WHITE);
		servicoButton.setBounds(140, 53, 130, 33);
		servicoButton.setBorder(null);
		servicoButton.setFocusPainted(false);
		menuCadastro.add(servicoButton);
		
		fornecedorButton = new JButton("  Fornecedores");
		fornecedorButton.setFont(Propiedade.FONT2);
		fornecedorButton.setHorizontalAlignment(SwingConstants.LEFT);
		fornecedorButton.setBackground(Color.WHITE);
		fornecedorButton.setBounds(10, 53, 120, 33);
		fornecedorButton.setBorder(null);
		fornecedorButton.setFocusPainted(false);
		
		menuCadastro.add(fornecedorButton);
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setForeground(Color.WHITE);
		lblCadastros.setBackground(new Color(255, 255, 255));
		lblCadastros.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCadastros.setBounds(10, 11, 201, 31);
		menuCadastro.add(lblCadastros);
		
		telaPacientes = new PacientesPanel();
		telaPacientes.getBtnNewButton_3().setLocation(10, 41);
		telaPacientes.setBackground(Color.WHITE);
		telaPacientes.getBtnNewButton_3().setFont(Propiedade.FONT2);
		telaPacientes.getTable().setBounds(11, 172, 635, 32);
		telaPacientes.setBounds(0, 96, 796, 493);
		//telaPacientes.setLayout(null);
		add(telaPacientes);
		
		
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



	
	
}
