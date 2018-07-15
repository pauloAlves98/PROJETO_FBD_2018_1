package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoProdutos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produtos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessProdutos_vendas implements IBusinessProdutos_vendas {
	private DaoProdutos_vendas daoProdutos_vendas;
	
	public BusinessProdutos_vendas() {
		this.daoProdutos_vendas = new DaoProdutos_vendas();
	}
	
	public void salvar(Produtos_vendas produto) throws BusinessException {
		try {
			this.daoProdutos_vendas.salvar(produto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Produtos_vendas produto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produtos_vendas buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produtos_vendas> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
