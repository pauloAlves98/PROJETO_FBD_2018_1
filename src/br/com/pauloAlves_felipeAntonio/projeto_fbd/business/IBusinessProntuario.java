package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Prontuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessProntuario {
	public void salvar(Prontuario prontuario ) throws BusinessException;
	public void editar(Prontuario prontuario) throws BusinessException;
	public Prontuario  buscarPorId(int id)  throws BusinessException;
	public Prontuario buscaPorData(Date data) throws BusinessException;
	public List<Prontuario> buscarPorBusca(String busca)throws BusinessException;
}
