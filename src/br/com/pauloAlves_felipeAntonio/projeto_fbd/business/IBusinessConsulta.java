package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;

public interface IBusinessConsulta {
	public void salvar(Consulta consulta,int id_medico,int id_paciente) throws BusinessException;
	public void editar(Consulta consulta) throws BusinessException;
	public Consulta buscarPorId(int id)  throws BusinessException;
	public Consulta buscaPorData(Date data) throws BusinessException;
	public List<Consulta> buscarPorBusca(String busca)throws BusinessException;
}
