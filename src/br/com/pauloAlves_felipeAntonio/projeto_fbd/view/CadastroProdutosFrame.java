package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroProdutosFrame extends JFrame {
	private JTextField codigoField;
	private JTextField descricaoField;
	private JTextField estoqueMinField;
	private JTextField estoqueMaxField;
	private JTextField quantidadeField;
	
	public CadastroProdutosFrame() {
		setLayout(null);
		setSize(444, 306);
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProduto.setBounds(10, 11, 100, 14);
		add(lblProduto);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 36, 46, 14);
		add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(106, 36, 62, 14);
		add(lblDescrio);
		
		codigoField = new JTextField();
		codigoField.setBounds(10, 49, 86, 20);
		add(codigoField);
		codigoField.setColumns(10);
		
		descricaoField = new JTextField();
		descricaoField.setBounds(106, 49, 316, 20);
		add(descricaoField);
		descricaoField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 80, 46, 14);
		add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 93, 86, 20);
		add(comboBox);
		
		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo");
		lblEstoqueMinimo.setBounds(106, 80, 106, 14);
		add(lblEstoqueMinimo);
		
		JLabel lblEstoqueMaximo = new JLabel("Estoque Maximo");
		lblEstoqueMaximo.setBounds(241, 80, 100, 14);
		add(lblEstoqueMaximo);
		
		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(394, 80, 46, 14);
		add(lblAtivo);
		
		estoqueMinField = new JTextField();
		estoqueMinField.setBounds(106, 93, 125, 20);
		add(estoqueMinField);
		estoqueMinField.setColumns(10);
		
		estoqueMaxField = new JTextField();
		estoqueMaxField.setBounds(241, 93, 125, 20);
		add(estoqueMaxField);
		estoqueMaxField.setColumns(10);
		
		JLabel lblFatorDeConverso = new JLabel("Fator de Convers\u00E3o");
		lblFatorDeConverso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFatorDeConverso.setBounds(10, 131, 158, 14);
		add(lblFatorDeConverso);
		
		JLabel lblUnidadeDeEntrada = new JLabel("Unidade de Entrada");
		lblUnidadeDeEntrada.setBounds(10, 156, 125, 14);
		add(lblUnidadeDeEntrada);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 174, 125, 20);
		add(comboBox_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(145, 156, 67, 14);
		add(lblQuantidade);
		
		JLabel lblUnidadeDeSaida = new JLabel("Unidade de Saida");
		lblUnidadeDeSaida.setBounds(280, 156, 125, 14);
		add(lblUnidadeDeSaida);
		
		quantidadeField = new JTextField();
		quantidadeField.setBounds(145, 174, 125, 20);
		add(quantidadeField);
		quantidadeField.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(280, 174, 125, 20);
		add(comboBox_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 217, 89, 31);
		add(btnSalvar);
		
		setVisible(true);
	}
}
