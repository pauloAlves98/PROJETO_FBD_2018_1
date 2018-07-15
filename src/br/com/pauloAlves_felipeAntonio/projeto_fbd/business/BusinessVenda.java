package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoVenda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Venda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessVenda implements IBusinessVenda {
	private DaoVenda daoVenda;
	
	public BusinessVenda() {
		this.daoVenda = new DaoVenda();
	}
	
	@Override
	public void salvar(Venda venda) throws BusinessException {
		try {
			this.daoVenda.salvar(venda);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Venda venda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venda buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
