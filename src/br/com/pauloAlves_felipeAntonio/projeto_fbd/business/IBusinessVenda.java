package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Venda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessVenda {
	public void salvar(Venda venda) throws BusinessException;
	public void editar(Venda venda) throws BusinessException;
	public Venda buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Venda> buscarPorBusca(String busca)throws BusinessException;
}
