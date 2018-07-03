package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoServicos_vendas {
	public void salvar(Servicos_vendas servico) throws DaoException;
	public void editar(Servicos_vendas servico) throws DaoException;
	public Servicos_vendas buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Servicos_vendas> buscarPorBusca(String busca)throws DaoException;
}
