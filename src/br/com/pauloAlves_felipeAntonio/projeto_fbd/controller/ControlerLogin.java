package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LoginFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.TelaPrincipal;

public class ControlerLogin {
	LoginFrame loginFrame;
	IFachada fachada;
	TelaPrincipal tela;
	public ControlerLogin(	LoginFrame loginFrame, TelaPrincipal tela){
		this.loginFrame = loginFrame;
		this.tela = tela;
		fachada = Fachada.getInstance();
		this.loginFrame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				loginFrame.setLocation(e.getXOnScreen(),e.getYOnScreen());
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		loginFrame.getEntrarBtn().addActionListener((ActionEvent e)->buscarFunc());
	}
	private void buscarFunc(){
		try {
			String login = loginFrame.getLoginField().getText();
			String senha = loginFrame.getSenhaField().getText();
			Funcionario func  = fachada.buscaPorLogin_senhaFuncionario(login,senha);
			loginFrame.setVisible(false);
			tela.setVisible(true);
		} catch (BusinessException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}
