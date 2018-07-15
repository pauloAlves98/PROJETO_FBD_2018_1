package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoServicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessServicos_vendas implements IBusinessServicos_vendas {
	private DaoServicos_vendas daoServicos_vendas;
	
	public BusinessServicos_vendas() {
		this.daoServicos_vendas = new DaoServicos_vendas();
	}
	@Override
	public void salvar(Servicos_vendas servico) throws BusinessException {
		try {
			this.daoServicos_vendas.salvar(servico);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Servicos_vendas servico) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servicos_vendas buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicos_vendas> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
