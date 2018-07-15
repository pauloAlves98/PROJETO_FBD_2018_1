package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoReceita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Receita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessReceita implements IBusinessReceita{
	private DaoReceita daoReceita;
	
	public BusinessReceita() {
		this.daoReceita = new DaoReceita();
	}
	
	public void salvar(Receita receita) throws BusinessException {
		try {
			this.daoReceita.salvar(receita);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Receita receita) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Receita buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receita> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
