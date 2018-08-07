package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessMedico implements IBusinessMedico{
	private DaoMedico dao;
	public BusinessMedico() {
		dao = new DaoMedico();
	}
	@Override
	public void salvar(Medico medico) throws BusinessException {
		try {
			dao.salvar(medico);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro business "+e.getMessage());
		}
	}

	@Override
	public void editar(Medico medico) throws BusinessException {
		try {
			dao.editar(medico);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro business "+e.getMessage());
		}
		
	}

	@Override
	public Medico buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscarPorCpf(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medico> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return dao.buscarPorBusca(busca);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro business "+e.getMessage());
		}
	}
	@Override
	public List<Medico> buscarInfoPorFiltro(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return dao.buscarInfoPorFiltro(busca);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro business "+e.getMessage());
		}
	}
	@Override
	public Medico buscaPorLogin_senha(String login, String senha) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return dao.buscaPorLogin_senha(login, senha);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro business "+e.getMessage());
		}
	}

}
