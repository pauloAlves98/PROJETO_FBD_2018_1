package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoContas_pagar {
	public void salvar(Contas_pagar contas_pagar) throws DaoException;
	public void editar(Contas_pagar contas_pagar) throws DaoException;
	public Contas_pagar  buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Contas_pagar> buscarPorBusca(String busca)throws DaoException;
}
