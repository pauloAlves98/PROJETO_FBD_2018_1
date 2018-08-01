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
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
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
	private Funcionario funcionarioCorrente;
	private FuncionarioPanel funcPanel;
	private boolean salvar = true;
	public ControleFuncionario(FuncionarioPanel funcPanel, CadastroFuncionarioDialog cdtFuncDialog) {
		this.cdtFuncDialog = cdtFuncDialog;
		cdtFuncDialog.setModal(true);
		funcionarioCorrente = new Funcionario();
		fachada = Fachada.getInstance();
		this.funcPanel = funcPanel;

		this.funcPanel.getFuncionarioButton().addActionListener((ActionEvent e) -> cdtFuncDialog.setVisible(true));

		this.cdtFuncDialog.getBtnSalvar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(salvar)
					salvarFunc();
				else
					editarFunc();
			}
		});
		this.funcPanel.getBuscaButton().addActionListener((ActionEvent e) -> buscarFuncionario());
		JTableButtonMouseListener tableListner = new JTableButtonMouseListener(funcPanel.getTable().getTable(),cdtFuncDialog);
		funcPanel.getTable().getTable().addMouseListener(tableListner);
		cdtFuncDialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
					salvar = true;
					limparCampos(cdtFuncDialog);
					funcionarioCorrente = new Funcionario();
		}
		});
	}

	private void buscarFuncionario() {
		try {
			String busca = funcPanel.getFiltroField().getText();//Busca Info
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
		cdtFuncDialog.getCodField().setText("");
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
	public class JTableButtonMouseListener implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private CadastroFuncionarioDialog cdFuncDialog = cdtFuncDialog;

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

				try {
					salvar = false;//Mostra qu é pra editar

					funcionarioCorrente = fachada.buscarPorBuscaFuncionario(""+getTable().getValueAt(getTable().getSelectedRow(),1)).get(0);
					cdFuncDialog.getCodField().setText(funcionarioCorrente.getId()+"");
					cdFuncDialog.getNomeField().setText(funcionarioCorrente.getNome());
					cdFuncDialog.getCpfField().setText(funcionarioCorrente.getCpf());
					cdFuncDialog.getRgField().setText(funcionarioCorrente.getRg());
					cdFuncDialog.getTelField().setText(funcionarioCorrente.getTelefone());
					cdFuncDialog.getLoginField().setText(funcionarioCorrente.getNome_usuario());
					cdFuncDialog.getSenhaField().setText(funcionarioCorrente.getSenha());
					cdFuncDialog.getAdmBox().setSelectedItem(funcionarioCorrente.getAdmim());
					Calendar c2 = Calendar.getInstance();
					c2.setTime(funcionarioCorrente.getData_acesso());
					cdFuncDialog.getNascField().setText((c2.get(c2.DAY_OF_MONTH)<10?"0"+c2.get(c2.DAY_OF_MONTH):c2.get(c2.DAY_OF_MONTH))+"/"+((c2.get(c2.MONTH)+1)<10?"0"+(c2.get(c2.MONTH)+1):(c2.get(c2.MONTH)+1))+"/"+c2.get(c2.YEAR));
					cdFuncDialog.getCargoField().setText(funcionarioCorrente.getCargo().getNome());
					cdFuncDialog.getDescricaoArea().setText(funcionarioCorrente.getCargo().getDescricao_cargo());
					cdFuncDialog.getBairroField().setText(funcionarioCorrente.getEndereco().getBairro());
					cdFuncDialog.getCepField().setText(funcionarioCorrente.getEndereco().getCep());
					cdFuncDialog.getCidadeField().setText(funcionarioCorrente.getEndereco().getCidade());
					cdFuncDialog.getComplementoField().setText(funcionarioCorrente.getEndereco().getComplemento());
					cdFuncDialog.getLogradouroField().setText(funcionarioCorrente.getEndereco().getLogradouro());
					cdFuncDialog.getNumeroField().setText(""+funcionarioCorrente.getEndereco().getNumero());
					cdFuncDialog.getRuaField().setText(funcionarioCorrente.getEndereco().getRua());
					
					cdtFuncDialog.setVisible(true);
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

		public JTableButtonMouseListener(JTable table,CadastroFuncionarioDialog pacientes) {
			this.table = table;
			this.cdFuncDialog = pacientes;
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
	private void preencherSalvar(){
		try {
			
			//Funcionario corrente foi preenchido quando se realizou o clik no botão abrir!
			Endereco end = funcionarioCorrente.getEndereco();
			Cargo cargo = funcionarioCorrente.getCargo();
			end.setId(funcionarioCorrente.getId_endereco());//lembrar 
			cargo.setId(funcionarioCorrente.getId_cargos());//lembrar pois precisace deste no daoComum para cargos!
			
			funcionarioCorrente.setAdmim(cdtFuncDialog.getAdmBox().getSelectedItem().toString());
			cargo.setNome(cdtFuncDialog.getCargoField().getText());
			cargo.setDescricao_cargo(cdtFuncDialog.getDescricaoArea().getText());
			funcionarioCorrente.setCargo(cargo);
			funcionarioCorrente.setCpf(cdtFuncDialog.getCpfField().getText().replace(".", "").replace("-", ""));
			TratadorDeMascara.isCPF(funcionarioCorrente.getCpf());
			funcionarioCorrente.setData_acesso(TratadorDeMascara.coletorDeData(cdtFuncDialog.getNascField().getText()));
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
			funcionarioCorrente.setEndereco(end);
			funcionarioCorrente.setNome(cdtFuncDialog.getNomeField().getText());
			funcionarioCorrente.setNome_usuario(cdtFuncDialog.getLoginField().getText());
			funcionarioCorrente.setRg(cdtFuncDialog.getRgField().getText());
			TratadorDeMascara.validaRg(funcionarioCorrente.getRg());
			funcionarioCorrente.setSenha(cdtFuncDialog.getSenhaField().getText().replace(" ", ""));
			funcionarioCorrente.setTelefone(cdtFuncDialog.getTelField().getText().trim());
			
		} catch (ValidacaoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	public void salvarFunc(){
		try {
			preencherSalvar();
			fachada.salvarFuncionario(funcionarioCorrente);
			funcionarioCorrente = new Funcionario();
			if ((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?")) == 0) {
				limparCampos(cdtFuncDialog);
			} else {
				cdtFuncDialog.setVisible(false);
				limparCampos(cdtFuncDialog);
			}
		}catch (BusinessException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	private  void editarFunc(){
		//Mostra que é pra editar
		try {
			preencherSalvar();
			fachada.editarFuncionario(funcionarioCorrente);
			JOptionPane.showMessageDialog(null,"Funcionario Editado com sucesso!");
		} catch (BusinessException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage());
		}finally{
			limparCampos(cdtFuncDialog);
			cdtFuncDialog.setVisible(false);
			funcionarioCorrente = new Funcionario();
			salvar = true;
		}
		
	}
}
