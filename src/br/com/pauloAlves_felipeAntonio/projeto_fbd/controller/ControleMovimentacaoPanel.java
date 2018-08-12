package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoComum;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroAdcionarNoEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.MovimentacaoPanel;

public class ControleMovimentacaoPanel {
	ItemProduto itemProduto;
	IFachada fachada;
	int condicao = 0;
	
	public ControleMovimentacaoPanel(MovimentacaoPanel movimentacaoPanel,CadastroAdcionarNoEstoque cadastroAdcionarNoEstoque) {
		fachada = Fachada.getInstance();
		movimentacaoPanel.getAdcionarButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					ArrayList<Produto> produtos = new ArrayList<Produto>();
					produtos= (ArrayList<Produto>)fachada.buscarPorBuscaProduto("%%");
					cadastroAdcionarNoEstoque.getProdutoBox().removeAllItems();
					for(Produto p : produtos) {
						cadastroAdcionarNoEstoque.getProdutoBox().addItem(p.getNome());
					}
					cadastroAdcionarNoEstoque.setVisible(true);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		cadastroAdcionarNoEstoque. addWindowListener(new WindowAdapter()  
	       {  
	           public void windowClosing(WindowEvent evt)  
	           { 	 condicao =0;
	           		limparCampos(cadastroAdcionarNoEstoque);
	           }  
	       });  
		
		cadastroAdcionarNoEstoque.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(condicao == 0) {
						itemProduto = new ItemProduto();
						ArrayList<Produto> produtos =  new ArrayList<Produto>(); 
					
						produtos = (ArrayList<Produto>) fachada.buscarPorBuscaProduto("%"+cadastroAdcionarNoEstoque.getProdutoBox().getItemAt(cadastroAdcionarNoEstoque.getProdutoBox().getSelectedIndex())+"%");
						itemProduto.setId_produto(produtos.get(0).getId());
						itemProduto.setDataCompra(TratadorDeMascara.coletorDeData(cadastroAdcionarNoEstoque.getDataCompraField().getText()));
						itemProduto.setPrecoCompra(Float.parseFloat(cadastroAdcionarNoEstoque.getPrecoCompraField().getText()));
						itemProduto.setQuantidade(Integer.parseInt(cadastroAdcionarNoEstoque.getQuantidadeField().getText()));
						itemProduto.setVencimento(TratadorDeMascara.coletorDeData(cadastroAdcionarNoEstoque.getVencimentoField().getText()));
						fachada.salvarItemProduto(itemProduto);
						if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
							limparCampos(cadastroAdcionarNoEstoque);
						}else {
							DaoComum  daoComum = new DaoComum();
							int x = daoComum.getCurrentValorTabela("item_produto");
							int y = daoComum.getCurrentValorTabela("caixa");
							Contas_pagar contasApagar = new Contas_pagar();
							contasApagar.setId_caixas(y);
							contasApagar.setValor(itemProduto.getPrecoCompra()*itemProduto.getQuantidade());
							contasApagar.setId_item_produto(x);
							contasApagar.setParcela(0);
							fachada.salvarContas_pagar(contasApagar);
							cadastroAdcionarNoEstoque.setVisible(false);
							limparCampos(cadastroAdcionarNoEstoque);
						}
					}else {
						itemProduto = new ItemProduto();
						ArrayList<Produto> produtos =  new ArrayList<Produto>(); 
						produtos = (ArrayList<Produto>) fachada.buscarPorBuscaProduto("%"+cadastroAdcionarNoEstoque.getProdutoBox().getItemAt(cadastroAdcionarNoEstoque.getProdutoBox().getSelectedIndex())+"%");
						itemProduto.setId_produto(produtos.get(0).getId());
						itemProduto.setDataCompra(TratadorDeMascara.coletorDeData(cadastroAdcionarNoEstoque.getDataCompraField().getText()));
						itemProduto.setPrecoCompra(Float.parseFloat(cadastroAdcionarNoEstoque.getPrecoCompraField().getText()));
						itemProduto.setQuantidade(Integer.parseInt(cadastroAdcionarNoEstoque.getQuantidadeField().getText()));
						itemProduto.setVencimento(TratadorDeMascara.coletorDeData(cadastroAdcionarNoEstoque.getVencimentoField().getText()));
						itemProduto.setId(condicao);
						fachada.editarItemProduto(itemProduto);
						JOptionPane.showMessageDialog(null, "Modificado com Sucesso!!");
						limparCampos(cadastroAdcionarNoEstoque);
						cadastroAdcionarNoEstoque.setVisible(false);
					}
				} catch (BusinessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				} catch (ValidacaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		movimentacaoPanel.getTable().getTable().addMouseListener(new JTableButtonMouseListener(movimentacaoPanel.getTable().getTable(), cadastroAdcionarNoEstoque));
	
		movimentacaoPanel.getBuscaButton().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if(movimentacaoPanel.getFiltroField().getText().equals("")) {
						ArrayList<ItemProduto> itemProdutos = new ArrayList<ItemProduto>();
						itemProdutos = (ArrayList<ItemProduto>) fachada.buscarPorBuscaItemProduto();
					

						int j = 0,tamanho = itemProdutos.size();
						
						for(int i =0;i<itemProdutos.size();i++) {
							if(itemProdutos.get(i).getQuantidade() == 0) {
								tamanho--;
							}
						}
						
						Object [][] linha = new Object[tamanho][6];
						for(ItemProduto i:itemProdutos) {
							if(i.getQuantidade() > 0) {
								linha[j][0] = i.getId();
								String s = ""+fachada.buscarPorIdProduto(i.getId_produto()).getNome();
								linha[j][1] = s;
								
								Calendar c = Calendar.getInstance();
								c.setTime(i.getVencimento());
								String dia = formatandoData(c.get(c.DAY_OF_MONTH)+"");
								String mes = formatandoData((c.get(c.MONTH)+1)+"");
								linha[j][2] =""+dia+"/"+mes+"/"+c.get(c.YEAR);
								
								linha[j][3] = i.getPrecoCompra();
								
								linha[j][4] = i.getQuantidade();
								
								JButton b = new JButton("Abrir");
								b.setForeground(Color.BLACK);
								b.setBackground(Color.white);
								b.setFont(Propiedade.FONT2);
								linha[j][5] = b;
								j++;
							}
						}
						JTableButtonModel jtableButtonModel = new JTableButtonModel();
						jtableButtonModel.adcionar(linha,new String[] {
								"Codigo","Produto","Vencimento","Preco da Compra","Quantidade","Cadastro"
						});



						movimentacaoPanel.getTable().getTable().setModel(jtableButtonModel);
						movimentacaoPanel.getTable().getTable().setRowHeight(40);

						movimentacaoPanel.getTable().getTable().setShowHorizontalLines(true);
						movimentacaoPanel.getTable().getTable().setShowVerticalLines(true);
						movimentacaoPanel.getTable().getTable().setBackground(Color.white);
						movimentacaoPanel.getTable().getTable().setFont(Propiedade.FONT2);
					}else {
						ArrayList<Produto> produtos = new ArrayList<Produto>();
						produtos =(ArrayList<Produto>) fachada.buscarPorBuscaProduto("%"+movimentacaoPanel.getFiltroField().getText()+"%");
						ArrayList<ItemProduto> itemProdutos = new ArrayList<ItemProduto>();
						System.out.print(produtos.size());
						for(Produto p: produtos) {
							itemProdutos = (ArrayList<ItemProduto>) fachada.buscarPorId_produto(p.getId());
							if(itemProduto != null) {
								break;
							}
						}
						
						int j = 0,tamanho = itemProdutos.size();
						
						for(int i =0;i<itemProdutos.size();i++) {
							if(itemProdutos.get(i).getQuantidade() == 0) {
								tamanho--;
							}
						}
						
						Object [][] linha = new Object[tamanho][6];
						for(ItemProduto i:itemProdutos) {
							if(i.getQuantidade() > 0) {
								linha[j][0] = i.getId();
								linha[j][1] = ""+fachada.buscarPorIdProduto(i.getId_produto()).getNome();
								
								Calendar c = Calendar.getInstance();
								c.setTime(i.getVencimento());
								String dia = formatandoData(c.get(c.DAY_OF_MONTH)+"");
								String mes = formatandoData((c.get(c.MONTH)+1)+"");
								linha[j][2] =""+dia+"/"+mes+"/"+c.get(c.YEAR);
								
								linha[j][3] = i.getPrecoCompra();
								
								linha[j][4] = i.getQuantidade();
								
								JButton b = new JButton("Abrir");
								b.setForeground(Color.BLACK);
								b.setBackground(Color.white);
								b.setFont(Propiedade.FONT2);
								linha[j][5] = b;
								j++;
							}
						
						}
						JTableButtonModel jtableButtonModel = new JTableButtonModel();
						jtableButtonModel.adcionar(linha,new String[] {
								"Codigo","Produto","Vencimento","Preco da Compra","Quantidade","Cadastro"
						});



						movimentacaoPanel.getTable().getTable().setModel(jtableButtonModel);
						movimentacaoPanel.getTable().getTable().setRowHeight(40);

						movimentacaoPanel.getTable().getTable().setShowHorizontalLines(true);
						movimentacaoPanel.getTable().getTable().setShowVerticalLines(true);
						movimentacaoPanel.getTable().getTable().setBackground(Color.white);
						movimentacaoPanel.getTable().getTable().setFont(Propiedade.FONT2);
					}
					
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	private String formatandoData(String antigo) {
		if(antigo.length()<2)
			antigo = 0+antigo;
		return antigo;
	}
	 private class JTableButtonMouseListener implements MouseListener {
		  private JTable table;
		  private CadastroAdcionarNoEstoque adcionarEstoque;

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
		    		adcionarEstoque.getProdutoBox().removeAllItems();
		    		ArrayList<Produto> produtos = new ArrayList<Produto>();
					produtos =(ArrayList<Produto>) fachada.buscarPorBuscaProduto(""+table.getValueAt(table.getSelectedRow(), 1));
					for(Produto p : produtos) {
						adcionarEstoque.getProdutoBox().addItem(p.getNome());
					}
					
					
					ItemProduto itemProduto = new ItemProduto();
					itemProduto = (ItemProduto) fachada.buscarPorIdItemProduto(Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0)));
					condicao = itemProduto.getId();
					Calendar c = Calendar.getInstance();
					c.setTime(itemProduto.getDataCompra());
					String dia = formatandoData(c.get(c.DAY_OF_MONTH)+"");
					String mes = formatandoData((c.get(c.MONTH)+1)+"");
					adcionarEstoque.getDataCompraField().setText(dia+""+mes+""+c.get(c.YEAR));
					c.setTime(itemProduto.getVencimento());
					dia = formatandoData(c.get(c.DAY_OF_MONTH)+"");
					mes = formatandoData((c.get(c.MONTH)+1)+"");
					adcionarEstoque.getVencimentoField().setText(dia+""+mes+""+c.get(c.YEAR));
					adcionarEstoque.getProdutoBox().addItem(itemProduto.getProduto().getNome());
					adcionarEstoque.getPrecoCompraField().setText(""+itemProduto.getPrecoCompra());
					adcionarEstoque.getQuantidadeField().setText(""+itemProduto.getQuantidade());
					
					adcionarEstoque.setVisible(true);
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

		  public JTableButtonMouseListener(JTable table,CadastroAdcionarNoEstoque adcionarNoEstoque) {
		    this.table = table;
		    this.adcionarEstoque =adcionarNoEstoque;
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
	 private void limparCampos(CadastroAdcionarNoEstoque adcionarEstoque) {
			adcionarEstoque.getProdutoBox().setSelectedIndex(0);
			adcionarEstoque.getPrecoCompraField().setText("");
			adcionarEstoque.getDataCompraField().setText("");
			adcionarEstoque.getVencimentoField().setText("");
			adcionarEstoque.getQuantidadeField().setText("");
	 }
	 
		
}
