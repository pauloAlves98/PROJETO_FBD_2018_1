package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFornecedoresFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.FornecedoresPanel;

public class ControleFornecedor {
	IFachada fachada;
	public ControleFornecedor(FornecedoresPanel fornecedoresPanel,CadastroFornecedoresFrame cadastro) {
		fachada = Fachada.getInstance();
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
					Fornecedor f = new Fornecedor();
					f.setCnpj(cadastro.getCpfField().getText());
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
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		fornecedoresPanel.getBuscaButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//nome,cnpj,incs_municipal,telefone
					ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
					fornecedores = (ArrayList<Fornecedor>) fachada.buscarPorBuscaFornecedor(fornecedoresPanel.getTextField().getText(), fornecedoresPanel.getTextField_1().getText());
					String linha[][] = new String[fornecedores.size()][5];
					int i=0;
					for(Fornecedor f:fornecedores){
						linha[i][0] = f.getNome();
						linha[i][1] = f.getCnpj();
						linha[i][2] = ""+f.getIncs_municipal();
						linha[i][3] = f.getTelefone();
						linha[i][4] = "nada";
					}
					DefaultTableModel d = new DefaultTableModel(linha,new String[] {
							"Nome", "CPF", "Incs. municipal","Telefone", "Cadastro"
			 			});
				 			
					fornecedoresPanel.getTable().setModel(d);
					fornecedoresPanel.getTable().setShowGrid(true);
					fornecedoresPanel.getTable().setShowHorizontalLines(true);
					fornecedoresPanel.getTable().setShowVerticalLines(true);
					fornecedoresPanel.getTable().setBackground(Color.white);
					fornecedoresPanel.getTable().setFont(Propiedade.FONT1);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
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
		
	}
}
