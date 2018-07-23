package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessFuncionario {
	public void salvar(Funcionario funcionario ) throws BusinessException;
	public void editar(Funcionario funcionario ) throws BusinessException;
	public Funcionario buscarPorId(int id)  throws BusinessException;
	public  Funcionario buscaPorCpf(String cpf) throws BusinessException;
	public  Funcionario buscaPorLogin_senha(String login, String senha) throws BusinessException;
	public List<Funcionario > buscarPorBusca(String busca) throws BusinessException;
	public List <Funcionario > buscarInfoCpf(String busca) throws BusinessException;
	public List <Funcionario > buscarInfoPorNomeCpf(String cpf,String nome) throws  BusinessException;
	public List <Funcionario > buscarInfoPorNome(String nome)  throws BusinessException;
}
