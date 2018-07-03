package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Local_end;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoLocalEnd implements IDaoLocal_end{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Local_end local_end) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Local_end.INSERT_ALL);
			
			statement.setString(1,local_end.getRua());
			statement.setString(2,local_end.getNome_clinica());
			statement.setInt(3,local_end.getTelefone());
			statement.setString(4,local_end.getBairro());
			statement.setInt(5,local_end.getId_exame());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Local_end local_end) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local_end buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Local_end> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
