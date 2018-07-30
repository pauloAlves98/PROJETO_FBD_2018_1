package br.com.pauloAlves_felipeAntonio.projeto_fbd.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleCadastros;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFinanceiro;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleMovimentacaoPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlePacientesPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleProdutoPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleServico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlerAgenda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlerLogin;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroAdcionarNoEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFornecedoresFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFuncionarioDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacienteFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroProdutoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroServicoFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ConsultaFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LoginFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.TelaPrincipal;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.VendaFrame;

public class App {
	public static void lookPadrao(){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Passando LookAndFeel padrão do sistema operacional
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println("Nao Pegou");
		}

	}
	public static void lookNimbus(){
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {
			   // If Nimbus is not available, you can set the GUI to another look and feel.
			}
}
	public static void main(String[] args) {
		//lookNimbus();
		
		IFachada fachada = Fachada.getInstance();
		TelaPrincipal tela = new TelaPrincipal();
		LoginFrame login = new LoginFrame();
		lookNimbus();
		CadastroProdutoFrame cadastroProdutoFrame = new CadastroProdutoFrame();
		CadastroAdcionarNoEstoque cadastroAdcionarNoEstoque = new CadastroAdcionarNoEstoque();
		CadastroPacienteFrame pacientePanel = new CadastroPacienteFrame();
		VendaFrame vendaFrame = new VendaFrame();
		CadastroServicoFrame cadastroServicoFrame = new CadastroServicoFrame();
		CadastroFornecedoresFrame cadastro = new CadastroFornecedoresFrame();
		ConsultaFrame consulta = new ConsultaFrame();//ainda tem q criar a agenda
		
		new ControlerLogin(login,tela);
		new ControleFuncionario(tela.getCadatrosPanel().getFuncionarioPanel(), new CadastroFuncionarioDialog());
		new ControlerAgenda(tela.getAgendaPanel());
		ControlePacientesPanel controlePacientesPanel = new ControlePacientesPanel(tela.getCadatrosPanel().getTelaPacientes(), pacientePanel);
		ControleFinanceiro controleFinanceiro = new ControleFinanceiro(tela.getFinanceiroPanel(), vendaFrame);
		ControleCadastros controleCadastro = new ControleCadastros(tela.getCadatrosPanel());
		ControleServico controleServico = new ControleServico(tela.getCadatrosPanel().getTelaServico(), cadastroServicoFrame);
		ControleFornecedor controleFornecedor = new ControleFornecedor(tela.getCadatrosPanel().getTelaFornecedor(), cadastro);
		ControleEstoque controleEstoque = new ControleEstoque(tela.getEstoquePanel());
		ControleProdutoPanel controleProduto = new ControleProdutoPanel(tela.getEstoquePanel().getPanel_7(),cadastroProdutoFrame);
		ControleMovimentacaoPanel controleMovimentacaoPanel = new ControleMovimentacaoPanel(tela.getEstoquePanel().getPanel_8(),cadastroAdcionarNoEstoque );

	}

}
