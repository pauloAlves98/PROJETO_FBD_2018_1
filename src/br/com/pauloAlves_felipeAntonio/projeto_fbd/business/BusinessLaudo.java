package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Laudo buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Laudo buscaPorHorario(String horario) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laudo> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
