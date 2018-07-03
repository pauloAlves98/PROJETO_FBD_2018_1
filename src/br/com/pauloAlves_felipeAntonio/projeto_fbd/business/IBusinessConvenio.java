package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Convenio;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessConvenio {
	public void salvar(Convenio convenio) throws BusinessException;
	public void editar(Convenio convenio) throws BusinessException;
	public Convenio buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Convenio> buscarPorBusca(String busca)throws BusinessException;
}
