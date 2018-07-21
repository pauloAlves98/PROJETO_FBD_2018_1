package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessServico {
	public void salvar(Servico servico) throws BusinessException;
	public void editar(Servico servico) throws BusinessException;
	public Servico buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Servico> buscarPorBusca(String tipo,String descricao)throws BusinessException;
}
