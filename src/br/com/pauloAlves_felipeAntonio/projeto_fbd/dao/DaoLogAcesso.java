package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Log_acesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoLogAcesso implements IDaoLog_acesso {
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Log_acesso log) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Log_acesso.INSERT_ALL);
			
			statement.setDate(1,log.getData_acesso());
			statement.setString(2,log.getNome_usuario());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}
	@Override
	public void editar(Log_acesso log) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Log_acesso buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log_acesso buscaPorData(Date data) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log_acesso> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
