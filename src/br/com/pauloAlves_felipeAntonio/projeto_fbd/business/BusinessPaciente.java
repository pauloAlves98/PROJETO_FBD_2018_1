package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessPaciente implements IBusinessPaciente {
	private static DaoPaciente daoPaciente;
	
	public BusinessPaciente() {
		daoPaciente = new DaoPaciente();
	}
	@Override
	public void salvar(Paciente paciente) throws BusinessException {
		try {
			this.daoPaciente.salvar(paciente);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Paciente paciente) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente buscarPorCpf(String cpf) throws BusinessException {
		try {
			daoPaciente.buscarIdPorCpf(cpf);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Paciente> buscarPorBusca(String busca) {
		
		return null;
	}
	@Override
	public int buscarIdPorCpf(String cpf) throws BusinessException {
		try {
			return daoPaciente.buscarIdPorCpf(cpf);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}

}
