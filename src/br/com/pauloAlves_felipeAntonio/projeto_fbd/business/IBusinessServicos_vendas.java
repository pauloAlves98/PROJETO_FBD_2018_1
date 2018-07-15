package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessServicos_vendas {
	public void salvar(Servicos_vendas servico) throws BusinessException;
	public void editar(Servicos_vendas servico) throws BusinessException;
	public Servicos_vendas buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Servicos_vendas> buscarPorBusca(String busca)throws BusinessException;
}
