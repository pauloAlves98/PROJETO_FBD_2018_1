package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoClinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessClinica implements IBusinessClinica {
	private DaoClinica daoClinica;
	
	public BusinessClinica() {
		this.daoClinica = new DaoClinica();
	}

	@Override
	public void salvar(Clinica clinica) throws BusinessException {
		try {
			this.daoClinica.salvar(clinica);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Clinica clinica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clinica buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clinica buscaPorCnpj(String cnpj) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clinica> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
