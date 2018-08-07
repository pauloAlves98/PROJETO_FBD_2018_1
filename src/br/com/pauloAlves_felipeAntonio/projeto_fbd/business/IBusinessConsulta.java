package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IBusinessConsulta {
	public void salvar(Consulta consulta,int id_medico,int id_paciente) throws BusinessException;
	public void editar(Consulta consulta) throws BusinessException;
	public Consulta buscarPorId(int id)  throws BusinessException;
	public Consulta buscaPorData(Date data) throws BusinessException;
	public List<Consulta> buscarPorBusca(String busca)throws BusinessException;
	
	public List<String> buscaHorarios(java.util.Date date,int id_medico) throws BusinessException ;
	public List<Consulta> buscaInfoConsultaPorData(java.util.Date busca) throws BusinessException;
	public List<Consulta> buscaInfoConsultaPorFiltro(String busca) throws BusinessException;
	
	public List<Consulta> buscaPorFiltroMedico(int id ,String busca) throws BusinessException;
	public List<Consulta> buscaInfoConsultaPorDataMedico(java.util.Date busca,int id) throws BusinessException;
}
