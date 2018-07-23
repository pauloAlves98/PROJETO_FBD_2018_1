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
			throw new BusinessException("Erro no Business!!!: "+e.getMessage());
		}
		
	}

	@Override
	public void editar(Paciente paciente,int id) throws BusinessException {
		try {
			daoPaciente.editar(paciente, id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Paciente buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente buscarPorCpf(String cpf) throws BusinessException {
		try {
			return daoPaciente.buscarPorCpf(cpf);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}

	@Override
	public List<Paciente> buscarPorBusca(String nome,String cpf) throws BusinessException{
		try {
			return daoPaciente.buscarPorBusca(nome, cpf);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro ao buscar pacientes");
		}
		
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
