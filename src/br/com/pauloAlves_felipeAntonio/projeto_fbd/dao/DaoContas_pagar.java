package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoContas_pagar implements IDaoContas_pagar{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	@Override
	public void salvar(Contas_pagar contas_pagar) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_pagar.INSERT_ALL);
			
			statement.setFloat(1,contas_pagar.getValor());
			statement.setInt(2,contas_pagar.getId_caixas());
			statement.setInt(3,contas_pagar.getId_item_produto());
			statement.setInt(4, contas_pagar.getParcela());
			
			statement.execute();
			statement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
	}

	@Override
	public void editar(Contas_pagar contas_pagar) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_pagar.UPDATE_ALL);
			
			statement.setFloat(1,contas_pagar.getValorPago());
			statement.setInt(2,contas_pagar.getParcela());
			statement.setInt(3, contas_pagar.getParecelasTotais());
			statement.setInt(4,contas_pagar.getId());
			
			
			statement.execute();
			statement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

	@Override
	public Contas_pagar buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contas_pagar> buscarPorBusca(String busca) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Contas_pagar.SELECT_ALL);
			
			statement.setString(1, busca);
			statement.setString(2, busca);
			result = statement.executeQuery();
			
			ArrayList<Contas_pagar> contasAPagar = new ArrayList<Contas_pagar>();
			int j, k;
			
			while(result.next()) {
				j=0;
				k=0;
				Contas_pagar contaPagar = new Contas_pagar();
				contaPagar.setId(result.getInt(1));
				contaPagar.setValor(result.getFloat(2));
				contaPagar.setNomeFornecedor(result.getString(3));
				contaPagar.setNomeProduto(result.getString(4));
				contaPagar.setQuantidade(result.getInt(5));
				contaPagar.setValorPago(result.getFloat(6));
				if(result.getInt(7)>0) {
					j= result.getInt(7);
				}
				contaPagar.setParcela(j);
				if(result.getInt(8) > 0) {
					k = result.getInt(8);
				}
				contaPagar.setParecelasTotais(k);
				
				contasAPagar.add(contaPagar);
			}
			statement.close();
			conexao.close();
			return contasAPagar;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}

}
