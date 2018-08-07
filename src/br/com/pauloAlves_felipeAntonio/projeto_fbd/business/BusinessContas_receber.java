package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoContas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessContas_receber implements IBusinessContas_receber {
	private DaoContas_receber daoContas_receber;
	
	
	public BusinessContas_receber() {
		this.daoContas_receber = new DaoContas_receber();
	}
	
	@Override
	public void salvar(Contas_receber contas_receber) throws BusinessException {
		try {
			this.daoContas_receber.salvar(contas_receber);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Contas_receber contas_receber) throws BusinessException {
		try {
			daoContas_receber.editar(contas_receber);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

	@Override
	public Contas_receber buscarPorId(int id) throws BusinessException {
		try {
			return daoContas_receber.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

	@Override
	public List<Contas_receber> buscarPorBusca(String busca) throws BusinessException {
		try {
			return daoContas_receber.buscarPorBusca(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

	@Override
	public float soma() throws BusinessException {
		try {
			return daoContas_receber.soma();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}

	@Override
	public float somaValorPago() throws BusinessException {
		try {
			return daoContas_receber.somaValorPago();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());

		}
	}

}
