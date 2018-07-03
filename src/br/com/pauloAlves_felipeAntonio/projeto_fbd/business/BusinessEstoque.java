package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Estoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessEstoque implements IBusinessEstoque {
	private DaoEstoque daoEstoque;
	
	public BusinessEstoque() {
		this.daoEstoque = new DaoEstoque();
	}
	
	@Override
	public void salvar(Estoque estoque) throws BusinessException {
		try {
			this.daoEstoque.salvar(estoque);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Estoque estoque) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estoque buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
