package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoProduto {
	public void salvar(Produto produto) throws DaoException;
	public void editar(Produto produto) throws DaoException;
	public Produto  buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Produto> buscarPorBusca(String nome ,String tipo)throws DaoException;
}
