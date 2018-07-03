package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;
//criar ooutro IDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoPaciente implements IDaoPaciente{
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Paciente paciente) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT_ALL);
			//Configura os ???? do insert na ordem
			statement.setString(1,paciente.getNome());
			statement.setString(2,paciente.getRg());
			statement.setString(3,paciente.getCpf());
			statement.setInt(4,paciente.getTelefone());
			statement.setInt(5,paciente.getId_prontuario());
			statement.setString(6,paciente.getNome_mae());
			statement.setString(7,paciente.getNome_pai());
			
			statement.execute();
			statement.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("Erro ao Inserir no Banco! Contate o ADM");
		}
	}
//	public void salvar_sem_convenio(Paciente paciente) throws DaoException {
//		try {
//			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
//			statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT_SEM_CONVENIO);
//			//Configura os ???? do insert na ordem
//			statement.setString(1,paciente.getNome());
//			statement.setString(2,paciente.getRg());
//			statement.setString(3,paciente.getCpf());
//			statement.setInt(4,paciente.getTelefone());
//			statement.setInt(5,paciente.getId_prontuario());
//			statement.setString(6,paciente.getNome_mae());
//			statement.setString(7,paciente.getNome_pai());
//			
//			statement.execute();
//			statement.close();
//		}catch (SQLException e1) {
//			e1.printStackTrace();
//			throw new DaoException("Erro ao Inserir no Banco! Contate o ADM");
//		}
//	}
//	public void salvar_simples(Paciente paciente) throws DaoException {
//		try {
//			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
//			statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT_SEM_CONVENIO);
//			//Configura os ???? do insert na ordem
//		
//			statement.setString(1,paciente.getNome());
//			statement.setString(2,paciente.getRg());
//			statement.setString(3,paciente.getCpf());
//			statement.setInt(4,paciente.getTelefone());
//			statement.setString(5,paciente.getNome_mae());
//			statement.setString(6,paciente.getNome_pai());
//			
//			statement.execute();
//			statement.close();
//		}catch (SQLException e1) {
//			e1.printStackTrace();
//			throw new DaoException("Erro ao Inserir no Banco! Contate o ADM");
//		}
//	}
	@Override
	public void editar(Paciente paciente) throws DaoException {
		// TODO Auto-generated method stub

	}
	@Override
	public Paciente buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	public Paciente buscarPorCpf(String cpf) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
