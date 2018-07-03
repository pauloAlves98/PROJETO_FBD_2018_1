package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessMedico implements IBusinessMedico{
	private DaoMedico dao;
	public BusinessMedico() {
		dao = new DaoMedico();
	}
	@Override
	public void salvar(Medico medico) throws DaoException {
		dao.salvar(medico);
	}

	@Override
	public void editar(Medico medico) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medico buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscarPorCpf(String cpf) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medico> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
