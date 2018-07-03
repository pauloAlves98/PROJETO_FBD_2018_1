package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessFornecedor {
	public void salvar(Fornecedor fornecedor) throws BusinessException;
	public void editar(Fornecedor fornecedor) throws BusinessException;
	public Fornecedor buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Fornecedor> buscarPorBusca(String busca)throws BusinessException;
}
