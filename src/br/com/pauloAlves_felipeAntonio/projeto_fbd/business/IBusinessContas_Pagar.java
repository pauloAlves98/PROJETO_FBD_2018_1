package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessContas_Pagar {
	public void salvar(Contas_pagar contas_pagar) throws BusinessException;
	public void editar(Contas_pagar contas_pagar) throws BusinessException;
	public Contas_pagar  buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Contas_pagar> buscarPorBusca(String busca)throws BusinessException;
}
