package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoClinica implements IDaoClinica {

	private Connection conexao;
	private PreparedStatement statement;
	private IDaoComum daoComum = new DaoComum();
	@Override
	public void salvar(Clinica clinica) throws DaoException {
	
		try {

			daoComum.salvarEndereco(clinica.getEndereco());
			int id_endereco = daoComum.getCurrentValorTabela("endereco");
			
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Clinica.INSERT_ALL);

			statement.setString(1,clinica.getNome());
			statement.setString(2,clinica.getCnpj());
			statement.setString(3,clinica.getDescricao_complemento());
			statement.setInt(4,clinica.getTelefone());
			statement.setInt(5,id_endereco);
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
	}

	@Override
	public void editar(Clinica clinica) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clinica buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clinica buscaPorCnpj(String cnpj) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clinica> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
