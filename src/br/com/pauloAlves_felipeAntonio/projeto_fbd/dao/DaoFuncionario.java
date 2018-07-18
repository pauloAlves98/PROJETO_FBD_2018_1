package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	private IDaoComum daoComum = new DaoComum();
	@Override
	public void salvar(Funcionario funcionario) throws DaoException {
		try {
			daoComum.salvarEndereco(funcionario.getEndereco());
			daoComum.salvarCargo(funcionario.getCargo());
			int id_endereco = daoComum.getCurrentValorTabela("endereco");
			int id_cargo = daoComum.getCurrentValorTabela("cargo");
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);
			
			statement.setString(1,funcionario.getNome());
			statement.setString(2,funcionario.getCpf());
			statement.setInt(3,funcionario.getId_clinicas());
			statement.setString(4,funcionario.getAdmim());
			statement.setString(5,funcionario.getSenha());
			statement.setInt(6,id_cargo);//pega o cargo e adiciona
			statement.setString(7,funcionario.getNome_usuario());
			statement.setDate(8,new Date(funcionario.getData_acesso().getTime()));
			statement.setString(9,funcionario.getTelefone());
			statement.setString(10,funcionario.getRg());
			statement.setInt(11,id_endereco);
			
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
