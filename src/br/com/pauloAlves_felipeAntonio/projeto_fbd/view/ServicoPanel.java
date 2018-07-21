package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ServicoPanel extends JPanel {
	private JTextField tipoField;
	private JTextField descricaoField;
	private JTable table;
	private JButton buscaButton,servicoButton;

	/**
	 * Create the panel.
	 */
	public ServicoPanel() {
		setLayout(null);
		
		JLabel lblCadastroDeServios = new JLabel("Cadastro De Servi\u00E7os");
		lblCadastroDeServios.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
		lblCadastroDeServios.setBounds(3, 11, 365, 27);
		add(lblCadastroDeServios);
		
		servicoButton = new JButton("Novo Servi\u00E7o");
		servicoButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		servicoButton.setBackground(Color.WHITE);
		servicoButton.setBounds(3, 39, 208, 43);
		servicoButton.setBorder(null);
		servicoButton.setFocusPainted(false);
		add(servicoButton);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblFiltro.setBounds(10, 93, 46, 32);
		add(lblFiltro);
		
		tipoField = new JTextField();
		tipoField.setBounds(66, 95, 145, 32);
		add(tipoField);
		tipoField.setColumns(10);
		
		descricaoField = new JTextField();
		descricaoField.setBounds(221, 95, 176, 32);
		add(descricaoField);
		descricaoField.setColumns(10);
		
		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		
 		buscaButton.setBounds(407, 95, 32, 32);
 		buscaButton.setBackground(Color.white);
 		add(buscaButton);
		
		table = new JTable();
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		table.setShowGrid(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "Descrição", "Valor", "Cadastro"
			}
		));
		table.setBounds(10, 274, 478, -153);
		add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 146, 737, 200);
		add(scrollPane);

		setVisible(false);
	}

	public JTextField getTextField() {
		return tipoField;
	}

	public JTextField getTextField_1() {
		return descricaoField;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBuscaButton() {
		return buscaButton;
	}

	public JButton getServicoButton() {
		return servicoButton;
	}
	
	

}
