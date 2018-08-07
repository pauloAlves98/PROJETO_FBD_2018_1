package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
//import exemplo.PaneGradiente;


public class VendaFrame extends JFrame {
	private JComboBox pacienteBox;
	private JTextField textField_3,restanteField;
	private JTextField DescontoField;
	private JTextField totalField;
	private JTextField recebidoField;
	private JButton btnFinalizarVenda, btnAdcionar,btnAdicionarProduto,btnNotaFiscal,btnCancelarVenda,btnNova;
	private JTextField entradaField;
	private JTextField parcelasField;
	private JTextArea areaServicos,areaProduto;
	private JComboBox boxCaixa,servicoBox,mercadoBox,produtoBox;
	private JSpinner spinner;
	/**
	 * Create the panel.
	 */
	public VendaFrame() {
		getContentPane().setLayout(null);
		setSize(884,602);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblPaciente.setBounds(10, 102, 65, 14);
		getContentPane().add(lblPaciente);
		
		pacienteBox = new JComboBox<>();
		pacienteBox.setBounds(10, 120, 188, 32);
		getContentPane().add(pacienteBox);
		
//		produtoBox = new JComboBox<>();
//		produtoBox.setBounds(58, 134, 188, 32);
//		getContentPane().add(produtoBox);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblCaixa.setBounds(208, 102, 65, 14);
		getContentPane().add(lblCaixa);
		
		boxCaixa = new JComboBox();
		boxCaixa.setBounds(208, 120, 115, 32);
		getContentPane().add(boxCaixa);
//		
//		JButton btnNewButton = new JButton(new ImageIcon("Res/pesquisa.png"));
//		btnNewButton .setBackground(Color.white);
//		btnNewButton.setBounds(251, 133, 32, 32);
//		getContentPane().add(btnNewButton);
		
//		textField_3 = new JTextField("aaaa");
//		textField_3.setBounds(310, 134, 97, 32);
//		getContentPane().add(textField_3);
//		textField_3.setColumns(10);
		
	//	JLabel restanteLabel =new JLabel("restante");
		
		btnAdcionar = new JButton(new ImageIcon("Res/adicionar32.png"));
		
		btnAdcionar.setBackground(Color.white);
		btnAdcionar.setBounds(299, 184, 32, 32);
		getContentPane().add(btnAdcionar);
		setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 393, 190);
		getContentPane().add(scrollPane);
		
		
		areaServicos = new JTextArea();
		areaServicos.setBounds(10, 216, 319, 141);
		areaServicos.setEditable(false);
		scrollPane.setViewportView(areaServicos);
		
		btnAdicionarProduto = new JButton(new ImageIcon("Res/adicionar32.png"));			
		btnAdicionarProduto.setBackground(Color.white);
		btnAdicionarProduto.setBounds(826, 184, 32, 32);
		getContentPane().add(btnAdicionarProduto);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblDesconto.setBounds(462, 421, 68, 14);
		getContentPane().add(lblDesconto);
		
		DescontoField = new JTextField();
		DescontoField.setBounds(462, 446, 86, 32);
		getContentPane().add(DescontoField);
		DescontoField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblTotal.setBounds(573, 421, 46, 14);
		getContentPane().add(lblTotal);
		
		JLabel lblRecebido = new JLabel("Recebido");
		lblRecebido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRecebido.setBounds(237, 421, 79, 14);
		getContentPane().add(lblRecebido);
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(573, 446, 86, 32);
		getContentPane().add(totalField);
		totalField.setColumns(10);
		
		recebidoField = new JTextField();
		recebidoField.setEditable(false);
		recebidoField.setBounds(237, 446, 86, 32);
		getContentPane().add(recebidoField);
		recebidoField.setColumns(10);
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		btnFinalizarVenda.setBackground(Color.WHITE);
		btnFinalizarVenda.setBounds(10, 489, 154, 50);
		getContentPane().add(btnFinalizarVenda);
		getContentPane().setBackground(Color.WHITE);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBounds(0, 0, 868, 91);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setBounds(10, 11, 446, 70);
		lblVenda.setForeground(Color.WHITE);
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
		
		
		
