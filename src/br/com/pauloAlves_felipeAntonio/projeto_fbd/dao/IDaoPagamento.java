package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoPagamento {
	public void salvar(Pagamento pagamento) throws DaoException;
	public void editar(Pagamento pagamento) throws DaoException;
	public Pagamento buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Pagamento> buscarPorBusca(String busca)throws DaoException;
}
