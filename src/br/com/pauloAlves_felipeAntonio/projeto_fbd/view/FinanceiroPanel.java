package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FinanceiroPanel extends JPanel {
	private JLabel lblValorCaixa,lblValorReceber;
	private JButton btnNovaVenda,btnDashoroad;
	
	/**
	 * Create the panel.
	 */
	public FinanceiroPanel() {
		setLayout(null);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSaldo.setBounds(149, 22, 113, 31);
		add(lblSaldo);
		
//		JLabel lblFormasDePagamento = new JLabel("Formas de Pagamento");
//		lblFormasDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
//		lblFormasDePagamento.setBounds(423, 23, 264, 28);
//		add(lblFormasDePagamento);
		
		JLabel lblCaixas = new JLabel("Caixas");
		lblCaixas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaixas.setBounds(149, 74, 46, 14);
		add(lblCaixas);
		
		JLabel lblValoresAReceber = new JLabel("Valores a Receber");
		lblValoresAReceber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValoresAReceber.setBounds(149, 99, 125, 14);
		add(lblValoresAReceber);
		
		btnNovaVenda = new JButton("Nova Venda");
		btnNovaVenda.setBounds(149, 167, 113, 39);
		add(btnNovaVenda);
		
//		JLabel lblServios = new JLabel("Servi\u00E7os");
//		lblServios.setFont(new Font("Tahoma", Font.PLAIN, 25));
//		lblServios.setBounds(697, 23, 139, 28);
//		add(lblServios);
		
		lblValorCaixa = new JLabel("R$ 0,00");
		lblValorCaixa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorCaixa.setBounds(342, 74, 62, 14);
		add(lblValorCaixa);
		
		lblValorReceber = new JLabel("R$ 0,00");
		lblValorReceber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorReceber.setBounds(342, 99, 62, 14);
		add(lblValorReceber);
		
		JLabel lblEntradasESaidas = new JLabel("Entradas e Saidas");
		lblEntradasESaidas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEntradasESaidas.setBounds(155, 266, 218, 31);
		add(lblEntradasESaidas);

		
		setBackground(new Color(0, 128, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 139, 531);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFinanceiro = new JLabel("Financeiro");
		lblFinanceiro.setBounds(10, 11, 99, 27);
		lblFinanceiro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblFinanceiro);
		
		btnDashoroad = new JButton("Dashoroad");
		btnDashoroad.setHorizontalAlignment(SwingConstants.LEFT);
		btnDashoroad.setBackground(Color.WHITE);
		btnDashoroad.setBounds(0, 67, 164, 36);
		btnDashoroad.setBorder(null);
		btnDashoroad.setFocusPainted(false);
		panel.add(btnDashoroad);
	}

	public JLabel getLblValorCaixa() {
		return lblValorCaixa;
	}

	public JLabel getLblValorReceber() {
		return lblValorReceber;
	}

	public JButton getBtnNovaVenda() {
		return btnNovaVenda;
	}
	

	public void setLblValorCaixa(JLabel lblValorCaixa) {
		this.lblValorCaixa = lblValorCaixa;
	}

	public void setLblValorReceber(JLabel lblValorReceber) {
		this.lblValorReceber = lblValorReceber;
	}

	public JButton getBtnDashoroad() {
		return btnDashoroad;
	}
	
	
}
