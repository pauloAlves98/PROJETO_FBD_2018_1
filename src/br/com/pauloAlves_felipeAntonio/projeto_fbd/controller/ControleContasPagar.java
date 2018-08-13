package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ContasApagarPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.FinanceiroPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PagamentoContaApagarPanel;

public class ControleContasPagar {
	IFachada fachada;
	float valor = 0;
	int indexPagar = 0,i=-1;
	ArrayList<Contas_pagar> contasP ;
	public ControleContasPagar(ContasApagarPanel contasApagarPanel,FinanceiroPanel financeiroPanel, PagamentoContaApagarPanel pagamentoContaApagarPanel) {
		fachada = Fachada.getInstance();
		
	  
		
		
		contasApagarPanel.getBuscaButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					contasP = new ArrayList<Contas_pagar>();
					contasP=(ArrayList<Contas_pagar>)fachada.buscarPorBuscaContas_pagar("%"+contasApagarPanel.getFiltroField().getText()+"%");
					int j = 0;
					String status = "Não Paga";
					Object [][] linha = new Object[contasP.size()][7];
					for(Contas_pagar conta:contasP) {
						linha[j][0] = conta.getId();
						linha[j][1] = conta.getNomeFornecedor();
						linha[j][2] = conta.getNomeProduto();
						
						linha[j][3] = conta.getValor();
						linha[j][4] = conta.getValorPago();
						if(conta.getValor() - conta.getValorPago() == 0) {
							status  = "Paga";
						}else {
							status = "Não paga";
						}
						linha[j][5] = status;
						JButton b = new JButton("Abrir");
						b.setForeground(Color.BLACK);
						b.setBackground(Color.white);
						b.setFont(Propiedade.FONT2);
						linha[j][6] = b;
						j++;
						
					}

					JTableButtonModel jtableButtonModel = new JTableButtonModel();
					jtableButtonModel.adcionar(linha, new String[] {
							"Codigo","Fornecedor","Produto","Valor","Pago","Status","Pagar"
					});

					contasApagarPanel.getTable().getTable().setModel(jtableButtonModel);
					contasApagarPanel.getTable().getTable().setRowHeight(40);

					contasApagarPanel.getTable().getTable().setShowGrid(true);
					contasApagarPanel.getTable().getTable().setShowHorizontalLines(true);
					contasApagarPanel.getTable().getTable().setShowVerticalLines(true);
					contasApagarPanel.getTable().getTable().setBackground(Color.white);
					contasApagarPanel.getTable().getTable().setFont(Propiedade.FONT2);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		pagamentoContaApagarPanel.getBtnPagar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(fachada.buscarPorIdCaixa(1).getSaldo()>=Float.parseFloat(pagamentoContaApagarPanel.getPagarField().getText())) {
						Contas_pagar contas_pagar = new Contas_pagar();
						contas_pagar.setId(indexPagar);
						contas_pagar.setParcela(Integer.parseInt(pagamentoContaApagarPanel.getParcelasRestantesField().getText()));
						contas_pagar.setParecelasTotais(Integer.parseInt(pagamentoContaApagarPanel.getTextField().getText()));
						contas_pagar.setValorPago(contasP.get(contasApagarPanel.getTable().getTable().getSelectedRow()).getValorPago()+Float.parseFloat(pagamentoContaApagarPanel.getPagarField().getText()));
					
						fachada.editarContas_pagar(contas_pagar);
						Caixa caixa = new Caixa();
						caixa.setSaldo((fachada.buscarPorIdCaixa(1).getSaldo()-Float.parseFloat(pagamentoContaApagarPanel.getPagarField().getText())));
						caixa.setId(1);
						fachada.editarCaixa(caixa);
						
						DecimalFormat df = new DecimalFormat();
						df.applyPattern("R$ .00");
						
					
						
						caixa = new Caixa();
						caixa = (Caixa) fachada.buscarPorIdCaixa(1);
						if(caixa.getSaldo() == 0) {
							financeiroPanel.getLblValorCaixa().setText("R$ 0,00");
						}else {
							financeiroPanel.getLblValorCaixa().setText(df.format(caixa.getSaldo()));
						}
						
						i=-1;
						JOptionPane.showMessageDialog(null, "Pagamento feito Com sucesso");
						pagamentoContaApagarPanel.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente");
					}
					
				
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		financeiroPanel.getContasApagarPanel().getTable().getTable().addMouseListener(new JTableButtonMouseListener1(financeiroPanel.getContasApagarPanel().getTable().getTable(), pagamentoContaApagarPanel));
		
		pagamentoContaApagarPanel.getChckbxParcelado().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			
					
					//float saldo =fachada.buscarPorIdCaixa(1).getSaldo();
					if(!pagamentoContaApagarPanel.getChckbxParcelado().isSelected()) {
						pagamentoContaApagarPanel.getParcelaSpinner().setVisible(false);
						pagamentoContaApagarPanel.getParcelasRestantesField().setVisible(false);
						pagamentoContaApagarPanel.getLblParcelas().setVisible(false);
						pagamentoContaApagarPanel.getLblParcelasRestantes().setVisible(false);
						pagamentoContaApagarPanel.getLblNDeParcelas().setVisible(false);
						pagamentoContaApagarPanel.getTextField().setVisible(false);
						
						pagamentoContaApagarPanel.getLblValorRestante().setBounds(10, 155, 114, 14);
						pagamentoContaApagarPanel.getLblPagar().setBounds(134, 151, 94, 23);
						pagamentoContaApagarPanel.getValorRestanteField().setBounds(10, 180, 102, 32);
						pagamentoContaApagarPanel.getPagarField().setBounds(134, 180, 102, 32);
						//lblPagar.setBounds(306, 155, 46, 14);
						pagamentoContaApagarPanel.getBtnPagar().setBounds(246, 180, 110, 32);
						valor = Float.parseFloat(pagamentoContaApagarPanel.getValorRestanteField().getText());
						pagamentoContaApagarPanel.getPagarField().setText(""+valor);
						
					}else {
						
						pagamentoContaApagarPanel.getParcelaSpinner().setVisible(true);
						pagamentoContaApagarPanel.getParcelasRestantesField().setVisible(true);
						pagamentoContaApagarPanel.getLblParcelas().setVisible(true);
						pagamentoContaApagarPanel.getLblParcelasRestantes().setVisible(true);
						pagamentoContaApagarPanel.getLblNDeParcelas().setVisible(true);
						pagamentoContaApagarPanel.getTextField().setVisible(true);
						pagamentoContaApagarPanel.getLblValorRestante().setBounds(194, 219, 114, 14);
						pagamentoContaApagarPanel.getLblPagar().setBounds(306, 219, 46, 14);
						pagamentoContaApagarPanel.getValorRestanteField().setBounds(194, 244, 102, 32);
						pagamentoContaApagarPanel.getPagarField().setBounds(306, 244, 102, 32);
						//valorRestanteField.setBounds(194, 180, 102, 32);
					//	pagarField.setBounds(306, 180, 102, 32);
						//lblPagar.setBounds(306, 155, 46, 14);
						pagamentoContaApagarPanel.getBtnPagar().setBounds(10, 289, 89, 32);
						pagamentoContaApagarPanel.getLblFornecedor().setBounds(10, 91, 102, 14);
						pagamentoContaApagarPanel.getCaixaBox().setBounds(268, 112, 156, 32);
						pagamentoContaApagarPanel.getPacienteField().setBounds(10, 112, 248, 32);
						pagamentoContaApagarPanel.getLblCaixa().setBounds(268, 87, 46, 22);
						valor = Float.parseFloat(pagamentoContaApagarPanel.getValorRestanteField().getText())/contasP.get(contasApagarPanel.getTable().getTable().getSelectedRow()).getParcela();
						pagamentoContaApagarPanel.getPagarField().setText(""+valor);
					}
				
				
			}});
		
		pagamentoContaApagarPanel.getParcelaSpinner().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				pagamentoContaApagarPanel.getPagarField().setText(""+valor*(Integer)pagamentoContaApagarPanel.getParcelaSpinner().getValue());
				
				if((Integer)pagamentoContaApagarPanel.getParcelaSpinner().getValue()>i) {
					pagamentoContaApagarPanel.getParcelasRestantesField().setText(""+(Integer.parseInt(pagamentoContaApagarPanel.getParcelasRestantesField().getText())-1));
					i = (Integer)pagamentoContaApagarPanel.getParcelaSpinner().getValue();
				}else {
					pagamentoContaApagarPanel.getParcelasRestantesField().setText(""+(Integer.parseInt(pagamentoContaApagarPanel.getParcelasRestantesField().getText())+1));
					i = (Integer)pagamentoContaApagarPanel.getParcelaSpinner().getValue();
				}
			}
		});
		
		pagamentoContaApagarPanel.getTextField().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int y=Integer.parseInt(pagamentoContaApagarPanel.getTextField().getText());
				SpinnerNumberModel model = new SpinnerNumberModel(0, 0,y,1);   
				pagamentoContaApagarPanel.getParcelaSpinner().setModel(model);
				pagamentoContaApagarPanel.getParcelasRestantesField().setText(""+y);
				//i = (Integer)pagamentoContaApagarPanel.getParcelaSpinner().getValue();
				valor =( Float.parseFloat(pagamentoContaApagarPanel.getValorRestanteField().getText())/y);
				pagamentoContaApagarPanel.getPagarField().setText(""+valor);
			}
		});
	}
	private String formatandoData(String antigo) {
		if(antigo.length()<2)
			antigo = 0+antigo;
		return antigo;
	}
	
	
	public class JTableButtonMouseListener1 implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private PagamentoContaApagarPanel pagamentoContaApagarPanel;

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
				indexPagar =(Integer)getTable().getValueAt(getTable().getSelectedRow(),0);
				pagamentoContaApagarPanel.getPacienteField().setText(""+getTable().getValueAt(getTable().getSelectedRow(),1));
				pagamentoContaApagarPanel.getValorRestanteField().setText(""+(Float.parseFloat(""+(getTable().getValueAt(getTable().getSelectedRow(),3)))-Float.parseFloat(""+getTable().getValueAt(getTable().getSelectedRow(),4))));
				pagamentoContaApagarPanel.getParcelasRestantesField().setText(""+contasP.get(getTable().getSelectedRow()).getParcela());
				pagamentoContaApagarPanel.getCaixaBox().addItem("Caixa principal");
				if(contasP.get(getTable().getSelectedRow()).getParecelasTotais()>0) {
					pagamentoContaApagarPanel.getTextField().setText(""+contasP.get(getTable().getSelectedRow()).getParecelasTotais());
					pagamentoContaApagarPanel.getTextField().setEditable(false);
					SpinnerNumberModel model = new SpinnerNumberModel(0, 0,contasP.get(getTable().getSelectedRow()).getParcela(),1);   
					pagamentoContaApagarPanel.getParcelaSpinner().setModel(model);

				}
				//if(pagamentoContaApagarPanel.getChckbxParcelado().isSelected()&&pagamentoContaApagarPanel.getTextField().getText().length()>0) {
				valor = Float.parseFloat(pagamentoContaApagarPanel.getValorRestanteField().getText())/contasP.get(getTable().getSelectedRow()).getParcela();
				//}//else if (!pagamentoContaApagarPanel.getChckbxParcelado().isSelected()) {
//					valor = Float.parseFloat(pagamentoContaApagarPanel.getValorRestanteField().getText());
//				}
				
				//pagamentoContaApagarPanel.getPagarField().setText(""+valor);
				pagamentoContaApagarPanel.setVisible(true);	
			}
			// This is necessary so that when a button is pressed and released
			// it gets rendered properly.  Otherwise, the button may still appear
			// pressed down when it has been released.
			this.table.repaint();
		}

		public JTableButtonMouseListener1(JTable table,PagamentoContaApagarPanel pacientes) {
			this.table = table;
			this.pagamentoContaApagarPanel = pacientes;
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
