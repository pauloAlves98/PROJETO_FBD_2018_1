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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Horario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.enums.EnumAgendaView;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.IDaoConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.IDaoMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.IDaoPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.AgendaPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.BuscaDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroConsultaPanel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.ConsultaFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.RemarcarConsultaDialog;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.VisualizarAgendaPanel;

public class ControlerAbaAgenda {
	private AgendaPanel agendaPanel;
	private CadastroConsultaPanel cConsultaP;
	private VisualizarAgendaPanel vAgendaPanel;
	private BuscaDialog buscarDialog;
	private IFachada fachada;//Corrigir busines de paciente e consulta
	private String QUEM_DISPAROU_A_BUSCA = " ";
	private Consulta consultaCorrente;
	private ConsultaFrame consultaF;
	private RemarcarConsultaDialog rcD;

	public ControlerAbaAgenda(AgendaPanel agendaP){
		
		this.buscarDialog = new BuscaDialog();
		this.agendaPanel = agendaP;
		this.cConsultaP = agendaPanel.getcConsulta();
		this.vAgendaPanel = agendaPanel.getvAgendaPanel();
		this.fachada = Fachada.getInstance();
		this.consultaCorrente = new Consulta();
		this.consultaF = new ConsultaFrame();
		this.rcD = new RemarcarConsultaDialog();
		//RemarcarConsultaDialog
		this.rcD.getCdtC().getDataC().addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent e) {
			atualizarHorario(rcD.getCdtC());}});
		this.rcD.getBtnCancelarRemarcao().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				rcD.setVisible(false);
			}	
		});
		this.rcD.getCdtC().getConcluirButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(rcD.getCdtC().getHorarioBox().getSelectedItem() == null || rcD.getCdtC().getHorarioBox().getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null,"Hórario Inválido!");
				}else{
					try {
						consultaCorrente.setSituacao("Não Realizada");
						consultaCorrente.set_data(rcD.getCdtC().getDataC().getDate());
						consultaCorrente.setHorario(rcD.getCdtC().getHorarioBox().getSelectedItem().toString());
						fachada.editarConsulta(consultaCorrente);
						JOptionPane.showMessageDialog(null,"Consulta Remarcada");
						
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage());
						e1.printStackTrace();
					}
					finally{
						consultaCorrente = new Consulta();
						rcD.setVisible(false);
						consultaF.setVisible(false);
						limparCamposConsulta();
					}
				}
					
			}
		});
			
		
		//Eventos ConsultaFrame
		consultaF.getRemarcarButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				atualizarHorario(rcD.getCdtC());
				rcD.getCdtC().getCodMedicoField().setText(consultaCorrente.getId_medico()+"");
				rcD.getCdtC().getCodPacienteField().setText(consultaCorrente.getId_paciente()+"");
				rcD.getCdtC().getPacienteField().setText(consultaCorrente.getPaciente().getNome());
				rcD.getCdtC().getMedicoField().setText(consultaCorrente.getMedico().getNome());
				rcD.setVisible(true);
			}});
		consultaF.getBtnCancelar().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Deseja realmente Cancelar a consulta?")==JOptionPane.YES_OPTION){
					try {
						consultaCorrente.setSituacao("Cancelada");
						fachada.editarConsulta(consultaCorrente);
						consultaF.setVisible(false);
						limparCamposConsulta();
						JOptionPane.showMessageDialog(null,"Consulta cancelada");
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage());
						e1.printStackTrace();
					}
				}
			}});
		this.consultaF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
					limparCamposConsulta();
					consultaCorrente = new  Consulta();
		}
		});
		//Eventos  Cabeçario Agenda
		this.agendaPanel.getBtnNovaConsulta().addActionListener((ActionEvent e)->agendaPanel.getCard().show(agendaPanel.getpCard(),EnumAgendaView.CONSULTA.getValor())
		
		);
		this.agendaPanel.getVisualizarAgendaButton().addActionListener((ActionEvent e)->agendaPanel.getCard().show(agendaPanel.getpCard(),EnumAgendaView.VISUALIZAR.getValor()));
		
		//Eventos para cConsulta
		this.cConsultaP.getConcluirButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(cConsultaP.getHorarioBox().getSelectedItem() == null || cConsultaP.getHorarioBox().getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null,"Hórario Inválido!");
				}
				else if(cConsultaP.getPacienteField().getText().length()<=0 || cConsultaP.getMedicoField().getText().length()<=0){
					JOptionPane.showMessageDialog(null,"Exitem Campos Vazios!");
				}
				else {
					try {
						Consulta consulta = new Consulta();
						consulta.set_data(cConsultaP.getDataC().getDate());
						consulta.setHorario(cConsultaP.getHorarioBox().getSelectedItem().toString());
						consulta.setSituacao("Não Realizada");
						int id_m = Integer.parseInt(cConsultaP.getCodMedicoField().getText());
						int id_p = Integer.parseInt(cConsultaP.getCodPacienteField().getText());
					
						fachada.salvarConsulta(consulta, id_m, id_p);
						JOptionPane.showMessageDialog(null,"Agendamento realizado com sucesso!");
						cConsultaP.getCodMedicoField().setText("");
						cConsultaP.getCodPacienteField().setText("");
						cConsultaP.getPacienteField().setText("");
						cConsultaP.getMedicoField().setText("");
						cConsultaP.getHorarioBox().removeAllItems();
					} catch (BusinessException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}
				}
			}});
		
		this.cConsultaP.getDataC().addPropertyChangeListener(new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent e) {
			atualizarHorario(cConsultaP);}});
		
		this.cConsultaP.getBuscarPacienteButton().addActionListener((ActionEvent e) ->{
		buscarDialog.getScrollPane().setVisible(false);buscarDialog.getResultadoLabel().setVisible(false);QUEM_DISPAROU_A_BUSCA = "PACIENTE";montarTabela(new String[][]{},"Telefone"); buscarDialog.setVisible(true);});
		
		this.cConsultaP.getBuscarMedicoButton().addActionListener((ActionEvent e) -> {buscarDialog.getScrollPane().setVisible(false);
		;QUEM_DISPAROU_A_BUSCA = "Medico";buscarDialog.getResultadoLabel().setVisible(false);montarTabela(new String[][]{},"Especialidade");buscarDialog.setVisible(true);});
		
		//Tela BuscarDialog
		this.buscarDialog.getPesqButton().addActionListener((ActionEvent e)->buscaDialog());
		this.buscarDialog.getFinalizarButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				buscarDialog.getFiltroField().setText("");
				if(buscarDialog.getTabelaInfo().getSelectedRowCount()>0){
					
					if(QUEM_DISPAROU_A_BUSCA.equalsIgnoreCase("PACIENTE")){
						cConsultaP.getPacienteField().setText(buscarDialog.getTabelaInfo().getValueAt(buscarDialog.getTabelaInfo().getSelectedRow(), 1)+"");
						cConsultaP.getCodPacienteField().setText(buscarDialog.getTabelaInfo().getValueAt(buscarDialog.getTabelaInfo().getSelectedRow(), 0)+"");
					}
					else{
						cConsultaP.getMedicoField().setText("Dr. "+buscarDialog.getTabelaInfo().getValueAt(buscarDialog.getTabelaInfo().getSelectedRow(), 1)+"");
						cConsultaP.getCodMedicoField().setText(buscarDialog.getTabelaInfo().getValueAt(buscarDialog.getTabelaInfo().getSelectedRow(), 0)+"");
					}
					buscarDialog.setVisible(false);
				}else if(buscarDialog.getResultadoLabel().isVisible()){
					
					if(QUEM_DISPAROU_A_BUSCA.equalsIgnoreCase("PACIENTE")){
						cConsultaP.getPacienteField().setText("");
						cConsultaP.getCodPacienteField().setText("");
					}
					else{
						cConsultaP.getMedicoField().setText("");
						cConsultaP.getCodMedicoField().setText("");
					}
					JOptionPane.showMessageDialog(null,"NENHUM "+QUEM_DISPAROU_A_BUSCA+" SELECIONADO!");
					buscarDialog.setVisible(false);
				}else{
					
					if(QUEM_DISPAROU_A_BUSCA.equalsIgnoreCase("PACIENTE")){
						cConsultaP.getPacienteField().setText("");
						cConsultaP.getCodPacienteField().setText("");
						//cConsultaP.getCodPacienteField().setText(buscarDialog.getTabelaInfo().getValueAt(buscarDialog.getTabelaInfo().getSelectedRow(), 0)+"");
					}
					else{
						cConsultaP.getMedicoField().setText("");
						cConsultaP.getCodMedicoField().setText("");
					}
					JOptionPane.showMessageDialog(null,"NENHUM "+QUEM_DISPAROU_A_BUSCA+" SELECIONADO!");
					buscarDialog.setVisible(false);
				}	
				atualizarHorario(cConsultaP);
			}});
		
		//Tela Visualizar Agenda
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
					cons=(ArrayList<Consulta>) fachada.buscaInfoConsultaPorFiltro(busca);//falta  Bussines e fachada
				} 
			    catch (BusinessException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				montarTabelaInfoVisualizar(cons);
				
			}
		});
		JTableButtonMouseListener tableListner = new JTableButtonMouseListener(vAgendaPanel.getTable().getTable(),vAgendaPanel);
		vAgendaPanel.getTable().getTable().addMouseListener(tableListner);
	}
	public void buscaDialog(){
		String busca = buscarDialog.getFiltroField().getText();
		System.out.println(busca + QUEM_DISPAROU_A_BUSCA );
		if(QUEM_DISPAROU_A_BUSCA.equalsIgnoreCase("PACIENTE")){
			try {
			
				busca = "%"+busca+"%";
				System.out.println(busca);
				List<Paciente>pacientes = fachada.buscaInfoPorFiltroPaciente(busca);
				System.out.println(pacientes);
				if(pacientes.size() <=0 ){
					buscarDialog.getScrollPane().setVisible(false);
					buscarDialog.getResultadoLabel().setVisible(true);
				}else{
					buscarDialog.getScrollPane().setVisible(true);
					String dados[][] = new String[pacientes.size()][4];
					int i = 0;
					for( Paciente p:pacientes){
						dados[i][0] = p.getId()+"";
						dados[i][1] = p.getNome();
						dados[i][2]= p.getCpf();
						dados[i][3] = p.getTelefone();
						i++;
					}
					montarTabela(dados,"Telefone");
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
			
		}else{//Foi Medico
			try {
				
		
				List<Medico>medicos = fachada.buscarInfoPorFiltroMedico(busca);
				if(medicos.size() <=0 ){
					buscarDialog.getScrollPane().setVisible(false);
					buscarDialog.getResultadoLabel().setVisible(true);
				}else{
					buscarDialog.getScrollPane().setVisible(true);
					String dados[][] = new String[medicos.size()][4];
					int i = 0;
					for( Medico p:medicos){
						dados[i][0] = p.getId()+"";
						dados[i][1] = p.getNome();
						dados[i][2]= p.getCpf();
						dados[i][3] = p.getEspecialidade();
						i++;
					}
					montarTabela(dados,"Especialidade");
					buscarDialog.getScrollPane().setVisible(true);
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			
			}
		}		
		
	}
	private void atualizarHorario(CadastroConsultaPanel cConsultaP){
		if(cConsultaP.getCodMedicoField().getText().length()<=0){
			cConsultaP.getHorarioBox().removeAllItems();
			//JOptionPane.showMessageDialog(null,"Selecione um médico Primeiro!!!");
		}
		else{
			try {
				cConsultaP.getHorarioBox().removeAllItems();
				Horario hor = new Horario();
			
				List<String>horarios = fachada.buscaHorariosConsulta(cConsultaP.getDataC().getDate(),Integer.parseInt(cConsultaP.getCodMedicoField().getText()));
				if(horarios.size()>=0 || horarios.size() < hor.getHorarios().size()){
					if(horarios.size()==0 )
						for(String h:hor.getHorarios()){
							cConsultaP.getHorarioBox().addItem(h);			
						}
					else{
						int cont = 0;
						for(String h:hor.getHorarios()){//preenchera apenas com horarios não existentes
							cont = 0;
							for(String h2:horarios){
								if(h2.equalsIgnoreCase(h))
									cont++;
							}
							if(cont == 0)
								cConsultaP.getHorarioBox().addItem(h);			
						}
					}
				}else //Lotado
					cConsultaP.getHorarioBox().removeAllItems();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void montarTabela(String[][] dados,String ultima){
		buscarDialog.getTabelaInfo().setModel(new DefaultTableModel(
				dados,
				new String[] {
					"<html><table><tr><td height=20>Cod</td></tr></table></html>", "Nome", "CPF", ultima
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		buscarDialog.getTabelaInfo().getColumnModel().getColumn(0).setPreferredWidth(66);
		buscarDialog.getTabelaInfo().getColumnModel().getColumn(1).setPreferredWidth(180);
		buscarDialog.getTabelaInfo().getColumnModel().getColumn(2).setPreferredWidth(100);
		buscarDialog.getTabelaInfo().getColumnModel().getColumn(2).setMinWidth(40);
		buscarDialog.getTabelaInfo().setRowHeight(30);
		buscarDialog.getTabelaInfo().setFont(new Font("Tahoma", Font.BOLD, 11));
		buscarDialog.getTabelaInfo().getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		buscarDialog.getTabelaInfo().setBorder(new LineBorder(Color.black,1,false));
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
				p=(ArrayList<Consulta>) fachada.buscaInfoConsultaPorData(vAgendaPanel.getCalendario().getDate());
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
			new String[] {"<html><table><tr><td height=50>Id</td></tr></table></html>",
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
				}  catch (BusinessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
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

	
}

