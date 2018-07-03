package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produtos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoProdutos_vendas {
	public void salvar(Produtos_vendas produto) throws DaoException;
	public void editar(Produtos_vendas produto) throws DaoException;
	public Produtos_vendas buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Produtos_vendas> buscarPorBusca(String busca)throws DaoException;
}
