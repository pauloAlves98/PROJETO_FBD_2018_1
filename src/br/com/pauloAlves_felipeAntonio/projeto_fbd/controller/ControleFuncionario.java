package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFuncionarioDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacienteFrame;

public class ControleFuncionario {
	CadastroFuncionarioDialog cdtFuncDialog;
	IFachada fachada;
	
	public ControleFuncionario(CadastroFuncionarioDialog cdtFuncDialog) {
		this.cdtFuncDialog = cdtFuncDialog;
		fachada = Fachada.getInstance();
		this.cdtFuncDialog.getBtnSalvar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Funcionario func = new Funcionario();
					Endereco end = new Endereco();
					Cargo cargo = new Cargo();
					func.setAdmim(cdtFuncDialog.getAdmBox().getSelectedItem().toString());
					cargo.setNome(cdtFuncDialog.getCargoField().getText());
					cargo.setDescricao_cargo(cdtFuncDialog.getDescricaoArea().getText());
					func.setCargo(cargo);
					func.setCpf(cdtFuncDialog.getCpfField().getText().replace(".","").replace("-",""));
					TratadorDeMascara.isCPF(func.getCpf());
					func.setData_acesso(TratadorDeMascara.coletorDeData(cdtFuncDialog.getNascField().getText()));
					end.setBairro(cdtFuncDialog.getBairroField().getText());
					end.setCep(cdtFuncDialog.getCepField().getText());
					end.setCidade(cdtFuncDialog.getCidadeField().getText());
					end.setComplemento(cdtFuncDialog.getComplementoField().getText());
					end.setEstado(""+cdtFuncDialog.getEstadoBox().getItemAt(cdtFuncDialog.getEstadoBox().getSelectedIndex()));
					end.setLogradouro(cdtFuncDialog.getLogradouroField().getText().trim().replace(" ",""));
					end.setNumero(Integer.parseInt(cdtFuncDialog.getNumeroField().getText()));
					end.setPais(""+cdtFuncDialog.getPaisBox().getItemAt(cdtFuncDialog.getPaisBox().getSelectedIndex()));
					end.setRua(cdtFuncDialog.getRuaField().getText());
					func.setEndereco(end);
					func.setNome(cdtFuncDialog.getNomeField().getText());
					func.setNome_usuario(cdtFuncDialog.getLoginField().getText());
					func.setRg(cdtFuncDialog.getRgField().getText());
					TratadorDeMascara.validaRg(func.getRg());
					func.setSenha(cdtFuncDialog.getSenhaField().getText().replace(" ",""));
					func.setTelefone(cdtFuncDialog.getTelField().getText().trim());
					fachada.salvarFuncionario(func);
					if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
						limparCampos(cdtFuncDialog);
					}else {
						cdtFuncDialog.setVisible(false);
						limparCampos(cdtFuncDialog);
					}
				} catch (ValidacaoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				} catch (BusinessException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
	}
	private void limparCampos(CadastroFuncionarioDialog cdtFuncDialog) {
		cdtFuncDialog.getNomeField().setText("");
		cdtFuncDialog.getCpfField().setText("");
		cdtFuncDialog.getRgField().setText("");
		cdtFuncDialog.getTelField().setText("");
		cdtFuncDialog.getLoginField().setText("");
		cdtFuncDialog.getSenhaField().setText("");
		cdtFuncDialog.getBairroField().setText("");
		cdtFuncDialog.getCepField().setText("");
		cdtFuncDialog.getCidadeField().setText("");
		cdtFuncDialog.getComplementoField().setText("");
		cdtFuncDialog.getLogradouroField().setText("");
		cdtFuncDialog.getNumeroField().setText("");
		cdtFuncDialog.getRuaField().setText("");
		cdtFuncDialog.getNascField().setText("");
		cdtFuncDialog.getDescricaoArea().setText("");
	}
}
