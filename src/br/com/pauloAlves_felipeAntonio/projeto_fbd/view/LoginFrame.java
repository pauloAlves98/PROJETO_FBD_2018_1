package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.app.App;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import java.awt.BorderLayout;
import javax.swing.JSeparator;

/**
 * @author P
 *
 */
public class LoginFrame extends JFrame{
	private JTextField loginField;
	private JTextField senhaField;
	private JButton entrarBtn;
	private JButton sairButton;
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1010,610);
		setLocationRelativeTo(null);
		PaneGradiente pane = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		this.setContentPane(pane);
		setResizable(false);
		setUndecorated(true)
;		setBackground(Color.WHITE);
		pane.setPreferredSize(new Dimension(1010,610));
		pane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel.setBounds(298, 164, 482, 348);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		loginField = new JTextField();
		loginField.setFont(new Font("Arial", Font.PLAIN, 14));
		loginField.setBounds(131, 122, 280, 41);
		panel.add(loginField);
		loginField.setBackground(Color.WHITE);
		loginField.setColumns(10);
		
		senhaField = new JPasswordField();
		senhaField.setFont(new Font("Arial", Font.PLAIN, 14));
		senhaField.setBounds(131, 174, 280, 41);
		panel.add(senhaField);
		senhaField.setColumns(10);
		
		entrarBtn = new JButton("Entrar");
		entrarBtn.setBackground(Propiedade.cor1);
		entrarBtn.setBounds(88, 226, 323, 50);
		panel.add(entrarBtn);
		entrarBtn.setForeground(Color.WHITE);
		entrarBtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		
		PaneGradiente panel_1 = new PaneGradiente(Propiedade.cor1,Propiedade.cor1);
		panel_1.setBounds(0, 0, 482, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setBounds(181, 11, 195, 78);
		panel_1.add(lblLogin);
		lblLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 50));
		
		JPanel panel_2 = new JPanel();
		panel_2 .setBackground(Propiedade.cor1);
		panel_2.setBounds(88, 122, 41, 41);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon = new JLabel(new ImageIcon("Res/usuario.png"));
		panel_2.add(lblIcon);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Propiedade.cor1);
		panel_3.setBounds(88, 174, 41, 41);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcon_1 = new JLabel(new ImageIcon("Res/senha.png"));
		panel_3.add(lblIcon_1);
		
		JLabel lblNewLabel = new JLabel("FBD CLIN\u00CDCA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblNewLabel.setBounds(460, 82, 173, 72);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(625, 129, 155, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(299, 129, 155, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(298, 531, 482, 10);
		getContentPane().add(separator_2);
		
		App.lookPadrao();
		sairButton = new JButton(new ImageIcon("Res/sair32.png"));
		sairButton.setOpaque(false);
		sairButton.setBounds(978, 578, 32, 32);
		sairButton.setBorder(null);
		pane.add(sairButton);
		setVisible(true);
	}
	public JTextField getLoginField() {
		return loginField;
	}
	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}
	public JTextField getSenhaField() {
		return senhaField;
	}
	public void setSenhaField(JTextField senhaField) {
		this.senhaField = senhaField;
	}
	public JButton getEntrarBtn() {
		return entrarBtn;
	}
	public void setEntrarBtn(JButton entrarBtn) {
		this.entrarBtn = entrarBtn;
	}
	public JButton getSairButton() {
		return sairButton;
	}
	public void setSairButton(JButton sairButton) {
		this.sairButton = sairButton;
	}
	
}
