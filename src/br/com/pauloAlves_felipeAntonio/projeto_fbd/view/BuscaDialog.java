package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class BuscaDialog extends JDialog{
	private JTextField filtroField;
	private JTable tabelaInfo;
	private JButton finalizarButton;
	private JButton pesqButton;
	private JScrollPane scrollPane;
	private JLabel resultadoLabel;
	public BuscaDialog(){
		
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setForeground(Color.WHITE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel lblBusca = new JLabel("Busca ");
		lblBusca.setForeground(Color.WHITE);
		lblBusca.setFont(new Font("Segoe UI Light", Font.BOLD, 22));
		lblBusca.setBounds(10, 11, 516, 32);
		this.getContentPane().add(lblBusca);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblFiltro.setBounds(10, 61, 46, 32);
		this.getContentPane().add(lblFiltro);
		
		filtroField = new JTextField();
		filtroField.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		filtroField.setBounds(66, 61, 215, 32);
		this.getContentPane().add(filtroField);
		filtroField.setColumns(10);
		
		resultadoLabel = new JLabel("\"Nenhum resultado encontrado\"");
		resultadoLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		resultadoLabel.setBounds(10, 110, 564, 193);
		resultadoLabel.setVisible(false);
		getContentPane().add(resultadoLabel);
		
		pesqButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		pesqButton.setBounds(281, 61, 32, 32);
		getContentPane().add(pesqButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 104, 584, 199);
		getContentPane().add(scrollPane);
		
		tabelaInfo = new JTable();
		tabelaInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaInfo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod", "Nome", "CPF", "Telefone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaInfo.getColumnModel().getColumn(0).setPreferredWidth(66);
		tabelaInfo.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabelaInfo.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelaInfo.getColumnModel().getColumn(2).setMinWidth(40);
		scrollPane.setViewportView(tabelaInfo);
		
		finalizarButton = new JButton("Finalizar");
		finalizarButton.setBackground(Color.WHITE);
		finalizarButton.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		finalizarButton.setBounds(10, 314, 89, 32);
		this.getContentPane().add(finalizarButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(-6, -2, 600, 49);
		getContentPane().add(panel);
		setModal(true);
		setVisible(false);
	}
	public JTextField getFiltroField() {
		return filtroField;
	}
	public void setFiltroField(JTextField filtroField) {
		this.filtroField = filtroField;
	}
	public JTable getTabelaInfo() {
		return tabelaInfo;
	}
	public void setTabelaInfo(JTable tabelaInfo) {
		this.tabelaInfo = tabelaInfo;
	}
	public JButton getFinalizarButton() {
		return finalizarButton;
	}
	public void setFinalizarButton(JButton finalizarButton) {
		this.finalizarButton = finalizarButton;
	}
	public JButton getPesqButton() {
		return pesqButton;
	}
	public void setPesqButton(JButton pesqButton) {
		this.pesqButton = pesqButton;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JLabel getResultadoLabel() {
		return resultadoLabel;
	}
	public void setResultadoLabel(JLabel resultadoLabel) {
		this.resultadoLabel = resultadoLabel;
	}
	
}
