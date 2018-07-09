package br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.IDaoConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoConsulta implements IDaoConsulta{
	private Connection conexao;
	private PreparedStatement statement;
	
	@Override
	public void salvar(Consulta consulta) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Consulta.INSERT_ALL);
		
			statement.setString(1,consulta.getTipo());
			statement.setString(2,consulta.getHorario());
			statement.setInt(3,consulta.getId_paciente());
			statement.setInt(4,consulta.getId_medico());
			statement.setDate(5,consulta.get_data());
			statement.setBoolean(6,consulta.isSituacao());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
		
	}

	@Override
	public void editar(Consulta consulta) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Consulta buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta buscaPorData(Date data) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulta> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
