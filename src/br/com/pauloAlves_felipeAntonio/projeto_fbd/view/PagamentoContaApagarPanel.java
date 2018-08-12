package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class PagamentoContaApagarPanel extends JFrame{

	private JPanel contentPane;
	private JTextField pacienteField;
	private JTextField valorRestanteField;
	private JTextField pagarField;
	private JTextField parcelasRestantesField;
	private JComboBox caixaBox;
	private JSpinner parcelaSpinner;
	private JButton btnPagar;
	private JTextField textField;
	private JCheckBox chckbxParcelado;
	private JLabel lblParcelasRestantes,lblParcelas,lblPagamento,lblValorRestante,lblPagar,
					lblNDeParcelas,lblCaixa,lblFornecedor;
	
	public PagamentoContaApagarPanel() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.black);
	
		panel.setBounds(0, 0, 534, 68);
		panel.setPreferredSize(new Dimension(809,99));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblPagamento = new JLabel("Pagamento");
		lblPagamento.setForeground(Color.WHITE);
		lblPagamento.setBackground(Color.WHITE);
		lblPagamento.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 28));
		lblPagamento.setBounds(20, 11, 282, 39);
		panel.add(lblPagamento);
		
		lblValorRestante = new JLabel("Valor Restante");
		lblValorRestante.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblValorRestante.setBounds(200, 219, 114, 14);
		contentPane.add(lblValorRestante);
		
		lblPagar = new JLabel("Pagar");
		lblPagar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPagar.setBounds(309, 219, 46, 14);
		contentPane.add(lblPagar);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPagar.setBounds(10, 289, 89, 32);
		contentPane.add(btnPagar);
		
		lblCaixa = new JLabel("Caixa");
		lblCaixa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblCaixa.setBounds(268, 87, 46, 22);
		contentPane.add(lblCaixa);
		
		lblParcelas = new JLabel("Parcelas");
		lblParcelas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblParcelas.setBounds(134, 215, 94, 23);
		contentPane.add(lblParcelas);
		
		pacienteField = new JTextField();
		pacienteField.setEnabled(false);
		pacienteField.setBounds(10, 112, 248, 32);
		contentPane.add(pacienteField);
		pacienteField.setColumns(10);
		
		caixaBox = new JComboBox();
		caixaBox.setBounds(268, 112, 156, 32);
		contentPane.add(caixaBox);
		
		parcelaSpinner = new JSpinner();
		parcelaSpinner.setBounds(134, 244, 51, 32);
		contentPane.add(parcelaSpinner);
		
		valorRestanteField = new JTextField();
		valorRestanteField.setEnabled(false);
		valorRestanteField.setBounds(194, 244, 102, 32);
		contentPane.add(valorRestanteField);
		valorRestanteField.setColumns(10);
		
		pagarField = new JTextField();
		pagarField.setEnabled(false);
		pagarField.setBounds(309, 244, 102, 32);
		contentPane.add(pagarField);
		pagarField.setColumns(10);
		
		lblParcelasRestantes = new JLabel("Parcelas Restantes");
		lblParcelasRestantes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblParcelasRestantes.setBounds(10, 219, 114, 14);
		contentPane.add(lblParcelasRestantes);
		
		parcelasRestantesField = new JTextField();
		parcelasRestantesField.setBounds(10, 244, 110, 32);
		contentPane.add(parcelasRestantesField);
		parcelasRestantesField.setColumns(10);
		
		lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblFornecedor.setBounds(10, 91, 102, 14);
		contentPane.add(lblFornecedor);
		
		chckbxParcelado = new JCheckBox("Parcelado");
		chckbxParcelado.setSelected(true); 
		chckbxParcelado.setBounds(168, 69, 97, 23);
		contentPane.add(chckbxParcelado);
		
		textField = new JTextField();
		textField.setBounds(10, 176, 86, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNDeParcelas = new JLabel("N\u00B0 de Parcelas");
		lblNDeParcelas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNDeParcelas.setBounds(10, 155, 114, 22);
		contentPane.add(lblNDeParcelas);
		contentPane.setBackground(Color.WHITE);
		setSize(450, 349);
		
	}

	
	
	public JLabel getLblFornecedor() {
		return lblFornecedor;
	}



	public JLabel getLblParcelasRestantes() {
		return lblParcelasRestantes;
	}



	public JLabel getLblParcelas() {
		return lblParcelas;
	}



	public JLabel getLblPagamento() {
		return lblPagamento;
	}



	public JLabel getLblValorRestante() {
		return lblValorRestante;
	}



	public JLabel getLblPagar() {
		return lblPagar;
	}



	public JLabel getLblNDeParcelas() {
		return lblNDeParcelas;
	}



	public JLabel getLblCaixa() {
		return lblCaixa;
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

	public JTextField getTextField() {
		return textField;
	}

	public JCheckBox getChckbxParcelado() {
		return chckbxParcelado;
	}
	
	
}
