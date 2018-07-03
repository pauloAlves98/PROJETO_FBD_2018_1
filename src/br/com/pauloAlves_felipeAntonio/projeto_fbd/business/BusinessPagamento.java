package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoPagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessPagamento implements IBusinessPagamento {
	private DaoPagamento daoPagamento;
	
	public BusinessPagamento() {
		this.daoPagamento = new DaoPagamento();
	}
	
	@Override
	public void salvar(Pagamento pagamento) throws BusinessException {
		try {
			this.daoPagamento.salvar(pagamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Pagamento pagamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pagamento buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
