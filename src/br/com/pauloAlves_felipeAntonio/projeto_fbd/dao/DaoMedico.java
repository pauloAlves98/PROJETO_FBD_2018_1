package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoMedico implements IDaoMedico{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	private IDaoComum daoComum = new DaoComum();
	@Override
	public void salvar(Medico medico) throws DaoException {
		try {
			daoComum.salvarEndereco(medico.getEndereco());
			int id_endereco = daoComum.getCurrentValorTabela("endereco");
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Medico.INSERT_ALL);
			
			statement.setString(1,medico.getCpf());
			statement.setString(2,medico.getArea());
			statement.setString(3,medico.getEspecialidade());
			statement.setString(4,medico.getNome_usuario());
			statement.setString(5,medico.getSenha());
			statement.setString(6,medico.getNome());
			statement.setString(7,medico.getRg());
			statement.setString(8,medico.getAdmin());
			statement.setInt(9,id_endereco);
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Inserir no Banco! Contate o ADM");
		}
		
	}
	@Override
	public void editar(Medico medico) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Medico buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscarPorCpf(String cpf) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medico> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Medico>buscarInfoPorFiltro(String busca) throws DaoException{//Colocar no businness e na Fachada
			try {
				conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Medico.SELECT_INFO_POR_NOME_CPF_ESPECIALIDADE);
				busca = "%"+busca+"%";
				statement.setString(1,busca);
				statement.setString(2,busca);
				statement.setString(3,busca);
				result = statement.executeQuery();
				
				List<Medico>medicos = new ArrayList<Medico>();
				while(result.next()){
					Medico p = new Medico();
					p.setId(result.getInt(1));
					p.setNome(result.getString(2));
					p.setCpf(result.getString(3));
					p.setEspecialidade(result.getString(4));
					medicos.add(p);
				}
				conexao.close();
				statement.close();
				result.close();
				return medicos;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
			}
	}
	
}
