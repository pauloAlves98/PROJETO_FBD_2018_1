package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Local_end;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoLocal_end {
	public void salvar(Local_end local_end) throws DaoException;
	public void editar(Local_end local_end) throws DaoException;
	public Local_end buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Local_end> buscarPorBusca(String busca)throws DaoException;
}
