package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;


public class CadastroServicoFrame extends JFrame {
	private JTextField tipoField;
	private JTextField descricaoField,valorField;
	private JPanel contentPane;
	private JButton salvarButton;

	/**
	 * Create the panel.
	 */
	public CadastroServicoFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setLayout(null);
		setSize(644,230);
		Panell panel = new Panell(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setBounds(0, 0, 644, 81);
		getContentPane().add(panel);
				panel.setLayout(null);
		
				JLabel lblCadastroDeServio = new JLabel("Cadastro de Serviços");
				lblCadastroDeServio.setForeground(Color.WHITE);
				lblCadastroDeServio.setBounds(10, 11, 446, 70);
				panel.add(lblCadastroDeServio);
				lblCadastroDeServio.setBackground(Color.WHITE);
				lblCadastroDeServio.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		
		JLabel lblCdigo = new JLabel("Tipo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCdigo.setBounds(10, 102, 46, 14);
		add(lblCdigo);
		
		tipoField = new JTextField();
		tipoField.setBounds(10, 122, 86, 32);
		add(tipoField);
		tipoField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNome.setBounds(106, 102, 46, 14);
		add(lblNome);
		
		descricaoField = new JTextField();
		descricaoField.setBounds(106, 122, 325, 32);
		add(descricaoField);
		descricaoField.setColumns(10);
		
		JLabel valorLabel = new JLabel("Valor(R$)");
		valorLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		valorLabel.setBounds(440, 102, 56, 14);
		add(valorLabel);
		
		valorField = new JTextField();
		valorField.setBounds(440, 122, 86, 32);
		add(valorField);
		valorField.setColumns(10);
		
		
		salvarButton = new JButton("Salvar");
		salvarButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		salvarButton.setBounds(530,122,85,32);
		add(salvarButton);
		getContentPane().setBackground(Color.WHITE);
		
	}
	private class Panell extends JGradientePanel{

		public Panell(Color initialColor, Color finalColor) {
			super(initialColor,finalColor);
		
		}
		
	}
	public JTextField getTipoField() {
		return tipoField;
	}
	public JTextField getDescricaoField() {
		return descricaoField;
	}
	public JTextField getValorField() {
		return valorField;
	}
	public JButton getSalvarButton() {
		return salvarButton;
	}
	public void setTipoField(JTextField tipoField) {
		this.tipoField = tipoField;
	}
	public void setDescricaoField(JTextField descricaoField) {
		this.descricaoField = descricaoField;
	}
	public void setValorField(JTextField valorField) {
		this.valorField = valorField;
	}
	
	
}
