package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;
//Entra no git
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoCaixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
//Testando o git
public class BusinessCaixa implements IBusinessCaixa{
	private DaoCaixa daoCaixa;
	public BusinessCaixa() {
		super();
		this.daoCaixa = new DaoCaixa();
	}
	@Override
	public void salvar(Caixa caixa) throws BusinessException {
		try {
			
			daoCaixa.salvar(caixa);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}
	@Override
	public void editar(Caixa caixa) throws BusinessException {
		try {
			daoCaixa.editar(caixa);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Caixa buscarPorId(int id) throws BusinessException {
		try {
			return daoCaixa.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
	}
	@Override
	public List<Caixa> buscarPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
