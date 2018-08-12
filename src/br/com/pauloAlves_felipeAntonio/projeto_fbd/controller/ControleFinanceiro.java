package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumnModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.FinanceiroPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PagamentoContReceberPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.VendaFrame;

public class ControleFinanceiro {
	IFachada fachada;
	ArrayList<ItemProduto> itemProdutosFiltrados = new ArrayList<ItemProduto>();
	ArrayList<ItemProduto> itemProdutos;
	ArrayList<Servico> servicos; 
	ArrayList<Paciente> pacientes;
	ArrayList<Contas_receber> contas_recebers;
	ArrayList<Contas_pagar> contas_pagars;
	ArrayList<Integer> numeros;
	ItemProduto itemProduto,itemProduto2;
	Caixa caixa;
	float valor;
	int index=0,i=-1,cont=1;
	boolean condicaoEditar = false,condicaoPegarProduto = false;
	public ControleFinanceiro(FinanceiroPanel financeiroPanel,VendaFrame vendaFrame,PagamentoContReceberPanel pagamentoContReceberPanel) {

		vendaFrame.getEntradaField().setToolTipText("Pressione enter para preencher os outros campos!");
		fachada = Fachada.getInstance();
		vendaFrame. addWindowListener(new WindowAdapter()  
		{  
			public void windowClosing(WindowEvent evt) { 
				limparCampos(vendaFrame);
			}  
		});


		financeiroPanel.getBtnNovaVenda().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {


					itemProdutos = new ArrayList<ItemProduto>();
					numeros = new ArrayList<Integer>();
					itemProdutos = (ArrayList<ItemProduto>)fachada.buscarPorBuscaItemProduto();
					int i = 0,cont = 1;
					boolean vdd = false;

					vendaFrame.getProdutoBox().removeAllItems();
					vendaFrame.getProdutoBox().addItem("");

					vendaFrame.getServicoBox().removeAllItems();
					vendaFrame.getServicoBox().addItem("");

					vendaFrame.getPacienteBox().removeAllItems();
					vendaFrame.getPacienteBox().addItem("");

					servicos= new ArrayList<Servico>();
					servicos = (ArrayList<Servico>) fachada.buscarPorBuscaServico("%%");

					caixa = new Caixa();
					caixa = (Caixa) fachada.buscarPorIdCaixa(1);

					vendaFrame.getBoxCaixa().addItem("");
					vendaFrame.getBoxCaixa().addItem(caixa.getNome());

					for(Servico s:servicos) {
						vendaFrame.getServicoBox().addItem(s.getDescricao());
					}

					AutoCompleteDecorator.decorate(vendaFrame.getServicoBox());

					pacientes = new ArrayList<Paciente>();
					pacientes = (ArrayList<Paciente>)fachada.buscarPorBuscaPaciente("%"+"%");
					//	System.out.print(pacientes.size());

					for(Paciente pa : pacientes){		
						vendaFrame.getPacienteBox().addItem(pa.getNome());
					}

					AutoCompleteDecorator.decorate(vendaFrame.getPacienteBox());

					for(ItemProduto item:itemProdutos){
						vdd = false;
						Produto p = new Produto();
						if(i>0){
							//System.out.print("Passei");
							for(Integer o:numeros) {
								if(item.getId_produto()==o) {
									vdd = true;
									break;
								}
							}

						}
						if(!vdd) {
							p = (Produto) fachada.buscarPorIdProduto(item.getId_produto());
							numeros.add(item.getId_produto());
							vendaFrame.getProdutoBox().addItem(p.getNome());
							ItemProduto it = new ItemProduto();
							it.setProduto(p);
							it.setId(cont);
							it.setPrecoCompra(item.getPrecoCompra());
							it.setQuantidade(item.getQuantidade());
							itemProdutosFiltrados.add(it);
							cont++;
						}



						i++;
					}
					AutoCompleteDecorator.decorate(vendaFrame.getProdutoBox());

					SpinnerNumberModel model = new SpinnerNumberModel(0, 0,fachada.somaQtd(),1);   
					vendaFrame.getSpinner().setModel(model);
					vendaFrame.setVisible(true);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		vendaFrame.getBtnAdcionar().addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				float valor = 0;
				//System.out.print("Passei");
				for(Servico s : servicos) {
					if(s.getId() == vendaFrame.getServicoBox().getSelectedIndex()) {
						valor=s.getValor();
						if(vendaFrame.getAreaServicos().getText().length()>0) {
							vendaFrame.getAreaServicos().setText(vendaFrame.getAreaServicos().getText()+"\n"+s.getDescricao()+"     R$"+valor+"0");
							vendaFrame.getTotalField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())+valor));
						}else if(vendaFrame.getAreaProduto().getText().length()>0) {
							vendaFrame.getAreaServicos().setText(s.getDescricao()+"     R$"+valor+"0");
							vendaFrame.getTotalField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())+valor));
						}
						else {
							vendaFrame.getAreaServicos().setText(s.getDescricao()+"     R$"+valor+"0");
							vendaFrame.getTotalField().setText(""+valor);
						}
					}
				}

			}
		});

		vendaFrame.getBtnAdicionarProduto().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					condicaoPegarProduto=true;
					int indiceMin = 0,indiceP = 0,qtd = 0,indiceMinArray = 0 ,indicePArray = 0;
					ArrayList<ItemProduto> itens = new ArrayList<>();
					itens = (ArrayList<ItemProduto>)fachada.buscarPorId_produto(vendaFrame.getProdutoBox().getSelectedIndex());
					System.out.print(itens.get(0).getId());
					for(int o = 0;o< itens.size();o++) {
						if(o==0) {
							qtd+=itens.get(o).getQuantidade();
						}

						if(itens.size()==1) {
							indiceMin = itens.get(o).getId();
						}

						for(int m = o+1;m<itens.size();m++) {

							if(itens.get(o).getVencimento().before(itens.get(m).getVencimento())) {
								indiceMin = itens.get(o).getId();
								indiceMinArray = o;
								if(o==0) {
									indiceP =  itens.get(m).getId();
									indicePArray = m;
								}else if(!(itens.get(indicePArray).getVencimento().before(itens.get(m).getVencimento()))) {
									indiceP =  itens.get(m).getId();
									indicePArray  =m;
								}
							}
							else {
								indiceMin =  itens.get(m).getId();
								indiceMinArray = m;
								if(o==0) {
									indiceP =  itens.get(o).getId();
									indicePArray  = o;
								}else if(!(itens.get(indicePArray).getVencimento().before(itens.get(m).getVencimento()))) {
									indiceP =  itens.get(m).getId();
									indicePArray = m;
								}
							}
							if(o==0) {
								qtd+=itens.get(m).getQuantidade();
							}
						}
						//						if(indiceMin == ) {
						//							break;
						//						}

					}
					//System.out.print("Passei");
					if(qtd >= (Integer)vendaFrame.getSpinner().getValue()) {

						for(ItemProduto i: itemProdutosFiltrados) {
							if( i.getId()== vendaFrame.getProdutoBox().getSelectedIndex()) {
								//System.out.print(itemProdutosFiltrados.size());
								float valor = 0;
								if(vendaFrame.getMercadoBox().getSelectedIndex()==0) {
									//System.out.print( "passei");
									valor = ((i.getPrecoCompra() * i.getProduto().getVendaVarejo())/100) + i.getPrecoCompra();
									int y =0;
									while(y<(Integer)vendaFrame.getSpinner().getValue()) {
										if(vendaFrame.getAreaProduto().getText().length()>0) {
											vendaFrame.getAreaProduto().setText(vendaFrame.getAreaProduto().getText()+"\n"+i.getProduto().getNome()+"     R$"+valor+"0");
											vendaFrame.getTotalField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())+valor));
										}else if(vendaFrame.getAreaServicos().getText().length()>0) {
											vendaFrame.getAreaProduto().setText(vendaFrame.getAreaProduto().getText()+i.getProduto().getNome()+"     R$"+valor+"0");
											vendaFrame.getTotalField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())+valor));
										}
										else {
											vendaFrame.getAreaProduto().setText(i.getProduto().getNome()+"     R$"+valor+"0");
											vendaFrame.getTotalField().setText(""+valor);
										}
										y++;
									}

								}else {
									valor += ((i.getPrecoCompra() * i.getProduto().getVendaAtacado())/100) + i.getPrecoCompra();
									int y =0;
									while(y<(Integer)vendaFrame.getSpinner().getValue()) {
										if(vendaFrame.getAreaProduto().getText().length()>0) {
											vendaFrame.getAreaProduto().setText(vendaFrame.getAreaProduto().getText()+"\n"+i.getProduto().getNome()+"     R$"+valor+"0");
											vendaFrame.getTotalField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())+valor));
										}else if(vendaFrame.getAreaServicos().getText().length()>0) {
											vendaFrame.getAreaProduto().setText(vendaFrame.getAreaProduto().getText()+i.getProduto().getNome()+"     R$"+valor+"0");
											vendaFrame.getTotalField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())+valor));
										}
										else {
											vendaFrame.getAreaProduto().setText(i.getProduto().getNome()+"     R$"+valor+"0");
											vendaFrame.getTotalField().setText(""+valor);
										}
										y++;
									}
								}
								break;
							}

						}
						if(itens.get(indiceMinArray).getQuantidade() >= (Integer)vendaFrame.getSpinner().getValue()) {
							itemProduto =new ItemProduto();

							itemProduto.setQuantidade((itens.get(indiceMinArray).getQuantidade()-(Integer)vendaFrame.getSpinner().getValue()));
							itemProduto.setId(indiceMin);
							//System.out.println(itemProduto.getId());
							//fachada.editarQtd(itemProduto);
						}else if((itens.get(indiceMinArray).getQuantidade()+itens.get(indicePArray).getQuantidade())>=(Integer)vendaFrame.getSpinner().getValue()){
							itemProduto =new ItemProduto();
							itemProduto.setQuantidade(itens.get(indiceMinArray).getQuantidade()-itens.get(indiceMinArray).getQuantidade());
							itemProduto.setId(indiceMin);

							int valorTemp =  (Integer)vendaFrame.getSpinner().getValue()-itens.get(indiceMinArray).getQuantidade();
							itemProduto2 = new ItemProduto();
							itemProduto2.setQuantidade(itens.get(indicePArray).getQuantidade()-valorTemp);
							itemProduto2.setId(indiceP);
							condicaoEditar = true;
						}

					}else {
						JOptionPane.showMessageDialog(null, "nao existe essa quantidade no estoque","Break",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}




			}
		});

		vendaFrame.getProdutoBox().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				vendaFrame.getProdutoBox().requestFocus();

			}
		});

		vendaFrame.getEntradaField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Float.parseFloat(vendaFrame.getTotalField().getText())-Float.parseFloat(vendaFrame.getEntradaField().getText())>0) {
					vendaFrame.getParcelasField().setEditable(true);
					vendaFrame.getParcelasField().grabFocus();
					if(vendaFrame.getRecebidoField().getText().length()>0) {
						vendaFrame.getRecebidoField().setText(""+(Float.parseFloat(vendaFrame.getRecebidoField().getText())+Float.parseFloat(vendaFrame.getEntradaField().getText())));
					}else {
						vendaFrame.getRecebidoField().setText(vendaFrame.getEntradaField().getText());
					}
					vendaFrame.getRestanteField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())-Float.parseFloat(vendaFrame.getRecebidoField().getText())));
				}else {
					vendaFrame.getParcelasField().setEditable(false);
					vendaFrame.getDescontoField().grabFocus();
					if(vendaFrame.getRecebidoField().getText().length()>0) {
						vendaFrame.getRecebidoField().setText(""+(Float.parseFloat(vendaFrame.getRecebidoField().getText())+Float.parseFloat(vendaFrame.getEntradaField().getText())));
					}else {
						vendaFrame.getRecebidoField().setText(vendaFrame.getEntradaField().getText());
					}
					vendaFrame.getRestanteField().setText(""+(Float.parseFloat(vendaFrame.getTotalField().getText())-Float.parseFloat(vendaFrame.getRecebidoField().getText())));
				}

			}
		});

		financeiroPanel.getBtnContasApagar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//financeiroPanel.getPanel_4().setVisible(true);
				financeiroPanel.getContasAreceberPanel().setVisible(false);
				financeiroPanel.getContasApagarPanel().setVisible(true);
				financeiroPanel.getPanel_4().add(financeiroPanel.getContasApagarPanel(),BorderLayout.CENTER);


			}
		});



		financeiroPanel.getBtnDashoroad().addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				financeiroPanel.getContasApagarPanel().setVisible(false);
				financeiroPanel.getContasAreceberPanel().setVisible(true);
				financeiroPanel.getPanel_4().add(financeiroPanel.getContasAreceberPanel(),BorderLayout.CENTER);

			}
		});
		pagamentoContReceberPanel.getParcelaSpinner().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				pagamentoContReceberPanel.getPagarField().setText(""+valor*(Integer)pagamentoContReceberPanel.getParcelaSpinner().getValue());

				if((Integer)pagamentoContReceberPanel.getParcelaSpinner().getValue()>i) {
					pagamentoContReceberPanel.getParcelasRestantesField().setText(""+(Integer.parseInt(pagamentoContReceberPanel.getParcelasRestantesField().getText())-1));
					i = (Integer)pagamentoContReceberPanel.getParcelaSpinner().getValue();
				}else {
					pagamentoContReceberPanel.getParcelasRestantesField().setText(""+(Integer.parseInt(pagamentoContReceberPanel.getParcelasRestantesField().getText())+1));
					i = (Integer)pagamentoContReceberPanel.getParcelaSpinner().getValue();
				}
			}
		});


		vendaFrame.getBtnFinalizarVenda().addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				try {
					if(trataEcecao(vendaFrame)) {
						Contas_receber contasReceber = new Contas_receber();
						caixa.setSaldo(caixa.getSaldo() + Float.parseFloat(vendaFrame.getEntradaField().getText()));
						fachada.editarCaixa(caixa);
						if(!((Float.parseFloat(vendaFrame.getEntradaField().getText())-Float.parseFloat(vendaFrame.getTotalField().getText()))==0)) {
							contasReceber.setId_caixas(1);
							contasReceber.setId_paciente(pacientes.get((vendaFrame.getPacienteBox().getSelectedIndex()-1)).getId());
							System.out.print(pacientes.get(vendaFrame.getPacienteBox().getSelectedIndex()).getId());
							contasReceber.setParcelas(Integer.parseInt(vendaFrame.getParcelasField().getText()));
							if(!vendaFrame.getDescontoField().getText().equals("")) {
								contasReceber.setValor(Float.parseFloat(vendaFrame.getRestanteField().getText())-Float.parseFloat(vendaFrame.getDescontoField().getText()));
							}else {
								contasReceber.setValor(Float.parseFloat(vendaFrame.getRestanteField().getText()));
							}
							//System.out.println(contasReceber.getValor());

							fachada.salvarContas_receber(contasReceber);
							JOptionPane.showMessageDialog(null, "Divida do Paciente Registrada");
						}


						DecimalFormat df = new DecimalFormat();
						df.applyPattern("R$ .00");

						financeiroPanel.getLblValorReceber().setText(df.format((fachada.soma()-fachada.somaValorPago())));

						caixa = new Caixa();
						caixa = (Caixa) fachada.buscarPorIdCaixa(vendaFrame.getBoxCaixa().getSelectedIndex());
						financeiroPanel.getLblValorCaixa().setText(df.format(caixa.getSaldo()));

						if(condicaoPegarProduto) {
							fachada.editarQtd(itemProduto);

							if(condicaoEditar) {
								fachada.editarQtd(itemProduto);
								fachada.editarQtd(itemProduto2);
								//cont++;

							}


						}



						if((JOptionPane.showConfirmDialog(null, "Deseja realizar mais alguma Venda?"))==0){
							limparCampos(vendaFrame);
						}else {
							limparCampos(vendaFrame);
							vendaFrame.setVisible(false);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Campos em branco");
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//quando ela for finalizada ela tem q verificar se a pessoa pagou e armazenar no caixa 
				//caso tenha sido parcelada tera q ser armazenada na tela de contas a receber e o que foi pago vai pro caixa


			}
		});


		financeiroPanel.getContasAreceberPanel().getBuscaButton().addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				try {

					contas_recebers = new ArrayList<Contas_receber>();
					contas_recebers = (ArrayList<Contas_receber>) fachada.buscarPorBuscaContas_receber("%"+financeiroPanel.getContasAreceberPanel().getFiltroField().getText()+"%");
					System.out.print(contas_recebers.size());
					int j = 0;
					String status = "Não Paga";
					Object [][] linha = new Object[contas_recebers.size()][6];
					for(Contas_receber c: contas_recebers) {
						linha[j][0] = c.getId();
						linha[j][1] = c.getNome();
						linha[j][2] = c.getValor();
						linha[j][3] = c.getValorPago();
						if(c.getValor() - c.getValorPago() == 0) {
							status  = "Paga";
						}else {
							status = "Não Pago";
						}
						linha[j][4] = status;
						JButton b = new JButton("Abrir");
						b.setForeground(Color.BLACK);
						b.setBackground(Color.white);
						b.setFont(Propiedade.FONT2);
						linha[j][5] = b;
						j++;

					}
					JTableButtonModel jtableButtonModel = new JTableButtonModel();
					jtableButtonModel.adcionar(linha,new String[] {
							"Codigo","Paciente","Valor","Pago","Status","Pagar"
					});



					financeiroPanel.getContasAreceberPanel().getTable().getTable().setModel(jtableButtonModel);
					financeiroPanel.getContasAreceberPanel().getTable().getTable().setRowHeight(40);

					financeiroPanel.getContasAreceberPanel().getTable().getTable().setShowGrid(true);
					financeiroPanel.getContasAreceberPanel().getTable().getTable().setShowHorizontalLines(true);
					financeiroPanel.getContasAreceberPanel().getTable().getTable().setShowVerticalLines(true);
					financeiroPanel.getContasAreceberPanel().getTable().getTable().setBackground(Color.white);
					financeiroPanel.getContasAreceberPanel().getTable().getTable().setFont(Propiedade.FONT2);

				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});




		financeiroPanel.getContasAreceberPanel().getTable().getTable().addMouseListener(new JTableButtonMouseListener(financeiroPanel.getContasAreceberPanel().getTable().getTable(), pagamentoContReceberPanel));



		pagamentoContReceberPanel.getBtnPagar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Contas_receber c = new Contas_receber();
					c.setId(index);
					c.setParcelas(Integer.parseInt(pagamentoContReceberPanel.getParcelasRestantesField().getText()));
					c.setValorPago((Float.parseFloat(pagamentoContReceberPanel.getPagarField().getText())+fachada.buscarPorIdContas_receber(index).getValorPago()));

					fachada.editarContas_receber(c);

					Caixa caixa = new Caixa();
					caixa.setSaldo((fachada.buscarPorIdCaixa(1).getSaldo()+Float.parseFloat(pagamentoContReceberPanel.getPagarField().getText())));
					caixa.setId(1);
					fachada.editarCaixa(caixa);

					DecimalFormat df = new DecimalFormat();
					df.applyPattern("R$ .00");

					if(fachada.soma() - fachada.somaValorPago() == 0) {
						financeiroPanel.getLblValorReceber().setText("R$ 0,00");
					}else {
						financeiroPanel.getLblValorReceber().setText(df.format((fachada.soma()-fachada.somaValorPago())));
					}


					caixa = new Caixa();
					caixa = (Caixa) fachada.buscarPorIdCaixa(1);
					financeiroPanel.getLblValorCaixa().setText(df.format(caixa.getSaldo()));

					JOptionPane.showMessageDialog(null, "Pagamento recebido Com sucesso");
					pagamentoContReceberPanel.setVisible(false);
					i=-1;
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});




	}


	private void limparCampos(VendaFrame vendaFrame) {
		vendaFrame.getProdutoBox().setSelectedIndex(0);
		vendaFrame.getServicoBox().setSelectedIndex(0);
		vendaFrame.getPacienteBox().setSelectedIndex(0);
		vendaFrame.getBoxCaixa().setSelectedIndex(0);
		vendaFrame.getAreaProduto().setText("");
		vendaFrame.getAreaServicos().setText("");
		vendaFrame.getRecebidoField().setText("");
		vendaFrame.getDescontoField().setText("");
		vendaFrame.getEntradaField().setText("");
		vendaFrame.getParcelasField().setText("");
		vendaFrame.getTotalField().setText("");
	}


	public boolean trataEcecao(VendaFrame vendaFrame) {
		if(vendaFrame.getServicoBox().getSelectedIndex() ==0 || vendaFrame.getPacienteBox().getSelectedIndex()==0 ||
				vendaFrame.getBoxCaixa().getSelectedIndex() == 0 ||	vendaFrame.getAreaServicos().getText().length() ==0 || vendaFrame.getRecebidoField().getText().equals("")|| 
				vendaFrame.getEntradaField().getText().equals("")||vendaFrame.getParcelasField().equals("")||vendaFrame.getTotalField().getText().equals("")) {
			return false;
		}
		return true;

	}




	public class JTableButtonMouseListener implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private PagamentoContReceberPanel pagamentoContReceberPanel;

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
			if(button == buttonEvent.getSource()) { 
				index =(Integer)getTable().getValueAt(getTable().getSelectedRow(),0);
				pagamentoContReceberPanel.getPacienteField().setText(""+getTable().getValueAt(getTable().getSelectedRow(),1));
				pagamentoContReceberPanel.getValorRestanteField().setText(""+(Float.parseFloat(""+(getTable().getValueAt(getTable().getSelectedRow(),2)))-Float.parseFloat(""+getTable().getValueAt(getTable().getSelectedRow(),3))));
				pagamentoContReceberPanel.getParcelasRestantesField().setText(""+contas_recebers.get(getTable().getSelectedRow()).getParcelas());
				pagamentoContReceberPanel.getCaixaBox().addItem("Caixa principal");
				SpinnerNumberModel model = new SpinnerNumberModel(0, 0, contas_recebers.get(getTable().getSelectedRow()).getParcelas(), 1);   
				pagamentoContReceberPanel.getParcelaSpinner().setModel(model);
				valor = Float.parseFloat(pagamentoContReceberPanel.getValorRestanteField().getText())/contas_recebers.get(getTable().getSelectedRow()).getParcelas();
				if( Float.parseFloat(pagamentoContReceberPanel.getValorRestanteField().getText())==0) {
					valor = 0;
				}
				pagamentoContReceberPanel.getPagarField().setText(""+valor);
				pagamentoContReceberPanel.setVisible(true);

			}
			// This is necessary so that when a button is pressed and released
			// it gets rendered properly.  Otherwise, the button may still appear
			// pressed down when it has been released.
			this.table.repaint();
		}

		public JTableButtonMouseListener(JTable table,PagamentoContReceberPanel pagamentoContReceberPanel) {
			this.table = table;
			this.pagamentoContReceberPanel = pagamentoContReceberPanel;
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
