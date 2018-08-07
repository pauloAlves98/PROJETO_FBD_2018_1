package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

import com.itextpdf.text.DocumentException;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Corrente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Relatorio;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LaudoDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LaudoPanel;

public class ControlerLaudoMedico {//para edicao
	private LaudoPanel laudoP;
	private LaudoDialog laudoD;
	private Laudo laudoCorrente = new Laudo();
	private JFileChooser fileC;
	private IFachada fachada;
	public ControlerLaudoMedico(LaudoPanel laudoP) {
		this.fachada = Fachada.getInstance();
		this.laudoP = laudoP;
		this.laudoD = new LaudoDialog();
		fileC = new JFileChooser();
		//LaudoD
		laudoD.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				limparCamposLaudo(laudoD);
				laudoCorrente = new  Laudo();
				laudoD.setVisible(false);
			}
		});
		laudoD.getBtnSalvar().addActionListener((ActionEvent e )->editarLaudo());
		laudoD.getBaixarButton().addActionListener((ActionEvent e )->baixarLaudo());
		//
		JTableButtonMouseListener tableListner = new JTableButtonMouseListener(laudoP.getTable().getTable(),laudoD);
		laudoP.getTable().getTable().addMouseListener(tableListner);
		//Laudopanel
		this.laudoP.getPesquisaButton().addActionListener((ActionEvent e)->buscarLaudos());
		
	}
	private void buscarLaudos(){
		try {
			String busca = laudoP.getFiltroField().getText();//Busca Info
			Date inicio = laudoP.getInicioData().getDate()==null?retornaData():laudoP.getInicioData().getDate();
			Date fim = laudoP.getFimData().getDate()==null?new Date():laudoP.getFimData().getDate();
			busca = "%" + busca + "%";
			System.out.println(busca);
			System.out.println(inicio);
			System.out.println(fim);
			System.out.println(Corrente.medicoCorrente.getId());
			ArrayList<Laudo> p = new ArrayList<Laudo>();
			
			p = (ArrayList<Laudo>) fachada.buscarInfoPorPeriodoLaudo(Corrente.medicoCorrente.getId(),inicio,fim,busca);
			preencherCamposBuscaTabela(p);
		} catch (BusinessException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
	}
	private void baixarLaudo(){
		fileC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		if((fileC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)){
			String c = fileC.getSelectedFile().getPath();
			String text  = laudoD.getDescricaoArea().getText();
			String codM = laudoD.getCodMedField().getText();
			String nomeM  = laudoD.getMedicoField().getText();
			String codP = laudoD.getCodPacienteField().getText();
			String nomeP = laudoD.getPacienteField().getText();
			System.out.println(c);
			System.out.println(c.replace("\\","/"));
			try {
				Relatorio.GerarLaudo(c.replace("\\","/"),new Date().toString().replace(":","_"),text,codM,nomeM,codP,nomeP);
				JOptionPane.showMessageDialog(null,"Salvo em:"+c);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Caminho não aceito!");
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Não foi possível salvar o arquivo!");
			}
		}else
			JOptionPane.showMessageDialog(null,"Nenhum caminho selecionado!");
		
	}
	private Date retornaData(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,1900);
		return c.getTime();
	}
	public class JTableButtonMouseListener implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private LaudoDialog cdLaudo = laudoD;

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
					System.out.println(""+getTable().getValueAt(getTable().getSelectedRow(),2));
					
					laudoCorrente =fachada.buscarParaEdicaoLaudo(Integer.parseInt(""+getTable().getValueAt(getTable().getSelectedRow(),0))).get(0);
					laudoD.getCodLaudoField().setText(laudoCorrente.getId()+"");
					laudoD.getDataField().setText(getTable().getValueAt(getTable().getSelectedRow(),3)+"");
					laudoD.getCodPacienteField().setText(laudoCorrente.getId_paciente()+"");
					laudoD.getPacienteField().setText(laudoCorrente.getPaciente().getNome());
					laudoD.getCodMedField().setText(laudoCorrente.getId_medico()+"");
					laudoD.getMedicoField().setText(laudoCorrente.getMedico().getNome());
					laudoD.getDescricaoArea().setText(laudoCorrente.getDescricao());
					laudoD.setVisible(true);
				}catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			this.table.repaint();
		}

		public JTableButtonMouseListener(JTable table,LaudoDialog pacientes) {
			this.table = table;
			this.cdLaudo = pacientes;
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
	private void editarLaudo(){
		try {
			this.preencherLaudo();
			fachada.editarLaudo(laudoCorrente);
			JOptionPane.showMessageDialog(null,"Editado Com sucesso!!!");
		} catch (BusinessException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		}finally{
			limparCamposLaudo(laudoD);
			laudoD.setVisible(false);
			laudoD.requestFocusInWindow();
			JTableButtonModel jtableButtonModel = new JTableButtonModel();
		}
	}
	private void preencherCamposBuscaTabela(ArrayList<Laudo> p) {

		Object[][] linha = new Object[p.size()][5];
		int i = 0;
		for (Laudo pac : p) {
			linha[i][0] = pac.getId()+"";
			linha[i][1] = pac.getPaciente().getNome();
			linha[i][2] = pac.getMedico().getNome();
			Calendar c2 = Calendar.getInstance();
			c2.setTime(pac.get_data());
			linha[i][3] = (c2.get(c2.DAY_OF_MONTH)<10?"0"+c2.get(c2.DAY_OF_MONTH):c2.get(c2.DAY_OF_MONTH))+"/"+((c2.get(c2.MONTH)+1)<10?"0"+(c2.get(c2.MONTH)+1):(c2.get(c2.MONTH)+1))+"/"+c2.get(c2.YEAR);
			JButton b = new JButton("Abrir");
			b.setForeground(Color.BLACK);
			b.setBackground(Color.white);
			b.setFont(Propiedade.FONT2);
			linha[i][4] = b;
			i++;
		}

		JTableButtonModel jtableButtonModel = new JTableButtonModel();
		jtableButtonModel.adcionar(linha, new String[] { "<html><table><tr><td height=50>Cod</td></tr></table></html>", "Paciente", "Medico", "Data", "Detalhes" });

		laudoP.getTable().getTable().getTableHeader().setFont(Propiedade.FONT1);
		laudoP.getTable().getTable().setModel(jtableButtonModel);
		laudoP.getTable().getTable().setRowHeight(40);

		laudoP.getTable().getTable().setShowGrid(true);
		laudoP.getTable().getTable().setShowHorizontalLines(true);
		laudoP.getTable().getTable().setShowVerticalLines(true);
		laudoP.getTable().getTable().setBackground(Color.white);
		laudoP.getTable().getTable().setFont(Propiedade.FONT2);
	}
	public static void limparCamposLaudo(LaudoDialog laudo){
		laudo.getCodLaudoField().setText("");
		laudo.getDataField().setText("");
		laudo.getCodPacienteField().setText("");
		laudo.getPacienteField().setText("");
		laudo.getCodMedField().setText("");
		laudo.getMedicoField().setText("");
		laudo.getDescricaoArea().setText("");
	}
	private   void preencherLaudo(){
		laudoCorrente.setDescricao(laudoD.getDescricaoArea().getText());
	}
}
