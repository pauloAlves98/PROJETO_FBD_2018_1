package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoCaixa {
	public void salvar(Caixa caixa) throws DaoException;
	public void editar(Caixa caixa) throws DaoException;
	public Caixa   buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Caixa > buscarPorBusca(String busca)throws DaoException;
}
