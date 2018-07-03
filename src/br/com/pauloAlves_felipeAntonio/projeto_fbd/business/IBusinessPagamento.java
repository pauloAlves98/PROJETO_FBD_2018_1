package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessPagamento {
	public void salvar(Pagamento pagamento) throws BusinessException;
	public void editar(Pagamento pagamento) throws BusinessException;
	public Pagamento buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Pagamento> buscarPorBusca(String busca)throws BusinessException;
}
