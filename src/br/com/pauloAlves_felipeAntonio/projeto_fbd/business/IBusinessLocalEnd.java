package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Local_end;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessLocalEnd {
	public void salvar(Local_end local_end) throws BusinessException;
	public void editar(Local_end local_end) throws BusinessException;
	public Local_end buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Local_end> buscarPorBusca(String busca)throws BusinessException;
}
