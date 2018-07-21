package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoServico implements IDaoServico{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	@Override
	public void salvar(Servico servico) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Servico.INSERT_ALL);
			
			
			statement.setFloat(1,servico.getValor());
			statement.setString(2,servico.getTipo());
			statement.setString(3,servico.getDescricao());
		
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Servico servico) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servico buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servico> buscarPorBusca(String tipo,String descricao ) throws DaoException {
		try {
			if(tipo.equals("")&&descricao.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ALL_EXCETO_ID);
				
				result = statement.executeQuery();
				
				ArrayList<Servico> servicos  = new ArrayList<Servico>();
				
				while(result.next()){
					Servico servico = new Servico();
					servico.setTipo(result.getString(1));
					servico.setDescricao(result.getString(2));
					servico.setValor(result.getFloat(3));
					
					servicos.add(servico);
				}
				
				statement.close();
				conexao.close();
				return servicos;
			}else if(tipo.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ALL_EXCETO_ID_POR_DESCRICAO);
				statement.setString(1, descricao);
				
				result = statement.executeQuery();
				
				ArrayList<Servico> servicos  = new ArrayList<Servico>();
				
				while(result.next()){
					Servico servico = new Servico();
					servico.setTipo(result.getString(1));
					servico.setDescricao(result.getString(2));
					servico.setValor(result.getFloat(3));
					
					servicos.add(servico);
				}
				
				statement.close();
				conexao.close();
				return servicos;
			}else if(descricao.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ALL_EXCETO_ID_POR_TIPO);
				
				statement.setString(1, tipo);
				
				result = statement.executeQuery();
				
				ArrayList<Servico> servicos  = new ArrayList<Servico>();
				
				while(result.next()){
					Servico servico = new Servico();
					servico.setTipo(result.getString(1));
					servico.setDescricao(result.getString(2));
					servico.setValor(result.getFloat(3));
					
					servicos.add(servico);
				}
				
				statement.close();
				conexao.close();
				return servicos;
			}else{
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Servico.SELECT_ALL_EXCETO_ID_POR_TIPO_E_DESCRICAO);
				
				statement.setString(1, tipo);
				statement.setString(2, descricao);
				
				result = statement.executeQuery();
				
				ArrayList<Servico> servicos  = new ArrayList<Servico>();
				
				while(result.next()){
					Servico servico = new Servico();
					servico.setTipo(result.getString(1));
					servico.setDescricao(result.getString(2));
					servico.setValor(result.getFloat(3));
					
					servicos.add(servico);
				}
				
				statement.close();
				conexao.close();
				return servicos;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Buscar no banco!!!Contate o adm.");
		}
		
	}

}
