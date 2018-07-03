package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoFornecedor{
	public void salvar(Fornecedor fornecedor) throws DaoException;
	public void editar(Fornecedor fornecedor) throws DaoException;
	public Fornecedor buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Fornecedor> buscarPorBusca(String busca)throws DaoException;
}