		areaProduto = new JTextArea();
		areaProduto.setBounds(468, 221, 390, 188);
		areaProduto.setEditable(false);
		getContentPane().add(areaProduto);
		JScrollPane scrollPane_2 = new JScrollPane(areaProduto);
		scrollPane_2.setBounds(468, 220, 392, 190);
		getContentPane().add(scrollPane_2);
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblServio.setBounds(10, 160, 103, 24);
		getContentPane().add(lblServio);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblProduto.setBounds(468, 160, 80, 24);
		getContentPane().add(lblProduto);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setBounds(29, 421, 46, 14);
		getContentPane().add(lblEntrada);
		
		entradaField = new JTextField();
		entradaField.setBounds(27, 446, 86, 32);
		getContentPane().add(entradaField);
		entradaField.setColumns(10);
		
		JLabel lblParcelas = new JLabel("Parcelas");
		lblParcelas.setBounds(123, 421, 46, 14);
		getContentPane().add(lblParcelas);
		
		parcelasField = new JTextField();
		parcelasField.setBounds(123, 446, 86, 32);
		getContentPane().add(parcelasField);
		parcelasField.setColumns(10);
		
		mercadoBox = new JComboBox(new String[] {
				"Varejo","Atacado"
		});
		mercadoBox.setBounds(669, 185, 97, 32);
		getContentPane().add(mercadoBox);
		
		produtoBox = new JComboBox();
		produtoBox.setBounds(468, 185, 191, 32);
		getContentPane().add(produtoBox);
		
		servicoBox = new JComboBox();
		servicoBox.setBounds(10, 184, 279, 32);
		getContentPane().add(servicoBox);
		
		JLabel lblRestante = new JLabel("Restante");
		lblRestante.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		lblRestante.setBounds(333, 421, 46, 14);
		getContentPane().add(lblRestante);
		
		restanteField = new JTextField();
		restanteField.setBounds(350, 446, 86, 32);
		restanteField.setEditable(false);
		getContentPane().add(restanteField);
		restanteField.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(774, 184, 42, 32);
		
		getContentPane().add(spinner);
		
		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblR.setBounds(10, 455, 46, 14);
		getContentPane().add(lblR);
		
		JLabel lblR_1 = new JLabel("R$");
		lblR_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblR_1.setBounds(219, 455, 46, 14);
		getContentPane().add(lblR_1);
		
		JLabel lblR_2 = new JLabel("R$");
		lblR_2.setBounds(446, 455, 46, 14);
		getContentPane().add(lblR_2);
		
		JLabel lblR_3 = new JLabel("R$");
		lblR_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblR_3.setBounds(333, 455, 46, 14);
		getContentPane().add(lblR_3);
		
		JLabel lblR_4 = new JLabel("R$");
		lblR_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblR_4.setBounds(558, 455, 46, 14);
		getContentPane().add(lblR_4);

	}
	private void mascaraData(JFormattedTextField formato) {
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
		}catch (Exception e){}
	}

	
	
	public JTextField getTextField_3() {
		return textField_3;
	}
	
	public JTextField getDescontoField() {
		return DescontoField;
	}
	public JTextField getTotalField() {
		return totalField;
	}
	public JTextField getRecebidoField() {
		return recebidoField;
	}
	public JButton getBtnFinalizarVenda() {
		return btnFinalizarVenda;
	}
	public JButton getBtnAdcionar() {
		return btnAdcionar;
	}
	public JButton getBtnAdicionarProduto() {
		return btnAdicionarProduto;
	}
	public JButton getBtnNotaFiscal() {
		return btnNotaFiscal;
	}
	public JButton getBtnCancelarVenda() {
		return btnCancelarVenda;
	}
	public JButton getBtnNova() {
		return btnNova;
	}
	public JTextField getEntradaField() {
		return entradaField;
	}
	public JTextField getParcelasField() {
		return parcelasField;
	}
	public JTextArea getAreaServicos() {
		return areaServicos;
	}
	public JTextArea getAreaProduto() {
		return areaProduto;
	}
	public JComboBox getBoxCaixa() {
		return boxCaixa;
	}
	public JComboBox getServicoBox() {
		return servicoBox;
	}
	public JComboBox getMercadoBox() {
		return mercadoBox;
	}
	public JComboBox getProdutoBox() {
		return produtoBox;
	}
	public JComboBox getPacienteBox() {
		return pacienteBox;
	}
	public JTextField getRestanteField() {
		return restanteField;
	}
	public JSpinner getSpinner() {
		return spinner;
	}
	
	
}
