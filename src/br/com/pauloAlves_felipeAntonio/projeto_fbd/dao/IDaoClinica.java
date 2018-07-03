package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoClinica {
	public void salvar(Clinica clinica) throws DaoException;
	public void editar(Clinica clinica) throws DaoException;
	public Clinica buscarPorId(int id)  throws DaoException;
	public Clinica buscaPorCnpj(String cnpj) throws DaoException;
	public List<Clinica> buscarPorBusca(String busca)throws DaoException;	
}
