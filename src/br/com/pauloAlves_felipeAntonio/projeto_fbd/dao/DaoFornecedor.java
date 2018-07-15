package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoFornecedor implements IDaoFornecedor {
	private Connection conexao;
	private PreparedStatement statement;
	private IDaoComum comunDao = new DaoComum();
	@Override
	public void salvar(Fornecedor fornecedor) throws DaoException {
		try {
			comunDao.salvarEndereco(fornecedor.getEndereco());
			int id_endereco = comunDao.getCurrentValorTabela("endereco");
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.INSERT_ALL);
			
	
			statement.setInt(1,fornecedor.getIncs_municipal());
			statement.setString(2,fornecedor.getCnpj());
			statement.setInt(3,fornecedor.getInsc_estadual());
			statement.setString(4,fornecedor.getNome());
			statement.setInt(5,fornecedor.getTelefone());
			statement.setInt(6, id_endereco);
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Fornecedor fornecedor) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
