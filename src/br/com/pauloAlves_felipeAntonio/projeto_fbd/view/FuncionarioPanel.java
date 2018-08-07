package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class FuncionarioPanel extends JPanel{
	private JTextField filtroField;
	private JTableButton table;
	private JButton funcionarioButton,buscaButton ;
	public FuncionarioPanel() {
    	setBounds(0, 0, 657, 493);
 		setLayout(new BorderLayout(0, 0));
 		setBackground(Color.WHITE);
 		
 		JTableButtonModel jTableButtonModel = new JTableButtonModel();
 		jTableButtonModel.adcionar(new Object[][] {
			},
			new String[] {
					
			});
 		table = new JTableButton(jTableButtonModel);
 		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		
 		table.getScrollPane().setBounds(10, 146, 737, 200);

 		
 		JPanel panelNorth = new JPanel();
 		panelNorth.setBackground(Color.WHITE);
 		add(panelNorth,BorderLayout.NORTH);
 		panelNorth.setPreferredSize(new Dimension(600,150));;
 		panelNorth.setLayout(null);
 		JLabel lblCadastroDePacientes = new JLabel("Cadastro de Funcionário");
 		lblCadastroDePacientes.setBounds(10, 0, 337, 27);
 		panelNorth.add(lblCadastroDePacientes);
 		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
 		
 		funcionarioButton = new JButton("Novo Funcionário");
 		funcionarioButton.setBounds(20, 39, 208, 43);
 		panelNorth.add(funcionarioButton);
 		funcionarioButton.setFont(Propiedade.FONT2);
 		funcionarioButton.setBackground(Color.WHITE);
 		funcionarioButton.setBorder(null);
 		funcionarioButton.setFocusPainted(false);
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setBounds(10, 93, 62, 32);
 		panelNorth.add(lblFiltro);
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
 		
 		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		buscaButton.setBounds(395, 93, 32, 32);
 		panelNorth.add(buscaButton);
 		buscaButton.setBackground(Color.white);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(76, 93, 309, 32);
 		panelNorth.add(filtroField);
 		filtroField.setColumns(10);
 		
 		JPanel panelTabela = new JPanel();
 		panelTabela.setBackground(Color.WHITE);
 	
 		panelTabela.setPreferredSize(new Dimension(600,150));;
 		panelTabela.setLayout(new BorderLayout(0, 0));
 		panelTabela.add(table.getScrollPane(),BorderLayout.CENTER);
 		add(panelTabela,BorderLayout.CENTER);
 		
// 		JScrollPane scrollPane = new JScrollPane(table);
// 		scrollPane.setBounds(10, 146, 737, 200);
// 		add(scrollPane);
 		setVisible(false);
 	}
	public JTextField getFiltroField() {
		return filtroField;
	}
	public void setFiltroField(JTextField filtroField) {
		this.filtroField = filtroField;
	}

	public JTableButton getTable() {
		return table;
	}
	public void setTable(JTableButton table) {
		this.table = table;
	}
	public JButton getFuncionarioButton() {
		return funcionarioButton;
	}
	public void setFuncionarioButton(JButton pacienteButton) {
		this.funcionarioButton = pacienteButton;
	}
	public JButton getBuscaButton() {
		return buscaButton;
	}
	public void setBuscaButton(JButton buscaButton) {
		this.buscaButton = buscaButton;
	}
}
