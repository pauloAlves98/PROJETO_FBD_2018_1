package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Exame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoExame {
	public void salvar(Exame exame) throws DaoException;
	public void editar(Exame exame) throws DaoException;
	public Exame buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Exame> buscarPorBusca(String busca)throws DaoException;
}
