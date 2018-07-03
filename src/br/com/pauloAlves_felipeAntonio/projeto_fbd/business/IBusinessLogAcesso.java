package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Log_acesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessLogAcesso {
	public void salvar(Log_acesso log ) throws BusinessException;
	public void editar(Log_acesso log) throws  BusinessException;
	public Log_acesso buscarPorId(int id)  throws  BusinessException;
	public Log_acesso buscaPorData(Date data) throws  BusinessException;
	public List<Log_acesso> buscarPorBusca(String busca)throws  BusinessException;
}
