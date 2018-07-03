package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Prontuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoProntuario {
	public void salvar(Prontuario prontuario ) throws DaoException;
	public void editar(Prontuario prontuario) throws DaoException;
	public Prontuario  buscarPorId(int id)  throws DaoException;
	public Prontuario buscaPorData(Date data) throws DaoException;
	public List<Prontuario> buscarPorBusca(String busca)throws DaoException;
}
