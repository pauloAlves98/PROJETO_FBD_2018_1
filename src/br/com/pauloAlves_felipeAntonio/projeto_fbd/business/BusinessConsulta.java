package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessConsulta implements IBusinessConsulta {
	private DaoConsulta daoConsulta;
	
	public BusinessConsulta() {
		this.daoConsulta = new DaoConsulta();
	}

	@Override
	public void salvar(Consulta consulta,int id_medico,int id_paciente) throws BusinessException {
		try {
			this.daoConsulta.salvar(consulta,id_medico,id_paciente);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Consulta consulta) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Consulta buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta buscaPorData(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulta> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
