package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.app.App;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Corrente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroAdcionarNoEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFornecedoresFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFuncionarioDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroMedicoDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacienteFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroProdutoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroServicoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ConsultaFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LoginFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.MedicoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PagamentoContReceberPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PagamentoContaApagarPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.TelaPrincipal;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.VendaFrame;

public class ControlerLogin {
	private LoginFrame loginFrame;
	private IFachada fachada;
	private TelaPrincipal tela;
	private MedicoFrame medicoF;
	private CadastroProdutoFrame cadastroProdutoFrame;
	private CadastroAdcionarNoEstoque cadastroAdcionarNoEstoque;
	private CadastroPacienteFrame pacientePanel;
	private VendaFrame vendaFrame;
	private CadastroServicoFrame cadastroServicoFrame;
	private CadastroFornecedoresFrame cadastro = new CadastroFornecedoresFrame();
	private ConsultaFrame consulta ;
	private PagamentoContReceberPanel pagamentoContReceberPanel;
	private PagamentoContaApagarPanel pagamentoContaApagarPanel;
	
	public ControlerLogin(){
		//Colocar buttoes de Logoff aki
		this.loginFrame = new LoginFrame();
		fachada = Fachada.getInstance();
		this.loginFrame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				loginFrame.setLocation(e.getXOnScreen(),e.getYOnScreen());	
			}
			@Override
			public void mouseMoved(MouseEvent e) {

			}	
		});
		loginFrame.getSairButton().addActionListener((ActionEvent e)->System.exit(0));

		loginFrame.getEntrarBtn().addActionListener((ActionEvent e)->{
			if(buscarFunc()){
				if(tela == null){
					tela = TelaPrincipal.getInstance();
					this.iniciarControlesFunc();
					tela.getSairButton().addActionListener((ActionEvent e1) ->limparEvoltarFunc());
				}
				tela = TelaPrincipal.getInstance();
				tela.setVisible(true);
	
			}
			else if(buscarMed()){
				if(medicoF == null){
					medicoF = MedicoFrame.getInstance();
					iniciarControlesMed();
					medicoF.getBtnSair().addActionListener((ActionEvent e1) ->limparEvoltarMedico());
				}
				medicoF = MedicoFrame.getInstance();
				medicoF.setVisible(true);
				medicoF.getLblNomeMedico().setText(Corrente.medicoCorrente.getNome());
				medicoF.getAgendaPanel().getCalendario().setDate(new Date());
			
			}
		});

	}
	private void limparEvoltarFunc(){
		loginFrame.getLoginField().setText("");
		loginFrame.getSenhaField().setText("");
		tela.setVisible(false);
		loginFrame.setVisible(true);

		JTableButtonModel jtableButtonModel = new JTableButtonModel();
		jtableButtonModel.adcionar(new Object[][] {},new String[] {});
		tela.getCadatrosPanel().getTelaPacientes().getTable().getTable().setModel(jtableButtonModel);
		tela.getCadatrosPanel().getTelaFornecedor().getTable().getTable().setModel(jtableButtonModel);	
		tela.getCadatrosPanel().getTelaServico().getTable().getTable().setModel(jtableButtonModel);
		tela.getCadatrosPanel().getFuncionarioPanel().getTable().getTable().setModel(jtableButtonModel);
		tela.getCadatrosPanel().getMedicoPanel().getTable().getTable().setModel(jtableButtonModel);
	}
	private void limparEvoltarMedico(){
		loginFrame.getLoginField().setText("");
		loginFrame.getSenhaField().setText("");
		medicoF.setVisible(false);
		loginFrame.setVisible(true);
		medicoF.getAgendaPanel().getFiltroField().setText("");

		medicoF.getLaudoPanel().getFiltroField().setText("");
		medicoF.getLaudoPanel().getInicioData().setDate(null);
		medicoF.getLaudoPanel().getFimData().setDate(null);
		JTableButtonModel jtableButtonModel = new JTableButtonModel();
		jtableButtonModel.adcionar(new Object[][] {},new String[] {});
		medicoF.getLaudoPanel().getTable().getTable().setModel(jtableButtonModel);
		medicoF.getAgendaPanel().getTable().getTable().setModel(jtableButtonModel);	
	}
	private boolean buscarFunc(){
		try {
			String login = loginFrame.getLoginField().getText();
			String senha = loginFrame.getSenhaField().getText();
			Funcionario func  = fachada.buscaPorLogin_senhaFuncionario(login,senha);
			if(func == null)
				return false;
			loginFrame.setVisible(false);
			return true;
		} catch (BusinessException e) {
			return false;
		}
	}
	private boolean buscarMed(){
		try {
			String login = loginFrame.getLoginField().getText();
			String senha = loginFrame.getSenhaField().getText();
			Corrente.medicoCorrente = null;
			Corrente.medicoCorrente =  fachada.buscaPorLogin_senhaMedico(login,senha);
			if(Corrente.medicoCorrente == null)
				return false;
			loginFrame.setVisible(false);
			return true;
		} catch (BusinessException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage());
			return false;
		}
	}
	public TelaPrincipal getTela() {
		return tela;
	}
	public void setTela(TelaPrincipal tela) {
		this.tela = tela;
	}
	public MedicoFrame getMedicoF() {
		return medicoF;
	}
	public void setMedicoF(MedicoFrame medicoF) {
		this.medicoF = medicoF;
	}
	private void iniciarControlesFunc(){
		App.lookNimbus();
		cadastroProdutoFrame = new CadastroProdutoFrame();
		cadastroAdcionarNoEstoque = new CadastroAdcionarNoEstoque();
		pacientePanel = new CadastroPacienteFrame();
		vendaFrame = new VendaFrame();
		cadastroServicoFrame = new CadastroServicoFrame();
		pagamentoContaApagarPanel = new PagamentoContaApagarPanel();
		pagamentoContReceberPanel = new PagamentoContReceberPanel();
		cadastro = new CadastroFornecedoresFrame();
		consulta = new ConsultaFrame();//ainda tem q criar a agenda
		new ControleFuncionario(tela.getCadatrosPanel().getFuncionarioPanel(), new CadastroFuncionarioDialog());
		new ControlerAbaAgenda(tela.getAgendaPanel());
		ControlePacientesPanel controlePacientesPanel = new ControlePacientesPanel(tela.getCadatrosPanel().getTelaPacientes(), pacientePanel);
		ControleFinanceiro financeiro = new ControleFinanceiro(tela.getFinanceiroPanel(), vendaFrame,new PagamentoContReceberPanel());
		ControleContasPagar controleContasPagar = new ControleContasPagar(tela.getFinanceiroPanel().getContasApagarPanel(), tela.getFinanceiroPanel(),pagamentoContaApagarPanel);
		ControleCadastros controleCadastro = new ControleCadastros(tela.getCadatrosPanel());
		ControleServico controleServico = new ControleServico(tela.getCadatrosPanel().getTelaServico(), cadastroServicoFrame);
		ControleFornecedor controleFornecedor = new ControleFornecedor(tela.getCadatrosPanel().getTelaFornecedor(), cadastro);
		ControleEstoque controleEstoque = new ControleEstoque(tela.getEstoquePanel());
		ControleProdutoPanel controleProduto = new ControleProdutoPanel(tela.getEstoquePanel().getPanel_7(),cadastroProdutoFrame);
		ControleMovimentacaoPanel controleMovimentacaoPanel = new ControleMovimentacaoPanel(tela.getEstoquePanel().getPanel_8(),cadastroAdcionarNoEstoque );
		//ControleContasPagar controleContasPagar = new ControleContasPagar(tela.getFinanceiroPanel().getContasApagarPanel(),tela.getFinanceiroPanel(),pagamentoContaApagarPanel);
		ControleMedicoPanel ctm = new ControleMedicoPanel(tela.getCadatrosPanel().getMedicoPanel(),new CadastroMedicoDialog());
		new ControleTelaPrincipal(tela);
	}
	private void iniciarControlesMed(){
		new ControlerMedicoFrame(medicoF);
		new ControlerAgendaMedico(medicoF.getAgendaPanel());
		new ControlerLaudoMedico(medicoF.getLaudoPanel());
	}
}
