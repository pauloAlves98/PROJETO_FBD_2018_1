package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoContas_receber implements IDaoContas_receber{
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Contas_receber contas_receber) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.INSERT_ALL);
			
			statement.setFloat(1,contas_receber.getValor());
			statement.setInt(2,contas_receber.getId_caixas());
			statement.setInt(3,contas_receber.getId_vendas());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}
	@Override
	public void editar(Contas_receber contas_receber) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Contas_receber buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contas_receber> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
