package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Receita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessReceita {
	public void salvar(Receita receita) throws BusinessException;
	public void editar(Receita receita) throws BusinessException;
	public Receita buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Receita> buscarPorBusca(String busca)throws BusinessException;
}
