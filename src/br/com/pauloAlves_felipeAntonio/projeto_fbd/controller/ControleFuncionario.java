package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFuncionarioDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.FuncionarioPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;

public class ControleFuncionario {
	private CadastroFuncionarioDialog cdtFuncDialog;
	private IFachada fachada;
	private Funcionario funcionario;
	private FuncionarioPanel funcPanel;

	public ControleFuncionario(FuncionarioPanel funcPanel, CadastroFuncionarioDialog cdtFuncDialog) {
		this.cdtFuncDialog = cdtFuncDialog;
		fachada = Fachada.getInstance();
		this.funcPanel = funcPanel;

		this.funcPanel.getFuncionarioButton().addActionListener((ActionEvent e) -> cdtFuncDialog.setVisible(true));

		this.cdtFuncDialog.getBtnSalvar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario func = new Funcionario();
					Endereco end = new Endereco();
					Cargo cargo = new Cargo();
					func.setAdmim(cdtFuncDialog.getAdmBox().getSelectedItem().toString());
					cargo.setNome(cdtFuncDialog.getCargoField().getText());
					cargo.setDescricao_cargo(cdtFuncDialog.getDescricaoArea().getText());
					func.setCargo(cargo);
					func.setCpf(cdtFuncDialog.getCpfField().getText().replace(".", "").replace("-", ""));
					TratadorDeMascara.isCPF(func.getCpf());
					func.setData_acesso(TratadorDeMascara.coletorDeData(cdtFuncDialog.getNascField().getText()));
					end.setBairro(cdtFuncDialog.getBairroField().getText());
					end.setCep(cdtFuncDialog.getCepField().getText());
					end.setCidade(cdtFuncDialog.getCidadeField().getText());
					end.setComplemento(cdtFuncDialog.getComplementoField().getText());
					end.setEstado(""
							+ cdtFuncDialog.getEstadoBox().getItemAt(cdtFuncDialog.getEstadoBox().getSelectedIndex()));
					end.setLogradouro(cdtFuncDialog.getLogradouroField().getText().trim().replace(" ", ""));
					end.setNumero(Integer.parseInt(cdtFuncDialog.getNumeroField().getText()));
					end.setPais(
							"" + cdtFuncDialog.getPaisBox().getItemAt(cdtFuncDialog.getPaisBox().getSelectedIndex()));
					end.setRua(cdtFuncDialog.getRuaField().getText());
					func.setEndereco(end);
					func.setNome(cdtFuncDialog.getNomeField().getText());
					func.setNome_usuario(cdtFuncDialog.getLoginField().getText());
					func.setRg(cdtFuncDialog.getRgField().getText());
					TratadorDeMascara.validaRg(func.getRg());
					func.setSenha(cdtFuncDialog.getSenhaField().getText().replace(" ", ""));
					func.setTelefone(cdtFuncDialog.getTelField().getText().trim());
					fachada.salvarFuncionario(func);
					if ((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?")) == 0) {
						limparCampos(cdtFuncDialog);
					} else {
						cdtFuncDialog.setVisible(false);
						limparCampos(cdtFuncDialog);
					}
				} catch (ValidacaoException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (BusinessException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		this.funcPanel.getBuscaButton().addActionListener((ActionEvent e) -> buscarFuncionario());
	}

	private void buscarFuncionario() {
		try {
			String busca = funcPanel.getFiltroField().getText();
			busca = "%" + busca + "%";
			System.out.println(busca);
			ArrayList<Funcionario> p = new ArrayList<Funcionario>();
			p = (ArrayList<Funcionario>) fachada.buscarInfoPorFiltroFuncionario(busca.trim());
			preencherCamposBuscaTabela(p);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private void preencherCamposBuscaTabela(ArrayList<Funcionario> p) {

		Object[][] linha = new Object[p.size()][5];
		int i = 0;
		for (Funcionario pac : p) {
			linha[i][0] = pac.getNome();
			linha[i][1] = pac.getCpf();
			linha[i][2] = pac.getTelefone();
			Calendar c = Calendar.getInstance();
			c.setTime(pac.getData_acesso());
			linha[i][3] = c.get(c.DAY_OF_MONTH) + "/" + (c.get(c.MONTH) + 1) + "/" + c.get(c.YEAR);
			JButton b = new JButton("Abrir");
			b.setForeground(Color.BLACK);
			b.setBackground(Color.white);
			b.setFont(Propiedade.FONT2);
			linha[i][4] = b;
			i++;
		}

		JTableButtonModel jtableButtonModel = new JTableButtonModel();
		jtableButtonModel.adcionar(linha, new String[] { "Nome", "CPF", "Telefone", "Nascimento", "Cadastro" });

		funcPanel.getTable().getTable().setModel(jtableButtonModel);
		funcPanel.getTable().getTable().setRowHeight(40);

		funcPanel.getTable().getTable().setShowGrid(true);
		funcPanel.getTable().getTable().setShowHorizontalLines(true);
		funcPanel.getTable().getTable().setShowVerticalLines(true);
		funcPanel.getTable().getTable().setBackground(Color.white);
		funcPanel.getTable().getTable().setFont(Propiedade.FONT2);
	}

}
