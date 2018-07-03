package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoProduto implements IDaoProduto{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Produto produto) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Produto.INSERT_ALL);
		
			statement.setString(1,produto.getTipo());
			statement.setInt(2,produto.getUnidade_entrada());
			statement.setInt(3,produto.getUnidade_saida());
			statement.setInt(4,produto.getQuantidade());
			statement.setFloat(5,produto.getPreco());
			statement.setString(6,produto.getNome());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Produto produto) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
