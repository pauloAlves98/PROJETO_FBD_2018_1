package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoPagamento_vendas {
	public void salvar(Pagamentos_vendas pagamento) throws DaoException;
	public void editar(Pagamentos_vendas  pagamento) throws DaoException;
	public Pagamentos_vendas  buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Pagamentos_vendas> buscarPorBusca(String busca)throws DaoException;
}
