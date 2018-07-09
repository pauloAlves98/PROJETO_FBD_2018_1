package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario{
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Funcionario funcionario) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);
			
			statement.setString(1,funcionario.getNome());
			statement.setString(2,funcionario.getCpf());
			statement.setInt(3,funcionario.getId_clinicas());
			statement.setString(4,funcionario.getAdmim());
			statement.setString(5,funcionario.getBairro());
			statement.setString(6,funcionario.getSenha());
			statement.setString(7,funcionario.getCep());
			statement.setInt(8,funcionario.getId_cargos());
			statement.setString(9,funcionario.getNome_usuario());
			statement.setDate(10,funcionario.getData_acesso());
			statement.setInt(11,funcionario.getTelefone());
			statement.setString(12,funcionario.getRg());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Funcionario funcionario) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscaPorCpf(String rg) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
