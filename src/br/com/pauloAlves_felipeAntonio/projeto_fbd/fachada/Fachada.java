package br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada;
import java.util.Date;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessCaixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessCargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessClinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessContas_Pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessContas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessDespesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessExame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessLocalEnd;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessLogAcesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessMedicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessPagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessPagamentoVendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessProdutos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessProntuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessReceita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessServico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessServicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.BusinessVenda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessCaixa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessCargo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessClinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessConsulta;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessContas_Pagar;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessContas_receber;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessDespesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessExame;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessFornecedor;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessFuncionario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessLaudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessLocalEnd;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessLogAcesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessMedicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessMedico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessPagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessPagamentoVendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessProdutos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessProntuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessReceita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessServico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessServicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessVenda;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.business.IBusinessItemProduto;
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
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.ItemProduto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Laudo;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Local_end;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Log_acesso;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medicamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamento;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Pagamentos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produto;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Produtos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Prontuario;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Receita;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servicos_vendas;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Venda;
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
	private IBusinessExame businessExame;
	private IBusinessFornecedor businessFornecedor;
	private IBusinessFuncionario businessFuncionario;
	private IBusinessLaudo businessLaudo;
	private IBusinessLocalEnd businessLocalEnd;
	private IBusinessLogAcesso businessLogAcesso;
	private IBusinessMedicamento businessMedicamento;
	private IBusinessMedico businessMedico;
	private IBusinessPaciente businessPaciente;
	private IBusinessPagamento businessPagamento;
	private IBusinessPagamentoVendas businessPagamentoVendas;
	private IBusinessProduto businessProduto;
	private IBusinessProdutos_vendas businessProdutos_vendas;
	private IBusinessProntuario businessProntuario;
	private IBusinessReceita businessReceita;
	private IBusinessServico businessServico;
	private IBusinessServicos_vendas businessServicos_vendas;
	private IBusinessVenda businessVenda;
	private IBusinessItemProduto businessItemProduto;
	

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
		
		this.businessExame = new BusinessExame();
		this.businessFornecedor = new BusinessFornecedor();
		this.businessDespesa = new BusinessDespesa();
		this.businessFuncionario = new BusinessFuncionario();
		this.businessLaudo = new BusinessLaudo();
		this.businessLocalEnd = new BusinessLocalEnd();
		this.businessLogAcesso = new BusinessLogAcesso();
		this.businessMedicamento = new BusinessMedicamento();
		this.businessMedico = new BusinessMedico();
		this.businessPaciente = new BusinessPaciente();
		this.businessPagamento = new  BusinessPagamento();
		this.businessPagamentoVendas = new BusinessPagamentoVendas();
		this.businessProduto = new BusinessProduto();
		this.businessProdutos_vendas = new BusinessProdutos_vendas();
		this.businessProntuario  = new BusinessProntuario();
		this.businessReceita = new BusinessReceita();
		this.businessServico = new BusinessServico();
		this.businessServicos_vendas = new BusinessServicos_vendas();
		this.businessVenda = new BusinessVenda();
		this.businessItemProduto = new BusinessItemProduto();
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
		businessCaixa.editar(caixa);
		
	}

	@Override
	public Caixa buscarPorIdCaixa(int id) throws BusinessException {
		return businessCaixa.buscarPorId(id);
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
		
		return businessClinica.buscarPorId(id);
	}

	@Override
	public Clinica buscaPorCnpjClinica(String cnpj) throws BusinessException {
		// TODO Auto-generated method stub
		return businessClinica.buscaPorCnpj(cnpj);
	}

	@Override
	public List<Clinica> buscarPorBuscaClinica(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessClinica.buscarPorBusca(busca);
	}

	@Override
	public void salvarConsulta(Consulta consulta,int id_medico,int id_paciente) throws BusinessException {
		businessConsulta.salvar(consulta,id_medico,id_paciente);
	}

	@Override
	public void editarConsulta(Consulta consulta) throws BusinessException {
		businessConsulta.editar(consulta);	
	}
	@Override
	public Consulta buscarPorIdConsulta(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscarPorId(id);
	}

	@Override
	public Consulta buscaPorDataConsulta(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscaPorData(data);
	}

	@Override
	public List<Consulta> buscarPorBuscaConsulta(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscarPorBusca(busca);
	}

	@Override
	public void salvarContas_pagar(Contas_pagar contas_pagar) throws BusinessException {
		businessContas_pagar.salvar(contas_pagar);
		
	}

	@Override
	public void editarContas_pagar(Contas_pagar contas_pagar) throws BusinessException {
		businessContas_pagar.editar(contas_pagar);
		
	}

	@Override
	public Contas_pagar buscarPorIdContas_pagar(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contas_pagar> buscarPorBuscaContas_pagar(String busca) throws BusinessException {
		return businessContas_pagar.buscarPorBusca(busca);
	}
	@Override
	public void salvarContas_receber(Contas_receber contas_receber) throws BusinessException {
		businessContas_receber.salvar(contas_receber);
		
	}
	@Override
	public void editarContas_receber(Contas_receber contas_receber) throws BusinessException {
		businessContas_receber.editar(contas_receber);
		
	}
	@Override
	public Contas_receber buscarPorIdContas_receber(int id) throws BusinessException {
		return businessContas_receber.buscarPorId(id);
	}
	@Override
	public List<Contas_receber> buscarPorBuscaContas_receber(String busca) throws BusinessException {
		return businessContas_receber.buscarPorBusca(busca);
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
		businessFornecedor.editar(fornecedor);
	}
	@Override
	public String buscarPorIdFornecedor(int id) throws BusinessException {
		return businessFornecedor.buscarPorId(id);
	}
	@Override
	public List<Fornecedor> buscarPorBuscaFornecedor(String buscar) throws BusinessException {
		return businessFornecedor.buscarPorBusca(buscar);
	}
	@Override
	public void salvarFuncionario(Funcionario funcionario) throws BusinessException {
		businessFuncionario.salvar(funcionario);
	}
	@Override
	public void editarFuncionario(Funcionario funcionario) throws BusinessException {
		businessFuncionario.editar(funcionario);	
	}
	@Override
	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.buscarPorId(id);
	}
	@Override
	public Funcionario buscaPorCpfFuncionario(String cpf) throws BusinessException {
	
		return businessFuncionario.buscaPorCpf(cpf);
	}
	@Override
	public List<Funcionario> buscarPorBuscaFuncionario(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.buscarPorBusca(busca);
	}
	@Override
	public void salvarLaudo(Laudo laudo) throws BusinessException {
		businessLaudo.salvar(laudo);
	}
	@Override
	public void editarLaudo(Laudo laudo) throws BusinessException {
		businessLaudo.editar(laudo);
	}
	@Override
	public Laudo buscarPorILaudo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLaudo.buscarPorId(id);
	}
	@Override
	public Laudo buscaPorHorarioLaudo(String horario) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLaudo.buscaPorHorario(horario);
	}
	@Override
	public List<Laudo> buscarPorBuscaLaudo(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLaudo.buscarPorBusca(busca);
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
		businessLogAcesso.editar(log);
	}
	@Override
	public Log_acesso buscarPorIdLog_acesso(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLogAcesso.buscarPorId(id);
	}
	@Override
	public Log_acesso buscaPorDataLog_acesso(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Log_acesso> buscarPorBuscaLog_acesso(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLogAcesso.buscarPorBusca(busca);
	}
	@Override
	public void salvarMedicamento(Medicamento medicamento) throws BusinessException {
		businessMedicamento.salvar(medicamento);
	}
	@Override
	public void editarMedicamento(Medicamento medicamento) throws BusinessException {
		businessMedicamento.editar(medicamento);
	}
	@Override
	public Medicamento buscarPorIdMedicamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessMedicamento.buscarPorId(id);
	}
	@Override
	public List<Medicamento> buscarPorBuscaMedicamento(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessMedicamento.buscarPorBusca(busca);
	}
	@Override
	public void salvarMedico(Medico medico) throws BusinessException {
		businessMedico.salvar(medico);
	}
	@Override
	public void editarMedico(Medico medico) throws BusinessException  {
		businessMedico.editar(medico);
	}
	@Override
	public Medico buscarPorIdMedico(int id) throws BusinessException {
		return businessMedico.buscarPorId(id);
	}
	@Override
	public Medico buscarPorCpfMedico(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return businessMedico.buscarPorCpf(cpf);
	}
	@Override
	public List<Medico> buscarPorBuscaMedico(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessMedico.buscarPorBusca(busca);
	}
	@Override
	public void salvarPaciente(Paciente paciente) throws BusinessException {
		businessPaciente.salvar(paciente);
	}
	@Override
	public void editarPaciente(Paciente paciente,int id) throws BusinessException {
		businessPaciente.editar(paciente,id);
		
	}
	@Override
	public Paciente buscarPorIdPaciente(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPaciente.buscarPorId(id);
	}
	@Override
	public Paciente buscarPorCpfPaciente(String cpf) throws BusinessException {
		return businessPaciente.buscarPorCpf(cpf);
	}
	@Override
	public int buscarIdPorCpfPaciente(String cpf) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPaciente.buscarIdPorCpf(cpf);
	}
	@Override
	public List<Paciente> buscarPorBuscaPaciente(String busca) throws BusinessException {
		
		return businessPaciente.buscarPorBusca(busca);
	}
	@Override
	public void salvarPagamento(Pagamento pagamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarPagamento(Pagamento pagamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Pagamento buscarPorIdPagamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Pagamento> buscarPorBuscaPagamento(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarPagamentos_vendas(Pagamentos_vendas pagamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarPagamentos_vendas(Pagamentos_vendas pagamento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Pagamentos_vendas buscarPorIdPagamentos_vendas(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Pagamentos_vendas> buscarPorBuscaPagamentos_vendas(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarProduto(Produto produto) throws BusinessException {
		businessProduto.salvar(produto);
		
	}
	@Override
	public void editarProduto(Produto produto) throws BusinessException {
		businessProduto.editar(produto);
		
	}
	@Override
	public Produto buscarPorIdProduto(int id) throws BusinessException {
		return businessProduto.buscarPorId(id);
	}

	public List<Produto> buscarPorBuscaProduto(String buscar) throws BusinessException {
		return businessProduto.buscarPorBusca(buscar);
	}
	@Override
	public void salvarProdutos_vendas(Produtos_vendas produto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarProdutos_vendas(Produtos_vendas produto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Produtos_vendas buscarPorIdProdutos_vendas(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Produtos_vendas> buscarPorBuscaProdutos_vendas(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarProntuario(Prontuario prontuario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarProntuario(Prontuario prontuario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Prontuario buscarPorIdProntuario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Prontuario buscaPorDataProntuario(Date data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Prontuario> buscarPorBuscaProntuario(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarReceita(Receita receita) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarReceita(Receita receita) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Receita buscarPorIdReceita(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Receita> buscarPorBuscaReceita(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarServico(Servico servico) throws BusinessException {
		businessServico.salvar(servico);
		
	}
	@Override
	public void editarServico(Servico servico) throws BusinessException {
		businessServico.editar(servico);
		
	}
	@Override
	public Servico buscarPorIdServico(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Servico> buscarPorBuscaServico(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessServico.buscarPorBusca(busca);
	}
	@Override
	public void salvarServicos_vendas(Servicos_vendas servico) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarServicos_vendas(Servicos_vendas servico) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Servicos_vendas buscarPorIdServicos_vendas(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Servicos_vendas> buscarPorBuscaServicos_vendas(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salvarVenda(Venda venda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarVenda(Venda venda) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Venda buscarPorIdVenda(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Venda> buscarPorBuscaVenda(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Funcionario buscaPorLogin_senhaFuncionario(String login, String senha) throws BusinessException {
		return businessFuncionario.buscaPorLogin_senha(login, senha);
	}

	@Override
	public List<Funcionario> buscarInfoPorFiltroFuncionario(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessFuncionario.buscarInfoPorFiltro(busca);
	}
	
	
	
	
	@Override
	public void salvarItemProduto(ItemProduto itemProduto) throws BusinessException {
		businessItemProduto.salvar(itemProduto);
		
	}
	@Override
	public void editarItemProduto(ItemProduto itemProduto) throws BusinessException {
		businessItemProduto.editar(itemProduto);
	}
	@Override
	public ItemProduto buscarPorIdItemProduto(int id) throws BusinessException {
		return businessItemProduto.buscarPorId(id);
	}
	@Override
	public List<ItemProduto> buscarPorBuscaItemProduto() throws BusinessException {
		return businessItemProduto.buscarPorBusca();
	}
	@Override
	public List<ItemProduto> buscarPorId_produto(int id) throws BusinessException {
		return businessItemProduto.buscarPorId_produto(id);
	}
	@Override
	public float soma() throws BusinessException {
		return businessContas_receber.soma();
	}
	@Override
	public float somaValorPago() throws BusinessException {
		return businessContas_receber.somaValorPago();
	}
	@Override
	public void editarQtd(ItemProduto itemProduto) throws BusinessException {
		businessItemProduto.editarQtd(itemProduto);
		
	}
	@Override
	public int somaQtd() throws BusinessException {
		return businessItemProduto.somaQtd();
	}
	@Override
	public void deleteLinha(int id) throws BusinessException {
		businessItemProduto.deleteLinha(id);
		
	}
	
	
	//Medico
	@Override
	public List<Medico> buscarInfoPorFiltroMedico(String busca) throws BusinessException {
		return businessMedico.buscarInfoPorFiltro(busca);
	}
	@Override
	public Medico buscaPorLogin_senhaMedico(String login, String senha) throws BusinessException {
		// TODO Auto-generated method stub
		return businessMedico.buscaPorLogin_senha(login, senha);
	}
	
	//Consulta
	public List<String> buscaHorariosConsulta(java.util.Date date, int id_medico) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscaHorarios(date, id_medico);
	}
	public List<Consulta> buscaInfoConsultaPorData(java.util.Date busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscaInfoConsultaPorData(busca);
	}
	@Override
	public List<Consulta> buscaPorFiltroConsultaMedico(int id, String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscaPorFiltroMedico(id, busca);
	}	
	@Override
	public List<Consulta> buscaInfoConsultaPorFiltro(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscaInfoConsultaPorFiltro(busca);
	}
	@Override
	public List<Consulta> buscaInfoConsultaPorDataMedico(java.util.Date busca, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessConsulta.buscaInfoConsultaPorDataMedico(busca, id);
	}
	//Paciente
	@Override
	public List<Paciente> buscaInfoPorFiltroPaciente(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessPaciente.buscaInfoPorFiltro(busca);
	}
	/**Laudo   */
	@Override
	public List<Laudo> buscarParaEdicaoLaudo(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLaudo.buscarParaEdicao(id);
	}
	@Override
	public List<Laudo> buscarInfoPorPeriodoLaudo(int id, Date inicio, Date fim, String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return businessLaudo.buscarInfoPorPeriodo(id, inicio, fim, busca);
	}
	
	

}