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
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFuncionario.JTableButtonMouseListener;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.parg.viacep.ViaCEP;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.parg.viacep.ViaCEPException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFuncionarioDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroMedicoDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.MedicoPanel;

public class ControleMedicoPanel {
	private MedicoPanel medicoPanel;
	private CadastroMedicoDialog cdtMedico;
	private Medico medicoCorrente;
	private boolean salvar;
	private IFachada fachada;
	public ControleMedicoPanel(MedicoPanel medicoPanel,CadastroMedicoDialog cdtMedico){
		this.medicoPanel = medicoPanel;
		this.cdtMedico = cdtMedico;
		this.medicoCorrente = new Medico();
		this.fachada = Fachada.getInstance();
		this.cdtMedico.setModal(true);
		//Eventos MPanel
		this.medicoPanel.getMeButton().addActionListener((ActionEvent e)->cdtMedico.setVisible(true));
		this.medicoPanel.getBuscaButton().addActionListener((ActionListener)-> buscaFiltro());
		JTableButtonMouseListener tableListner = new JTableButtonMouseListener(this.medicoPanel.getTable().getTable(),cdtMedico);
		this.medicoPanel.getTable().getTable().addMouseListener(tableListner);
		//Evnt CdtMedico
		this.cdtMedico.getBtnSalvar().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(salvar)
					salvarMed();
				else
					editarMed();
			}});
		this.cdtMedico.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
					salvar = true;
					limparCampos();
					medicoCorrente = new Medico();
		}
		});
		this.cdtMedico.getBuscarCepButton().addActionListener((ActionEvent e)->buscarCep());
	}
	private void buscarCep(){
		try {
			ViaCEP via = new ViaCEP(cdtMedico.getCepField().getText().replace("-", ""));
			cdtMedico.getCidadeField().setText(via.getLocalidade());
			cdtMedico.getEstadoField().setText(via.getUf());
			cdtMedico.getLogradouroField().setText(via.getLogradouro());
			cdtMedico.getBairroField().setText(via.getBairro());
		} catch (ViaCEPException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage()+", preencha o dados manualmente!");
		}
	}
	private void buscaFiltro(){
		try {
			String busca = medicoPanel.getFiltroField().getText();//Busca Info
			busca = "%" + busca + "%";
			System.out.println(busca);
			ArrayList<Medico> p = new ArrayList<Medico>();
			p = (ArrayList<Medico>) fachada.buscarInfoPorFiltroMedico(busca);
			preencherCamposBuscaTabela(p);

		} catch (BusinessException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
	}
	private void limparCampos(){
		cdtMedico.getCodField().setText("");
		cdtMedico.getBairroField().setText("");
		cdtMedico.getCepField().setText("");
	    cdtMedico.getCidadeField().setText("");;
		cdtMedico.getComplementoField().setText("");
		cdtMedico.getEstadoField().setText("");
		cdtMedico.getLogradouroField().setText("");
		cdtMedico.getNumeroField().setText("");
		cdtMedico.getRuaField().setText("");
		
		cdtMedico.getAdmBox().setSelectedItem("Não");
		cdtMedico.getAreaField().setText("");
		cdtMedico.getCpfField().setText("");
		cdtMedico.getEspecialidadeField().setText("");
		cdtMedico.getNomeField().setText("");
		cdtMedico.getLoginField().setText("");
		cdtMedico.getRgField().setText("");
		cdtMedico.getSenhaField().setText("");
	}
	public void  preencherSalvar() throws Exception{
		try {
			
		Endereco  end = medicoCorrente.getEndereco();
		end.setId(medicoCorrente.getId_endereco());
		
		end.setBairro(cdtMedico.getBairroField().getText());
		end.setCep(cdtMedico.getCepField().getText());
		end.setCidade(cdtMedico.getCidadeField().getText());
		end.setComplemento(cdtMedico.getComplementoField().getText());
		end.setEstado(cdtMedico.getEstadoField().getText());
		end.setLogradouro(cdtMedico.getLogradouroField().getText());
		end.setNumero(Integer.parseInt(cdtMedico.getNumeroField().getText()));
		end.setPais(cdtMedico.getPaisBox().getSelectedItem().toString());
		end.setRua(cdtMedico.getRuaField().getText());
		
		medicoCorrente.setEndereco(end);
		
		medicoCorrente.setAdmin(cdtMedico.getAdmBox().getSelectedItem().toString());
		medicoCorrente.setArea(cdtMedico.getAreaField().getText());
		medicoCorrente.setCpf(cdtMedico.getCpfField().getText().replace(".", "").replace("-",""));
		TratadorDeMascara.isCPF(medicoCorrente.getCpf());
		medicoCorrente.setEspecialidade(cdtMedico.getEspecialidadeField().getText());
		medicoCorrente.setNome(cdtMedico.getNomeField().getText());
		medicoCorrente.setNome_usuario(cdtMedico.getLoginField().getText());
		medicoCorrente.setRg(cdtMedico.getRgField().getText());
		TratadorDeMascara.validaRg(	medicoCorrente.getRg());
		medicoCorrente.setSenha(cdtMedico.getSenhaField().getText());
		} catch (ValidacaoException | NumberFormatException e) {
			throw new Exception(e.getMessage());
		}
		
	}
	public void salvarMed(){
		try {
			preencherSalvar();
			fachada.salvarMedico(medicoCorrente);
			medicoCorrente = new Medico();
			if ((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?")) == 0) {
				limparCampos();
			} else {
				cdtMedico.setVisible(false);
				limparCampos();
			}
		}catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	public void editarMed(){
		//Mostra que é pra editar
				try {
					preencherSalvar();
					fachada.editarMedico(medicoCorrente);
					JOptionPane.showMessageDialog(null,"Funcionario Editado com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				}finally{
					limparCampos();
					cdtMedico.setVisible(false);
					medicoCorrente = new Medico();
					salvar = true;
				}
	}
	public class JTableButtonMouseListener implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private CadastroMedicoDialog cdMedico = cdtMedico;

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
					System.out.println(""+getTable().getValueAt(getTable().getSelectedRow(),2));
					medicoCorrente = fachada.buscarPorBuscaMedico(""+getTable().getValueAt(getTable().getSelectedRow(),2)).get(0);
					
					Endereco end = medicoCorrente.getEndereco();
					end.setId(medicoCorrente.getId_endereco());
					cdtMedico.getCodField().setText(medicoCorrente.getId()+"");
					cdtMedico.getCidadeField().setText(end.getCidade());
					cdtMedico.getBairroField().setText(end.getBairro());
					cdtMedico.getCepField().setText(end.getCep());
					cdtMedico.getComplementoField().setText(end.getComplemento());
					cdtMedico.getEstadoField().setText(end.getEstado());
					cdtMedico.getLogradouroField().setText(end.getLogradouro());
					cdtMedico.getNumeroField().setText(end.getNumero()+"");
					cdtMedico.getRuaField().setText(end.getRua());
					
					cdtMedico.getAdmBox().setSelectedItem(medicoCorrente.getAdmin());
					cdtMedico.getAreaField().setText(medicoCorrente.getArea());
					cdtMedico.getCpfField().setText(medicoCorrente.getCpf());
					cdtMedico.getEspecialidadeField().setText(medicoCorrente.getEspecialidade());
					cdtMedico.getNomeField().setText(medicoCorrente.getNome());
					cdtMedico.getLoginField().setText(medicoCorrente.getNome_usuario());
					cdtMedico.getRgField().setText(medicoCorrente.getRg());
					cdtMedico.getSenhaField().setText(medicoCorrente.getSenha());
					
					cdtMedico.setVisible(true);
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

		public JTableButtonMouseListener(JTable table,CadastroMedicoDialog pacientes) {
			this.table = table;
			this.cdMedico = pacientes;
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
	private void preencherCamposBuscaTabela(ArrayList<Medico> p) {

		Object[][] linha = new Object[p.size()][5];
		int i = 0;
		for (Medico pac : p) {
			linha[i][0] = pac.getId()+"";
			linha[i][1] = pac.getNome();
			linha[i][2] = pac.getCpf();
			linha[i][3] = pac.getEspecialidade();
		
			JButton b = new JButton("Abrir");
			b.setForeground(Color.BLACK);
			b.setBackground(Color.white);
			b.setFont(Propiedade.FONT2);
			linha[i][4] = b;
			i++;
		}

		JTableButtonModel jtableButtonModel = new JTableButtonModel();
		jtableButtonModel.adcionar(linha, new String[] { "<html><table><tr><td height=50>Cod</td></tr></table></html>", "Nome", "CPF", "Especialidade", "Detalhes" });

		medicoPanel.getTable().getTable().setModel(jtableButtonModel);
		medicoPanel.getTable().getTable().setRowHeight(40);

		medicoPanel.getTable().getTable().setShowGrid(true);
		medicoPanel.getTable().getTable().setShowHorizontalLines(true);
		medicoPanel.getTable().getTable().setShowVerticalLines(true);
		medicoPanel.getTable().getTable().setBackground(Color.white);
		medicoPanel.getTable().getTable().setFont(Propiedade.FONT2);
		medicoPanel.getTable().getTable().getTableHeader().setFont(Propiedade.FONT2);
	}
}
