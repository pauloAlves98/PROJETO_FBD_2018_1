package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoLaudo {
	public void salvar(Laudo laudo ) throws DaoException;
	public void editar(Laudo laudo) throws DaoException;
	public Laudo buscarPorId(int id)  throws DaoException;
	public Laudo buscaPorHorario(String horario) throws DaoException;
	public List<Laudo> buscarPorBusca(String busca)throws DaoException;
}
