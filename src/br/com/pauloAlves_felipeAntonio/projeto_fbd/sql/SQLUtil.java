/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pauloAlves_felipeAntonio.projeto_fbd.sql;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoClinica;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.DaoPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.dao.IDaoPaciente;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

/**
 *
 * @author prof Heldon
 */
public class SQLUtil {

	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/banco_fbd_2018_1";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "padS1998";

	//os inserts
	
 
	public static class Paciente{
		public static String INSERT_ALL = "insert into paciente (nome, rg, cpf, telefone, nome_mae, nome_pai,id_endereco,datanascimento)"+
		"values (?,?,?,?,?,?,?,?)";	
		public static String SELECT_ID_POR_CPF = "select id from paciente where cpf = ?";
		public static String SELECT_NOME_POR_CPF = "select id,nascimento from paciente where paciente.cpf = ? and paciente.nome=?";
		public static String SELECT_ALL_EXCETO_PRONTUARIO_POR_CPF = "select paciente.id,nome,rg,cpf,telefone,nome_mae,nome_pai,cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero,paciente.datanascimento from paciente, endereco e where paciente.id_endereco = e.id and paciente.cpf = ?";
	}
	public static class Endereco {

		public static String INSERT_ALL = "insert into endereco (cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero) "
				+ "values (?,?,?,?,?,?,?,?,?) ";
	}
	public static class Medico{
		public static String INSERT_ALL = "insert into medico(cpf, area, especialidade, nome_usuario, senha, nome, rg,admim,id_endereco)"+
				"values(?,?,?,?,?,?,?,?,?)";
	}
	public static class Aluno {
		public static String INSERT_ALL = "insert into aluno (nome, codigo, carga_horaria) "
				+ "values (?,?,?) ";
	}
	public static class Clinica{
		public static String INSERT_ALL = "insert into clinica(nome,cnpj, descricao_complemento,telefone,id_endereco)"+
				"values(?,?,?,?,?)";
	}
	public static class Funcionario{
		//Pra criar funcionario eh preciso ter cargo e clinica associada!!!
		//Colocar cargo em daoComum
		public static String INSERT_ALL = "insert into funcionario(nome, cpf, id_clinicas, admim,senha,id_cargos,nome_usuario, data_acesso, telefone, rg,id_endereco)"+
				"values(?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
	}
	public static class Log_acesso{
		public static String INSERT_ALL = "insert into log_acesso(data_acesso,nome_usuario)"+
				"values(?,?)";
	}
	public static class Prontuario{
		public static String INSERT_ALL = "insert into prontuario( data_exame, data_inicio, data_final, descricao_resultado,observacao)"+
				"values(?, ?, ?, ?, ?)";
	}
	public static class Consulta{
		public static String INSERT_ALL = "insert into consulta( tipo, horario, id_paciente, id_medico, _data, situacao)"+
				"values(?,?,?,?,?,?)";
	}
	public static class Laudo{
		public static String INSERT_ALL = "insert into laudo(_data, horario, descricao, id_paciente, id_medico)"+
				"values(?, ?, ?, ?, ?)";
	}
	public static class Medicamento{
		public static String INSERT_ALL = "insert into medicamento(descricao_laboratorio, desricao_generica, descricao_substancia,nome)"+
				"values(?, ?, ?, ?)";
	}
	public static class Receita{
		public static String INSERT_ALL = "insert into receita(observacoes, id_medicamentos, nome_clinica, id_medico)"+
				"values(?, ?, ?, ?)";
	}
	public static class Exame{
		public static String INSERT_ALL = "insert into exame(id_receita, observacoes, nome)"+
				"values(?, ?, ?)";
	}
	public static class Local_end{
		public static String INSERT_ALL = "insert into local_end(rua, nome_clinica, telefone, bairro, id_exame)"+
				"values(?,?,?,?,?)";
	}
	public static class Cargo{
		public static String INSERT_ALL = "insert into cargo(descricao_cargo,nome)"+
				"values(?,?)";
	}
	public static class Convenio{
		public static String INSERT_ALL = "insert into convenio(data_inicio, descricao_regiao,nome)"+
				"values(?,?,?)";
	}
	public static class Venda{
		public static String INSERT_ALL = "insert into venda(data, nota_fiscal, status, total, desconto, valor_recebido,troco, id_pacientes)"+
				"values(?,?,?,?,?,?,?,?)";
	}
	public static class Pagamento{
		public static String INSERT_ALL = "insert into pagamento(valor)"+
				"values(?)";
	}
	public static class Pagamentos_vendas{
		public static String INSERT_ALL = "insert into pagamentos_vendas(id_vendas, id_pagamento)"+
				"values(?,?)";
	}
	public static class Produto{
		public static String INSERT_ALL = "insert into produto(tipo, unidade_entrada, unidade_saida, quantidade, preco,nome)"+
				"values(?,?,?,?,?,?)";
	}
	public static class Produtos_vendas{
		public static String INSERT_ALL = "insert into produtos_vendas(id_produtos,id_vendas)"+
				"values(?,?)";
	}
	public static class Fornecedor{
		public static String INSERT_ALL = "insert into fornecedor(incs_municipal, cnpj, insc_estadual,nome,telefone,id_endereco)"+
				"values(?,?,?,?,?,?)";
	}
	public static class Estoque{
		public static String INSERT_ALL = "insert into estoque(id_fornecedores, id_produtos, total_produtos)"+
				"values(?,?,?)";
	}
	public static class Servico{
		public static String INSERT_ALL = "insert into servico(valor, tipo, descricao)"+
				"values(?,?,?)";
	}
	public static class Servicos_vendas{
		public static String INSERT_ALL = "insert into servicos_vendas(id_vendas, id_servicos, id_produtos)"+
				"values(?,?,?)";
	}
	public static class Caixa{
		public static String INSERT_ALL = "insert into caixa(saldo, nome)"+
				"values(?,?)";
	}
	public static class Contas_receber {
		public static String INSERT_ALL = "insert into contas_receber(valor, id_caixas, id_vendas)"+
				"values(?,?,?)";
	}
	public static class Despesa {
		public static String INSERT_ALL = "insert into despesa(categoria, valor, data_vencimento)"+
				"values(?,?,?)";
	}
	public static class Contas_pagar {
		public static String INSERT_ALL = "insert into contas_pagar(valor, id_caixas, id_dispesas)"+
				"values(?,?,?)";
	}

	//	public static class Curso {
	//
	//		public static final String INSERT_ALL = "insert into curso2 (nome, codigo, carga_horaria) "
	//				+ "values (?,?,?) ";
	//
	//		public static final String SELECT_ID = "select * from curso2 where id = ?";
	//
	//	}
	private SQLUtil() {

	}

}
