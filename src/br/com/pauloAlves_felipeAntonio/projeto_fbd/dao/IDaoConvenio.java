package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Convenio;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoConvenio {
	public void salvar(Convenio convenio) throws DaoException;
	public void editar(Convenio convenio) throws DaoException;
	public Convenio buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Convenio> buscarPorBusca(String busca)throws DaoException;
}
