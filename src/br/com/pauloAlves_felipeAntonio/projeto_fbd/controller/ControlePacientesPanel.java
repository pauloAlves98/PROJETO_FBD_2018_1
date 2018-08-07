package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.Propiedade;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento.TratadorDeMascara;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoComum;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.ValidacaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.parg.viacep.ViaCEP;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.parg.viacep.ViaCEPException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroFornecedoresFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastroPacienteFrame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.JTableButtonModel;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.PacientesPanel;



public class ControlePacientesPanel {
	private Paciente paciente = new Paciente();
	private IFachada fachada;
	PacientesPanel telaPaciente;
	CadastroPacienteFrame pacienteCdastro;
	int condicao = 0;
	public ControlePacientesPanel(PacientesPanel telaPaciente,CadastroPacienteFrame pacienteCdastr) {
		this.telaPaciente = telaPaciente;
		fachada = Fachada.getInstance();
		this.pacienteCdastro =  pacienteCdastr;
		JTableButtonMouseListener tableListner = new JTableButtonMouseListener(telaPaciente.getTable().getTable(),pacienteCdastro);
		telaPaciente.getBuscaButton().addActionListener((ActionEvent e)-> buscarPaciente());

		telaPaciente.getTable().getTable().addMouseListener(tableListner);

		telaPaciente.getBtnNewButton_3().addActionListener((ActionEvent e)->{limparCampos(pacienteCdastro); pacienteCdastro.setVisible(true);});


		pacienteCdastr. addWindowListener(new WindowAdapter()  
	       {  
	           public void windowClosing(WindowEvent evt)  
	           {  condicao =0;
	           		limparCampos(pacienteCdastr);
	           }  
	       });  
		
		pacienteCdastro.getBtnSalvar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(condicao == 0){//Se for pra inserir
						paciente = new Paciente();
						Endereco end = new Endereco();
						//Perguntar se o tratamento de campo vazio fica aqui  ou no Businnes
						paciente.setEndereco(end);
						paciente.setNome(pacienteCdastro.getNomeField().getText());
						paciente.setCpf(pacienteCdastro.getCpfField().getText().replace(".","").replace("-",""));
						TratadorDeMascara.isCPF(paciente.getCpf());
						paciente.setRg(pacienteCdastro.getRgField().getText());
						TratadorDeMascara.validaRg(paciente.getRg());
						paciente.setTelefone(pacienteCdastro.getTelField().getText().trim());
						paciente.setNome_mae(pacienteCdastro.getNomeMField().getText());
						paciente.setNome_pai(pacienteCdastro.getNomePField().getText());
						paciente.setDataNascimento(TratadorDeMascara.coletorDeData(pacienteCdastro.getNascField().getText()));
						paciente.getEndereco().setBairro(pacienteCdastro.getBairroField().getText());
						paciente.getEndereco().setCep(pacienteCdastro.getCepField().getText());
						paciente.getEndereco().setCidade(pacienteCdastro.getCidadeField().getText());
						paciente.getEndereco().setComplemento(pacienteCdastro.getComplementoField().getText());
						paciente.getEndereco().setEstado(""+pacienteCdastro.getEstadoField().getText());
						paciente.getEndereco().setLogradouro(pacienteCdastro.getLogradouroField().getText().trim().replace(" ",""));
						paciente.getEndereco().setNumero(Integer.parseInt(pacienteCdastro.getNumeroField().getText()));
						paciente.getEndereco().setPais(""+pacienteCdastro.getPaisBox().getItemAt(pacienteCdastro.getPaisBox().getSelectedIndex()));
						paciente.getEndereco().setRua(pacienteCdastro.getRuaField().getText());

						fachada.salvarPaciente(paciente);
						if((JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Mais algum?"))==0){
							limparCampos(pacienteCdastro);
						}else {
							pacienteCdastro.setVisible(false);
							limparCampos(pacienteCdastro);
						}
					}else{//se for pra editar

						Endereco end = new Endereco();
						end.setId(paciente.getEndereco().getId());//transfere o id  do endereco a ser editado

						pacienteCdastro.getProntuarioField().setEditable(false);
						paciente.setEndereco(end);
						paciente.setNome(pacienteCdastro.getNomeField().getText());
						paciente.setCpf(pacienteCdastro.getCpfField().getText().replace(".","").replace("-",""));
						TratadorDeMascara.isCPF(paciente.getCpf());
						paciente.setRg(pacienteCdastro.getRgField().getText());
						TratadorDeMascara.validaRg(paciente.getRg());
						paciente.setTelefone(pacienteCdastro.getTelField().getText().trim());
						paciente.setNome_mae(pacienteCdastro.getNomeMField().getText());
						paciente.setNome_pai(pacienteCdastro.getNomePField().getText());
						paciente.setDataNascimento(TratadorDeMascara.coletorDeData(pacienteCdastro.getNascField().getText()));
						paciente.getEndereco().setBairro(pacienteCdastro.getBairroField().getText());
						paciente.getEndereco().setCep(pacienteCdastro.getCepField().getText());
						paciente.getEndereco().setCidade(pacienteCdastro.getCidadeField().getText());
						paciente.getEndereco().setComplemento(pacienteCdastro.getComplementoField().getText());
						paciente.getEndereco().setEstado(""+pacienteCdastro.getEstadoField().getText());
						paciente.getEndereco().setLogradouro(pacienteCdastro.getLogradouroField().getText().trim().replace(" ",""));
						paciente.getEndereco().setNumero(Integer.parseInt(pacienteCdastro.getNumeroField().getText()));
						paciente.getEndereco().setPais(""+pacienteCdastro.getPaisBox().getItemAt(pacienteCdastro.getPaisBox().getSelectedIndex()));
						paciente.getEndereco().setRua(pacienteCdastro.getRuaField().getText());
						paciente.setId(condicao);//seta o id para realizar a comparação na busca
						fachada.editarPaciente(paciente,paciente.getEndereco().getId());
						JOptionPane.showConfirmDialog(null, "Paciente Editado com Sucesso!");
						pacienteCdastro.setVisible(false);
						limparCampos(pacienteCdastro);
						condicao=0;
					}
				}catch (BusinessException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (ValidacaoException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});

		pacienteCdastro.getBuscarCEPButton().addActionListener((ActionEvent e)->buscarCep());

	}
	private void buscarCep(){
		try {
			ViaCEP via = new ViaCEP(this.pacienteCdastro.getCepField().getText().replace("-", ""));
			this.pacienteCdastro.getCidadeField().setText(via.getLocalidade());
			this.pacienteCdastro.getEstadoField().setText(via.getUf());
			this.pacienteCdastro.getLogradouroField().setText(via.getLogradouro());
			this.pacienteCdastro.getBairroField().setText(via.getBairro());
		} catch (ViaCEPException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage()+", preencha o dados manualmente!");
		}
	}
	private void buscarPaciente() {
		try {
			//validar buscas, fazer busca por busca , tratar se nehum paciente for retornado!!!
			//if(telaPaciente.getDescricaoField().getText().equals("") && telaPaciente.getFiltroField().getText().equals("")) {
			ArrayList<Paciente> p = new ArrayList<Paciente>();
			p=(ArrayList<Paciente>) fachada.buscarPorBuscaPaciente("%"+telaPaciente.getFiltroField().getText()+"%");
			Object [][] linha = new Object[p.size()][5];
			int i=0;
			for(Paciente pac:p){
				linha[i][0] = pac.getNome();
				linha[i][1] = pac.getCpf();
				linha[i][2] = pac.getTelefone();
				Calendar c = Calendar.getInstance();
				c.setTime(pac.getDataNascimento());
				linha[i][3] = c.get(c.DAY_OF_MONTH)+"/"+(c.get(c.MONTH)+1)+"/"+c.get(c.YEAR);
				JButton b = new JButton("Abrir");
				b.setForeground(Color.BLACK);
				b.setBackground(Color.white);
				b.setFont(Propiedade.FONT2);
				linha[i][4] = b;
				i++;
			}

			JTableButtonModel jtableButtonModel = new JTableButtonModel();
			jtableButtonModel.adcionar(linha,new String[] {
					"Nome","CPF", "Telefone", "Nascimento","Cadastro"
			});



			telaPaciente.getTable().getTable().setModel(jtableButtonModel);
			telaPaciente.getTable().getTable().setRowHeight(40);

			telaPaciente.getTable().getTable().setShowGrid(true);
			telaPaciente.getTable().getTable().setShowHorizontalLines(true);
			telaPaciente.getTable().getTable().setShowVerticalLines(true);
			telaPaciente.getTable().getTable().setBackground(Color.white);
			telaPaciente.getTable().getTable().setFont(Propiedade.FONT2);
			//	}else {
			//				String cpf = telaPaciente.getDescricaoField().getText().trim().replace(" ","");
			//				Paciente paciente = fachada.buscarPorCpfPaciente(cpf);
			//				String [][] linha = new String[1][5];
			//				linha[0][0] = paciente.getNome();
			//				linha[0][1] = paciente.getCpf();
			//				linha[0][2] = paciente.getTelefone()+"";
			//				linha[0][3] = paciente.getRg();
			//				Calendar c = Calendar.getInstance();
			//				c.setTime(paciente.getDataNascimento());
			//				linha[0][4] = c.get(c.DAY_OF_MONTH)+"/"+(c.get(c.MONTH)+1)+"/"+c.get(c.YEAR);
			//				DefaultTableModel d = new DefaultTableModel(linha,new String[] {
			//		 				"Nome","RG", "CPF", "Telefone", "Nascimento"
			//		 			});
			//			 			
			//				telaPaciente.getTable().setModel(d);
			//				telaPaciente.getTable().setShowGrid(true);
			//				telaPaciente.getTable().setShowHorizontalLines(true);
			//				telaPaciente.getTable().setShowVerticalLines(true);
			//				telaPaciente.getTable().setBackground(Color.white);
			//				telaPaciente.getTable().setFont(Propiedade.FONT1);
			//				
			//			}

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void limparCampos(CadastroPacienteFrame pacienteCdastro) {
		pacienteCdastro.getNomeField().setText("");
		pacienteCdastro.getCpfField().setText("");
		pacienteCdastro.getRgField().setText("");
		pacienteCdastro.getTelField().setText("");
		pacienteCdastro.getNomeMField().setText("");
		pacienteCdastro.getNomePField().setText("");
		pacienteCdastro.getBairroField().setText("");
		pacienteCdastro.getCepField().setText("");
		pacienteCdastro.getCidadeField().setText("");
		pacienteCdastro.getComplementoField().setText("");
		pacienteCdastro.getLogradouroField().setText("");
		pacienteCdastro.getNumeroField().setText("");
		pacienteCdastro.getRuaField().setText("");
		pacienteCdastro.getNascField().setText("");
	}
	public class JTableButtonMouseListener implements MouseListener {
		private JTable table;

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}

		private CadastroPacienteFrame pacientes = pacienteCdastro;

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
					condicao = fachada.buscarIdPorCpfPaciente(""+getTable().getValueAt(getTable().getSelectedRow(),1));
					paciente = fachada.buscarPorCpfPaciente(""+getTable().getValueAt(getTable().getSelectedRow(),1));
					pacienteCdastro.getNomeField().setText(paciente.getNome());
					pacienteCdastro.getCpfField().setText(paciente.getCpf());
					pacienteCdastro.getRgField().setText(paciente.getRg());
					pacienteCdastro.getTelField().setText(paciente.getTelefone());
					pacienteCdastro.getNomeMField().setText(paciente.getNome_mae());
					pacienteCdastro.getNomePField().setText(paciente.getNome_pai());
					pacienteCdastro.getBairroField().setText(paciente.getEndereco().getBairro());
					pacienteCdastro.getCepField().setText(paciente.getEndereco().getCep());
					pacienteCdastro.getCidadeField().setText(paciente.getEndereco().getCidade());
					pacienteCdastro.getComplementoField().setText(paciente.getEndereco().getComplemento());
					pacienteCdastro.getLogradouroField().setText(paciente.getEndereco().getLogradouro());
					pacienteCdastro.getNumeroField().setText(""+paciente.getEndereco().getNumero());
					pacienteCdastro.getRuaField().setText(paciente.getEndereco().getRua());
					Calendar c = Calendar.getInstance();
					c.setTime(paciente.getDataNascimento());
					String dia = formatandoData(c.get(c.DAY_OF_MONTH)+"");
					String mes = formatandoData((c.get(c.MONTH)+1)+"");
					pacienteCdastro.getNascField().setText(""+dia+""+mes+""+c.get(c.YEAR));
					pacienteCdastro.getEstadoField().setText(paciente.getEndereco().getEstado());
					pacientes.setVisible(true);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			// This is necessary so that when a button is pressed and released
			// it gets rendered properly.  Otherwise, the button may still appear
			// pressed down when it has been released.
			this.table.repaint();
		}

		public JTableButtonMouseListener(JTable table,CadastroPacienteFrame pacientes) {
			this.table = table;
			this.pacientes = pacientes;
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
	private String formatandoData(String antigo) {
		if(antigo.length()<2)
			antigo = 0+antigo;
		return antigo;
	}
}
