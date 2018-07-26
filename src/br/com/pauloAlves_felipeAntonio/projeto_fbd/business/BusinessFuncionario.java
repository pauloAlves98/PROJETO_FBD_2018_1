package br.com.pauloAlves_felipeAntonio.projeto_fbd.business;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class BusinessFuncionario implements IBusinessFuncionario{
	private DaoFuncionario daoFuncionario;
	
	public BusinessFuncionario() {
		this.daoFuncionario = new DaoFuncionario();
	}
	
	@Override
	public void salvar(Funcionario funcionario) throws BusinessException {
		try {
			this.daoFuncionario.salvar(funcionario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public void editar(Funcionario funcionario) throws BusinessException {
		try {
			daoFuncionario.editar(funcionario);
		} catch (DaoException e) {
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}	
	}

	@Override
	public Funcionario buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscaPorCpf(String cpf) throws BusinessException {
		try {
			return daoFuncionario.buscaPorCpf(cpf);
		} catch (DaoException e) {
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public List<Funcionario> buscarPorBusca(String busca) throws BusinessException {
		try {
			return daoFuncionario.buscarPorBusca(busca);
		} catch (DaoException e) {
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public Funcionario buscaPorLogin_senha(String login, String senha) throws BusinessException {
		try {
			return this.daoFuncionario.buscaPorLogin_senha(login,senha);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Funcionario> buscarInfoCpf(String busca) throws BusinessException {
		try {
			return daoFuncionario.buscarInfoPorCpf(busca);
		} catch (DaoException e) {
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

	@Override
	public List<Funcionario> buscarInfoPorFiltro(String busca) throws BusinessException {
		try {
			return daoFuncionario.buscarInfoPorFiltro(busca);
		} catch (DaoException e) {
			throw new BusinessException("Erro no Business!!!"+e.getMessage());
		}
		
	}

}
