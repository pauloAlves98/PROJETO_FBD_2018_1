package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessItemProduto {
	public void salvar(ItemProduto itemProduto) throws BusinessException;
	public void editar(ItemProduto itemProduto) throws BusinessException;
	public ItemProduto buscarPorId(int id)  throws BusinessException;
	public List<ItemProduto> buscarPorId_produto(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<ItemProduto> buscarPorBusca()throws BusinessException;
}
