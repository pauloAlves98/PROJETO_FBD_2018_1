package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessMedico {
	public void salvar(Medico medico)throws  BusinessException;
	public void editar(Medico medico)throws  BusinessException;
	public Medico buscarPorId(int id)throws BusinessException;
	public Medico buscarPorCpf(String cpf)throws BusinessException;
	public List<Medico> buscarPorBusca(String busca) throws BusinessException;
	
	public List<Medico>buscarInfoPorFiltro(String busca)throws BusinessException;
	public Medico buscaPorLogin_senha(String login , String senha) throws BusinessException;
	
}
