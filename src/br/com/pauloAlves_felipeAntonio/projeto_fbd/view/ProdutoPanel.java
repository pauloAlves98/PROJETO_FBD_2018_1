package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoPanel extends JPanel {
	private JTextField DescricaoField,tipoField;
	private JButton btnNovoProduto;
	//private JTable
	
	public ProdutoPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setBackground(Color.WHITE);
		lblCadastroDeProdutos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lblCadastroDeProdutos.setBounds(10, 28, 209, 34);
		add(lblCadastroDeProdutos);
		
		btnNovoProduto = new JButton("Novo Produto");
	
		btnNovoProduto.setBackground(Color.WHITE);
		btnNovoProduto.setFont(Propiedade.FONT2);
		btnNovoProduto.setBounds(257, 29, 181, 39);
		add(btnNovoProduto);
		
		JLabel lblFiltro_1 = new JLabel("Filtro");
		lblFiltro_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblFiltro_1.setBounds(10, 133, 64, 39);
		add(lblFiltro_1);
		
		DescricaoField = new JTextField();
		DescricaoField.setForeground(Color.YELLOW);
		DescricaoField.setFont(new Font("tahoma",Font.ITALIC,12));
		DescricaoField.setBounds(94, 139, 106, 32);
		add(DescricaoField);
		DescricaoField.setColumns(10);
		
		tipoField = new JTextField("tipo");
		tipoField.setForeground(Color.YELLOW);
		tipoField.setFont(new Font("tahoma",Font.ITALIC,12));
		tipoField.setBounds(225, 139, 171, 32);
		add(tipoField);
		tipoField.setColumns(10);
	}

	public JTextField getDescricaoField() {
		return DescricaoField;
	}

	public void setDescricaoField(JTextField descricaoField) {
		DescricaoField = descricaoField;
	}

	public JTextField getTipoField() {
		return tipoField;
	}

	public void setTipoField(JTextField tipoField) {
		this.tipoField = tipoField;
	}

	public JButton getBtnNovoProduto() {
		return btnNovoProduto;
	}
	
	

}
