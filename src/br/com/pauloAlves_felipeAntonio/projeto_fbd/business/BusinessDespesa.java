package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoDespesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Despesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessDespesa implements IBusinessDespesa{
	private DaoDespesa daoDespesa;
	
	public BusinessDespesa() {
		this.daoDespesa  = new DaoDespesa();
	}
	
	
	@Override
	public void salvar(Despesa despesa) throws BusinessException {
		try {
			this.daoDespesa.salvar(despesa);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Despesa despesa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Despesa buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Despesa> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
