package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacienteFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PacientesPanel;



public class ControlePacientesPanel {
	private Paciente paciente = new Paciente();
	private IFachada fachada;
	PacientesPanel telaPaciente;
	public ControlePacientesPanel(PacientesPanel telaPaciente,CadastroPacienteFrame pacienteCdastro) {
		this.telaPaciente = telaPaciente;
		fachada = Fachada.getInstance();
		
		telaPaciente.getBuscaButton().addActionListener((ActionEvent e)-> buscarPaciente());
		telaPaciente.getBtnNewButton_3().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pacienteCdastro.setVisible(true);
			}
		});
		pacienteCdastro.getBtnSalvar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					paciente = new Paciente();
					Endereco end = new Endereco();
					//Perguntar se o tratamento de campo vazio fica aqui  ou no Businnes
					paciente.setEndereco(end);
					paciente.setNome(pacienteCdastro.getNomeField().getText());
					paciente.setCpf(pacienteCdastro.getCpfField().getText().replace(".","").replace("-",""));
					TratadorDeMascara.isCPF(paciente.getCpf());
					paciente.setRg(pacienteCdastro.getRgField().getText());
					TratadorDeMascara.validaRg(paciente.getRg());
					paciente.setTelefone(pacienteCdastro.getTelField().getText().trim());
					paciente.setNome_mae(pacienteCdastro.getNomeMField().getText());
					paciente.setNome_pai(pacienteCdastro.getNomePField().getText());
					paciente.setDataNascimento(TratadorDeMascara.coletorDeData(pacienteCdastro.getNascField().getText()));
					paciente.getEndereco().setBairro(pacienteCdastro.getBairroField().getText());
					paciente.getEndereco().setCep(pacienteCdastro.getCepField().getText());
					paciente.getEndereco().setCidade(pacienteCdastro.getCidadeField().getText());
					paciente.getEndereco().setComplemento(pacienteCdastro.getComplementoField().getText());
					paciente.getEndereco().setEstado(""+pacienteCdastro.getEstadoBox().getItemAt(pacienteCdastro.getEstadoBox().getSelectedIndex()));
					paciente.getEndereco().setLogradouro(pacienteCdastro.getLogradouroField().getText().trim().replace(" ",""));
					paciente.getEndereco().setNumero(Integer.parseInt(pacienteCdastro.getNumeroField().getText()));
					paciente.getEndereco().setPais(""+pacienteCdastro.getPaisBox().getItemAt(pacienteCdastro.getPaisBox().getSelectedIndex()));
					paciente.getEndereco().setRua(pacienteCdastro.getRuaField().getText());
					
					fachada.salvarPaciente(paciente);
					if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
						limparCampos(pacienteCdastro);
					}else {
						pacienteCdastro.setVisible(false);
						limparCampos(pacienteCdastro);
					}
				} catch (BusinessException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (ValidacaoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				}

			}
		});



	}
	private void buscarPaciente() {
		try {
			//validar buscas, fazer busca por busca , tratar se nehum paciente for retornado!!!
			//if(telaPaciente.getDescricaoField().getText().equals("") && telaPaciente.getFiltroField().getText().equals("")) {
				ArrayList<Paciente> p = new ArrayList<Paciente>();
				p=(ArrayList<Paciente>) fachada.buscarPorBuscaPaciente(telaPaciente.getFiltroField().getText(),telaPaciente.getDescricaoField().getText());
				String [][] linha = new String[p.size()][5];
				int i=0;
				for(Paciente pac:p){
					linha[i][0] = pac.getNome();
					linha[i][1] = pac.getRg();
					linha[i][2] = pac.getCpf();
					linha[i][3] = pac.getTelefone();
					Calendar c = Calendar.getInstance();
					c.setTime(pac.getDataNascimento());
					linha[i][4] = c.get(c.DAY_OF_MONTH)+"/"+(c.get(c.MONTH)+1)+"/"+c.get(c.YEAR);
					i++;
				}
				DefaultTableModel d = new DefaultTableModel(linha,new String[] {
						"Nome","RG", "CPF", "Telefone", "Nascimento"
		 			});
			 			
				telaPaciente.getTable().setModel(d);
				telaPaciente.getTable().setShowGrid(true);
				telaPaciente.getTable().setShowHorizontalLines(true);
				telaPaciente.getTable().setShowVerticalLines(true);
				telaPaciente.getTable().setBackground(Color.white);
				telaPaciente.getTable().setFont(Propiedade.FONT1);
		//	}else {
//				String cpf = telaPaciente.getDescricaoField().getText().trim().replace(" ","");
//				Paciente paciente = fachada.buscarPorCpfPaciente(cpf);
//				String [][] linha = new String[1][5];
//				linha[0][0] = paciente.getNome();
//				linha[0][1] = paciente.getCpf();
//				linha[0][2] = paciente.getTelefone()+"";
//				linha[0][3] = paciente.getRg();
//				Calendar c = Calendar.getInstance();
//				c.setTime(paciente.getDataNascimento());
//				linha[0][4] = c.get(c.DAY_OF_MONTH)+"/"+(c.get(c.MONTH)+1)+"/"+c.get(c.YEAR);
//				DefaultTableModel d = new DefaultTableModel(linha,new String[] {
//		 				"Nome","RG", "CPF", "Telefone", "Nascimento"
//		 			});
//			 			
//				telaPaciente.getTable().setModel(d);
//				telaPaciente.getTable().setShowGrid(true);
//				telaPaciente.getTable().setShowHorizontalLines(true);
//				telaPaciente.getTable().setShowVerticalLines(true);
//				telaPaciente.getTable().setBackground(Color.white);
//				telaPaciente.getTable().setFont(Propiedade.FONT1);
//				
//			}
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void limparCampos(CadastroPacienteFrame pacienteCdastro) {
		pacienteCdastro.getNomeField().setText("");
		pacienteCdastro.getCpfField().setText("");
		pacienteCdastro.getRgField().setText("");
		pacienteCdastro.getTelField().setText("");
		pacienteCdastro.getNomeMField().setText("");
		pacienteCdastro.getNomePField().setText("");
		pacienteCdastro.getBairroField().setText("");
		pacienteCdastro.getCepField().setText("");
		pacienteCdastro.getCidadeField().setText("");
		pacienteCdastro.getComplementoField().setText("");
		pacienteCdastro.getLogradouroField().setText("");
		pacienteCdastro.getNumeroField().setText("");
		pacienteCdastro.getRuaField().setText("");
		pacienteCdastro.getNascField().setText("");
	}
}
