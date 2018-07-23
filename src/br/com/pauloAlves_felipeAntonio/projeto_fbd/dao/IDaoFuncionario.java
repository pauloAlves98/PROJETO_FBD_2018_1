package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoFuncionario {
	public void salvar(Funcionario funcionario ) throws DaoException;
	public void editar(Funcionario funcionario ) throws DaoException;
	public Funcionario buscarPorId(int id)  throws DaoException;
	public  Funcionario buscaPorCpf(String cpf) throws DaoException;
	public  Funcionario buscaPorLogin_senha(String login,String senha) throws DaoException;
	public List <Funcionario > buscarPorBusca(String busca)throws DaoException;
	public List <Funcionario > buscarInfoPorCpf(String busca)throws DaoException;
	public List <Funcionario > buscarInfoPorNomeCpf(String cpf,String nome)throws DaoException;
	public List <Funcionario > buscarInfoPorNome(String nome)throws DaoException;
}
