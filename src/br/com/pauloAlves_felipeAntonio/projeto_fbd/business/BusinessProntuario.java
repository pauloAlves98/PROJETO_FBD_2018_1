package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoProntuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Prontuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessProntuario implements IBusinessProntuario {
	private DaoProntuario daoProntuario;
	
	public BusinessProntuario() {
		this.daoProntuario = new DaoProntuario();
	}
	
	public void salvar(Prontuario prontuario) throws BusinessException {
		try {
			this.daoProntuario.salvar(prontuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Prontuario prontuario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prontuario buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prontuario buscaPorData(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prontuario> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
