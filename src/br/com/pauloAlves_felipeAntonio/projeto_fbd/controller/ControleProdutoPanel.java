package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroProdutoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ProdutoPanel;

public class ControleProdutoPanel {
	IFachada fachada;
	Produto produto;
	int condicao = 0;
	
	public ControleProdutoPanel(ProdutoPanel produtoPanel,CadastroProdutoFrame cadastroProdutoFrame) {
		fachada = Fachada.getInstance();
		
		produtoPanel.getBtnNovoProduto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
					fornecedores= (ArrayList<Fornecedor>)fachada.buscarPorBuscaFornecedor("%%");
					for(Fornecedor f : fornecedores) {
						cadastroProdutoFrame.getFornecedorBox().addItem(f.getNome());
					}
					cadastroProdutoFrame.setVisible(true);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		cadastroProdutoFrame.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if(condicao == 0) {
						produto = new Produto();
						
						produto.setNome(cadastroProdutoFrame.getDescricaoField().getText());
						produto.setTipo(""+cadastroProdutoFrame.getTipoBox().getItemAt(cadastroProdutoFrame.getTipoBox().getSelectedIndex()));
						ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
						//Fornecedor f = new Fornecedor();
						fornecedores =(ArrayList<Fornecedor>)fachada.buscarPorBuscaFornecedor("%"+cadastroProdutoFrame.getFornecedorBox().getItemAt(cadastroProdutoFrame.getFornecedorBox().getSelectedIndex())+"%");
						produto.setIdFornecedor(fornecedores.get(0).getId());
						produto.setVendaAtacado(Integer.parseInt(cadastroProdutoFrame.getAtacadoField().getText()));
						produto.setVendaVarejo(Integer.parseInt(cadastroProdutoFrame.getVarejoField().getText()));
						fachada.salvarProduto(produto);
						if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
							limparCampos(cadastroProdutoFrame);
						}else {
							cadastroProdutoFrame.setVisible(false);
							limparCampos(cadastroProdutoFrame);
						}
					}else {
						produto = new Produto();
						
						produto.setNome(cadastroProdutoFrame.getDescricaoField().getText());
						produto.setTipo(""+cadastroProdutoFrame.getTipoBox().getItemAt(cadastroProdutoFrame.getTipoBox().getSelectedIndex()));
						ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
						//Fornecedor f = new Fornecedor();
						fornecedores =(ArrayList<Fornecedor>)fachada.buscarPorBuscaFornecedor("%"+cadastroProdutoFrame.getFornecedorBox().getItemAt(cadastroProdutoFrame.getFornecedorBox().getSelectedIndex())+"%");
						produto.setIdFornecedor(fornecedores.get(0).getId());
						produto.setVendaAtacado(Integer.parseInt(cadastroProdutoFrame.getAtacadoField().getText()));
						produto.setVendaVarejo(Integer.parseInt(cadastroProdutoFrame.getVarejoField().getText()));
						produto.setId(condicao);
						fachada.editarProduto(produto);
					}
					
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		produtoPanel.getBuscaButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//nome,cnpj,incs_municipal,telefone
					ArrayList<Produto> produtos = new ArrayList<Produto>();
					produtos = (ArrayList<Produto>) fachada.buscarPorBuscaProduto("%"+cadastroProdutoFrame.getDescricaoField().getText()+"%");
					
