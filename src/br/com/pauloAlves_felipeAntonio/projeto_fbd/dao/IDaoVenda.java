package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Venda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoVenda {
	public void salvar(Venda venda) throws DaoException;
	public void editar(Venda venda) throws DaoException;
	public Venda buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Venda> buscarPorBusca(String busca)throws DaoException;
}
