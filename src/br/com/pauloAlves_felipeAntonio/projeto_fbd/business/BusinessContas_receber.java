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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contas_receber buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contas_receber> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
