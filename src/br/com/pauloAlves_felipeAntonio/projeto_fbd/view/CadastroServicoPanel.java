package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class CadastroServicoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CadastroServicoPanel() {
		setLayout(null);
		
		JLabel lblCadastroDeServios = new JLabel("Cadastro de servi\u00E7os");
		lblCadastroDeServios.setBounds(10, 11, 188, 22);
		lblCadastroDeServios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCadastroDeServios);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 44, 46, 14);
		add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(10, 57, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(106, 44, 46, 14);
		add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 57, 225, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(454, 107, -454, 22);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		panel.setBounds(454, 107, -454, 22);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
	}
}
