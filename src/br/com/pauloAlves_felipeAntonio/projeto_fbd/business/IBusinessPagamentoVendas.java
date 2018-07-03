package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessPagamentoVendas {
	public void salvar(Pagamentos_vendas pagamento) throws BusinessException;
	public void editar(Pagamentos_vendas  pagamento) throws  BusinessException;
	public Pagamentos_vendas  buscarPorId(int id)  throws  BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Pagamentos_vendas> buscarPorBusca(String busca)throws  BusinessException;
}
