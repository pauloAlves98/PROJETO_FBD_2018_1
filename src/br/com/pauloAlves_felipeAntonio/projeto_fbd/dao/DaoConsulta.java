package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoConsulta implements IDaoConsulta{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	@Override
	public void salvar(Consulta consulta,int id_medico,int id_paciente) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.INSERT_ALL);

			statement.setString(1,consulta.getTipo());
			statement.setString(2,consulta.getHorario());
			statement.setInt(3,id_paciente);
			statement.setInt(4,id_medico);
			statement.setDate(5,new java.sql. Date(consulta.get_data().getTime()));
			statement.setString(6,consulta.isSituacao());

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}


	}

	@Override
	public void editar(Consulta consulta) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.UPDATE);

			statement.setString(1,consulta.getHorario());
			statement.setDate(2,new java.sql.Date(consulta.get_data().getTime()));
			statement.setString(3,consulta.isSituacao());
			statement.setInt(4,consulta.getId());
			statement.execute();

			statement.close();
			conexao.close();


		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar Médico!!");
		}


	}

	@Override
	public Consulta buscarPorId(int id) throws DaoException {
		try{
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.SELECT_INFO_POR_ID);
			statement.setInt(1,id);
			result = statement.executeQuery();

			Consulta c = new Consulta();
			while(result.next()){
				Paciente p = new Paciente();
				Medico m = new Medico();

				c.setHorario(result.getString(1));
				c.setSituacao(result.getString(2));
				c.set_data(result.getDate(3));
				p.setNome(result.getString(4));
				p.setTelefone(result.getString(5));
				p.setCpf(result.getString(6));
				c.setPaciente(p);
				m.setNome(result.getString(7));
				m.setEspecialidade(result.getString(8));
				m.setId(result.getInt(9));
				c.setMedico(m);
				c.setId(result.getInt(10));
				c.setId_medico(m.getId());
				c.setId_paciente(result.getInt(11));
			}
			conexao.close();
			statement.close();
			result.close();
			return c;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
	}

	@Override
	public Consulta buscaPorData(java.util.Date data) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Consulta> buscaPorFiltroMedico(int id ,String busca) throws DaoException {
		try{
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.SELECT_INFO_POR_MEDICO);
			statement.setInt(1,id);
			statement.setString(2, busca);
			statement.setString(3, busca);
			statement.setString(4, busca);
			statement.setString(5, busca);
			statement.setString(6, busca);
			statement.setString(7, busca);
			result = statement.executeQuery();


			List<Consulta> consultas = new ArrayList<Consulta>();
			while(result.next()){

				Consulta c = new Consulta();
				Paciente p = new Paciente();
				Medico m =new Medico();

				c.setHorario(result.getString(1));
				c.setSituacao(result.getString(2));
				c.set_data(result.getDate(3));
				p.setNome(result.getString(4));
				p.setTelefone(result.getString(5));
				p.setCpf(result.getString(6));
				c.setPaciente(p);
				m.setNome(result.getString(7));
				m.setEspecialidade(result.getString(8));
				m.setId(result.getInt(9));
				c.setMedico(m);
				c.setId(result.getInt(10));
				c.setId_medico(m.getId());
				c.setId_paciente(result.getInt(11));
				consultas.add(c);
			}
			conexao.close();
			statement.close();
			result.close();
			return consultas;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
	}
	@Override
	public List<Consulta> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> buscaHorarios(java.util.Date busca,int id_medico) throws DaoException {
		try{
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.SELECT_HORARIOS_POR_DATA_E_MEDICO);
			statement.setInt(1,id_medico);
			statement.setDate(2,new java.sql.Date(busca.getTime()));
			result = statement.executeQuery();

			List<String>horarios = new ArrayList<String>();
			while(result.next()){
				String hor = "";
				hor = result.getString(1);
				horarios.add(hor);
			}
			conexao.close();
			statement.close();
			result.close();
			return horarios;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
	}
	public List<Consulta> buscaInfoConsultaPorData(java.util.Date busca) throws DaoException {
		try{
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.SELECT_INFO_POR_DATA);
			statement.setDate(1,new java.sql.Date(busca.getTime()));
			result = statement.executeQuery();

			List<Consulta> consultas = new ArrayList<Consulta>();
			while(result.next()){

				Consulta c = new Consulta();
				Paciente p = new Paciente();
				Medico m =new Medico();

				c.setHorario(result.getString(1));
				c.setSituacao(result.getString(2));
				c.set_data(result.getDate(3));
				p.setNome(result.getString(4));
				p.setTelefone(result.getString(5));
				p.setCpf(result.getString(6));
				c.setPaciente(p);
				m.setNome(result.getString(7));
				m.setEspecialidade(result.getString(8));
				m.setId(result.getInt(9));
				c.setMedico(m);

				c.setId(result.getInt(10));
				consultas.add(c);
			}
			conexao.close();
			statement.close();
			result.close();
			return consultas;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
	}
	public List<Consulta> buscaInfoConsultaPorDataMedico(java.util.Date busca,int id) throws DaoException {
		try{
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.SELECT_INFO_POR_DATA_MEDICO);
			statement.setDate(1,new java.sql.Date(busca.getTime()));
			statement.setInt(2,id);
			result = statement.executeQuery();

			List<Consulta> consultas = new ArrayList<Consulta>();
			while(result.next()){

				Consulta c = new Consulta();
				Paciente p = new Paciente();
				Medico m =new Medico();

				c.setHorario(result.getString(1));
				c.setSituacao(result.getString(2));
				c.set_data(result.getDate(3));
				p.setNome(result.getString(4));
				p.setTelefone(result.getString(5));
				p.setCpf(result.getString(6));
				c.setPaciente(p);
				m.setNome(result.getString(7));
				m.setEspecialidade(result.getString(8));
				m.setId(result.getInt(9));
				c.setMedico(m);

				c.setId(result.getInt(10));
				consultas.add(c);
			}
			conexao.close();
			statement.close();
			result.close();
			return consultas;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
	}
	public List<Consulta> buscaInfoConsultaPorFiltro(String busca) throws DaoException {
		try{
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.SELECT_INFO_POR_FILTRO);

			statement.setString(1,busca);
			statement.setString(2,busca);
			statement.setString(3,busca);
			statement.setString(4,busca);
			statement.setString(5,busca);
			statement.setString(6,busca);

			result = statement.executeQuery();

			List<Consulta> consultas = new ArrayList<Consulta>();
			while(result.next()){
				Consulta c = new Consulta();
				Paciente p = new Paciente();
				Medico m =new Medico();

				c.setHorario(result.getString(1));
				c.setSituacao(result.getString(2));
				c.set_data(result.getDate(3));
				p.setNome(result.getString(4));
				p.setTelefone(result.getString(5));
				p.setCpf(result.getString(6));
				c.setPaciente(p);
				m.setNome(result.getString(7));
				m.setEspecialidade(result.getString(8));
				m.setId(result.getInt(9));
				c.setMedico(m);
				c.setId(result.getInt(10));
				consultas.add(c);
			}
			conexao.close();
			statement.close();
			result.close();
			return consultas;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
	}
}
