package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LoginFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.TelaPrincipal;

public class ControlerLogin {
	LoginFrame loginFrame;
	IFachada fachada;
	public ControlerLogin(	LoginFrame loginFrame, TelaPrincipal tela){
		this.loginFrame = loginFrame;
		fachada = Fachada.getInstance();
		loginFrame.getEntrarBtn().addActionListener((ActionEvent e)->buscarFunc());


		
	}
	private void buscarFunc(){
		//eu mechi na view ,  controler e dao funcionario!!!
		//Funcionario buscar = fachada.buscarPorLogin() criar fachada ,u
	}
}
