package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class PagamentoContReceberPanel extends JFrame {

	private JPanel contentPane;
	private JTextField pacienteField;
	private JTextField valorRestanteField;
	private JTextField pagarField;
	private JTextField parcelasRestantesField;
	private JComboBox caixaBox;
	private JSpinner parcelaSpinner;
	private JButton btnPagar;

	
	public PagamentoContReceberPanel() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.black);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 68);
		panel.setPreferredSize(new Dimension(809,99));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setForeground(Color.WHITE);
		lblPagamento.setBackground(Color.WHITE);
		lblPagamento.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 28));
		lblPagamento.setBounds(20, 11, 282, 39);
		panel.add(lblPagamento);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPaciente.setBounds(10, 77, 94, 23);
		contentPane.add(lblPaciente);
		
		JLabel lblValorRestante = new JLabel("Valor Restante");
		lblValorRestante.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblValorRestante.setBounds(194, 155, 114, 14);
		contentPane.add(lblValorRestante);
		
		JLabel lblPagar = new JLabel("Pagar");
		lblPagar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPagar.setBounds(306, 155, 46, 14);
		contentPane.add(lblPagar);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(10, 223, 89, 32);
		contentPane.add(btnPagar);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCaixa.setBounds(268, 79, 46, 22);
		contentPane.add(lblCaixa);
		
		JLabel lblParcelas = new JLabel("Parcelas");
		lblParcelas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblParcelas.setBounds(134, 151, 94, 23);
		contentPane.add(lblParcelas);
		
		pacienteField = new JTextField();
		pacienteField.setEnabled(false);
		pacienteField.setBounds(10, 102, 248, 32);
		contentPane.add(pacienteField);
		pacienteField.setColumns(10);
		
		caixaBox = new JComboBox();
		caixaBox.setBounds(268, 102, 156, 32);
		contentPane.add(caixaBox);
		
		parcelaSpinner = new JSpinner();
		parcelaSpinner.setBounds(134, 180, 51, 32);
		contentPane.add(parcelaSpinner);
		
		valorRestanteField = new JTextField();
		valorRestanteField.setEnabled(false);
		valorRestanteField.setBounds(194, 180, 102, 32);
		contentPane.add(valorRestanteField);
		valorRestanteField.setColumns(10);
		
		pagarField = new JTextField();
		pagarField.setEnabled(false);
		pagarField.setBounds(306, 180, 102, 32);
		contentPane.add(pagarField);
		pagarField.setColumns(10);
		
		JLabel lblParcelasRestantes = new JLabel("Parcelas Restantes");
		lblParcelasRestantes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblParcelasRestantes.setBounds(10, 155, 114, 14);
		contentPane.add(lblParcelasRestantes);
		
		parcelasRestantesField = new JTextField();
		parcelasRestantesField.setEnabled(false);
		parcelasRestantesField.setBounds(10, 180, 110, 32);
		contentPane.add(parcelasRestantesField);
		parcelasRestantesField.setColumns(10);
		
		setSize(450, 297);
		contentPane.setBackground(Color.WHITE);
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getPacienteField() {
		return pacienteField;
	}

	public JTextField getValorRestanteField() {
		return valorRestanteField;
	}

	public JTextField getPagarField() {
		return pagarField;
	}

	public JTextField getParcelasRestantesField() {
		return parcelasRestantesField;
	}

	public JComboBox getCaixaBox() {
		return caixaBox;
	}

	public JSpinner getParcelaSpinner() {
		return parcelaSpinner;
	}

	public JButton getBtnPagar() {
		return btnPagar;
	}
	
	
}
