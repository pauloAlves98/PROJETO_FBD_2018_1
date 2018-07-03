package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoContas_receber {
	public void salvar(Contas_receber contas_receber) throws DaoException;
	public void editar(Contas_receber contas_receber) throws DaoException;
	public Contas_receber   buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Contas_receber > buscarPorBusca(String busca)throws DaoException;
}
