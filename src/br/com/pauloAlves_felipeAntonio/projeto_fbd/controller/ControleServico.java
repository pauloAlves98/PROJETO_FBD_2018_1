package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacienteFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroServicoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ServicoPanel;

public class ControleServico {
	IFachada fachada;
	int condicao = 0;
	public ControleServico(ServicoPanel servicoPanel,CadastroServicoFrame cadastroServicoFrame) {
		fachada = Fachada.getInstance();
		servicoPanel.getServicoButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroServicoFrame.setVisible(true);
				
			}
		});
		
		cadastroServicoFrame. addWindowListener(new WindowAdapter()  
	       {  
	           public void windowClosing(WindowEvent evt)  
	           {  condicao =0;
	           		limparCampos(cadastroServicoFrame);
	           }  
	       });  
		
		cadastroServicoFrame.getSalvarButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(condicao == 0) {
						Servico servico = new Servico();
						servico.setTipo(cadastroServicoFrame.getTipoField().getText());
						servico.setDescricao(cadastroServicoFrame.getDescricaoField().getText());
						servico.setValor(Float.parseFloat(cadastroServicoFrame.getValorField().getText()));
					
						fachada.salvarServico(servico);
						if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
							limparCampos(cadastroServicoFrame);
						}else {
							cadastroServicoFrame.setVisible(false);
							limparCampos(cadastroServicoFrame);
						}
					}else {
						Servico servico = new Servico();
						servico.setTipo(cadastroServicoFrame.getTipoField().getText());
						servico.setDescricao(cadastroServicoFrame.getDescricaoField().getText());
						servico.setValor(Float.parseFloat(cadastroServicoFrame.getValorField().getText()));
						servico.setId(condicao);
						fachada.editarServico(servico);
						JOptionPane.showMessageDialog(null, "modificado com sucesso!!");
						limparCampos(cadastroServicoFrame);
						cadastroServicoFrame.setVisible(false);	
						
					}
					
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		servicoPanel.getBuscaButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Servico> servicos = new ArrayList<Servico>();
				
					servicos = (ArrayList<Servico>)fachada.buscarPorBuscaServico("%"+servicoPanel.getTextField().getText()+"%");
					Object [][] linha = new Object[servicos.size()][5];
					int i=0;
					for(Servico s:servicos){
						linha[i][0] = s.getTipo(); 
						linha[i][1] = s.getDescricao();
						linha[i][2] = ""+s.getValor();
						linha[i][3] = new JButton("cadastro");
						i++;
					}
					
					JTableButtonModel jTableButtonModel = new JTableButtonModel();
					jTableButtonModel.adcionar(linha,new String[] {
							"Tipo","Descricao","Valor","Cadastro"
			 			} );
					
					servicoPanel.getTable().getTable().setModel(jTableButtonModel);
					servicoPanel.getTable().getTable().setShowGrid(true);
					servicoPanel.getTable().getTable().setShowHorizontalLines(true);
					servicoPanel.getTable().getTable().setShowVerticalLines(true);
					servicoPanel.getTable().getTable().setBackground(Color.white);
					servicoPanel.getTable().getTable().setFont(Propiedade.FONT1);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		servicoPanel.getTable().getTable().addMouseListener(new JTableButtonMouseListener(servicoPanel.getTable().getTable(),cadastroServicoFrame));
		
	}
	private void limparCampos(CadastroServicoFrame cadastroServicoFrame) {
		cadastroServicoFrame.getTipoField().setText("");
		cadastroServicoFrame.getDescricaoField().setText("");
		cadastroServicoFrame.getValorField().setText("");
		
	}
	 private class JTableButtonMouseListener implements MouseListener {
		  private JTable table;
		  private CadastroServicoFrame servicos;

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
		    		//Falta o id
		    		ArrayList<Servico> servicoss = new ArrayList<Servico>();
			    	Servico servico = new Servico();
					servicoss = (ArrayList<Servico>)fachada.buscarPorBuscaServico("%"+table.getValueAt(table.getSelectedRow(), 0)+"%");
					servico = servicoss.get(0);
					condicao  = servico.getId();
					servicos.getTipoField().setText(servico.getTipo());
					servicos.getDescricaoField().setText(servico.getDescricao());
					servicos.getValorField().setText(""+servico.getValor());
			    	servicos.setVisible(true); 
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

		  public JTableButtonMouseListener(JTable table,CadastroServicoFrame servicos) {
		    this.table = table;
		    this.servicos =servicos;
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
