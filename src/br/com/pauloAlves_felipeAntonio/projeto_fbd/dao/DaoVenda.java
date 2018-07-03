package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Venda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoVenda implements IDaoVenda{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Venda venda) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Venda.INSERT_ALL);
			 
			
	        statement.setDate(1,venda.getData());
			statement.setInt(2,venda.getNota_fiscal());
			statement.setBoolean(3,venda.isStatus());
			statement.setFloat(4,venda.getTotal());
			statement.setFloat(5,venda.getDesconto());
			statement.setFloat(6,venda.getValor_recebido());
			statement.setFloat(7,venda.getTroco());
			statement.setInt(8,venda.getId_pacientes());
		
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
	}

	@Override
	public void editar(Venda venda) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venda buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
