package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoContas_pagar implements IDaoContas_pagar{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Contas_pagar contas_pagar) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_pagar.INSERT_ALL);
			
			statement.setFloat(1,contas_pagar.getValor());
			statement.setInt(2,contas_pagar.getId_caixas());
			statement.setInt(3,contas_pagar.getId_dispesas());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
	}

	@Override
	public void editar(Contas_pagar contas_pagar) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contas_pagar buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contas_pagar> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
