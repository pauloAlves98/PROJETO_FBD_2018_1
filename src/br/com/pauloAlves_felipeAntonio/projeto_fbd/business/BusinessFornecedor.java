package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessFornecedor implements IBusinessFornecedor{
	private DaoFornecedor daoFornecedor;
	
	public BusinessFornecedor() {
		this.daoFornecedor = new  DaoFornecedor();
	}
	
	@Override
	public void salvar(Fornecedor fornecedor) throws BusinessException {
		try {
			this.daoFornecedor.salvar(fornecedor);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Fornecedor fornecedor) throws BusinessException {
		try {
			this.daoFornecedor.editar(fornecedor);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
		
	}

	@Override
	public String buscarPorId(int id) throws BusinessException {
		try {
			return daoFornecedor.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro ao buscar fornecedor");
		}
	}

	@Override
	public List<Fornecedor> buscarPorBusca(String buscar) throws BusinessException {
		try {
			return daoFornecedor.buscarPorBusca(buscar);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro ao buscar fornecedor");
		}
	}

}
