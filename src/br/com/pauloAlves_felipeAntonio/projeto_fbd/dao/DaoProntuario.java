package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Prontuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoProntuario implements IDaoProntuario{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Prontuario prontuario) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Prontuario.INSERT_ALL);
			
			statement.setDate(1,prontuario.getData_exame());
			statement.setDate(2,prontuario.getData_inicio());
			statement.setDate(3,prontuario.getData_final());
			statement.setString(4,prontuario.getDescricao_resultado());
			statement.setString(5,prontuario.getObservacao());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
	}

	@Override
	public void editar(Prontuario prontuario) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prontuario buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prontuario buscaPorData(Date data) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prontuario> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
