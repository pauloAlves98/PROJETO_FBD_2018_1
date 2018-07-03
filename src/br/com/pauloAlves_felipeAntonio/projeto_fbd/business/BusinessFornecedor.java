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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
