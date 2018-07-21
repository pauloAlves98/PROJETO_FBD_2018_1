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
	public List<Produto> buscarPorBusca(String nome ,String tipo) throws DaoException {
		try{
			if(nome.equals("")&&tipo.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_ALL);
				
				result = statement.executeQuery();
				
				ArrayList<Produto> produtos = new ArrayList<Produto>();
				
				while(result.next()){
					Produto produto = new Produto();
					
					produto.setNome(result.getString(1));
					produto.setTipo(result.getString(2));
					produto.setPreco(result.getFloat(3));
					produto.setQuantidade(result.getInt(4));
					
					produtos.add(produto);
				}
				statement.execute();
				statement.close();
				return produtos;
			}else if(tipo.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_ALL_POR_NOME);
				statement.setString(1, nome);
				result = statement.executeQuery();
				
				ArrayList<Produto> produtos = new ArrayList<Produto>();
				
				while(result.next()){
					Produto produto = new Produto();
					
					produto.setNome(result.getString(1));
					produto.setTipo(result.getString(2));
					produto.setPreco(result.getFloat(3));
					produto.setQuantidade(result.getInt(4));
					
					produtos.add(produto);
				}
				statement.execute();
				statement.close();
				return produtos;	
			}else if(nome.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_ALL_POR_TIPO);
				
				statement.setString(1, tipo);
				
				result = statement.executeQuery();
				
				ArrayList<Produto> produtos = new ArrayList<Produto>();
				
				while(result.next()){
					Produto produto = new Produto();
					
					produto.setNome(result.getString(1));
					produto.setTipo(result.getString(2));
					produto.setPreco(result.getFloat(3));
					produto.setQuantidade(result.getInt(4));
					
					produtos.add(produto);
				}
				statement.execute();
				statement.close();
				return produtos;
			}else{
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_ALL_POR_NOME_E_TIPO);
				
				statement.setString(1, nome);
				statement.setString(2,tipo);
				
				result = statement.executeQuery();
				
				ArrayList<Produto> produtos = new ArrayList<Produto>();
				
				while(result.next()){
					Produto produto = new Produto();
					
					produto.setNome(result.getString(1));
					produto.setTipo(result.getString(2));
					produto.setPreco(result.getFloat(3));
					produto.setQuantidade(result.getInt(4));
					
					produtos.add(produto);
				}
				statement.execute();
				statement.close();
				return produtos;
			}
		}catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException("Erro ao buscar no banco!!!Contate o adm.");
		}
	}

}
