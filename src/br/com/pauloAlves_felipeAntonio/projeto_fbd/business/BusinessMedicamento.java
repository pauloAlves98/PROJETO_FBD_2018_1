package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoMedicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessMedicamento implements IBusinessMedicamento{
	private DaoMedicamento daoMedicamento;
	
	public BusinessMedicamento() {
		this.daoMedicamento = new DaoMedicamento();
	}
	
	@Override
	public void salvar(Medicamento medicamento) throws BusinessException {
		try {
			this.daoMedicamento.salvar(medicamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Medicamento medicamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medicamento buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicamento> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
