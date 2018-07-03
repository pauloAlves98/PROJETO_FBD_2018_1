package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoCargo {
	public void salvar(Cargo cargo) throws DaoException;
	public void editar(Cargo cargo) throws DaoException;
	public Cargo buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Cargo> buscarPorBusca(String busca)throws DaoException;
}
