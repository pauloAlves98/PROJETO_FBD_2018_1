package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Estoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessEstoque {
	public void salvar(Estoque estoque) throws BusinessException;
	public void editar(Estoque estoque) throws BusinessException;
	public Estoque buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Estoque> buscarPorBusca(String busca)throws BusinessException;
}
