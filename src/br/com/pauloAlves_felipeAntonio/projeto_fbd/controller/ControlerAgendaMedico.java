package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Corrente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ConsultaFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.LaudoDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.VisualizarAgendaPanel;

public class ControlerAgendaMedico {
	private VisualizarAgendaPanel vAgendaPanel;
	private Consulta consultaCorrente;
	private ConsultaFrame consultaF;
	private LaudoDialog laudoD;
	private IFachada fachada;
	public ControlerAgendaMedico(VisualizarAgendaPanel agenda){
		this.fachada = Fachada.getInstance();
		this.vAgendaPanel = agenda;
		this.consultaCorrente = new Consulta();
		this.consultaF = new ConsultaFrame();
		this.laudoD = new LaudoDialog();
		//LaudoD
		laudoD.getBtnSalvar().addActionListener((ActionEvent e)->salvarLaudo());
		laudoD.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//ConsultaF
		consultaF.getBtnConcluir().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(consultaCorrente.isSituacao().equalsIgnoreCase("Cancelada")){
					JOptionPane.showMessageDialog(null,"Esta consulta foi Cancelada!Não é possível concluila!");
					limparCamposConsulta();
					consultaCorrente = new Consulta();
					consultaF.setVisible(false);
					return ;
				}
				else if(consultaCorrente.isSituacao().equalsIgnoreCase("Realizada")){
					JOptionPane.showMessageDialog(null,"A consulta já foi concluida!");
					limparCamposConsulta();
					consultaCorrente = new Consulta();
					consultaF.setVisible(false);
					return ;
				}

				try {
					consultaCorrente.setSituacao("Realizada");
				
					fachada.editarConsulta(consultaCorrente);
					JOptionPane.showMessageDialog(null,"Consulta Concluida");
					preencherLaudo();
					laudoD.setVisible(true);
				} catch (BusinessException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}	finally{
					consultaCorrente = new Consulta();
					consultaF.setVisible(false);
					limparCamposConsulta();	
				}
			}	
		} );
		this.consultaF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				limparCamposConsulta();
				consultaCorrente = new  Consulta();
			}
		});
		//Agenda
		vAgendaPanel.getCalendario().addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent e) {
				buscaVisualizar();
			}});
		vAgendaPanel.getPesquisaButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				String busca = vAgendaPanel.getFiltroField().getText();
				vAgendaPanel.getLblExtenso().setText("'"+"Resultados para "+busca+"'");
				busca = "%"+busca+"%";
				ArrayList<Consulta>cons = new ArrayList<Consulta>();
				try {
					cons = (ArrayList<Consulta>) fachada.buscaPorFiltroConsultaMedico(Corrente.medicoCorrente.getId(), busca);//falta  Bussines e fachada
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				montarTabelaInfoVisualizar(cons);

			}
		});
		JTableButtonMouseListener tableListner = new JTableButtonMouseListener(vAgendaPanel.getTable().getTable(),vAgendaPanel);
		vAgendaPanel.getTable().getTable().addMouseListener(tableListner);
	}
	private String weekDay(Calendar cal) {
		return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
	}
	public void buscaVisualizar(){
		Calendar c = Calendar.getInstance();
		c.setTime(vAgendaPanel.getCalendario().getDate());
		c.set(Calendar.MONTH,((JComboBox) vAgendaPanel.getCalendario().getMonthChooser().getComboBox()).getSelectedIndex());
		c.set(Calendar.YEAR, vAgendaPanel.getCalendario().getYearChooser().getYear());
		c.set(Calendar.DAY_OF_MONTH,vAgendaPanel.getCalendario().getDayChooser().getDay());
		System.out.println(((JComboBox) vAgendaPanel.getCalendario().getMonthChooser().getComboBox()).getSelectedIndex());
		Locale local = new Locale("pt","BR");
		DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local); 
		vAgendaPanel.getLblExtenso().setText(weekDay(c)+", "+dateFormat.format(c.getTime()));

		//Buscar a consulta do dia;
		try {
			ArrayList<Consulta> p = new ArrayList<Consulta>();
			p=(ArrayList<Consulta>) fachada.buscaInfoConsultaPorDataMedico(vAgendaPanel.getCalendario().getDate(),Corrente.medicoCorrente.getId());
			montarTabelaInfoVisualizar(p);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void montarTabelaInfoVisualizar(List<Consulta>p){
		Calendar c = Calendar.getInstance();
		Object [][] linha = new Object[p.size()][8];
		System.out.println(p);
		System.out.println(vAgendaPanel.getCalendario().getDate());
		int i=0;
		for(Consulta pac:p){
			linha[i][0] = pac.getId()+"";
			linha[i][1] = pac.getHorario();
			linha[i][2] = pac.getPaciente().getNome();
			Calendar c2 = Calendar.getInstance();
			c2.setTime(pac.get_data());
			linha[i][3] = (c2.get(c2.DAY_OF_MONTH)<10?"0"+c2.get(c2.DAY_OF_MONTH):c2.get(c2.DAY_OF_MONTH))+"/"+((c2.get(c.MONTH)+1)<10?"0"+(c2.get(c.MONTH)+1):(c2.get(c.MONTH)+1))+"/"+c2.get(c.YEAR);
			linha[i][4] = pac.getPaciente().getTelefone();
			linha[i][5] = pac.getMedico().getNome();
			linha[i][6] = pac.isSituacao();

			JButton b = new JButton("Abrir");
			b.setForeground(Color.BLACK);
			b.setBackground(Color.white);
			b.setFont(Propiedade.FONT2);
			linha[i][7] = b;
			i++;
		}
		JTableButtonModel jtableButtonModel = new JTableButtonModel();
		jtableButtonModel.adcionar(linha,
				new String[] {"<html><table><tr><td height=50>Cod</td></tr></table></html>",
						"Horário","Paciente", "Data", "Telefone","Médico", "Status","Detalhes"
		});

		vAgendaPanel.getTable().getTable().setBackground(Color.WHITE);

		vAgendaPanel.getTable().getTable().setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
		vAgendaPanel.getTable().getTable().setShowGrid(true);
		vAgendaPanel.getTable().getTable().setRowHeight(40);



		vAgendaPanel.getTable().getTable().getTableHeader().setForeground(Color.WHITE);

		vAgendaPanel.getTable().getTable().getTableHeader().setBackground(Propiedade.cor1);
		vAgendaPanel.getTable().getTable().getTableHeader().setFont(Propiedade.FONT2);
		vAgendaPanel.getTable().getTable().getTableHeader().setBorder(new LineBorder(Color.WHITE,1,true));
		vAgendaPanel.getTable().getTable().setModel(jtableButtonModel);

	}
	public class JTableButtonMouseListener implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private  VisualizarAgendaPanel vAgenda = vAgendaPanel;

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
					consultaCorrente = fachada.buscarPorIdConsulta(Integer.parseInt(""+getTable().getValueAt(getTable().getSelectedRow(),0)));
					consultaF.getCodField().setText(consultaCorrente.getPaciente().getCpf());
					consultaF.getEspField().setText(consultaCorrente.getMedico().getEspecialidade());
					consultaF.getMedicoField().setText(consultaCorrente.getMedico().getNome());
					consultaF.getPacienteField().setText(consultaCorrente.getPaciente().getNome());
					consultaF.getTipoField().setText(consultaCorrente.getHorario());
					consultaF.getStatusField().setText(consultaCorrente.isSituacao());
					consultaF.getDataField().setText(""+getTable().getValueAt(getTable().getSelectedRow(),3));
					consultaF.setVisible(true);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
			// This is necessary so that when a button is pressed and released
			// it gets rendered properly.  Otherwise, the button may still appear
			// pressed down when it has been released.
			this.table.repaint();
		}

		public JTableButtonMouseListener(JTable table,VisualizarAgendaPanel pacientes) {
			this.table = table;
			this.vAgenda = pacientes;
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
	private void limparCamposConsulta(){
		consultaF.getCodField().setText("");
		consultaF.getEspField().setText("");
		consultaF.getMedicoField().setText("");
		consultaF.getPacienteField().setText("");
		consultaF.getTipoField().setText("");
		consultaF.getStatusField().setText("");
		consultaF.getDataField().setText("");
	}
	public void salvarLaudo(){

		try {
			Laudo l = new Laudo();
			l.setId_paciente(Integer.parseInt(laudoD.getCodPacienteField().getText()));
			l.setId_medico(Integer.parseInt(laudoD.getCodMedField().getText()));
			l.setDescricao(laudoD.getDescricaoArea().getText());
			l.set_data(TratadorDeMascara.coletorDeData(laudoD.getDataField().getText()));
			l.setHorario("");
			fachada.salvarLaudo(l);
		}catch (ValidacaoException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			JOptionPane.showConfirmDialog(null,e.getMessage());
			e.printStackTrace();
		}finally{
			ControlerLaudoMedico.limparCamposLaudo(laudoD);
			laudoD.setVisible(false);
		}
	}
	public void preencherLaudo(){
		Calendar c2 = Calendar.getInstance();
		c2.setTime(consultaCorrente.get_data());
		laudoD.getDataField().setText((c2.get(c2.DAY_OF_MONTH)<10?"0"+c2.get(c2.DAY_OF_MONTH):c2.get(c2.DAY_OF_MONTH))+"/"+((c2.get(c2.MONTH)+1)<10?"0"+(c2.get(c2.MONTH)+1):(c2.get(c2.MONTH)+1))+"/"+c2.get(c2.YEAR));
		laudoD.getCodPacienteField().setText(consultaCorrente.getId_paciente()+"");
		laudoD.getPacienteField().setText(consultaCorrente.getPaciente().getNome());
		laudoD.getCodMedField().setText(consultaCorrente.getId_medico()+"");
		laudoD.getMedicoField().setText(consultaCorrente.getMedico().getNome());
		laudoD.getDescricaoArea().setText("");
	}
}
