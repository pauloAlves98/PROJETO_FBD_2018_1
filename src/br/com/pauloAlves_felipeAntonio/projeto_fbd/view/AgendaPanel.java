package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;

public class AgendaPanel extends JPanel{
	private VisualizarAgendaPanel vAgendaPanel;;
	private JButton btnNovaConsulta;
	private JButton visualizarAgendaButton;
	private CadastroConsultaPanel cConsulta;
	private CardLayout card;
	private JPanel pCard;
	public AgendaPanel(){
	   setLayout(new BorderLayout());

		
		setBackground(Color.WHITE);
		
		PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.black);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 809, 99);
		panel.setPreferredSize(new Dimension(809,99));
		add(panel,BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblFinanceiro = new JLabel("Agenda");
		lblFinanceiro.setBounds(10, 0, 201, 59);
		panel.add(lblFinanceiro);
		lblFinanceiro.setFont(Propiedade.FONT3);
		lblFinanceiro.setForeground(Color.WHITE);
		btnNovaConsulta = new JButton("Nova Consulta");
 		btnNovaConsulta.setBounds(147, 55, 138, 33);
		btnNovaConsulta.setFont(Propiedade.FONT2);
		btnNovaConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		btnNovaConsulta.setBackground(Color.WHITE);
		//btnNovaConsulta.setBorder(null);
		btnNovaConsulta.setFocusPainted(false);
		
		
		visualizarAgendaButton = new JButton("Visualizar");
		visualizarAgendaButton.setFont(Propiedade.FONT2);
		visualizarAgendaButton.setBounds(10, 55, 132, 33);
		visualizarAgendaButton.setHorizontalAlignment(SwingConstants.CENTER);
		visualizarAgendaButton.setBackground(Color.WHITE);
		//visualizarAgendaButon.setBorder(null);
		visualizarAgendaButton.setFocusPainted(false);
		
		panel.add(btnNovaConsulta);
 		panel.add(visualizarAgendaButton);
 	
 		
 		pCard = new JPanel();	
 		add(pCard,BorderLayout.CENTER);
 		cConsulta = new CadastroConsultaPanel();
 		pCard.add(cConsulta,BorderLayout.CENTER);
		vAgendaPanel = new VisualizarAgendaPanel();
		pCard.add(vAgendaPanel,BorderLayout.CENTER);
		card = new CardLayout();
		card.addLayoutComponent(vAgendaPanel,"Visualizar");
		card.addLayoutComponent(cConsulta,"Consulta");
		pCard.setLayout(card);
		card.show(pCard,"Visualizar");
		
	}
	
	public JPanel getpCard() {
		return pCard;
	}

	public void setpCard(JPanel pCard) {
		this.pCard = pCard;
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public VisualizarAgendaPanel getvAgendaPanel() {
		return vAgendaPanel;
	}

	public void setvAgendaPanel(VisualizarAgendaPanel vAgendaPanel) {
		this.vAgendaPanel = vAgendaPanel;
	}

	public JButton getBtnNovaConsulta() {
		return btnNovaConsulta;
	}

	public void setBtnNovaConsulta(JButton btnNovaConsulta) {
		this.btnNovaConsulta = btnNovaConsulta;
	}

	public JButton getVisualizarAgendaButton() {
		return visualizarAgendaButton;
	}

	public void setVisualizarAgendaButton(JButton visualizarAgendaButton) {
		this.visualizarAgendaButton = visualizarAgendaButton;
	}

	public CadastroConsultaPanel getcConsulta() {
		return cConsulta;
	}

	public void setcConsulta(CadastroConsultaPanel cConsulta) {
		this.cConsulta = cConsulta;
	}

//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.setSize(400, 400);
//		f.getContentPane().add(new AgendaPanel());
//		f.setVisible(true);
//	}
}
