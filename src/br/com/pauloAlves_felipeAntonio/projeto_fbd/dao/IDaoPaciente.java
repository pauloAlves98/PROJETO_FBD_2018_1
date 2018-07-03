package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;



public interface  IDaoPaciente {
    public void salvar(Paciente paciente) throws DaoException;
   // public void salvar_sem_convenio(Paciente paciente) throws DaoException;
   // public void salvar_simples(Paciente paciente) throws DaoException;
    public void editar(Paciente paciente)throws DaoException;
    public Paciente buscarPorId(int id)throws DaoException;
    public Paciente buscarPorCpf(String cpf)throws DaoException;
    public List<Paciente> buscarPorBusca(String busca);
}
