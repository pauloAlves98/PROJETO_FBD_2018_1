package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
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
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public void editar(Fornecedor fornecedor) throws DaoException {
		
		try {
			comunDao.editarEndereco(fornecedor.getEndereco(),fornecedor.getEndereco().getId());
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.UPDATE_ALL);
			statement.setInt(1,fornecedor.getIncs_municipal());
			statement.setString(2,fornecedor.getCnpj());
			statement.setInt(3,fornecedor.getInsc_estadual());
			statement.setString(4,fornecedor.getNome());
			statement.setString(5,fornecedor.getTelefone());
			statement.setInt(6,fornecedor.getId());
			 
			statement.execute();
			statement.close();
			conexao.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new DaoException("Erro ao atualizar Fornecedor");
		}
	}

//	@Override
//	public Fornecedor buscarPorId(int id) throws DaoException {
//		
//	
//	}

	@Override
	public List<Fornecedor> buscarPorBusca(String buscar) throws DaoException {
		try{
			
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_ALL_POR_NOME_CNPJ);
				statement.setString(1, buscar);
				statement.setString(2, buscar);

				
				result = statement.executeQuery();
				
				ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
				
				while(result.next()){
					Fornecedor f = new Fornecedor();
					Endereco end = new Endereco();
					//cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero,
					f.setNome(result.getString(1));
					f.setCnpj(result.getString(2));
					f.setIncs_municipal(result.getInt(3));
					f.setTelefone(result.getString(4));
					f.setId(result.getInt(5));
					end.setCep(result.getString(6));
					end.setEstado(result.getString(7));
					end.setLogradouro(result.getString(8));
					end.setComplemento(result.getString(9));
					end.setBairro(result.getString(10));
					end.setPais(result.getString(11));
					end.setCidade(result.getString(12));
					end.setRua(result.getString(13));
					end.setNumero(result.getInt(14));
					end.setId(result.getInt(15));
					f.setEndereco(end);
					fornecedores.add(f);
				}
				statement.close();
				conexao.close();
				return fornecedores;
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao buscar fornecedor!!");
		}
	
	}

	@Override
	public String buscarPorId(int id) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_NOME_POR_ID);
			statement.setInt(1, id);
			
			result = statement.executeQuery();
	
			//Fornecedor f = new Fornecedor();
			String s = null;
			if(result.next()){
				s = result.getString(1);
				
			}
			statement.close();
			conexao.close();
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar fornecedor!!");
		}
		
		
	}

}
