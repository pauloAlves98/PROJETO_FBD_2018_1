package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Financeiro extends JPanel {

	/**
	 * Create the panel.
	 */
	public Financeiro() {
		setLayout(null);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSaldo.setBounds(149, 22, 113, 31);
		add(lblSaldo);
		
		JLabel lblFormasDePagamento = new JLabel("Formas de Pagamento");
		lblFormasDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFormasDePagamento.setBounds(423, 23, 264, 28);
		add(lblFormasDePagamento);
		
		JLabel lblCaixas = new JLabel("Caixas");
		lblCaixas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaixas.setBounds(149, 74, 46, 14);
		add(lblCaixas);
		
		JLabel lblValoresAReceber = new JLabel("Valores a Receber");
		lblValoresAReceber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValoresAReceber.setBounds(149, 99, 125, 14);
		add(lblValoresAReceber);
		
		JButton btnNovaVenda = new JButton("Nova Venda");
		btnNovaVenda.setBounds(149, 167, 113, 39);
		add(btnNovaVenda);
		
		JLabel lblServios = new JLabel("Servi\u00E7os");
		lblServios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblServios.setBounds(697, 23, 139, 28);
		add(lblServios);
		
		JLabel lblR = new JLabel("R$ 0,00");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR.setBounds(342, 74, 62, 14);
		add(lblR);
		
		JLabel lblR_2 = new JLabel("R$ 0,00");
		lblR_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR_2.setBounds(342, 99, 62, 14);
		add(lblR_2);
		
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
		
		JButton btnDashoroad = new JButton("Dashoroad");
		btnDashoroad.setHorizontalAlignment(SwingConstants.LEFT);
		btnDashoroad.setBackground(Color.WHITE);
		btnDashoroad.setBounds(0, 67, 164, 36);
		btnDashoroad.setBorder(null);
		btnDashoroad.setFocusPainted(false);
		panel.add(btnDashoroad);
	}
}
