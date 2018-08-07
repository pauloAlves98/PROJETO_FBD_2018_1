package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessLaudo implements IBusinessLaudo{
	private DaoLaudo daoLaudo;
	
	public BusinessLaudo() {
		this.daoLaudo = new DaoLaudo();
	}
	
	@Override
	public void salvar(Laudo laudo) throws BusinessException {
		try {
			this.daoLaudo.salvar(laudo);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Laudo laudo) throws BusinessException {
		try {
			daoLaudo.editar(laudo);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Laudo buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoLaudo.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Laudo buscaPorHorario(String horario) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoLaudo.buscaPorHorario(horario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Laudo> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoLaudo.buscarPorBusca(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Laudo> buscarParaEdicao(int id) throws BusinessException {
		try {
			return daoLaudo.buscarParaEdicao(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Laudo> buscarInfoPorPeriodo(int id, Date inicio, Date fim, String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoLaudo.buscarInfoPorPeriodo(id, inicio, fim, busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
