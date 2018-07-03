package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoLogAcesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Log_acesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessLogAcesso implements IBusinessLogAcesso {
	private DaoLogAcesso daoLogAcesso;
	
	public BusinessLogAcesso() {
		this.daoLogAcesso = new DaoLogAcesso();
	}
	@Override
	public void salvar(Log_acesso log) throws BusinessException {
		try {
			this.daoLogAcesso.salvar(log);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Log_acesso log) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Log_acesso buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log_acesso buscaPorData(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log_acesso> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
