package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlePacientesPanel;


public class TelaPrincipal extends JFrame {
	JButton btnFinanceiro ;
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
	CadastrosPanel cadatrosPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setSize(1005,610);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					new  ConsultaPanel();
					CadastroPacientePanel pacienteCadastro = new CadastroPacientePanel();
					new ProdutoPanel();
					new VendaPanel();
					
					ControlePacientesPanel contPacientes = new ControlePacientesPanel(frame.cadatrosPanel.telaPacientes,pacienteCadastro);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(0,128,255));
		panel.setBounds(0, 0, 181, 573);
		getContentPane().add(panel);
		
		JButton btnCadastros = new JButton("      Cadastros",new ImageIcon("Res//mais.png"));
		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastros.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastros.setForeground(Color.WHITE);
		btnCadastros.setBackground(new Color(0,128,255));
		btnCadastros.setBounds(0, 199, 181, 53);
		btnCadastros.setBorder(null);
		btnCadastros.setFocusPainted(false);
		panel.add(btnCadastros);
		
		JButton btnEstoque = new JButton("      Estoque",new ImageIcon("Res//est.jpg"));
		btnEstoque.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstoque.setForeground(Color.WHITE);
		btnEstoque.setBackground(new Color(0,128,255));
		btnEstoque.setBounds(0, 254, 181, 53);
		btnEstoque.setBorder(null);
		btnEstoque.setFocusPainted(false);
		panel.add(btnEstoque);
		
		btnFinanceiro = new JButton("      Financeiro",new ImageIcon("Res//financeiro.png"));
		btnFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinanceiro.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinanceiro.setForeground(Color.WHITE);
		btnFinanceiro.setBackground(new Color(0,128,255));
		btnFinanceiro.setBounds(0, 145, 181, 53);
		btnFinanceiro.setBorder(null);
		btnFinanceiro.setFocusPainted(false);
		
		panel.add(btnFinanceiro);
		
		JButton btnAgenda = new JButton("Agenda",new ImageIcon("Res//images.png"));
		btnAgenda.setForeground(Color.WHITE);
		btnAgenda.setBackground(new Color(0, 128, 255));
		btnAgenda.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgenda.setBounds(0, 92, 181, 53);
		btnAgenda.setFocusPainted(false);
		btnAgenda.setBorder(null);
		panel.add(btnAgenda);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(182, 52, 803, 521);
		getContentPane().add(tabbedPane);
		
		Financeiro panel_1 = new Financeiro();
		tabbedPane.addTab("Financeiro", null, panel_1, null);
		
		cadatrosPanel = new CadastrosPanel();
		//Component component;
		tabbedPane.addTab("Cadastros", null,cadatrosPanel, null);
	
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Estoque", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 0, 145, 493);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEstoque.setBounds(36, 11, 84, 27);
		panel_6.add(lblEstoque);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setBackground(Color.WHITE);
		btnProdutos.setBounds(10, 48, 125, 33);
		btnProdutos.setFocusPainted(false);
		btnProdutos.setBorder(null);
		panel_6.add(btnProdutos);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 128, 255));
		panel_7.setBounds(142, 0, 656, 493);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCadastroDeProdutos.setBounds(25, 27, 241, 27);
		panel_7.add(lblCadastroDeProdutos);
		
		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.setBounds(447, 21, 156, 49);
		panel_7.add(btnNovoProduto);
		
		JLabel lblFiltro_1 = new JLabel("Filtro");
		lblFiltro_1.setBounds(214, 94, 46, 14);
		panel_7.add(lblFiltro_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(250, 91, 86, 20);
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(346, 91, 146, 20);
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(502, 91, 86, 20);
		panel_7.add(textField_5);
		textField_5.setColumns(10);
	
	

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
	
}
