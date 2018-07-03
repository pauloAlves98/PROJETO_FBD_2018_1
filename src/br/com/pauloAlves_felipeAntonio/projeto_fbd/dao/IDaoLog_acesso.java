package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Log_acesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;



public interface IDaoLog_acesso {
	public void salvar(Log_acesso log ) throws DaoException;
	public void editar(Log_acesso log) throws DaoException;
	public Log_acesso buscarPorId(int id)  throws DaoException;
	public Log_acesso buscaPorData(Date data) throws DaoException;
	public List<Log_acesso> buscarPorBusca(String busca)throws DaoException;
}
