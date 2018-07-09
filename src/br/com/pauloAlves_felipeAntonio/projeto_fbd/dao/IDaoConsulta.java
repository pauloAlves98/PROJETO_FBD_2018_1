package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoConsulta {
	public void salvar(Consulta consulta ) throws DaoException;
	public void editar(Consulta consulta) throws DaoException;
	public Consulta buscarPorId(int id)  throws DaoException;
	public Consulta buscaPorData(Date data) throws DaoException;
	public List<Consulta> buscarPorBusca(String busca)throws DaoException;
}
