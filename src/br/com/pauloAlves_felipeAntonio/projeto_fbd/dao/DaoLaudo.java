package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoLaudo implements IDaoLaudo{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Laudo laudo) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Laudo.INSERT_ALL);
		
			statement.setDate(1,laudo.get_data());
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
