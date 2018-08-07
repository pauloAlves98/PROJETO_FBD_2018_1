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

public class ContasAreceberPanel extends JPanel{
	private JTextField filtroField;
	private JTableButton table;
	private JButton buscaButton ;

	
	public ContasAreceberPanel() {
		setBounds(0, 0, 657, 493);//setLayout(null); 
		setLayout(new BorderLayout(0, 0));
		
		
		JTableButtonModel jTableButtonModel = new JTableButtonModel();
 		jTableButtonModel.adcionar(new Object[][] {
			},
			new String[] {
					"Codigo","Paciente","Valor","Pago","Status","Pagar"
			});
 		table = new JTableButton(jTableButtonModel);
 		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		table.getTable().setRowHeight(40);
 		
 		table.getScrollPane().setBounds(10, 106, 700, 150);
		
		
		
		JPanel panelNorth = new JPanel();
 		panelNorth.setBackground(Color.WHITE);
 		add(panelNorth,BorderLayout.NORTH);
 		panelNorth.setPreferredSize(new Dimension(600,120));;
 		panelNorth.setLayout(null);
		
 		JLabel lblCadastroDePacientes = new JLabel("Contas a Receber");
 		lblCadastroDePacientes.setBounds(3, 11, 365, 27);
 		lblCadastroDePacientes.setFont(new Font("Franklin Gothic Book", Font.BOLD, 23));
 		panelNorth.add(lblCadastroDePacientes);
 		
 		
 		
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
 		lblFiltro.setBounds(10, 53, 46, 32);
 		panelNorth.add(lblFiltro);
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(66, 55, 145, 32);
 		panelNorth.add(filtroField);
 		setBackground(Color.WHITE);
 		filtroField.setColumns(10);
 		 		
 		buscaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		buscaButton.setBounds(221, 55, 32, 32);
 		buscaButton.setBackground(Color.white);
 		panelNorth.add(buscaButton);
 		
 	
 		//add(table.getScrollPane());
 		JPanel panelTabela = new JPanel();
 		panelTabela.setBackground(Color.WHITE);
 		panelTabela.setPreferredSize(new Dimension(600,150));;
 		panelTabela.setLayout(new BorderLayout(0, 0));
 	//	table.getTable().getTableHeader().setForeground(Color.WHITE);
 	 	
 	
 		panelTabela.add(table.getScrollPane(),BorderLayout.CENTER);
 		add(panelTabela,BorderLayout.CENTER);
 		//App.lookNimbus();
 		setVisible(true);
	}


	public JTextField getFiltroField() {
		return filtroField;
	}


	public JTableButton getTable() {
		return table;
	}


	public JButton getBuscaButton() {
		return buscaButton;
	}
	
	
}
