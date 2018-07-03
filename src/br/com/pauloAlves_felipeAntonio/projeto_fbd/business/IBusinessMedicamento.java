package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessMedicamento {
	public void salvar(Medicamento medicamento) throws BusinessException;
	public void editar(Medicamento medicamento) throws BusinessException;
	public Medicamento buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Medicamento> buscarPorBusca(String busca)throws BusinessException;
}
