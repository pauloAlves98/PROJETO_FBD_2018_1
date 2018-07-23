package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoComum {
	 public void salvarEndereco(Endereco endereco) throws DaoException;
	 public void salvarCargo(Cargo cargo) throws DaoException;
	 public int getCurrentValorTabela(String nomeTabela) throws DaoException;
	 public void editarEndereco(Endereco endereco,int k) throws DaoException;
}
