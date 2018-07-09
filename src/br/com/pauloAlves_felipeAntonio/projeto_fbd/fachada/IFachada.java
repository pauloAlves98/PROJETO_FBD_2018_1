package br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Caixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Cargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Clinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Consulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Contas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Despesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Estoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Exame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Fornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Local_end;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Log_acesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IFachada {
	public void salvarCaixa(Caixa caixa) throws BusinessException;
	public void editarCaixa(Caixa caixa) throws BusinessException;
	public Caixa  buscarPorIdCaixa(int id)  throws BusinessException;
	public List<Caixa > buscarPorBuscaCaixa(String busca)throws BusinessException;
	
	public void salvarCargo(Cargo cargo) throws BusinessException;
	public void editarCargo(Cargo cargo) throws BusinessException;
	public Cargo buscarPorIdCargo(int id)  throws BusinessException;

	public List<Cargo> buscarPorBuscaCargo(String busca)throws BusinessException;
	public void salvarClinica (Clinica clinica) throws BusinessException;
	public void editarClinica (Clinica clinica) throws BusinessException;
	public Clinica buscarPorIdClinica (int id)  throws BusinessException;
	public Clinica buscaPorCnpjClinica (String cnpj) throws BusinessException;
	public List<Clinica> buscarPorBuscaClinica (String busca)throws BusinessException;	
	
	public void salvarConsulta(Consulta consulta,int id_medico,int id_paciente) throws BusinessException;
	public void editarConsulta(Consulta consulta) throws BusinessException;
	public Consulta buscarPorIdConsulta(int id)  throws BusinessException;
	public Consulta buscaPorDataConsulta(Date data) throws BusinessException;
	public List<Consulta> buscarPorBuscaConsulta(String busca)throws BusinessException;
	
	public void salvarContas_pagar (Contas_pagar contas_pagar) throws BusinessException;
	public void editarContas_pagar (Contas_pagar contas_pagar) throws BusinessException;
	public Contas_pagar  buscarPorIdContas_pagar (int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Contas_pagar> buscarPorBuscaContas_pagar (String busca)throws BusinessException;
	
	public void salvarContas_receber(Contas_receber contas_receber) throws BusinessException;
	public void editarContas_receber(Contas_receber contas_receber) throws BusinessException;
	public Contas_receber  buscarPorIdContas_receber(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	
	public List<Contas_receber > buscarPorBuscaContas_receber(String busca)throws BusinessException;
	public void salvarDespesa(Despesa despesa) throws BusinessException;
	public void editarDespesa(Despesa despesa) throws BusinessException;
	public Despesa  buscarPorIdDespesa(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Despesa> buscarPorBuscaDespesa(String busca)throws BusinessException;
	
	public void salvarEstoque(Estoque estoque) throws BusinessException;
	public void editarEstoque(Estoque estoque) throws BusinessException;
	public Estoque buscarPorIdEstoque(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Estoque> buscarPorBuscaEstoque(String busca)throws BusinessException;
	
	public void salvarExame(Exame exame) throws BusinessException;
	public void editarExame(Exame exame) throws BusinessException;
	public Exame buscarPorIdExame(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Exame> buscarPorBuscaExame(String busca)throws BusinessException;
	
	public void salvarFornecedor(Fornecedor fornecedor) throws BusinessException;
	public void editarFornecedor(Fornecedor fornecedor) throws BusinessException;
	public Fornecedor buscarPorIdFornecedor(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Fornecedor> buscarPorBuscaFornecedor(String busca)throws BusinessException;
	
	public void salvarFuncionario(Funcionario funcionario ) throws BusinessException;
	public void editarFuncionario(Funcionario funcionario ) throws BusinessException;
	public Funcionario buscarPorIdFuncionario(int id)  throws BusinessException;
	public  Funcionario buscaPorCpfFuncionario(String cpf) throws BusinessException;
	public List<Funcionario > buscarPorBuscaFuncionario(String busca)throws BusinessException;
	
	public void salvarLaudo(Laudo laudo ) throws BusinessException;
	public void editarLaudo(Laudo laudo) throws BusinessException;
	public Laudo buscarPorILaudo(int id)  throws BusinessException;
	public Laudo buscaPorHorarioLaudo(String horario) throws BusinessException;
	public List<Laudo> buscarPorBuscaLaudo(String busca)throws BusinessException;
	
	public void salvarLocal_end (Local_end local_end) throws BusinessException;
	public void editarLocal_end (Local_end local_end) throws BusinessException;
	public Local_end buscarPorIdLocal_end (int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Local_end> buscarPorBuscaLocal_end (String busca)throws BusinessException;
	
	public void salvarLog_acesso(Log_acesso log ) throws BusinessException;
	public void editarLog_acesso(Log_acesso log) throws  BusinessException;
	public Log_acesso buscarPorIdLog_acesso(int id)  throws  BusinessException;
	public Log_acesso buscaPorDataLog_acesso(Date data) throws  BusinessException;
	public List<Log_acesso> buscarPorBuscaLog_acesso(String busca)throws  BusinessException;
	
	public void salvarMedicamento(Medicamento medicamento) throws BusinessException;
	public void editarMedicamento(Medicamento medicamento) throws BusinessException;
	public Medicamento buscarPorIdMedicamento(int id)  throws BusinessException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Medicamento> buscarPorBuscaMedicamento(String busca)throws BusinessException;
	
	public void salvarMedico(Medico medico)throws DaoException;
	public void editarMedico(Medico medico)throws DaoException;
	public Medico buscarPorIdMedico(int id)throws DaoException;
	public Medico buscarPorCpfMedico(String cpf)throws DaoException;
	public List<Medico> buscarPorBuscaMedico(String busca);
	
	public void salvarPaciente(Paciente paciente) throws BusinessException;
	   // public void salvar_sem_convenio(Paciente paciente) throws DaoException;
	   // public void salvar_simples(Paciente paciente) throws DaoException;
	    public void editarPaciente(Paciente paciente)throws BusinessException;
	    public Paciente buscarPorIdPaciente(int id)throws BusinessException;
	    public Paciente buscarPorCpfPaciente(String cpf)throws BusinessException;
	    public int buscarIdPorCpfPaciente(String cpf) throws BusinessException;
	    public List<Paciente> buscarPorBuscaPaciente(String busca);
	
	
}
