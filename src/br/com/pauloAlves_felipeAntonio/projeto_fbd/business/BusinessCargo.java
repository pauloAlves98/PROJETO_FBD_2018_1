package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoCargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessCargo  implements IBusinessCargo {
	private DaoCargo daoCargo;
	
	public BusinessCargo() {
		this.daoCargo = new DaoCargo();
	}

	@Override
	public void salvar(Cargo cargo) throws BusinessException {
		try {
			this.daoCargo.salvar(cargo);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Cargo cargo) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cargo buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cargo> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
