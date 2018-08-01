package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.app.App;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class VisualizarAgendaPanel extends JPanel{
	private JTextField filtroField;
	private JButton pesquisaButton;
	private JTableButton table;
	private JCalendar calendario;
	private JLabel lblExtenso;
	public VisualizarAgendaPanel(){
		
		setLayout(new BorderLayout(0, 0));
		JPanel panelParaBorder = new JPanel();
		panelParaBorder.setBackground(Color.WHITE);
		add(panelParaBorder);
		setPreferredSize(new Dimension(1000,600));
		App.lookPadrao();
	
	
		App.lookNimbus();
		App.lookPadrao();
		JTableButtonModel jTableButtonModel = new JTableButtonModel();
 		jTableButtonModel.adcionar(new Object[][] {
			},
			new String[] {"<html><table><tr><td height=50>Horário</td></tr></table></html>"
					,"Paciente", "Data", "Telefone","Médico", "Status","Detalhes"
			});
 		table = new JTableButton(jTableButtonModel);
 		table.getTable().setBackground(Color.WHITE);
 		table.getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
 		table.getTable().setShowGrid(true);
 		
 		table.getTable().setRowHeight(40);
 		//panel_1.add(table.getScrollPane());
 		panelParaBorder.setLayout(new BorderLayout(0, 0));
 		
 		JPanel panel = new JPanel();
 		panel.setBackground(Color.WHITE);
 		panelParaBorder.add(panel);
 		panel.setLayout(null);
 		
 		JSeparator separator = new JSeparator();
 		separator.setBounds(0, 215, 4000, 2);
 		panel.add(separator);
 		panel.setPreferredSize(new Dimension(800,220));
 		
 		filtroField = new JTextField();
 		filtroField.setBounds(417, 155, 256, 32);
 		panel.add(filtroField);
 		filtroField.setColumns(10);
 		calendario = new JCalendar(new Date(),false);
 		calendario.setBounds(10, 38, 340, 171);
 		panel.add(calendario);
 		calendario.getDayChooser().getDayPanel().setForeground(Color.WHITE);
 		
 		calendario.getDayChooser().getDayPanel().setBackground(new Color(248, 248, 255));
 		
 		calendario.setBackground(Color.DARK_GRAY);
 		calendario.getMonthChooser().setBackground(Color.DARK_GRAY);
 		
 		JLabel lblDataSelecionada = new JLabel("Selecione a data da consulta");
 		lblDataSelecionada.setBounds(10, 11, 561, 29);
 		panel.add(lblDataSelecionada);
 		lblDataSelecionada.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
 		pesquisaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
 		pesquisaButton.setBounds(673, 155, 32, 32);
 		panel.add(pesquisaButton);
 		pesquisaButton.setBackground(Color.white);
 		JLabel lblFiltro = new JLabel("Filtro");
 		lblFiltro.setBounds(373, 154, 43, 32);
 		panel.add(lblFiltro);
 		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
 		
 		JPanel panel_2 = new JPanel();
 		panel_2.setBackground(Color.WHITE);
 		panelParaBorder.add(panel_2,BorderLayout.CENTER);
 		panel_2.setLayout(new BorderLayout());
 		panelParaBorder.add(panel,BorderLayout.NORTH);
 		lblExtenso = new JLabel("Extenso");
 		lblExtenso.setBounds(10, 0, 672, 54);
 		panel_2.add(lblExtenso,BorderLayout.NORTH);
 		lblExtenso.setFont(new Font("Arial", Font.PLAIN, 23));
 		
 		
 		table.getScrollPane().setBounds(10, 300, 600, 200);
 		table.getTable().getTableHeader().setForeground(Color.WHITE);
 	
 		table.getTable().getTableHeader().setBackground(Propiedade.cor1);
 		table.getTable().getTableHeader().setFont(Propiedade.FONT2);
 		table.getTable().getTableHeader().setBorder(new LineBorder(Color.WHITE,1,true));
 		panel_2.add(table.getScrollPane(),BorderLayout.CENTER);
 		App.lookNimbus();
	}

	public JTextField getFiltroField() {
		return filtroField;
	}
	public void setFiltroField(JTextField filtroField) {
		this.filtroField = filtroField;
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
	public JCalendar getCalendario() {
		return calendario;
	}
	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}
	public JLabel getLblExtenso() {
		return lblExtenso;
	}
	public void setLblExtenso(JLabel lblExtenso) {
		this.lblExtenso = lblExtenso;
	}
}
