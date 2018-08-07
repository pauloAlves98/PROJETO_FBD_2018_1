package br.com.pauloAlves_felipeAntonio.projeto_fbd.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleCadastros;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFinanceiro;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleMedicoPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleMovimentacaoPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlePacientesPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleProdutoPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleServico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlerAbaAgenda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControlerLogin;
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
		
		
		new ControlerLogin();
//		
	}

}
