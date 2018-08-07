package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class LaudoPanel extends JPanel {
	private JTextField filtroField;
	private JDateChooser inicioData,fimData;
	private JButton pesquisaButton;
	private JTableButton table;
	public LaudoPanel() {
		setLayout(new BorderLayout(0, 0));
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		panelNorth.setPreferredSize(new Dimension(1000,100));
		add(panelNorth,BorderLayout.NORTH);
		panelNorth.setLayout(null);
		
		JLabel lblLaudos = new JLabel("Laudos");
		lblLaudos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 22));
		lblLaudos.setBounds(10, 11, 247, 26);
		panelNorth.add(lblLaudos);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblFiltro.setBounds(10, 63, 46, 30);
		panelNorth.add(lblFiltro);
		
		filtroField = new JTextField();
		filtroField.setBounds(59, 63, 185, 32);
		panelNorth.add(filtroField);
		filtroField.setColumns(10);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblDe.setBounds(255, 63, 39, 30);
		panelNorth.add(lblDe);
		
		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblA.setBounds(409, 63, 39, 30);
		panelNorth.add(lblA);
		
		inicioData = new JDateChooser(new Date());
		panelNorth.add(inicioData);
		inicioData.setBounds(280,63,119,30);
		
		fimData  = new JDateChooser();
		panelNorth.add(fimData);
		fimData.setBounds(428,63,119,30);
		
		pesquisaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		pesquisaButton.setBackground(Color.WHITE);
		pesquisaButton.setBounds(552, 63, 32, 32);
		panelNorth.add(pesquisaButton);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		panelCenter.setPreferredSize(new Dimension(1000,500));
		add(panelCenter,BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
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
 		panelCenter.add(table.getScrollPane(),BorderLayout.CENTER);
	}
	public JTextField getFiltroField() {
		return filtroField;
	}
	public void setFiltroField(JTextField filtroField) {
		this.filtroField = filtroField;
	}
	public JDateChooser getInicioData() {
		return inicioData;
	}
	public void setInicioData(JDateChooser inicioData) {
		this.inicioData = inicioData;
	}
	public JDateChooser getFimData() {
		return fimData;
	}
	public void setFimData(JDateChooser fimData) {
		this.fimData = fimData;
	}
	public JButton getPesquisaButton() {
		return pesquisaButton;
	}
	public void setPesquisaButton(JButton pesquisaButton) {
		this.pesquisaButton = pesquisaButton;
	}
	public JTableButton getTable() {
		return table;
	}
	public void setTable(JTableButton table) {
		this.table = table;
	}
	
	
}
