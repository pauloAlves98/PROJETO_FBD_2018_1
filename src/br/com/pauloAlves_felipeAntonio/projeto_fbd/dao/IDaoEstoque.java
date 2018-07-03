package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Estoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoEstoque {
	public void salvar(Estoque estoque) throws DaoException;
	public void editar(Estoque estoque) throws DaoException;
	public Estoque buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Estoque> buscarPorBusca(String busca)throws DaoException;
}
