package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoContas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessContas_Pagar implements IBusinessContas_Pagar {
	private DaoContas_pagar daoContas_Pagar;
	
	public BusinessContas_Pagar() {
		this.daoContas_Pagar = new DaoContas_pagar();
	}

	@Override
	public void salvar(Contas_pagar contas_pagar) throws BusinessException {
		try {
			this.daoContas_Pagar.salvar(contas_pagar);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Contas_pagar contas_pagar) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contas_pagar buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contas_pagar> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
