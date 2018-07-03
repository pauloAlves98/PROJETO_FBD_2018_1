package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessFuncionario {
	public void salvar(Funcionario funcionario ) throws BusinessException;
	public void editar(Funcionario funcionario ) throws BusinessException;
	public Funcionario buscarPorId(int id)  throws BusinessException;
	public  Funcionario buscaPorCpf(String cpf) throws BusinessException;
	public List<Funcionario > buscarPorBusca(String busca)throws BusinessException;
}
