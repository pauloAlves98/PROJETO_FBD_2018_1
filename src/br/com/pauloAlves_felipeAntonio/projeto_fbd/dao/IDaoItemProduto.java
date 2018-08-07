package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Exame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoItemProduto {
	public void salvar(ItemProduto itemProduto) throws DaoException;
	public void editar(ItemProduto itemProduto) throws DaoException;
	public void editarQtd(ItemProduto itemProduto) throws DaoException;
	public ItemProduto buscarPorId(int id)  throws DaoException;
	public List<ItemProduto> buscarPorId_produto(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<ItemProduto> buscarPorBusca()throws DaoException;
	public int somaQtd() throws DaoException;
	public void deleteLinha(int id) throws  DaoException;
}
