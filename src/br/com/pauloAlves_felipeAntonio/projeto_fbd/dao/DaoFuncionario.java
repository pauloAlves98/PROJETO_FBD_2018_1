package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario{
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	private IDaoComum daoComum = new DaoComum();
	@Override
	public void salvar(Funcionario funcionario) throws DaoException {
		try {

			daoComum.salvarEndereco(funcionario.getEndereco());
			daoComum.salvarCargo(funcionario.getCargo());
			int id_endereco = daoComum.getCurrentValorTabela("endereco");
			int id_cargo = daoComum.getCurrentValorTabela("cargo");
			int id_clinica = daoComum.getCurrentValorTabela("clinica");
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);

			statement.setString(1,funcionario.getNome());
			statement.setString(2,funcionario.getCpf());
			statement.setInt(3,id_clinica);
			statement.setString(4,funcionario.getAdmim());
			statement.setString(5,funcionario.getSenha());
			statement.setInt(6,id_cargo);//pega o cargo e adiciona
			statement.setString(7,funcionario.getNome_usuario());
			statement.setDate(8,new Date(funcionario.getData_acesso().getTime()));
			statement.setString(9,funcionario.getTelefone());
			statement.setString(10,funcionario.getRg());
			statement.setInt(11,id_endereco);

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}

	}

	@Override
	public void editar(Funcionario funcionario) throws DaoException {

		daoComum.editarCargo(funcionario.getCargo());
		daoComum.editarEndereco(funcionario.getEndereco(),funcionario.getEndereco().getId() );
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.UPDATE_ALL);
			statement.setString(1,funcionario.getNome());
			statement.setString(2,funcionario.getCpf());
			statement.setString(3,funcionario.getRg());
			statement.setString(4,funcionario.getTelefone());
			statement.setString(5,funcionario.getAdmim());
			statement.setString(6,funcionario.getNome_usuario());
			statement.setString(7,funcionario.getSenha());
			statement.setDate(8,new Date(funcionario.getData_acesso().getTime()));
			statement.setString(9,funcionario.getCpf());
			statement.execute();

			statement.close();
			conexao.close();


		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Buscar Funcionarios!!");
		}

	}

	@Override
	public Funcionario buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscaPorCpf(String rg) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorBusca(String busca) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_ALL_CPF);
			statement.setString(1,busca);
			result = statement.executeQuery();
			List<Funcionario>funcs = new ArrayList<Funcionario>();
			Funcionario func = null;


			while(result.next()){
				func = new Funcionario();
				Cargo cargo = new Cargo();
				Endereco end = new Endereco();

				func.setNome(result.getString(1));
				func.setCpf(result.getString(2));
				func.setRg(result.getString(3));
				func.setTelefone(result.getString(4));
				func.setAdmim(result.getString(5));
				func.setNome_usuario(result.getString(6));
				func.setSenha(result.getString(7));
				func.setData_acesso(result.getDate(8));
				func.setId_endereco(result.getInt(9));
				func.setId_cargos(result.getInt(10));

				cargo.setNome(result.getString(11));
				cargo.setDescricao_cargo(result.getString(12));

				end.setCep(result.getString(13));
				end.setEstado(result.getString(14));
				end.setLogradouro(result.getString(15));
				end.setComplemento(result.getString(16));
				end.setBairro(result.getString(17));
				end.setPais(result.getString(18));
				end.setCidade(result.getString(19));
				end.setRua(result.getString(20));
				end.setNumero(result.getInt(21));

				func.setEndereco(end);
				func.setCargo(cargo);
				func.setId(result.getInt(22));
				funcs.add(func);
			}
			return funcs;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Buscar Funcionarios!!");
		}

	}

	@Override
	public Funcionario buscaPorLogin_senha(String login , String senha) throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_POR_LOGIN_SENHA);

			statement.setString(1,login);
			statement.setString(2, senha);
			result = statement.executeQuery();
			Funcionario func = null;
			if(result.next()){
				func = new Funcionario();
				func.setId(result.getInt(1));
				func.setNome(result.getString(2));
				func.setCpf(result.getString(3));
				func.setAdmim(result.getString(4));
				func.setNome_usuario(result.getString(5));
				func.setSenha(result.getString(6));
			}else
				throw new DaoException("Login ou Senha Inv�lidos!!!");
			return func;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Login ou Senha Inv�lidos!!!");
		}

	}

	@Override
	public List<Funcionario> buscarInfoPorCpf(String busca) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_INFO_POR_CPF);

			statement.setString(1,busca);

			result = statement.executeQuery();
			List<Funcionario>funcs = new ArrayList<Funcionario>();
			Funcionario func = null;
			while(result.next()){
				func = new Funcionario();

				func.setNome(result.getString(1));
				func.setCpf(result.getString(2));
				func.setTelefone(result.getString(3));
				func.setData_acesso(result.getDate(4));
				funcs.add(func);
			}
			return funcs;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Buscar Funcionarios!!");
		}

	}

	@Override
	public List<Funcionario> buscarInfoPorFiltro(String busca) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_INFO_POR_FILTRO);

			statement.setString(1,busca);
			statement.setString(2,busca);
			statement.setString(3,busca);
			result = statement.executeQuery();

			List<Funcionario>funcs = new ArrayList<Funcionario>();
			Funcionario func = null;
			while(result.next()){
				System.out.println();

				func = new Funcionario();
				func.setNome(result.getString(1));
				func.setCpf(result.getString(2));
				func.setTelefone(result.getString(3));
				func.setData_acesso(result.getDate(4));
				func.setId(result.getInt(5));
				funcs.add(func);
			}
			return funcs;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao Buscar Funcionarios!!");
		}
	}
}
