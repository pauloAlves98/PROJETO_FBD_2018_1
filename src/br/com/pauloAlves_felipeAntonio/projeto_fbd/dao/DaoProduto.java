package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoProduto implements IDaoProduto{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	//private IDaoComum daoComum =new DaoComum();
	@Override
	public void salvar(Produto produto) throws DaoException {
		try {
			
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Produto.INSERT_ALL);
		
			statement.setString(1,produto.getTipo());
			statement.setString(2,produto.getNome());
			statement.setInt(3, produto.getIdFornecedor());
			statement.setInt(4,produto.getVendaVarejo());
			statement.setInt(5, produto.getVendaAtacado());
			
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Produto produto) throws DaoException {
		try {
			
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Produto.UPDATE_ALL);
		
			statement.setString(1,produto.getNome());
			statement.setString(2,produto.getTipo());
			statement.setInt(3, produto.getIdFornecedor());
			statement.setInt(4,produto.getVendaVarejo());
			statement.setInt(5, produto.getVendaAtacado());
			statement.setInt(6, produto.getId());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
	}

	@Override
	public Produto buscarPorId(int id) throws DaoException {
		conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
		try {
			statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_NOME_PRODUTO_POR_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			
			Produto p = new Produto();
			
			if(result.next()) {
				p.setNome(result.getString(1));
				p.setVendaVarejo(result.getInt(2));
				p.setVendaAtacado(result.getInt(3));
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar no banco!!!Contate o adm.");
		}
	}

	@Override
	public List<Produto> buscarPorBusca(String buscar) throws DaoException {
		try{
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_ALL_POR_NOME_OU_TIPO);
			statement.setString(1, buscar);
			statement.setString(2, buscar);
			result = statement.executeQuery();
			
			ArrayList<Produto> produtos = new ArrayList<Produto>();
				
			while(result.next()){
				Produto produto = new Produto();
				
				produto.setNome(result.getString(1));
				produto.setTipo(result.getString(2));
				produto.setIdFornecedor(result.getInt(3));
				produto.setVendaVarejo(result.getInt(4));
				produto.setVendaAtacado(result.getInt(5));
				produto.setId(result.getInt(6));
				
					
				produtos.add(produto);
			}
			statement.execute();
			statement.close();
			return produtos;
		
		}catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException("Erro ao buscar no banco!!!Contate o adm.");
		}
	}

	

}
