package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Receita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoReceita {
	public void salvar(Receita receita) throws DaoException;
	public void editar(Receita receita) throws DaoException;
	public Receita buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Receita> buscarPorBusca(String busca)throws DaoException;
}
