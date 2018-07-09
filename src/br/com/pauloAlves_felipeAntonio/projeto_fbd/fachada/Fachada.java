package br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada;

import java.sql.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessCaixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessCargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessClinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessContas_Pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessContas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessDespesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessExame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessLocalEnd;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessLogAcesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessMedicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessCaixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessCargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessClinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessContas_Pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessContas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessDespesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessEstoque;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessExame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessLocalEnd;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessLogAcesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessMedicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessMedico;
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
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.BusinessException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public class Fachada implements IFachada{
	private IBusinessCaixa businessCaixa;
	private IBusinessCargo businessCargo;
	private IBusinessClinica businessClinica;
	private IBusinessConsulta businessConsulta;
	private IBusinessContas_Pagar businessContas_pagar;
	private IBusinessContas_receber businessContas_receber;
	private IBusinessDespesa businessDespesa;
	private IBusinessEstoque  businessEstoque;
	private IBusinessExame businessExame;
	private IBusinessFornecedor businessFornecedor;
	private IBusinessFuncionario businessFuncionario;
	private IBusinessLaudo businessLaudo;
	private IBusinessLocalEnd businessLocalEnd;
	private IBusinessLogAcesso businessLogAcesso;
	private IBusinessMedicamento businessMedicamento;
	private IBusinessMedico businessMedico;
	private static Fachada fachada;
	
	private Fachada() {
		super();
		//Git
		this.businessCaixa = new BusinessCaixa();
		this.businessCargo = new BusinessCargo();
		this.businessClinica = new BusinessClinica();
		this.businessConsulta = new BusinessConsulta();
		this.businessContas_pagar = new BusinessContas_Pagar();
		this.businessContas_receber = new  BusinessContas_receber();
		this.businessEstoque = new BusinessEstoque();
		this.businessExame = new BusinessExame();
		this.businessFornecedor = new BusinessFornecedor();
		this.businessDespesa = new BusinessDespesa();
		this.businessFuncionario = new BusinessFuncionario();
		this.businessLaudo = new BusinessLaudo();
		this.businessLocalEnd = new BusinessLocalEnd();
		this.businessLogAcesso = new BusinessLogAcesso();
		this.businessMedicamento = new BusinessMedicamento();
		this.businessMedico = new BusinessMedico();
	}
	public static Fachada getInstance() {
		if(fachada==null ) {
			fachada = new Fachada();
		}
		return fachada;
	}
	@Override
	public void salvarCaixa(Caixa caixa) throws BusinessException {
		businessCaixa.salvar(caixa);
	}

	@Override
	public void editarCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caixa buscarPorIdCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> buscarPorBuscaCaixa(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarCargo(Cargo cargo) throws BusinessException {
		businessCargo.salvar(cargo);
		
	}

	@Override
	public void editarCargo(Cargo cargo) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cargo buscarPorIdCargo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cargo> buscarPorBuscaCargo(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarClinica(Clinica clinica) throws BusinessException {
		businessClinica.salvar(clinica);
	}

	@Override
	public void editarClinica(Clinica clinica) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clinica buscarPorIdClinica(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clinica buscaPorCnpjClinica(String cnpj) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clinica> buscarPorBuscaClinica(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarConsulta(Consulta consulta) throws BusinessException {
		businessConsulta.salvar(consulta);
		
	}

	@Override
	public void editarConsulta(Consulta consulta) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Consulta buscarPorIdConsulta(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta buscaPorDataConsulta(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulta> buscarPorBuscaConsulta(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarContas_pagar(Contas_pagar contas_pagar) throws BusinessException {
		businessContas_pagar.salvar(contas_pagar);
		
	}

	@Override
	public void editarContas_pagar(Contas_pagar contas_pagar) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contas_pagar buscarPorIdContas_pagar(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contas_pagar> buscarPorBuscaContas_pagar(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarContas_receber(Contas_receber contas_receber) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarContas_receber(Contas_receber contas_receber) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Contas_receber buscarPorIdContas_receber(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contas_receber> buscarPorBuscaContas_receber(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarDespesa(Despesa despesa) throws BusinessException {
		businessDespesa.salvar(despesa);
		
	}
	@Override
	public void editarDespesa(Despesa despesa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Despesa buscarPorIdDespesa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Despesa> buscarPorBuscaDespesa(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarEstoque(Estoque estoque) throws BusinessException {
		businessEstoque.salvar(estoque);	
	}
	@Override
	public void editarEstoque(Estoque estoque) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Estoque buscarPorIdEstoque(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Estoque> buscarPorBuscaEstoque(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarExame(Exame exame) throws BusinessException {
		businessExame.salvar(exame);
	}
	@Override
	public void editarExame(Exame exame) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Exame buscarPorIdExame(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Exame> buscarPorBuscaExame(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarFornecedor(Fornecedor fornecedor) throws BusinessException {
		businessFornecedor.salvar(fornecedor);
	}
	@Override
	public void editarFornecedor(Fornecedor fornecedor) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Fornecedor buscarPorIdFornecedor(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Fornecedor> buscarPorBuscaFornecedor(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarFuncionario(Funcionario funcionario) throws BusinessException {
		businessFuncionario.salvar(funcionario);
	}
	@Override
	public void editarFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Funcionario buscaPorCpfFuncionario(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Funcionario> buscarPorBuscaFuncionario(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarLaudo(Laudo laudo) throws BusinessException {
		businessLaudo.salvar(laudo);
	}
	@Override
	public void editarLaudo(Laudo laudo) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Laudo buscarPorILaudo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Laudo buscaPorHorarioLaudo(String horario) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Laudo> buscarPorBuscaLaudo(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarLocal_end(Local_end local_end) throws BusinessException {
		businessLocalEnd.salvar(local_end);
		
	}
	@Override
	public void editarLocal_end(Local_end local_end) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Local_end buscarPorIdLocal_end(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Local_end> buscarPorBuscaLocal_end(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarLog_acesso(Log_acesso log) throws BusinessException {
		businessLogAcesso.salvar(log);
	}
	@Override
	public void editarLog_acesso(Log_acesso log) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Log_acesso buscarPorIdLog_acesso(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Log_acesso buscaPorDataLog_acesso(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Log_acesso> buscarPorBuscaLog_acesso(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarMedicamento(Medicamento medicamento) throws BusinessException {
		businessMedicamento.salvar(medicamento);
		
	}
	@Override
	public void editarMedicamento(Medicamento medicamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Medicamento buscarPorIdMedicamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Medicamento> buscarPorBuscaMedicamento(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarMedico(Medico medico) throws DaoException {
		businessMedico.salvar(medico);
	}
	@Override
	public void editarMedico(Medico medico) throws DaoException {
		
	}
	@Override
	public Medico buscarPorIdMedico(int id) throws DaoException {
		return null;
	}
	@Override
	public Medico buscarPorCpfMedico(String cpf) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Medico> buscarPorBuscaMedico(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
