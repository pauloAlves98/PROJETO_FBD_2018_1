package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoConsulta {
	public void salvar(Consulta consulta,int id_medico,int id_paciente ) throws DaoException;
	public void editar(Consulta consulta) throws DaoException;
	public Consulta buscarPorId(int id)  throws DaoException;
	public Consulta buscaPorData(Date data) throws DaoException;
	public List<String> buscaHorarios(java.util.Date date,int id_medico) throws DaoException ;//Falta
	public List<Consulta> buscaInfoConsultaPorData(java.util.Date busca) throws DaoException;//falta
	public List<Consulta> buscaInfoConsultaPorFiltro(String busca) throws DaoException;//falta
	public List<Consulta> buscarPorBusca(String busca)throws DaoException;
}
