package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Estoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoEstoque implements IDaoEstoque{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Estoque estoque) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Estoque.INSERT_ALL);
			
			statement.setInt(1,estoque.getFornecedor().getId());
			statement.setInt(2,estoque.getProduto().getId());
			statement.setFloat(3,estoque.getTotal_produtos());
		
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}
	@Override
	public void editar(Estoque estoque) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Estoque buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Estoque> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
