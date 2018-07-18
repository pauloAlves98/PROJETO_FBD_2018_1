package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProdutoPanel extends JPanel {
	private JTextField DescricaoField,tipoField;
	private JButton btnNovoProduto;
	//private JTable
	
	public ProdutoPanel() {
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCadastroDeProdutos.setBounds(25, 27, 241, 27);
		add(lblCadastroDeProdutos);
		
		btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.setBounds(447, 21, 156, 49);
		add(btnNovoProduto);
		
		JLabel lblFiltro_1 = new JLabel("Filtro");
		lblFiltro_1.setBounds(214, 94, 46, 14);
		add(lblFiltro_1);
		
		DescricaoField = new JTextField();
		DescricaoField.setForeground(Color.YELLOW);
		DescricaoField.setFont(new Font("tahoma",Font.ITALIC,12));
		DescricaoField.setBounds(250, 91, 86, 20);
		add(DescricaoField);
		DescricaoField.setColumns(10);
		
		tipoField = new JTextField("tipo");
		tipoField.setForeground(Color.YELLOW);
		tipoField.setFont(new Font("tahoma",Font.ITALIC,12));
		tipoField.setBounds(346, 91, 146, 20);
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
