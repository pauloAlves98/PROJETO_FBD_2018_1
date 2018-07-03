package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessClinica {
	public void salvar(Clinica clinica) throws BusinessException;
	public void editar(Clinica clinica) throws BusinessException;
	public Clinica buscarPorId(int id)  throws BusinessException;
	public Clinica buscaPorCnpj(String cnpj) throws BusinessException;
	public List<Clinica> buscarPorBusca(String busca)throws BusinessException;	
}
