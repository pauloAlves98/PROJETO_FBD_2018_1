package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.app.App;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.enums.EnumAgendaView;

public class MedicoFrame extends JFrame{
	JLabel lblNomeMedico;
	JButton agendaB;
	JButton Pacientes;
	JButton btnSair;
	private VisualizarAgendaPanel agendaPanel;
	private CardLayout card;
	private JPanel panelCenter;
	private LaudoPanel laudoPanel;
	private static MedicoFrame instance;
	private MedicoFrame(){
		App.lookNimbus();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(d);
		JPanel panel = new JPanel(null);
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(1000,100));
		PaneGradiente paneNorth = new PaneGradiente(Propiedade.cor1,Color.BLACK);
		paneNorth.setPreferredSize(new Dimension(1000,200));
		getContentPane().add(paneNorth,BorderLayout.NORTH);
		paneNorth.setLayout(new BorderLayout(0, 0));
	
		lblNomeMedico = new JLabel("Nome M\u00E9dico");
		lblNomeMedico.setLocation(10, 31);
		lblNomeMedico.setSize(378, 58);
		lblNomeMedico.setFont(new Font("Segoe UI Light", Font.BOLD, 28));
		lblNomeMedico.setForeground(Color.WHITE);
		panel.add(lblNomeMedico);
		paneNorth.add(panel,BorderLayout.NORTH);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.DARK_GRAY);
		paneNorth.add(toolBar, BorderLayout.SOUTH);
	    agendaB = new JButton("Agenda",new ImageIcon("Res/images.png"));
		agendaB.setFont(new Font("Tahoma", Font.BOLD, 12));
		agendaB.setForeground(Color.WHITE);
		agendaB.setBackground(Color.BLACK);
		agendaB .setOpaque(false);
		toolBar.add(agendaB);
		toolBar.setOpaque(false);
		
		Pacientes = new JButton("Paciente",new ImageIcon("Res/paciente.png"));
		Pacientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		Pacientes.setForeground(Color.WHITE);
		toolBar.add(Pacientes);
		Pacientes.setOpaque(false);
		btnSair = new JButton("Sair",new ImageIcon("Res/sair64.png"));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setForeground(Color.WHITE);
		toolBar.add(btnSair);
		btnSair.setOpaque(false);
		
		agendaPanel = new VisualizarAgendaPanel();
		
		card = new CardLayout();
		panelCenter = new JPanel();
		
		laudoPanel = new LaudoPanel();
		add(panelCenter,BorderLayout.CENTER);
		card.addLayoutComponent(agendaPanel,EnumAgendaView.AGENDA.getValor());
		card.addLayoutComponent(laudoPanel,EnumAgendaView.LAUDO.getValor());
		panelCenter.add(agendaPanel);
		panelCenter.add(laudoPanel);
		panelCenter.setLayout(card);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		card.show(panelCenter,EnumAgendaView.AGENDA.getValor() );
		setVisible(false);	
	}
	
	public LaudoPanel getLaudoPanel() {
		return laudoPanel;
	}

	public void setLaudoPanel(LaudoPanel laudoPanel) {
		this.laudoPanel = laudoPanel;
	}

	public static MedicoFrame getInstance(){
		if(instance ==null){
			instance  = new MedicoFrame();
		}
		return instance;
			
	}
	public JLabel getLblNomeMedico() {
		return lblNomeMedico;
	}

	public void setLblNomeMedico(JLabel lblNomeMedico) {
		this.lblNomeMedico = lblNomeMedico;
	}

	public JButton getAgendaB() {
		return agendaB;
	}

	public void setAgendaB(JButton agendaB) {
		this.agendaB = agendaB;
	}

	public JButton getPacientes() {
		return Pacientes;
	}

	public void setPacientes(JButton pacientes) {
		Pacientes = pacientes;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}

	public VisualizarAgendaPanel getAgendaPanel() {
		return agendaPanel;
	}

	public void setAgendaPanel(VisualizarAgendaPanel agendaPanel) {
		this.agendaPanel = agendaPanel;
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

}
