package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoLocalEnd;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Local_end;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessLocalEnd implements IBusinessLocalEnd {
	private DaoLocalEnd daoLocalEnd;
	
	
	public BusinessLocalEnd() {
		this.daoLocalEnd = new DaoLocalEnd();
	}
	
	@Override
	public void salvar(Local_end local_end) throws BusinessException {
		try {
			this.daoLocalEnd.salvar(local_end);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Local_end local_end) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local_end buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Local_end> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
