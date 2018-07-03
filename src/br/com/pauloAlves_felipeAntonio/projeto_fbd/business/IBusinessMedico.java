package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessMedico {
	public void salvar(Medico medico)throws DaoException;
	public void editar(Medico medico)throws DaoException;
	public Medico buscarPorId(int id)throws DaoException;
	public Medico buscarPorCpf(String cpf)throws DaoException;
	public List<Medico> buscarPorBusca(String busca);
}
