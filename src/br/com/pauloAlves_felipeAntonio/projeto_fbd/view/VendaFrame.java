package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class VendaFrame extends JFrame{
	private JTextField codField;
	private JTextField pacienteField;
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
		getContentPane().setLayout(null);
		setSize(750,602);
		
		JLabel lblCod = new JLabel("Cod");
		lblCod.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCod.setBounds(10, 109, 46, 14);
		getContentPane().add(lblCod);
		
		codField = new JTextField();
		codField.setBounds(10, 134, 38, 32);
		getContentPane().add(codField);
		codField.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblPaciente.setBounds(60, 109, 65, 14);
		getContentPane().add(lblPaciente);
		
		pacienteField = new JTextField();
		pacienteField.setBounds(58, 134, 188, 32);
		getContentPane().add(pacienteField);
		pacienteField.setColumns(10);
		
		JButton btnNewButton = new JButton(new ImageIcon("Res/pesquisa.png"));
		btnNewButton .setBackground(Color.white);
		btnNewButton.setBounds(251, 133, 32, 32);
		getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(291, 134, 182, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(483, 134, 134, 32);
		getContentPane().add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(627, 134, 97, 32);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblServiosprodutos = new JLabel("Servi\u00E7os/Produtos");
		lblServiosprodutos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblServiosprodutos.setBounds(10, 177, 174, 22);
		getContentPane().add(lblServiosprodutos);
		
		JButton btnAdcionar = new JButton(new ImageIcon("Res/adicionar32.png"));
		btnAdcionar.setBackground(Color.white);
		btnAdcionar.setBounds(298, 177, 32, 32);
		getContentPane().add(btnAdcionar);
		setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 319, 147);
		getContentPane().add(scrollPane);
		
		
		JTextArea areaServicos = new JTextArea();
		areaServicos.setBounds(10, 216, 319, 141);
		
		scrollPane.setViewportView(areaServicos);
		JLabel lblPagamentos = new JLabel("Pagamentos");
		lblPagamentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblPagamentos.setBounds(341, 177, 109, 23);
		getContentPane().add(lblPagamentos);
		
		JButton btnAdicionarPagamento = new JButton(new ImageIcon("Res/adicionar32.png"));
		btnAdicionarPagamento.setBackground(Color.white);
		btnAdicionarPagamento.setBounds(632, 177, 32, 32);
		getContentPane().add(btnAdicionarPagamento);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCaixa.setBounds(10, 383, 46, 14);
		getContentPane().add(lblCaixa);
		
		JComboBox boxCaixa = new JComboBox();
		boxCaixa.setBounds(10, 408, 115, 32);
		getContentPane().add(boxCaixa);
		
		JLabel lblNnotaFiscal = new JLabel("N\u00B0Nota Fiscal");
		lblNnotaFiscal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblNnotaFiscal.setBounds(143, 383, 96, 14);
		getContentPane().add(lblNnotaFiscal);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 408, 115, 32);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblData.setBounds(268, 384, 46, 14);
		getContentPane().add(lblData);
		
		textField_5 = new JTextField();
		textField_5.setBounds(268, 408, 86, 32);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblStatus.setBounds(364, 383, 46, 14);
		getContentPane().add(lblStatus);
		
		textField_6 = new JTextField();
		textField_6.setBounds(364, 408, 86, 32);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblDesconto.setBounds(459, 383, 68, 14);
		getContentPane().add(lblDesconto);
		
		textField_7 = new JTextField();
		textField_7.setBounds(459, 408, 86, 32);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblTotal.setBounds(555, 383, 46, 14);
		getContentPane().add(lblTotal);
		
		JLabel lblRecebido = new JLabel("Recebido");
		lblRecebido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRecebido.setBounds(638, 383, 79, 14);
		getContentPane().add(lblRecebido);
		
		textField_8 = new JTextField();
		textField_8.setBounds(555, 408, 68, 32);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(638, 408, 86, 32);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnFinalizarVenda.setBackground(Color.WHITE);
		btnFinalizarVenda.setBounds(10, 451, 115, 32);
		getContentPane().add(btnFinalizarVenda);
		
		JButton btnRecibo = new JButton("Recibo");
		btnRecibo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnRecibo.setBackground(Color.WHITE);
		btnRecibo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRecibo.setBounds(143, 451, 89, 32);
		getContentPane().add(btnRecibo);
		
		JButton btnNotaFiscal = new JButton("Nota Fiscal");
		btnNotaFiscal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnNotaFiscal.setBackground(Color.WHITE);
		btnNotaFiscal.setBounds(240, 451, 114, 32);
		getContentPane().add(btnNotaFiscal);
		
		JButton btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnCancelarVenda.setBackground(Color.WHITE);
		btnCancelarVenda.setBounds(364, 451, 120, 32);
		getContentPane().add(btnCancelarVenda);
		
		JButton btnNova = new JButton("Nova");
		btnNova.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnNova.setBackground(Color.WHITE);

		btnNova.setBounds(494, 451, 89, 32);
		getContentPane().add(btnNova);
		getContentPane().setBackground(Color.WHITE);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBounds(0, 0, 734, 91);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setBounds(10, 11, 446, 70);
		lblVenda.setForeground(Color.WHITE);
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(339, 210, 325, 147);
		getContentPane().add(scrollPane_2);
		
		JTextArea areaPagamento = new JTextArea();
		scrollPane_2.setViewportView(areaPagamento);
		//setVisible(true);

	}
	public JTextField getTextField() {
		return codField;
	}
	public void setTextField(JTextField textField) {
		this.codField = textField;
	}
	public JTextField getTextField_1() {
		return pacienteField;
	}
	public void setTextField_1(JTextField textField_1) {
		this.pacienteField = textField_1;
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
