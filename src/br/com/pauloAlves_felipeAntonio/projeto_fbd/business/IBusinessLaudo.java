package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessLaudo {
	public void salvar(Laudo laudo ) throws BusinessException;
	public void editar(Laudo laudo) throws BusinessException;
	public Laudo buscarPorId(int id)  throws BusinessException;
	public Laudo buscaPorHorario(String horario) throws BusinessException;
	public List<Laudo> buscarPorBusca(String busca)throws BusinessException;
	
	
	public List<Laudo> buscarParaEdicao(int id) throws  BusinessException ;
	public List<Laudo> buscarInfoPorPeriodo(int id,Date inicio,Date fim,String busca) throws BusinessException;
}
