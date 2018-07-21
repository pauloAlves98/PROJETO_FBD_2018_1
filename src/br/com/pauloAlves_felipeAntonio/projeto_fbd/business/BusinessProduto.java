package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessProduto implements IBusinessProduto{
	private DaoProduto daoProduto;
	
	public BusinessProduto() {
		this.daoProduto = new DaoProduto();
	}
	
	
	public void salvar(Produto produto) throws BusinessException {
		try {
			this.daoProduto.salvar(produto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Produto produto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarPorBusca(String nome ,String tipo) throws BusinessException {
		try {
			return daoProduto.buscarPorBusca(nome, tipo);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro ao Buscar produto!!!");
		}
	}

}
