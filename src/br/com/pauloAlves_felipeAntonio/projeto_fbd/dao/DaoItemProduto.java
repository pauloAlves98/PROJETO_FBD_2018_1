package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoItemProduto implements IDaoItemProduto{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	public void salvar(ItemProduto itemProduto) throws DaoException {
		try {	
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.ItemProduto.INSERT_ALL);
			statement.setInt(1, itemProduto.getId_produto());
			statement.setDate(2, new Date(itemProduto.getDataCompra().getTime()));
			statement.setDate(3,new Date(itemProduto.getVencimento().getTime()));
			statement.setFloat(4, itemProduto.getPrecoCompra());
			statement.setInt(5, itemProduto.getQuantidade());
			
			statement.execute();
			conexao.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void editar(ItemProduto itemProduto) throws DaoException {
		try {	
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.ItemProduto.UPDATE_ALL);
			
			statement.setInt(1, itemProduto.getId_produto());
			statement.setDate(2, new Date(itemProduto.getDataCompra().getTime()));
			statement.setDate(3,new Date(itemProduto.getVencimento().getTime()));
			statement.setFloat(4, itemProduto.getPrecoCompra());
			statement.setInt(5, itemProduto.getQuantidade());
			
			statement.execute();
			conexao.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public ItemProduto buscarPorId(int id) throws DaoException {
		try {	
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.ItemProduto.SELECT_ALL_POR_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			ItemProduto i = new ItemProduto();
			if(result.next()) {
				
				i.setId(result.getInt(1));
				i.setId_produto(result.getInt(2));
				i.setDataCompra(result.getDate(3));
				i.setVencimento(result.getDate(4));
				i.setPrecoCompra(result.getFloat(5));
				i.setQuantidade(result.getInt(6));
				
				
			}
			conexao.close();
			statement.close();
			
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar no banco!!!Contate o adm.");
		}
	}

	
	public List<ItemProduto> buscarPorBusca() throws DaoException {
		try {	
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.ItemProduto.SELECT_ALL);
			result = statement.executeQuery();
			ArrayList<ItemProduto> itemProdutos = new ArrayList<ItemProduto>();
			if(result.next()) {
				ItemProduto i = new ItemProduto();
				i.setId(result.getInt(1));
				i.setId_produto(result.getInt(2));
				i.setVencimento(result.getDate(3));
				i.setPrecoCompra(result.getFloat(4));
				i.setQuantidade(result.getInt(5));
				itemProdutos.add(i);
				
				
			}
			conexao.close();
			statement.close();
			
			return itemProdutos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar no banco!!!Contate o adm.");
		}
	
		
	}


	@Override
	public List<ItemProduto> buscarPorId_produto(int id) throws DaoException {
		try {	
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.ItemProduto.SELECT_ALL_POR_ID_PRODUTO);
			statement.setInt(1, id);
			result = statement.executeQuery();
			ArrayList<ItemProduto> itemProdutos = new ArrayList<ItemProduto>();
			if(result.next()) {
				ItemProduto i = new ItemProduto();
				i.setId(result.getInt(1));
				i.setId_produto(result.getInt(2));
				i.setDataCompra(result.getDate(3));
				i.setVencimento(result.getDate(4));
				i.setPrecoCompra(result.getFloat(5));
				i.setQuantidade(result.getInt(6));
				itemProdutos.add(i);
				
				
			}
			conexao.close();
			statement.close();
			
			return itemProdutos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar no banco!!!Contate o adm.");
		}
	}

}
