package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Despesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoDespesa {
	public void salvar(Despesa despesa) throws DaoException;
	public void editar(Despesa despesa) throws DaoException;
	public Despesa  buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Despesa> buscarPorBusca(String busca)throws DaoException;
}
