package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Despesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessDespesa {
	public void salvar(Despesa despesa) throws BusinessException;
	public void editar(Despesa despesa) throws BusinessException;
	public Despesa  buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Despesa> buscarPorBusca(String busca)throws BusinessException;
}
