package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProdutoPanel extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public ProdutoPanel() {
		getContentPane().setLayout(null);
		setSize(444, 306);
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProduto.setBounds(10, 11, 100, 14);
		getContentPane().add(lblProduto);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 36, 46, 14);
		getContentPane().add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(106, 36, 62, 14);
		getContentPane().add(lblDescrio);
		
		textField = new JTextField();
		textField.setBounds(10, 49, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 49, 316, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 80, 46, 14);
		getContentPane().add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 93, 86, 20);
		getContentPane().add(comboBox);
		
		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo");
		lblEstoqueMinimo.setBounds(106, 80, 106, 14);
		getContentPane().add(lblEstoqueMinimo);
		
		JLabel lblEstoqueMaximo = new JLabel("Estoque Maximo");
		lblEstoqueMaximo.setBounds(241, 80, 100, 14);
		getContentPane().add(lblEstoqueMaximo);
		
		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(394, 80, 46, 14);
		getContentPane().add(lblAtivo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 93, 125, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(241, 93, 125, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFatorDeConverso = new JLabel("Fator de Convers\u00E3o");
		lblFatorDeConverso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFatorDeConverso.setBounds(10, 131, 158, 14);
		getContentPane().add(lblFatorDeConverso);
		
		JLabel lblUnidadeDeEntrada = new JLabel("Unidade de Entrada");
		lblUnidadeDeEntrada.setBounds(10, 156, 125, 14);
		getContentPane().add(lblUnidadeDeEntrada);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 174, 125, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(145, 156, 67, 14);
		getContentPane().add(lblQuantidade);
		
		JLabel lblUnidadeDeSaida = new JLabel("Unidade de Saida");
		lblUnidadeDeSaida.setBounds(280, 156, 125, 14);
		getContentPane().add(lblUnidadeDeSaida);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 174, 125, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(280, 174, 125, 20);
		getContentPane().add(comboBox_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 217, 89, 31);
		getContentPane().add(btnSalvar);
		
		setVisible(true);

	}

}
