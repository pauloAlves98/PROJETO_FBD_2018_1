package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroServicoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ServicoPanel;

public class ControleServico {
	IFachada fachada;
	public ControleServico(ServicoPanel servicoPanel,CadastroServicoFrame cadastroServicoFrame) {
		fachada = Fachada.getInstance();
		servicoPanel.getServicoButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroServicoFrame.setVisible(true);
				
			}
		});
		
		cadastroServicoFrame.getSalvarButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
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
				
					servicos = (ArrayList<Servico>)fachada.buscarPorBuscaServico(servicoPanel.getTextField().getText(),servicoPanel.getTextField_1().getText());
					String [][] linha = new String[servicos.size()][5];
					int i=0;
					for(Servico s:servicos){
						linha[i][0] = s.getTipo(); 
						linha[i][1] = s.getDescricao();
						linha[i][2] = ""+s.getValor();
						linha[i][3] ="nada";
						i++;
					}
					DefaultTableModel d = new DefaultTableModel(linha,new String[] {
							"Tipo","Descricao","Valor","Cadastro"
			 			});
				 			
					servicoPanel.getTable().setModel(d);
					servicoPanel.getTable().setShowGrid(true);
					servicoPanel.getTable().setShowHorizontalLines(true);
					servicoPanel.getTable().setShowVerticalLines(true);
					servicoPanel.getTable().setBackground(Color.white);
					servicoPanel.getTable().setFont(Propiedade.FONT1);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	private void limparCampos(CadastroServicoFrame cadastroServicoFrame) {
		cadastroServicoFrame.getTipoField().setText("");
		cadastroServicoFrame.getDescricaoField().setText("");
		cadastroServicoFrame.getValorField().setText("");
		
	}
}
