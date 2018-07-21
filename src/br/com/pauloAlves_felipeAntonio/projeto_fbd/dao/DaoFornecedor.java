package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoFornecedor implements IDaoFornecedor {
	private Connection conexao;
	private PreparedStatement statement;
	private IDaoComum comunDao = new DaoComum();
	private ResultSet result;
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
			statement.setString(5,fornecedor.getTelefone());
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
	public List<Fornecedor> buscarPorBusca(String nome,String cnpj) throws DaoException {
		try{
			if(nome.equals("")&&cnpj.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_ALL);
				
				result = statement.executeQuery();
				
				ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
				
				while(result.next()){
					Fornecedor f = new Fornecedor();
					
					f.setNome(result.getString(1));
					f.setCnpj(result.getString(2));
					f.setIncs_municipal(result.getInt(3));
					f.setTelefone(result.getString(4));
					
					fornecedores.add(f);
				}
				statement.close();
				conexao.close();
				return fornecedores;
			}else if(nome.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_ALL_POR_CNPJ);
				statement.setString(1, cnpj);
				
				result = statement.executeQuery();
				
				ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
				
				while(result.next()){
					Fornecedor f = new Fornecedor();
					
					f.setNome(result.getString(1));
					f.setCnpj(result.getString(2));
					f.setIncs_municipal(result.getInt(3));
					f.setTelefone(result.getString(4));
					
					fornecedores.add(f);
				}
				statement.close();
				conexao.close();
				return fornecedores;
			}else if(cnpj.equals("")){
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_ALL_POR_NOME);
				statement.setString(1,nome);
				
				result = statement.executeQuery();
				
				ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
				
				while(result.next()){
					Fornecedor f = new Fornecedor();
					
					f.setNome(result.getString(1));
					f.setCnpj(result.getString(2));
					f.setIncs_municipal(result.getInt(3));
					f.setTelefone(result.getString(4));
					
					fornecedores.add(f);
				}
				statement.close();
				conexao.close();
				return fornecedores;
			}else{
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_ALL_POR_NOME_E_CNPJ);
				statement.setString(1, nome);
				statement.setString(2, cnpj);
				
				result = statement.executeQuery();
				
				ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
				
				while(result.next()){
					Fornecedor f = new Fornecedor();
					
					f.setNome(result.getString(1));
					f.setCnpj(result.getString(2));
					f.setIncs_municipal(result.getInt(3));
					f.setTelefone(result.getString(4));
					
					fornecedores.add(f);
				}
				statement.close();
				conexao.close();
				return fornecedores;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao buscar fornecedor!!");
		}
	
	}

}
