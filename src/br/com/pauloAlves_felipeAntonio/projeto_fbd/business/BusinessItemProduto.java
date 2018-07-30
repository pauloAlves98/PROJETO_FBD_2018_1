package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessItemProduto implements IBusinessItemProduto{
	private DaoItemProduto daoItemProduto;
	
	public BusinessItemProduto() {
		this.daoItemProduto = new DaoItemProduto();
	}
	
	@Override
	public void salvar(ItemProduto itemProduto) throws BusinessException {
		try {
			this.daoItemProduto.salvar(itemProduto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editar(ItemProduto itemProduto) throws BusinessException {
		try {
			this.daoItemProduto.editar(itemProduto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ItemProduto buscarPorId(int id) throws BusinessException {
		try {
			return this.daoItemProduto.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

	@Override
	public List<ItemProduto> buscarPorBusca() throws BusinessException {
		try {
			return this.daoItemProduto.buscarPorBusca();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

	@Override
	public List<ItemProduto> buscarPorId_produto(int id) throws BusinessException {
		try {
			return this.daoItemProduto.buscarPorId_produto(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

}
