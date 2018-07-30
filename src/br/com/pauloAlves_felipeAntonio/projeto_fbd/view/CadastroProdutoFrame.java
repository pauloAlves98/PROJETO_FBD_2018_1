package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
//import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFornecedoresFrame.Panell;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProdutoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField codigoField;
	private JTextField descricaoField;
	private JComboBox tipoBox, fornecedorBox;
	private JButton btnSalvar;
	private JTextField varejoField;
	private JTextField atacadoField;
	
	public CadastroProdutoFrame() {
		getContentPane().setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 318);
		
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		panel.setBackground(Propiedade.cor1);
		panel.setBackground(Propiedade.cor1);
		panel.setBounds(0, 0, 644, 81);
		getContentPane().add(panel);
			panel.setLayout(null);
			JLabel lblProduto = new JLabel("Cadastro de Produtos");
			lblProduto.setFont(new Font("Franklin Gothic Book", Font.BOLD, 28));
			lblProduto.setBounds(10, 11, 446, 70);
			lblProduto.setForeground(Color.WHITE);
			lblProduto.setBackground(Color.WHITE);
			panel.add(lblProduto);
				
		
		
		getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblCdigo.setBounds(10, 92, 86, 20);
		
		getContentPane().add(lblCdigo);
		
		codigoField = new JTextField();
		codigoField.setBounds(10, 113, 86, 32);
		getContentPane().add(codigoField);
		codigoField.setColumns(10);
		
		descricaoField = new JTextField();
		descricaoField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		descricaoField.setBounds(106, 113, 316, 32);
		getContentPane().add(descricaoField);
			descricaoField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblTipo.setBounds(472, 95, 46, 14);
		getContentPane().add(lblTipo);
		
		tipoBox = new JComboBox(new String[] {
		"alimenticio"
		});
		tipoBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		tipoBox.setBounds(472, 111, 106, 32);
		getContentPane().add(tipoBox);
			
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		btnSalvar.setBounds(7, 238, 89, 31);
		getContentPane().add(btnSalvar);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblFornecedor.setBounds(10, 174, 129, 14);
		getContentPane().add(lblFornecedor);
		
		fornecedorBox = new JComboBox();
		fornecedorBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		fornecedorBox.setBounds(9, 192, 316, 32);
		getContentPane().add(fornecedorBox);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblNome.setBounds(106, 97, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblVendaVarejo = new JLabel("Venda Varejo");
		lblVendaVarejo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblVendaVarejo.setBounds(466, 174, 106, 14);
		getContentPane().add(lblVendaVarejo);
		
		JLabel lblVendaAtacado = new JLabel("Venda Atacado");
		lblVendaAtacado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		lblVendaAtacado.setBounds(335, 174, 111, 14);
		getContentPane().add(lblVendaAtacado);
		
		varejoField = new JTextField();
		varejoField.setBounds(466, 194, 112, 32);
		getContentPane().add(varejoField);
		varejoField.setColumns(10);
		
		atacadoField = new JTextField();
		atacadoField.setBounds(335, 194, 112, 32);
		getContentPane().add(atacadoField);
		atacadoField.setColumns(10);
		setBackground(Color.WHITE);
		//setVisible(true);
		
	}

	
	
	public JTextField getVarejoField() {
		return varejoField;
	}



	public JTextField getAtacadoField() {
		return atacadoField;
	}



	public JTextField getCodigoField() {
		return codigoField;
	}

	public JTextField getDescricaoField() {
		return descricaoField;
	}

	public JComboBox getTipoBox() {
		return tipoBox;
	}

	public JComboBox getFornecedorBox() {
		return fornecedorBox;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}
}
