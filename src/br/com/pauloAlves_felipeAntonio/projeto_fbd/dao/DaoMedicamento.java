package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoMedicamento implements IDaoMedicamento{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Medicamento medicamento) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Medicamento.INSERT_ALL);

			statement.setString(1,medicamento.getDescricao_laboratorio());
			statement.setString(2,medicamento.getDesricao_generica());
			statement.setString(3,medicamento.getDescricao_substancia());
			statement.setString(4,medicamento.getNome());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
		
	}

	@Override
	public void editar(Medicamento medicamento) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medicamento buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicamento> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
