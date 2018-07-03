package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessCargo {
	public void salvar(Cargo cargo) throws BusinessException;
	public void editar(Cargo cargo) throws BusinessException;
	public Cargo buscarPorId(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Cargo> buscarPorBusca(String busca)throws BusinessException;
}
