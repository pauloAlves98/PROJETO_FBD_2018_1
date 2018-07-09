package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessPaciente {
	public void salvar(Paciente paciente) throws BusinessException;
	   // public void salvar_sem_convenio(Paciente paciente) throws DaoException;
	   // public void salvar_simples(Paciente paciente) throws DaoException;
	    public void editar(Paciente paciente)throws BusinessException;
	    public Paciente buscarPorId(int id)throws BusinessException;
	    public Paciente buscarPorCpf(String cpf)throws BusinessException;
	    public int buscarIdPorCpf(String cpf) throws BusinessException;
	    public List<Paciente> buscarPorBusca(String busca);
}
