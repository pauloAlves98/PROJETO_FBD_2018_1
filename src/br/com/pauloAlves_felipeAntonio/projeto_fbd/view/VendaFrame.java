package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VendaFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnFinalizarVenda;
	/**
	 * Create the panel.
	 */
	public VendaFrame() {
		setLayout(null);
		setSize(750,410);
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVenda.setBounds(10, 11, 82, 22);
		add(lblVenda);
		
		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(10, 44, 46, 14);
		add(lblCod);
		
		textField = new JTextField();
		textField.setBounds(10, 59, 38, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(60, 44, 65, 14);
		add(lblPaciente);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 59, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(154, 57, 30, 22);
		add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 59, 182, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(386, 59, 182, 20);
		add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(578, 59, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblServiosprodutos = new JLabel("Servi\u00E7os/Produtos");
		lblServiosprodutos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblServiosprodutos.setBounds(10, 100, 174, 22);
		add(lblServiosprodutos);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 133, 319, 155);
		add(textArea);
		
		JButton btnAdcionar = new JButton("Adcionar");
		btnAdcionar.setBounds(240, 99, 89, 23);
		add(btnAdcionar);
		
		JLabel lblPagamentos = new JLabel("Pagamentos");
		lblPagamentos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPagamentos.setBounds(346, 100, 109, 23);
		add(lblPagamentos);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(345, 133, 319, 155);
		add(textArea_1);
		
		JButton btnAdcionar_1 = new JButton("Adcionar");
		btnAdcionar_1.setBounds(575, 103, 89, 23);
		add(btnAdcionar_1);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setBounds(10, 299, 46, 14);
		add(lblCaixa);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 312, 134, 20);
		add(comboBox_1);
		
		JLabel lblNnotaFiscal = new JLabel("N\u00B0Nota Fiscal");
		lblNnotaFiscal.setBounds(154, 299, 96, 14);
		add(lblNnotaFiscal);
		
		textField_4 = new JTextField();
		textField_4.setBounds(154, 312, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(253, 299, 46, 14);
		add(lblData);
		
		textField_5 = new JTextField();
		textField_5.setBounds(253, 312, 86, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(346, 299, 46, 14);
		add(lblStatus);
		
		textField_6 = new JTextField();
		textField_6.setBounds(346, 312, 86, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setBounds(442, 299, 68, 14);
		add(lblDesconto);
		
		textField_7 = new JTextField();
		textField_7.setBounds(442, 312, 86, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(538, 299, 46, 14);
		add(lblTotal);
		
		JLabel lblRecebido = new JLabel("Recebido");
		lblRecebido.setBounds(618, 299, 79, 14);
		add(lblRecebido);
		
		textField_8 = new JTextField();
		textField_8.setBounds(538, 312, 68, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(618, 312, 79, 20);
		add(textField_9);
		textField_9.setColumns(10);
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.setBounds(10, 343, 115, 23);
		add(btnFinalizarVenda);
		
		JButton btnRecibo = new JButton("Recibo");
		btnRecibo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRecibo.setBounds(135, 343, 89, 23);
		add(btnRecibo);
		
		JButton btnNotaFiscal = new JButton("Nota Fiscal");
		btnNotaFiscal.setBounds(234, 343, 89, 23);
		add(btnNotaFiscal);
		
		JButton btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.setBounds(333, 343, 122, 23);
		add(btnCancelarVenda);
		
		JButton btnNova = new JButton("Nova");
		btnNova.setBounds(463, 343, 89, 23);
		add(btnNova);
		getContentPane().setBackground(new Color(0, 128, 255));
		//setVisible(true);

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
	public JTextField getTextField_6() {
		return textField_6;
	}
	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}
	public JTextField getTextField_7() {
		return textField_7;
	}
	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
	}
	public JTextField getTextField_8() {
		return textField_8;
	}
	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}
	public JTextField getTextField_9() {
		return textField_9;
	}
	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}
	public JButton getBtnFinalizarVenda() {
		return btnFinalizarVenda;
	}
	public void setBtnFinalizarVenda(JButton btnFinalizarVenda) {
		this.btnFinalizarVenda = btnFinalizarVenda;
	}
	
	
}
