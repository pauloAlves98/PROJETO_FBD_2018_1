package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.Date;
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
		try {
			daoConsulta.editar(consulta);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}	
	}

	@Override
	public Consulta buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoConsulta.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Consulta buscaPorData(Date data) throws BusinessException {
		try {
			return daoConsulta.buscaPorData(data);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Consulta> buscarPorBusca(String busca) throws BusinessException {
		try {
			return daoConsulta.buscarPorBusca(busca);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<String> buscaHorarios(java.util.Date date, int id_medico) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoConsulta.buscaHorarios(date, id_medico);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Consulta> buscaInfoConsultaPorData(java.util.Date busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoConsulta.buscaInfoConsultaPorData(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Consulta> buscaInfoConsultaPorFiltro(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoConsulta.buscaInfoConsultaPorFiltro(busca);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Consulta> buscaPorFiltroMedico(int id, String busca) throws BusinessException {
		
		try {
			return daoConsulta.buscaPorFiltroMedico(id, busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	public List<Consulta> buscaInfoConsultaPorDataMedico(java.util.Date busca, int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoConsulta.buscaInfoConsultaPorDataMedico(busca, id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
}
