package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoContas_receber implements IDaoContas_receber{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	@Override
	public void salvar(Contas_receber contas_receber) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.INSERT_ALL);
			
			statement.setFloat(1,contas_receber.getValor());
			statement.setInt(2,contas_receber.getId_caixas());
			statement.setInt(3,contas_receber.getId_paciente());
			statement.setInt(4, contas_receber.getParcelas());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}
	@Override
	public void editar(Contas_receber contas_receber) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.UPDATE_ALL);
			
			statement.setFloat(1,contas_receber.getParcelas());
			statement.setFloat(2,contas_receber.getValorPago());
			statement.setInt(3,contas_receber.getId());
			
			
			statement.execute();
			statement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
	}
	@Override
	public Contas_receber buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.SELECT_CONTA_RECEBER);
		
			statement.setInt(1, id);
			result  = statement.executeQuery();
			Contas_receber conta_receber = new Contas_receber();
			//ArrayList<Contas_receber> contas_recebers = new ArrayList<Contas_receber>();
			float i ;
			if(result.next()) {
				i = 0;
				conta_receber = new Contas_receber();
				conta_receber.setValorPago(result.getFloat(1));
				
				
			}
			statement.close();
			conexao.close();
			return conta_receber;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
	}
	@Override
	public List<Contas_receber> buscarPorBusca(String busca) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.SELECT_ALL);
		
			statement.setString(1, busca);
			result  = statement.executeQuery();
			Contas_receber conta_receber;
			ArrayList<Contas_receber> contas_recebers = new ArrayList<Contas_receber>();
			float i ;
			while(result.next()) {
				i = 0;
				conta_receber = new Contas_receber();
				conta_receber.setId(result.getInt(1));
				conta_receber.setNome(result.getString(2));
				conta_receber.setSaldo(result.getFloat(3));
				conta_receber.setValor(result.getFloat(4));
				if(result.getFloat(5)>0) {
					i = result.getFloat(5);
				}
				
				conta_receber.setValorPago(i);
				conta_receber.setParcelas(result.getInt(6));
				
				contas_recebers.add(conta_receber);
				
			}
			statement.close();
			conexao.close();
			return contas_recebers;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
	}
	
	public float soma() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.SELECT_SOMA_VALOR);
			
			result = statement.executeQuery();
			
			float i = 0;
			if(result.next()) {
				i = result.getFloat(1);
			}
			statement.close();
			conexao.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
	}
	@Override
	public float somaValorPago() throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_receber.SELECT_SOMA_VALOR_PAGO);
			
			result = statement.executeQuery();
			
			float i = 0;
			if(result.next()) {
				if(result.getFloat(1)>0) {
					i = result.getFloat(1);
				}
				
			}
			statement.close();
			conexao.close();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
	}
}
