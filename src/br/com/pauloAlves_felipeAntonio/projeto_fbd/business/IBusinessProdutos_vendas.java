package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produtos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessProdutos_vendas {
	public void salvar(Produtos_vendas produto) throws BusinessException;
	public void editar(Produtos_vendas produto) throws BusinessException;
	public Produtos_vendas buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Produtos_vendas> buscarPorBusca(String busca)throws BusinessException;
}
