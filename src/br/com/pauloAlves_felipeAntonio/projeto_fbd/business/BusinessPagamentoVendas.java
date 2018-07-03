package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoPagamentosVendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil.Pagamentos_vendas;

public class BusinessPagamentoVendas implements IBusinessPagamentoVendas{
	private DaoPagamentosVendas daoPagamentosVendas;
	
	
	public BusinessPagamentoVendas() {
		this.daoPagamentosVendas = new DaoPagamentosVendas();
	}


	@Override
	public void salvar(br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas pagamento)
			throws BusinessException {
		try {
			this.daoPagamentosVendas.salvar(pagamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}


	@Override
	public void editar(br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas pagamento)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas buscarPorId(int id)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas> buscarPorBusca(String busca)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	

}
