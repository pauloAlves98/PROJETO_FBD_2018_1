package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
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
		daoComum.editarEndereco(medico.getEndereco(),medico.getEndereco().getId() );
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Medico.UPDATE_ALL);

			statement.setString(1,medico.getCpf());
			statement.setString(2,medico.getArea());
			statement.setString(3,medico.getEspecialidade());
			statement.setString(4,medico.getNome_usuario());
			statement.setString(5,medico.getSenha());
			statement.setString(6,medico.getNome());
			statement.setString(7,medico.getRg());
			statement.setString(8,medico.getAdmin());
			statement.setInt(9,medico.getId());
			statement.execute();

			statement.close();
			conexao.close();


		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Atualizar Médico!!");
		}
		
	}
	@Override
	public Medico buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscarPorCpf(String cpf) throws DaoException {
		return null;
	}

	@Override
	public List<Medico> buscarPorBusca(String cpf) throws DaoException {
		try {
			conexao  = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Medico.SELECT_ALL);
			statement.setString(1,cpf);
			result = statement.executeQuery();
			List<Medico>medicos = new ArrayList<Medico>();
			
			while(result.next()){
				Medico p = new Medico();
				p.setId(result.getInt(1));
				p.setCpf(result.getString(2));
				p.setArea(result.getString(3));
				p.setEspecialidade(result.getString(4));
				p.setNome_usuario(result.getString(5));
				p.setSenha(result.getString(6));
				p.setNome(result.getString(7));
				p.setRg(result.getString(8));
				p.setAdmin(result.getString(9));
				p.setId_endereco(result.getInt(10));
				
				Endereco end = new Endereco();
				end.setCep(result.getString(11));
				end.setEstado(result.getString(12));
				end.setLogradouro(result.getString(13));
				end.setComplemento(result.getString(14));
				end.setBairro(result.getString(15));
				end.setPais(result.getString(16));
				end.setCidade(result.getString(17));
				end.setRua(result.getString(18));
				end.setNumero(result.getInt(19));
				
				p.setEndereco(end);
				medicos.add(p);
			}
			conexao.close();
			statement.close();
			result.close();
			return medicos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("PROBLEMA AO CONSULTAR MEDICO - Contate o ADM");
		}
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
	public Medico buscaPorLogin_senha(String login , String senha) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Medico.SELECT_POR_LOGIN_SENHA);
			login = "%"+login+"%"
;			statement.setString(1,login);
			statement.setString(2, senha);
			result = statement.executeQuery();
			Medico func = null;
			if(result.next()){
				func = new Medico();
				func.setId(result.getInt(1));
				func.setNome(result.getString(2));
				func.setCpf(result.getString(3));
				func.setAdmin(result.getString(4));
				func.setNome_usuario(result.getString(5));
				func.setSenha(result.getString(6));
			}else
				throw new DaoException("Login ou Senha Inválidos!!!");
			return func;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao acessar banco, Contate o ADM!");
		}

	}
	
}
