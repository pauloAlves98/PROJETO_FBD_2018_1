package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class MovimentacaoPanel extends JPanel {
	private JButton AdcionarButton,buscaButton;
	private JTextField filtroField;
	private JTableButton table;
	
	
	public MovimentacaoPanel() {
		setLayout(null); 
 		
 		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
 		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
 		lblCadastroDePacientes.setBounds(3, 11, 365, 27);
 		add(lblCadastroDePacientes);
 		
 		AdcionarButton = new JButton("Adicionar Produto");
 		AdcionarButton.setFont(Propiedade.FONT2);
 		AdcionarButton.setBackground(Color.WHITE);
 		AdcionarButton.setBounds(3, 39, 208, 43);
 		AdcionarButton.setBorder(null);
 		AdcionarButton.setFocusPainted(false);
 		add(AdcionarButton);
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
 		lblFiltro.setBounds(10, 93, 46, 32);
 		add(lblFiltro);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(66, 95, 145, 32);
 		add(filtroField);
 		setBackground(Color.WHITE);
 		filtroField.setColumns(10);
 		
 		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		buscaButton.setBounds(221, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		add(buscaButton);
 		
 		
 		JTableButtonModel jTableButtonModel = new JTableButtonModel();
 		jTableButtonModel.adcionar(new Object[][] {
			},
			new String[] {
					"Codigo","Produto","Vencimento","Preco da Compra","Quantidade","Cadastro"
			});
 		table = new JTableButton(jTableButtonModel);
 		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		
 		table.getScrollPane().setBounds(10, 146, 737, 200);
 		add(table.getScrollPane());
 		
 		setVisible(false);
	}


	public JButton getAdcionarButton() {
		return AdcionarButton;
	}


	public JButton getBuscaButton() {
		return buscaButton;
	}


	public JTextField getFiltroField() {
		return filtroField;
	}


	public JTableButton getTable() {
		return table;
	}

	
}