					Object linha[][] = new Object[produtos.size()][4];
					int i=0;
					for(Produto p: produtos){
						String s = fachada.buscarPorIdFornecedor(produtos.get(i).getIdFornecedor());
						linha[i][0] = p.getNome();
						linha[i][1] = p.getTipo();
						linha[i][2] = ""+s;
						JButton b = new JButton("Abrir");
						b.setForeground(Color.BLACK);
						b.setBackground(Color.white);
						b.setFont(Propiedade.FONT2);
						linha[i][3] = b;
						i ++;
					}
					JTableButtonModel jtableButtonModel= new JTableButtonModel();
			 		jtableButtonModel.adcionar(linha,new String[] {
			 				"Nome","Tipo","Fornecedor","Cadastro"
					});
			 		
				 			
					produtoPanel.getTable().getTable().setModel(jtableButtonModel);
					produtoPanel.getTable().getTable().setRowHeight(40);
					produtoPanel.getTable().getTable().setShowGrid(true);
					produtoPanel.getTable().getTable().setShowHorizontalLines(true);
					produtoPanel.getTable().getTable().setShowVerticalLines(true);
					produtoPanel.getTable().getTable().setBackground(Color.white);
					produtoPanel.getTable().getTable().setFont(Propiedade.FONT2);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});		
		produtoPanel.getTable().getTable().addMouseListener(new JTableButtonMouseListener(produtoPanel.getTable().getTable(), cadastroProdutoFrame));
		
	}
	private void limparCampos(CadastroProdutoFrame cadastroProdutoFrame) {
		cadastroProdutoFrame.getDescricaoField().setText("");
		cadastroProdutoFrame.getVarejoField().setText("");
		cadastroProdutoFrame.getAtacadoField().setText("");
	}
	 private class JTableButtonMouseListener implements MouseListener {
		  private JTable table;
		  private CadastroProdutoFrame produtoTela;

		  private void __forwardEventToButton(MouseEvent e) {
		    TableColumnModel columnModel = this.table.getColumnModel();
		    int column = columnModel.getColumnIndexAtX(e.getX());
		    int row    = e.getY() / this.table.getRowHeight();
		    Object value;
		    JButton button;
		    MouseEvent buttonEvent;

		    if(row >= this.table.getRowCount() || row < 0 ||
		       column >= this.table.getColumnCount() || column < 0)
		      return;

		    value = this.table.getValueAt(row, column);

		    if(!(value instanceof JButton))
		      return;

		    button = (JButton)value;

		    buttonEvent =
		      (MouseEvent)SwingUtilities.convertMouseEvent(this.table, e, button);
		  
		    
		    button.dispatchEvent(buttonEvent);
		    if(button ==buttonEvent.getSource()) { 
		    	try {
	
		    		ArrayList<Produto> produtos = new ArrayList<Produto>();
					produtos =(ArrayList<Produto>) fachada.buscarPorBuscaProduto(""+table.getValueAt(table.getSelectedRow(), 0));
					produto = new Produto();
					produto = produtos.get(0);
					condicao = produto.getId();
					
					produtoTela.getDescricaoField().setText(produto.getNome());
					produtoTela.getVarejoField().setText(""+produto.getVendaVarejo());
					produtoTela.getAtacadoField().setText(""+produto.getVendaAtacado());
					ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
					fornecedores= (ArrayList<Fornecedor>)fachada.buscarPorBuscaFornecedor("%%");
					for(Fornecedor f : fornecedores) {
						produtoTela.getFornecedorBox().addItem(f.getNome());
					}
					produtoTela.setVisible(true);
		    	} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	 
			 }
		    // This is necessary so that when a button is pressed and released
		    // it gets rendered properly.  Otherwise, the button may still appear
		    // pressed down when it has been released.
		    this.table.repaint();
		  }

		  public JTableButtonMouseListener(JTable table,CadastroProdutoFrame produto) {
		    this.table = table;
		    this.produtoTela =produto;
		  }

		  public void mouseClicked(MouseEvent e) {
		    __forwardEventToButton(e);
		    
		    
		  }

		  public void mouseEntered(MouseEvent e) {
		   // __forwardEventToButton(e);
		  }

		  public void mouseExited(MouseEvent e) {
		  //  __forwardEventToButton(e);
		  }

		  public void mousePressed(MouseEvent e) {
		 //   __forwardEventToButton(e);
		  }

		  public void mouseReleased(MouseEvent e) {
		   // __forwardEventToButton(e);
		  }
		}

}
