package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoLaudo implements IDaoLaudo{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	@Override
	public void salvar(Laudo laudo) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Laudo.INSERT_ALL);

			statement.setDate(1,new java.sql.Date(laudo.get_data().getTime()));
			statement.setString(2,laudo.getHorario());
			statement.setString(3,laudo.getDescricao());
			statement.setInt(4,laudo.getId_paciente());
			statement.setInt(5,laudo.getId_medico());

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}


	}

	@Override
	public void editar(Laudo laudo) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Laudo.UPDATE);
			//update laudo from _data, horario, descricao, id_paciente, id_medico from laudo.id = ?";"
			statement.setDate(1,new java.sql.Date(laudo.get_data().getTime()));
			statement.setString(2,laudo.getHorario());
			statement.setString(3,laudo.getDescricao());
			statement.setInt(4,laudo.getId_paciente());
			statement.setInt(5,laudo.getId_medico());
			statement.setInt(6, laudo.getId());
			statement.execute();

			statement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar Médico!!");
		}
	}

	@Override
	public Laudo buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Laudo buscaPorHorario(String horario) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laudo> buscarPorBusca(String busca) throws DaoException {

		return null;
	}

	public List<Laudo> buscarParaEdicao(int id) throws DaoException {
		try {
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Laudo.SELECT_ALL_EDICAO);
			statement.setInt(1,id);
			result = statement.executeQuery();
			List<Laudo>laudos = new ArrayList<Laudo>();
			while(result.next()){
				Laudo l = new Laudo();

				l.getPaciente().setNome(result.getString(1));
				l.getMedico().setNome(result.getString(2));
				l.set_data(result.getDate(3));
				l.setDescricao(result.getString(4));
				l.setId(result.getInt(5));
				l.setId_paciente(result.getInt(6));
				l.setId_medico(result.getInt(7));

				laudos.add(l);
			}
			conexao.close();
			statement.close();
			result.close();
			return laudos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR LAUDO - Contate o ADM");
		}
	}

	

	@Override
	public List<Laudo> buscarInfoPorPeriodo(int id, Date inicio, Date fim, String busca) throws DaoException {
		try {
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Laudo.SELECT_ALL_INFO);
			statement.setInt(1,id);
			statement.setDate(2,new java.sql.Date(inicio.getTime()));
			statement.setDate(3,new java.sql.Date(fim.getTime()));
			statement.setString(4,busca);
			statement.setString(5,busca);
			result = statement.executeQuery();

			List<Laudo>laudos = new ArrayList<Laudo>();
			while(result.next()){
				Laudo l = new Laudo();

				l.getPaciente().setNome(result.getString(1));
				l.getMedico().setNome(result.getString(2));
				l.set_data(result.getDate(3));
				l.setId(result.getInt(4));
				laudos.add(l);
			}
			conexao.close();
			statement.close();
			result.close();
			return laudos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR LAUDO - Contate o ADM");
		}
	}

}
