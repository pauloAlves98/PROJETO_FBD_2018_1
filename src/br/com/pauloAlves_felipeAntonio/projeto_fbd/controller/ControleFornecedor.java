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
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFornecedoresFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.FornecedoresPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
//import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonMouseListener;

public class ControleFornecedor {
	IFachada fachada;
	Fornecedor fornecedor;
	CadastroFornecedoresFrame  forncedorrCdt;
	int condicao = 0;
	public ControleFornecedor(FornecedoresPanel fornecedoresPanel,CadastroFornecedoresFrame cadastro) {
		fachada = Fachada.getInstance();
		forncedorrCdt = cadastro;
		cadastro.getCodigoField().setEditable(false);
		fornecedoresPanel.getNovoFornecedorButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastro.setVisible(true);
				
			}
		});
		
		cadastro.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(condicao == 0){
						Fornecedor f = new Fornecedor();
						f.setCnpj(cadastro.getCpfField().getText().replace(".","").replace("-",""));
						f.setIncs_municipal(Integer.parseInt(cadastro.getInscMunicipalField().getText()));
						f.setInsc_estadual(Integer.parseInt(cadastro.getInscEstadualField().getText()));
						f.setNome(cadastro.getNomeField().getText());
						f.setTelefone(cadastro.getTelefoneField().getText());
						Endereco end = new Endereco();
						end.setBairro(cadastro.getBairroField().getText());
						end.setCep(cadastro.getCepField().getText());
						end.setCidade(""+cadastro.getCidadeBox().getItemAt(cadastro.getCidadeBox().getSelectedIndex()));
						end.setComplemento(cadastro.getComplementoField().getText());
						end.setEstado(""+cadastro.getUfBox().getItemAt(cadastro.getUfBox().getSelectedIndex()));
						end.setLogradouro(cadastro.getLogradouroField().getText());
						end.setNumero(Integer.parseInt(cadastro.getNumeroField().getText()));
						end.setPais(""+cadastro.getPaisBox().getItemAt(cadastro.getPaisBox().getSelectedIndex()));
						end.setRua(cadastro.getRuaField().getText());
						f.setEndereco(end);
						
						fachada.salvarFornecedor(f);
						if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
							limparCampos(cadastro);
						}else {
							cadastro.setVisible(false);
							limparCampos(cadastro);
						}
					}else{
						Endereco end = new Endereco();
						end.setId(fornecedor.getEndereco().getId());//transfere o id  do endereco a ser editado
						
						fornecedor.setEndereco(end);
						fornecedor.setNome(forncedorrCdt.getNomeField().getText());
						fornecedor.setCnpj(forncedorrCdt.getCpfField().getText().replace(".","").replace("-",""));
						fornecedor.setIncs_municipal(Integer.parseInt(forncedorrCdt.getInscMunicipalField().getText().replace(" ","")));
						fornecedor.setInsc_estadual(Integer.parseInt(forncedorrCdt.getInscEstadualField().getText().replace(" ","")));
						TratadorDeMascara.isCPF(fornecedor.getCnpj());
						fornecedor.setTelefone(forncedorrCdt.getTelefoneField().getText());
						
						fornecedor.getEndereco().setBairro(forncedorrCdt.getBairroField().getText());
						fornecedor.getEndereco().setCep(forncedorrCdt.getCepField().getText());
						fornecedor.getEndereco().setCidade(forncedorrCdt.getCidadeBox().getSelectedItem().toString());
						fornecedor.getEndereco().setComplemento(forncedorrCdt.getComplementoField().getText());
						fornecedor.getEndereco().setEstado(""+forncedorrCdt.getUfBox().getSelectedItem().toString());
						fornecedor.getEndereco().setLogradouro(forncedorrCdt.getLogradouroField().getText().trim().replace(" ",""));
						fornecedor.getEndereco().setNumero(Integer.parseInt(forncedorrCdt.getNumeroField().getText()));
						fornecedor.getEndereco().setPais(""+forncedorrCdt.getPaisBox().getItemAt(forncedorrCdt.getPaisBox().getSelectedIndex()));
						fornecedor.getEndereco().setRua(forncedorrCdt.getRuaField().getText());
						fornecedor.setId(condicao);//seta o id para realizar a comparação na busca


						fachada.editarFornecedor(fornecedor);
						JOptionPane.showMessageDialog(null,"Fornecedor Atualizado");
						limparCampos(forncedorrCdt);
						forncedorrCdt.setVisible(false);
						condicao = 0;
					}
				} catch (BusinessException e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				} catch (ValidacaoException e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"CNPJ INVÁLIDO!!!");
				}
			}
		});
		
		fornecedoresPanel.getBuscaButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//nome,cnpj,incs_municipal,telefone
					ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
					fornecedores = (ArrayList<Fornecedor>) fachada.buscarPorBuscaFornecedor("%"+fornecedoresPanel.getTextField().getText()+"%");
					Object linha[][] = new Object[fornecedores.size()][5];
					int i=0;
					for(Fornecedor f:fornecedores){
						linha[i][0] = f.getNome();
						linha[i][1] = f.getCnpj();
						linha[i][2] = ""+f.getIncs_municipal();
						linha[i][3] = f.getTelefone();
						JButton b = new JButton("Abrir");
						b.setForeground(Color.BLACK);
						b.setBackground(Color.white);
						b.setFont(Propiedade.FONT2);
						linha[i][4] = b;
						i++;
			
					}
					JTableButtonModel jtableButtonModel= new JTableButtonModel();
			 		jtableButtonModel.adcionar(linha,new String[] {
							"Nome", "CNPJ", "Incs. municipal","Telefone", "Cadastro"
					});
			 		
				 			
					fornecedoresPanel.getTable().getTable().setModel(jtableButtonModel);
					fornecedoresPanel.getTable().getTable().setRowHeight(40);
					fornecedoresPanel.getTable().getTable().setShowGrid(true);
					fornecedoresPanel.getTable().getTable().setShowHorizontalLines(true);
					fornecedoresPanel.getTable().getTable().setShowVerticalLines(true);
					fornecedoresPanel.getTable().getTable().setBackground(Color.white);
					fornecedoresPanel.getTable().getTable().setFont(Propiedade.FONT2);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		fornecedoresPanel.getTable().getTable().addMouseListener(new JTableButtonMouseListener(fornecedoresPanel.getTable().getTable(),cadastro));
		
	}
	private void limparCampos(CadastroFornecedoresFrame CadastroFornecedor) {
		CadastroFornecedor.getNomeField().setText("");
		CadastroFornecedor.getCpfField().setText("");
		CadastroFornecedor.getTelefoneField().setText("");
		CadastroFornecedor.getInscEstadualField().setText("");
		CadastroFornecedor.getInscMunicipalField().setText("");
		CadastroFornecedor.getBairroField().setText("");
		CadastroFornecedor.getCepField().setText("");
		
		CadastroFornecedor.getComplementoField().setText("");
		CadastroFornecedor.getLogradouroField().setText("");
		CadastroFornecedor.getNumeroField().setText("");
		CadastroFornecedor.getRuaField().setText("");
		CadastroFornecedor.getCodigoField().setText("");
	}
	 private class JTableButtonMouseListener implements MouseListener {
		  private JTable table;
		  private CadastroFornecedoresFrame fornecedoresTela;

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
	
		    		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
					fornecedores =(ArrayList<Fornecedor>) fachada.buscarPorBuscaFornecedor(""+table.getValueAt(table.getSelectedRow(), 1));
					fornecedor = new Fornecedor();
					fornecedor = fornecedores.get(0);
					condicao = fornecedor.getId();
					fornecedoresTela.getNomeField().setText(fornecedor.getNome());
					fornecedoresTela.getCpfField().setText(fornecedor.getCnpj());
					fornecedoresTela.getTelefoneField().setText(fornecedor.getTelefone());
					fornecedoresTela.getInscEstadualField().setText(""+fornecedor.getInsc_estadual());
					fornecedoresTela.getInscMunicipalField().setText(""+fornecedor.getIncs_municipal());
					fornecedoresTela.getBairroField().setText(fornecedor.getEndereco().getBairro());
					fornecedoresTela.getCepField().setText(fornecedor.getEndereco().getCep());
					
					fornecedoresTela.getComplementoField().setText(fornecedor.getEndereco().getComplemento());
					fornecedoresTela.getLogradouroField().setText(fornecedor.getEndereco().getLogradouro());
					fornecedoresTela.getNumeroField().setText(""+fornecedor.getEndereco().getNumero());
					fornecedoresTela.getRuaField().setText(fornecedor.getEndereco().getRua());
					fornecedoresTela.getCodigoField().setText(fornecedor.getId()+"");
					fornecedoresTela.setVisible(true);
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

		  public JTableButtonMouseListener(JTable table,CadastroFornecedoresFrame fornecedores) {
		    this.table = table;
		    this.fornecedoresTela =fornecedores;
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
