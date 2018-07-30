package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.app.App;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;


public class TelaPrincipal extends JFrame {
	private JButton btnFinanceiro ;
	private PacientesPanel p;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	private JTable table_2;
	private CadastrosPanel cadatrosPanel;
	private EstoquePanel estoquePanel;
	private FinanceiroPanel financeiroPanel;
	private AgendaPanel agendaPanel;

	public TelaPrincipal() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.black);
		//this.setContentPane(panel);
		//JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0,128,255));
		getContentPane().add(panel,BorderLayout.WEST);
		panel.setPreferredSize(new Dimension(183,600));

		JButton btnCadastros = new JButton("    Cadastros",new ImageIcon("Res//mais.png"));
		btnCadastros.setOpaque(false);
		btnCadastros.setFont(Propiedade.FONT1);
		btnCadastros.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastros.setForeground(Color.WHITE);
		btnCadastros.setBackground(new Color(0,128,255));
		btnCadastros.setBounds(0, 262, 181, 68);
		btnCadastros.setBorder(null);
		btnCadastros.setFocusPainted(false);
		panel.add(btnCadastros);

		JButton btnEstoque = new JButton("    Estoque",new ImageIcon("Res//est.png"));
		btnEstoque.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstoque.setFont(Propiedade.FONT1);
		btnEstoque.setForeground(Color.WHITE);
		btnEstoque.setBackground(new Color(0,128,255));
		btnEstoque.setBounds(0, 341, 181, 68);
		btnEstoque.setBorder(null);
		btnEstoque.setFocusPainted(false);
		btnEstoque.setOpaque(false);
		panel.add(btnEstoque);

		btnFinanceiro = new JButton("    Financeiro",new ImageIcon("Res//financeiro.png"));
		btnFinanceiro.setOpaque(false);
		btnFinanceiro.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinanceiro.setForeground(Color.WHITE);
		btnFinanceiro.setBackground(new Color(0,128,255));
		btnFinanceiro.setBounds(0, 183, 181, 68);
		btnFinanceiro.setBorder(null);
		btnFinanceiro.setFont(Propiedade.FONT1);
		btnFinanceiro.setFocusPainted(false);

		panel.add(btnFinanceiro);

		JButton btnAgenda = new JButton("   Agenda",new ImageIcon("Res//images.png"));
		btnAgenda.setOpaque(false);
		btnAgenda.setForeground(Color.WHITE);
		btnAgenda.setBackground(new Color(0, 128, 255));
		btnAgenda.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgenda.setBounds(5, 106, 181, 68);
		btnAgenda.setFocusPainted(false);
		btnAgenda.setBorder(null);
		btnAgenda.setFont(Propiedade.FONT1);
		panel.add(btnAgenda);

		App.lookNimbus();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		App.lookPadrao();
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		panel_1.add(tabbedPane);
		tabbedPane.setFont(Propiedade.FONT1);
		App.lookNimbus();
		cadatrosPanel = new CadastrosPanel();
		tabbedPane.addTab("Cadastros", new ImageIcon("Res//mais.png"),cadatrosPanel, null);
		financeiroPanel = new FinanceiroPanel();
		tabbedPane.addTab("Financeiro",new ImageIcon("Res//financeiro.png"), financeiroPanel, null);

		estoquePanel = new EstoquePanel();
		tabbedPane.addTab("Estoque", new ImageIcon("Res//est.png"), estoquePanel, null);
		tabbedPane.setBackground(new Color(102, 102, 255));
		tabbedPane.setForeground(Color.WHITE);
		setSize(1010, 620);
		agendaPanel = new AgendaPanel();
		tabbedPane.addTab("Agenda",new ImageIcon("Res//images.png"), agendaPanel, null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(false);



	}

	public JButton getBtnFinanceiro() {
		return btnFinanceiro;
	}

	public void setBtnFinanceiro(JButton btnFinanceiro) {
		this.btnFinanceiro = btnFinanceiro;
	}

	public PacientesPanel getP() {
		return p;
	}

	public void setP(PacientesPanel p) {
		this.p = p;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JTable getTable_2() {
		return table_2;
	}

	public void setTable_2(JTable table_2) {
		this.table_2 = table_2;
	}

	public CadastrosPanel getCadatrosPanel() {
		return cadatrosPanel;
	}

	public void setCadatrosPanel(CadastrosPanel cadatrosPanel) {
		this.cadatrosPanel = cadatrosPanel;
	}

	public EstoquePanel getEstoquePanel() {
		return estoquePanel;
	}

	public FinanceiroPanel getFinanceiroPanel() {
		return financeiroPanel;
	}

	public AgendaPanel getAgendaPanel() {
		return agendaPanel;
	}

	public void setAgendaPanel(AgendaPanel agendaPanel) {
		this.agendaPanel = agendaPanel;
	}

	public void setEstoquePanel(EstoquePanel estoquePanel) {
		this.estoquePanel = estoquePanel;
	}

	public void setFinanceiroPanel(FinanceiroPanel financeiroPanel) {
		this.financeiroPanel = financeiroPanel;
	}

	private class Panell extends JGradientePanel{

		public Panell(Color initialColor, Color finalColor) {
			super(initialColor,finalColor);

		}

	}
}
