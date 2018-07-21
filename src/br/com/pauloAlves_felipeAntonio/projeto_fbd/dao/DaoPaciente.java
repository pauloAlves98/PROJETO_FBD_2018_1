package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;
//criar ooutro IDao
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoPaciente implements IDaoPaciente{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	private IDaoLaudo daoLaudo = new DaoLaudo(); //Perguntar se Pode????
    private IDaoComum comunDao = new DaoComum();
	@Override
	public void salvar(Paciente paciente) throws DaoException {
		try {
			comunDao.salvarEndereco(paciente.getEndereco());
			int id_endereco = comunDao.getCurrentValorTabela("endereco");
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT_ALL);
			//Configura os ???? do insert na ordem
			statement.setString(1,paciente.getNome());
			statement.setString(2,paciente.getRg());
			statement.setString(3,paciente.getCpf());
			statement.setString(4,paciente.getTelefone());
			statement.setString(5,paciente.getNome_mae());
			statement.setString(6,paciente.getNome_pai());
			statement.setInt(7,id_endereco);
			statement.setDate(8,new Date(paciente.getDataNascimento().getTime()));
			
			statement.execute();
			conexao.close();
			statement.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
			throw new DaoException("Erro ao Inserir no Banco! Contate o ADM");
		}
	}

	@Override
	public void editar(Paciente paciente) throws DaoException {
	

	}
	@Override
	public Paciente buscarPorId(int id) throws DaoException {
	
		return null;
	}

	@Override
	public List<Paciente> buscarPorBusca(String nome,String cpf) throws DaoException {
		if(nome.equals("")&&cpf.equals("")){
			try{
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Paciente.SELECT_ALL);
				//statement.setString(1,cpf);
				result = statement.executeQuery();
				
				ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
				Paciente paciente = null;
				//Endereco end = null; 
				while(result.next()){
					paciente = new Paciente();
				//	paciente.setId(result.getInt(1));
					paciente.setNome(result.getString(1));
					paciente.setRg(result.getString(2));
					paciente.setCpf(result.getString(3));
					paciente.setTelefone(result.getString(4));
					paciente.setDataNascimento(result.getDate(5));
					System.out.print(paciente.getNome());
					pacientes.add(paciente);
					
				}
				statement.close();
				conexao.close();
				return pacientes;
			}catch (SQLException e) {
				 e.printStackTrace();
				 throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
			}
		}else if(nome.equals("")){
			
			try {
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Paciente.SELECT_ALL_EXCETO_PRONTUARIO_POR_CPF);
			
				statement.setString(1,cpf);
				result = statement.executeQuery();
				
				ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
				Paciente paciente = null;
				Endereco end = null; 
				
				while(result.next()){
					paciente = new Paciente();
					paciente.setId(result.getInt(1));
					paciente.setNome(result.getString(2));
					paciente.setRg(result.getString(3));
					paciente.setCpf(result.getString(4));
					paciente.setTelefone(result.getString(5));
					paciente.setNome_mae(result.getString(6));
					paciente.setNome_pai(result.getString(7));
				
					end = new Endereco();
					end.setCep(result.getString(8));
					end.setEstado(result.getString(9));
					end.setLogradouro(result.getString(10));
					end.setComplemento(result.getString(11));
					end.setBairro(result.getString(12));
					end.setPais(result.getString(13));
					end.setCidade(result.getString(14));
					end.setRua(result.getString(15));
					end.setNumero(result.getInt(16));
					
					paciente.setDataNascimento(result.getDate(17));
					
					paciente.setEndereco(end);
					
					pacientes.add(paciente);
					
				}
				statement.close();
				conexao.close();
				return pacientes;
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cpf.equals("")){
			try{
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Paciente.SELECT_ALL_POR_NOME);
				statement.setString(1,nome);
				result = statement.executeQuery();
				
				ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
				Paciente paciente = null;
				//Endereco end = null; 
				
				while(result.next()){
					paciente = new Paciente();
					//paciente.setId(result.getInt(1));
					paciente.setNome(result.getString(1));
					paciente.setRg(result.getString(2));
					paciente.setCpf(result.getString(3));
					paciente.setTelefone(result.getString(4));
					paciente.setDataNascimento(result.getDate(5));
					
					//paciente.setEndereco(end);
					
					pacientes.add(paciente);
					
					
				}
				statement.close();
				conexao.close();
				return pacientes;
			}catch (SQLException e) {
				 e.printStackTrace();
				 throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
			}
		}else {	
			try {
				conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
				statement = conexao.prepareStatement(SQLUtil.Paciente.SELECT_ALL_POR_NOME_E_CPF);
			
				statement.setString(1,cpf);
				statement.setString(2,nome);
				result = statement.executeQuery();
				
				ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
				Paciente paciente = null;
				//Endereco end = null; 
				
				while(result.next()){
					paciente = new Paciente();
					//paciente.setId(result.getInt(1));
					paciente.setNome(result.getString(1));
					paciente.setRg(result.getString(2));
					paciente.setCpf(result.getString(3));
					paciente.setTelefone(result.getString(4));
										
					paciente.setDataNascimento(result.getDate(5));
					
					pacientes.add(paciente);
				}
				statement.close();
				conexao.close();
				return pacientes;
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	public Paciente buscarPorCpf(String cpf) throws DaoException {
		try {
			
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Paciente.SELECT_ALL_EXCETO_PRONTUARIO_POR_CPF);
			statement.setString(1,cpf);
			result = statement.executeQuery();
			
			Paciente paciente = null;
			Endereco end = null; 
			
			if(result.next()){
				paciente = new Paciente();
				paciente.setId(result.getInt(1));
				paciente.setNome(result.getString(2));
				paciente.setRg(result.getString(3));
				paciente.setCpf(result.getString(4));
				paciente.setTelefone(result.getString(5));
				paciente.setNome_mae(result.getString(6));
				paciente.setNome_pai(result.getString(7));
			
				end = new Endereco();
				end.setCep(result.getString(8));
				end.setEstado(result.getString(9));
				end.setLogradouro(result.getString(10));
				end.setComplemento(result.getString(11));
				end.setBairro(result.getString(12));
				end.setPais(result.getString(13));
				end.setCidade(result.getString(14));
				end.setRua(result.getString(15));
				end.setNumero(result.getInt(16));
				
				paciente.setDataNascimento(result.getDate(17));
				
				paciente.setEndereco(end);
			}
			else
				throw new DaoException("CPF Não Existe no Banco!!!");
			statement.close();
			conexao.close();
			return paciente;
			//Buscar o laudo separado pos retorna uma lista
		} catch (SQLException e) {
			 e.printStackTrace();
			 throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
		
	}
	@Override
	public int buscarIdPorCpf(String cpf) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Paciente.SELECT_ID_POR_CPF);
			statement.setString(1,cpf);
			result = statement.executeQuery();
			
			int id = 0;
			if(result.next())
				id = result.getInt(1);
			else
				throw new DaoException("CPF Não Existe no Banco!!!");
			statement.close();
			conexao.close();
			return id;
			//Buscar o laudo separado pos retorna uma lista
		} catch (SQLException e) {
			 e.printStackTrace();
			 throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
		}
		
		
	}
}
