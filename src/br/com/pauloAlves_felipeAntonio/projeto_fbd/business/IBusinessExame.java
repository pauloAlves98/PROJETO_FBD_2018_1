package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Exame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessExame {
	public void salvar(Exame exame) throws BusinessException;
	public void editar(Exame exame) throws BusinessException;
	public Exame buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Exame> buscarPorBusca(String busca)throws BusinessException;
}
