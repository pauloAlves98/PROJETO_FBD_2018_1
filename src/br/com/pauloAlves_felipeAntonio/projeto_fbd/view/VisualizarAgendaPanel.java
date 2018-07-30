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
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(null);
		setPreferredSize(new Dimension(1000,600));
		
		JLabel lblDataSelecionada = new JLabel("Selecione a data da consulta");
		lblDataSelecionada.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblDataSelecionada.setBounds(10, 24, 338, 29);
		panel_1.add(lblDataSelecionada);
		
		lblExtenso = new JLabel("Extenso");
		lblExtenso.setFont(new Font("Arial", Font.PLAIN, 23));
		lblExtenso.setBounds(373, 11, 672, 26);
		panel_1.add(lblExtenso);
		App.lookPadrao();
		calendario = new JCalendar(new Date(),false);
		calendario.getDayChooser().getDayPanel().setForeground(Color.WHITE);
		
		calendario.getDayChooser().getDayPanel().setBackground(new Color(248, 248, 255));
		
		calendario.setBackground(Color.DARK_GRAY);
		calendario.getMonthChooser().setBackground(Color.DARK_GRAY);
		
		calendario.setBounds(10, 59, 278, 193);
	
	
		App.lookNimbus();
		panel_1.add(calendario);
		pesquisaButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		pesquisaButton.setBounds(256, 297, 32, 32);
		pesquisaButton.setBackground(Color.white);
		panel_1.add(pesquisaButton);
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblFiltro.setBounds(10, 296, 43, 32);
		panel_1.add(lblFiltro);
		
		filtroField = new JTextField();
		filtroField.setBounds(57, 297, 195, 32);
		panel_1.add(filtroField);
		filtroField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(298, 11, 2, 4000);
		panel_1.add(separator);
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
 		panel_1.add(table.getScrollPane());
 		
 		
 		table.getScrollPane().setBounds(310, 59, 488, 271);
 		table.getTable().getTableHeader().setForeground(Color.WHITE);
 	
 		table.getTable().getTableHeader().setBackground(Propiedade.cor1);
 		table.getTable().getTableHeader().setFont(Propiedade.FONT2);
 		table.getTable().getTableHeader().setBorder(new LineBorder(Color.WHITE,1,true));
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
