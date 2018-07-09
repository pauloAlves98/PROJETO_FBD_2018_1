package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoMedico implements IDaoMedico{
	private Connection conexao;
	private PreparedStatement statement;
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
	
}
