package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoServico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessServico implements IBusinessServico {
	private DaoServico daoServico;
	
	public BusinessServico() {
		this.daoServico = new DaoServico();
	}
	
	public void salvar(Servico servico) throws BusinessException {
		try {
			this.daoServico.salvar(servico);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Servico servico) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servico buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servico> buscarPorBusca(String tipo,String descricao) throws BusinessException {
		try {
			return daoServico.buscarPorBusca(tipo, descricao);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("Erro ao buscar servico!!!");
		}
	}

}
