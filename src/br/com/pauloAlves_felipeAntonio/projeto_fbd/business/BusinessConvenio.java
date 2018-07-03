package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoConvenio;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Convenio;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessConvenio implements IBusinessConvenio{
	private DaoConvenio daoConvenio;
	
	
	public BusinessConvenio() {
		this.daoConvenio = new DaoConvenio();
	}
	
	@Override
	public void salvar(Convenio convenio) throws BusinessException {
		try {
			this.daoConvenio.salvar(convenio);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Convenio convenio) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Convenio buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Convenio> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
