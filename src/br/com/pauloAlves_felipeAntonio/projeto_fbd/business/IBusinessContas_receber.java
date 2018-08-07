package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessContas_receber {
	public void salvar(Contas_receber contas_receber) throws BusinessException;
	public void editar(Contas_receber contas_receber) throws BusinessException;
	public Contas_receber   buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Contas_receber > buscarPorBusca(String busca)throws BusinessException;
	public float soma() throws  BusinessException;
	public float somaValorPago() throws BusinessException;
}
