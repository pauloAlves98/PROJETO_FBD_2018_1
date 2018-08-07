package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoMedico {
	public void salvar(Medico medico)throws DaoException;
	public void editar(Medico medico)throws DaoException;
	public Medico buscarPorId(int id)throws DaoException;
	public Medico buscarPorCpf(String cpf)throws DaoException;
	public List<Medico>buscarInfoPorFiltro(String busca)throws DaoException;
	public List<Medico> buscarPorBusca(String busca) throws DaoException;
	
	public Medico buscaPorLogin_senha(String login , String senha)  throws DaoException;
}
