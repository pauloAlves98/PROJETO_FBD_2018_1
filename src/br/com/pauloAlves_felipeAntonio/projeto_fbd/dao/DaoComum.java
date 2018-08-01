package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoComum implements IDaoComum {

	private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;


    @Override
    public void salvarEndereco(Endereco endereco) throws DaoException {

        try {
        	
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
            
            statement.setString(1, endereco.getCep());
            statement.setString(2, endereco.getEstado());
            statement.setString(3, endereco.getLogradouro());
            statement.setString(4, endereco.getComplemento());
            statement.setString(5, endereco.getBairro());
            statement.setString(6, endereco.getPais());
            statement.setString(7, endereco.getCidade());
            statement.setString(8, endereco.getRua());
            statement.setInt(9, endereco.getNumero());
            
            statement.execute();
            this.conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO SALVAR ENDERECO - Contate o ADM");
        }
    }

    @Override
    public int getCurrentValorTabela(String nomeTabela) throws DaoException {

        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("select id from " + nomeTabela + " order by id desc limit 1");

            result = this.statement.executeQuery();
            int id;
            if (result.next()) {
                id = result.getInt(1);
            } else {
                throw new DaoException("Não há registro nessa tabela");
            }
            this.conexao.close();
            return id;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR " + nomeTabela + " - Contate o ADM");
        }
    }

	@Override
	public void salvarCargo(Cargo cargo) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Cargo.INSERT_ALL);
		
			statement.setString(1,cargo.getDescricao_cargo());
			statement.setString(2,cargo.getNome());
		
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir Cargo no banco!!!Contate o adm.");
		}
		
	}
	public void editarEndereco(Endereco endereco,int k) throws DaoException{
		
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Endereco.UPDATE_ALL_ENDERECO);
			
			 statement.setString(1, endereco.getCep());
	         statement.setString(2, endereco.getEstado());
	         statement.setString(3, endereco.getLogradouro());
	         statement.setString(4, endereco.getComplemento());
	         statement.setString(5, endereco.getBairro());
	         statement.setString(6, endereco.getPais());
	         statement.setString(7, endereco.getCidade());
	         statement.setString(8, endereco.getRua());
	         statement.setInt(9, endereco.getNumero());
	         statement.setInt(10,k);
	            
	         statement.execute();
	         this.conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editarCargo(Cargo c) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Cargo.UPDATE_ALL);
			
			 statement.setString(1, c.getNome());
	         statement.setString(2, c.getDescricao_cargo());
	         statement.setInt(3,c.getId());
	            
	         statement.execute();
	         this.conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
