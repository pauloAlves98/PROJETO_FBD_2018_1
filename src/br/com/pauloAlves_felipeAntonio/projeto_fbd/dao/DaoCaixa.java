package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.controller.ControleCadastros;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoCaixa implements IDaoCaixa{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	@Override
	public void salvar(Caixa caixa) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Caixa.INSERT_ALL);
		
			statement.setFloat(1,caixa.getSaldo());
			statement.setString(2,caixa.getNome());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Caixa caixa) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Caixa.UPDATE_ALL);
		
			statement.setFloat(1,caixa.getSaldo());
			statement.setInt(2,1);
			
			statement.execute();
			statement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao editar no banco!!!Contate o adm.");
		}
	}

	@Override
	public Caixa buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Caixa.SELECT_CAIXA);
		
			statement.setInt(1, id);
			result  = statement.executeQuery();
			Caixa caixa = new Caixa();
			if(result.next()) {
				caixa.setNome(result.getString(1));
				caixa.setSaldo(result.getFloat(2));
				caixa.setId(id);
				
			}
			statement.close();
			conexao.close();
			return caixa;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public List<Caixa> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
