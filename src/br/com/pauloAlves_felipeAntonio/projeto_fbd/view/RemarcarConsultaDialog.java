package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class RemarcarConsultaDialog extends JDialog
{
	private CadastroConsultaPanel cdtC;
	private JButton btnCancelarRemarcao;
	public RemarcarConsultaDialog(){
		setSize(400,358);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		cdtC = new CadastroConsultaPanel();
		cdtC.getLblCadastroDeConsultas().setText("Remarcar Consulta");
		this.getContentPane().add(cdtC,BorderLayout.CENTER);
		cdtC.getPacienteField().setEditable(false);
		cdtC.getMedicoField().setEditable(false);
		btnCancelarRemarcao = new JButton("Cancelar Remarca\u00E7\u00E3o");
		btnCancelarRemarcao.setBackground(Color.WHITE);
		btnCancelarRemarcao.setFont(new Font("Tahoma", Font.BOLD, 12));
		cdtC.add(btnCancelarRemarcao, BorderLayout.SOUTH);
		btnCancelarRemarcao.setBackground(Color.red);
		btnCancelarRemarcao.setForeground(Color.WHITE);
		setModal(true);
	}
	public JButton getBtnCancelarRemarcao() {
		return btnCancelarRemarcao;
	}

	public void setBtnCancelarRemarcao(JButton btnCancelarRemarcao) {
		this.btnCancelarRemarcao = btnCancelarRemarcao;
	}

	public CadastroConsultaPanel getCdtC() {
		return cdtC;
	}
	public void setCdtC(CadastroConsultaPanel cdtC) {
		this.cdtC = cdtC;
	}


}
