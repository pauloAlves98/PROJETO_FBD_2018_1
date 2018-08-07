package br.com.pauloAlves_felipeAntonio.projeto_fbd.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;

public class FinanceiroPanel extends JPanel {
	private IFachada fachada;
	private JLabel lblValorCaixa,lblValorReceber;
	private JButton btnNovaVenda,btnDashoroad,btnContasApagar;
	private JPanel panel_4;
	private ContasApagarPanel contasApagarPanel;
	private ContasAreceberPanel contasAreceberPanel;
	/**
	 * Create the panel.
	 */
	public FinanceiroPanel() {
		try {
			fachada = Fachada.getInstance();
			setLayout(new BorderLayout());
	
			
			setBackground(Color.WHITE);
			
			PaneGradiente panel = new PaneGradiente(Propiedade.cor1,Color.black);
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 809, 90);
			panel.setPreferredSize(new Dimension(809,99));
			add(panel,BorderLayout.NORTH);
			panel.setLayout(null);
			
			btnDashoroad = new JButton("Contas a Receber");
			btnDashoroad.setFont(Propiedade.FONT2);
			btnDashoroad.setBackground(Color.WHITE);
			btnDashoroad.setBounds(10, 55, 170, 33);
			btnDashoroad.setBorder(null);
			btnDashoroad.setFocusPainted(false);
			panel.add(btnDashoroad);
			
			btnContasApagar = new JButton("Contas a Pagar");
			btnContasApagar.setFont(Propiedade.FONT2);
			btnContasApagar.setBackground(Color.WHITE);
			btnContasApagar.setBounds(187, 55, 160, 33);
			btnContasApagar.setBorder(null);
			btnContasApagar.setFocusPainted(false);
			panel.add(btnContasApagar);
			
			JLabel lblFinanceiro = new JLabel("Financeiro");
			lblFinanceiro.setBounds(10, 0, 201, 59);
			panel.add(lblFinanceiro);
			lblFinanceiro.setFont(Propiedade.FONT3);
			lblFinanceiro.setForeground(Color.WHITE);
			
			panel_4 = new JPanel();
			panel_4.setBounds(0, 95, 900, 600);
			add(panel_4,BorderLayout.CENTER);
			panel_4.setBackground(Color.white);
			panel_4.setLayout(new BorderLayout(0, 0));
			
	//		PaneGradiente panel_2 = new PaneGradiente(Propiedade.cor2,Color.black);;
	//		panel_2.setBounds(332, 0, 256, 86);
	//		panel_4.add(panel_2);
	//		panel_2.setBorder(new LineBorder(Color.BLACK,1,true));
	//		//panel_2.setBackground(Color.WHITE);
	//		panel_2.setLayout(null);
			PaneGradiente panel_3 = new PaneGradiente(Color.black,Propiedade.cor3);
			//panel_3.setBackground(Color.RED);
			panel_3.setPreferredSize(new Dimension(600, 80));
		//	panel_3.setPreferredSize(new Dimension(900,99));
			panel_4.add(panel_3,BorderLayout.NORTH);
			panel_3.setBorder(new LineBorder(Color.BLACK,1,true));
			panel_3.setLayout(null);
			
			JLabel lblValoresAReceber = new JLabel("Valores a Receber");
			lblValoresAReceber.setForeground(Color.white);
			lblValoresAReceber.setBounds(270, 0, 223, 39);
			panel_3.add(lblValoresAReceber);
			lblValoresAReceber.setFont(Propiedade.FONT3);
			
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("R$ .00");
			
			Caixa caixa = new Caixa();
			
				caixa = (Caixa) fachada.buscarPorIdCaixa(1);
			
			if(fachada.soma() - fachada.somaValorPago() == 0) {
				lblValorReceber= new JLabel("R$ 0,00");
			}else {
				lblValorReceber = new JLabel(df.format((fachada.soma()-fachada.somaValorPago())));
			}
			lblValorReceber.setForeground(Color.WHITE);
			lblValorReceber.setBounds(270, 36, 200, 28);
			panel_3.add(lblValorReceber);
			lblValorReceber.setFont(Propiedade.FONT3);
			
			
			
			JLabel lblSaldo = new JLabel("Saldo no Caixa");
			lblSaldo.setForeground(Color.white);
			lblSaldo.setBounds(10, 0, 246, 39);
			panel_3.add(lblSaldo);
			lblSaldo.setFont(Propiedade.FONT3);
			
	//		JLabel lblServios = new JLabel("Servi\u00E7os");
	//		lblServios.setFont(new Font("Tahoma", Font.PLAIN, 25));
	//		lblServios.setBounds(697, 23, 139, 28);
	//		add(lblServios);
			
			if(caixa.getSaldo() == 0) {
				lblValorCaixa = new JLabel("R$ 0,00");
			}else {
				lblValorCaixa = new JLabel(df.format(caixa.getSaldo()));
			}
			
			lblValorCaixa.setForeground(Color.white);
			lblValorCaixa.setBounds(10, 24, 200, 62);
			panel_3.add(lblValorCaixa);
			lblValorCaixa.setFont(Propiedade.FONT3);
			
			btnNovaVenda = new JButton("Nova Venda");
			
			btnNovaVenda.setBounds(625, 24, 145, 39);
			panel_3.add(btnNovaVenda);
			btnNovaVenda.setFont(Propiedade.FONT2);
			btnNovaVenda.setBackground(Color.WHITE);
			
			contasApagarPanel= new ContasApagarPanel();
			contasApagarPanel.setBounds(0, 150, 720, 405);
			panel_4.add(contasApagarPanel);
			contasApagarPanel.setBackground(Color.white);
			
	
			contasAreceberPanel = new ContasAreceberPanel();
			contasAreceberPanel.setBounds(0, 150, 720, 405);
			panel_4.add(contasAreceberPanel);
			contasAreceberPanel.setBackground(Color.white);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public ContasApagarPanel getContasApagarPanel() {
		return contasApagarPanel;
	}


	public JButton getBtnContasApagar() {
		return btnContasApagar;
	}


	public JPanel getPanel_4() {
		return panel_4;
	}


	public JLabel getLblValorCaixa() {
		return lblValorCaixa;
	}

	public JLabel getLblValorReceber() {
		return lblValorReceber;
	}

	public JButton getBtnNovaVenda() {
		return btnNovaVenda;
	}
	

	public void setLblValorCaixa(JLabel lblValorCaixa) {
		this.lblValorCaixa = lblValorCaixa;
	}

	public void setLblValorReceber(JLabel lblValorReceber) {
		this.lblValorReceber = lblValorReceber;
	}

	public JButton getBtnDashoroad() {
		return btnDashoroad;
	}


	public ContasAreceberPanel getContasAreceberPanel() {
		return contasAreceberPanel;
	}
	
	
}
