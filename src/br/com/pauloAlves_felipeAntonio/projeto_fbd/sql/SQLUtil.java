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
	public static String SENHA_POSTGRES = "123";

	//os inserts


	public static class Paciente{
		public static String INSERT_ALL = "insert into paciente (nome, rg, cpf, telefone, nome_mae, nome_pai,id_endereco,datanascimento)"+
				"values (?,?,?,?,?,?,?,?)";	
		public static String SELECT_ALL = "select nome,cpf,telefone,datanascimento from paciente order by id";
		public static String SELECT_FOREINGS_POR_CPF = "select id_endereco,id_prontuario from paciente where paciente.cpf = ? order by id";
		public static String SELECT_ALL_POR_NOME = "select nome,cpf,telefone,datanascimento from paciente where paciente.nome ilike ? order by id";
		public static String SELECT_ID_POR_CPF = "select id from paciente where cpf = ?";
		//public static String SELECT_FOREINGNS_POR_CPF = "select id_endereco , id_prontuario from paciente where cpf = ?";
		public static String SELECT_ALL_POR_NOME_E_CPF = "select nome,cpf,telefone,datanascimento,id from paciente where cpf ilike ? or nome ilike ? order by id";
		public static String SELECT_ALL_EXCETO_PRONTUARIO_POR_CPF = "select paciente.id,nome,rg,cpf,telefone,nome_mae,nome_pai,cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero,paciente.datanascimento,id_endereco from paciente, endereco e where paciente.id_endereco = e.id and paciente.cpf = ? order by id";
		public static String SELECT_INFO_POR_NOME_CPF_TELEFONE = "select id,nome,cpf,telefone from paciente where paciente.nome ilike ? or paciente.cpf ilike ? or paciente.telefone ilike ? order by id";	
		public static String UPDATE_All_PACIENTE="update paciente set nome = ?,rg = ? ,cpf = ?,telefone = ?, nome_mae = ?,nome_pai = ?,datanascimento = ? where paciente.id=? order by id"; 

	}
	public static class Endereco {

		public static String INSERT_ALL = "insert into endereco (cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero) "
				+ "values (?,?,?,?,?,?,?,?,?) ";
		public static String UPDATE_ALL_ENDERECO ="update endereco set cep = ?, estado= ? ,logradouro= ?,complemento= ?,bairro= ?,pais= ?,cidade= ?,rua= ?,numero = ? where endereco.id = ?";
	}
	public static class Medico{
		public static String INSERT_ALL = "insert into medico(cpf, area, especialidade, nome_usuario, senha, nome, rg,admim,id_endereco)"+
				"values(?,?,?,?,?,?,?,?,?)";
		public static String SELECT_INFO_POR_NOME_CPF_ESPECIALIDADE = "select id,nome,cpf,especialidade from medico where nome ilike ? or cpf ilike ? or especialidade ilike ?";
		public static String SELECT_ALL = "select medico.id,cpf,area,especialidade,nome_usuario,senha,nome,rg,admim,id_endereco,cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero from medico,endereco where endereco.id = medico.id_endereco and medico.cpf = ?";
		public static String SELECT_POR_LOGIN_SENHA = "select id,nome,cpf,admim,nome_usuario,senha from medico where medico.nome_usuario ilike ? and medico.senha = ?";
		public static String UPDATE_ALL = "update  medico set cpf = ?,area = ?,especialidade = ?,nome_usuario = ?,senha = ?, nome = ?,rg = ?,admim = ? where  medico.id = ?";
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
		public static String SELECT_INFO_POR_CPF ="select nome,cpf,telefone,data_acesso from funcionario where funcionario.cpf = ? order by funcionario.id";
		public static String SELECT_INFO ="select nome,cpf,telefone,data_acesso from funcionario";
		public static String SELECT_INFO_POR_NOME ="select nome,cpf,telefone,data_acesso from funcionario where funcionario.nome ilike ? order by funcionario.id";
		public static String SELECT_INFO_POR_FILTRO ="select nome,cpf,telefone,data_acesso, id from funcionario where "
				+ "funcionario.cpf ilike ? or funcionario.nome ilike ? or funcionario.telefone ilike ? order by funcionario.id";
		public static String INSERT_ALL = "insert into funcionario(nome, cpf, id_clinicas, admim,senha,id_cargos,nome_usuario, data_acesso, telefone, rg,id_endereco)"+
				"values(?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
		public static String SELECT_POR_LOGIN_SENHA = "select id,nome,cpf,admim,nome_usuario,senha from funcionario where funcionario.nome_usuario = ? and funcionario.senha = ?";
		public static String SELECT_ALL_CPF = "select funcionario.nome, cpf, rg , telefone, admim ,nome_usuario, senha ,data_acesso,id_endereco,id_cargos,cargo.nome,cargo.descricao_cargo,cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero,funcionario.id from funcionario inner join endereco on funcionario.id_endereco = endereco.id"
				+" inner join cargo on cargo.id = funcionario.id and funcionario.cpf = ?";
		public static String UPDATE_ALL = "update funcionario set nome = ?, cpf = ?, rg = ? , telefone = ?, admim = ? ,nome_usuario = ?, senha = ? , data_acesso = ? where funcionario.id = ?";
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
		public static String SELECT_HORARIOS_POR_DATA_E_MEDICO = "select horario from consulta inner join medico on consulta.id_medico = ? and _data = ?"; //BETWEEN '01-01-1981' AND '31-12-1990' compara intervalos
		public static String SELECT_INFO_POR_DATA = "select c.horario,c.situacao,c._data,p.nome,p.telefone,p.cpf,m.nome,m.especialidade,m.id,c.id from consulta c inner join paciente as p on c.id_paciente = p.id "+ 
				"inner join medico as m on m.id = c.id_medico and c._data = ?";
		public static String SELECT_INFO_POR_FILTRO = "select c.horario,c.situacao,c._data,p.nome,p.telefone,p.cpf,m.nome,m.especialidade,m.id,c.id from consulta c inner join paciente as p on c.id_paciente = p.id "+ 
				"inner join medico as m on m.id = c.id_medico where c.horario ilike ? or  m.nome ilike ? or m.especialidade ilike ? or p.nome ilike ? or p.cpf ilike ? or p.telefone ilike ?" ;
		public static String SELECT_INFO_POR_ID = "select c.horario,c.situacao,c._data,p.nome,p.telefone,p.cpf,m.nome,m.especialidade,m.id,c.id,p.id from consulta c inner join paciente as p on c.id_paciente = p.id "+ 
				"inner join medico as m on m.id = c.id_medico where c.id = ?";
		public static String SELECT_INFO_POR_MEDICO = "select c.horario,c.situacao,c._data,p.nome,p.telefone,p.cpf,m.nome,m.especialidade,m.id,c.id,p.id from consulta c inner join paciente as p on c.id_paciente = p.id "+ 
				"inner join medico as m on m.id = c.id_medico where m.id = ? and (c.horario ilike ? or  m.nome ilike ? or m.especialidade ilike ? or p.nome ilike ? or p.cpf ilike ? or p.telefone ilike ?)";
		public static String SELECT_INFO_POR_DATA_MEDICO = "select c.horario,c.situacao,c._data,p.nome,p.telefone,p.cpf,m.nome,m.especialidade,m.id,c.id from consulta c inner join paciente as p on c.id_paciente = p.id "+ 
				"inner join medico as m on m.id = c.id_medico where c._data = ? and m.id = ?";
		public static String UPDATE = "update consulta set horario = ?, _data = ?,situacao = ? where consulta.id = ?";
	}
	public static class Laudo{
		public static String INSERT_ALL = "insert into laudo(_data, horario, descricao, id_paciente, id_medico)"+
				"values(?, ?, ?, ?, ?)";
		public static String SELECT_ALL_INFO = "select p.nome,m.nome,l._data,l.id from laudo l "+
				"inner join paciente as p on p.id = l.id_paciente inner join medico as m on m.id = l.id_medico where l.id_medico = ? and (l._data BETWEEN ? and ? ) and (p.nome ilike ? or p.cpf ilike ?)";
		public static String SELECT_ALL_EDICAO = "select p.nome,m.nome,l._data,l.descricao,l.id,l.id_paciente,l.id_medico from laudo l "+
				"inner join paciente as p on p.id = l.id_paciente inner join medico as m on m.id = l.id_medico where  l.id = ?";
		public static String UPDATE = "update laudo set  _data = ?, horario = ?, descricao = ?, id_paciente = ? , id_medico = ? where  laudo.id = ?";
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
		public static String UPDATE_ALL  = "update cargo set nome = ?, descricao_cargo = ? where cargo.id = ?";
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
		public static String INSERT_ALL = "insert into produto(tipo, nome, id_fornecedor, venda_varejo, venda_atacado)"+
				"values(?,?,?,?,?)";
		public static String SELECT_ALL_POR_NOME_OU_TIPO = "select nome,tipo,id_fornecedor,venda_varejo,"
				+"venda_atacado, id from produto where nome ilike  ? or tipo  ilike ? order by id";
		public static String UPDATE_ALL = "update produto set nome = ?, tipo = ?, id_fornecedor = ?, venda_varejo = ?, venda_atacado = ? where id= ? order by id";
		public static String SELECT_NOME_PRODUTO_POR_ID = "select nome,venda_varejo,venda_atacado from produto  where id = ? order by id";
	}

	public static class Produtos_vendas{
		public static String INSERT_ALL = "insert into produtos_vendas(id_produtos,id_vendas)"+
				"values(?,?)";
	}

	public static class Fornecedor{
		//Mechendo Aqui...
		public static String INSERT_ALL = "insert into fornecedor(incs_municipal, cnpj, insc_estadual,nome,telefone,id_endereco)"+
				"values(?,?,?,?,?,?)";
		public static String UPDATE_ALL = "update fornecedor set incs_municipal = ?, cnpj = ?, insc_estadual = ? ,nome = ?,telefone = ? where fornecedor.id = ?";
		public static String SELECT_ALL = "select nome,cnpj,incs_municipal,telefone from fornecedor order by id";
		public static String SELECT_NOME_POR_ID = "select nome from fornecedor where id =? order by id";
		//public static String SELECT_ALL_POR_CNPJ = "select nome,cnpj,incs_municipal,telefone,id_endereco,fornecedor.id,cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero,insc_estadual from fornecedor, endereco where fornecedor.cnpj = ? and fornecedor.id_endereco = endereco.id";
		public static String SELECT_ALL_POR_NOME_CNPJ  = "select distinct nome,cnpj,incs_municipal,telefone,fornecedor.id,cep,estado,logradouro,complemento,bairro,pais,cidade,rua,numero,endereco.id from fornecedor, endereco  where  endereco.id = fornecedor.id_endereco and (nome ilike ? or cnpj ilike ? ) order by fornecedor.id";
	}
	public static class Estoque{
		public static String INSERT_ALL = "insert into estoque(id_fornecedores, id_produtos, total_produtos)"+
				"values(?,?,?)";
	}
	public static class Servico{
		public static String INSERT_ALL = "insert into servico(valor, tipo, descricao)"+
				"values(?,?,?)";
		public static String UPDATE_ALL = "update servico set valor = ?, tipo = ?, descricao = ? where id = ?";
		public static String SELECT_ALL_EXCETO_ID = "select tipo,descricao,valor from servico";
		public static String SELECT_ALL_EXCETO_ID_POR_DESCRICAO = "select  tipo,descricao,valor from servico where servico.descricao = ? order by id";
		public static String SELECT_ALL_EXCETO_ID_POR_TIPO = "select  tipo,descricao,valor from servico where servico.tipo = ? order by id";
		public static String SELECT_ALL_EXCETO_ID_POR_TIPO_DESCRICAO = "select  tipo,descricao,valor,id from servico where tipo ilike ? or descricao ilike ? order by id";
	}
	public static class Servicos_vendas{
		public static String INSERT_ALL = "insert into servicos_vendas(id_vendas, id_servicos, id_produtos)"+
				"values(?,?,?)";
	}
	public static class Caixa{
		public static String INSERT_ALL = "insert into caixa(saldo, nome)"+
				"values(?,?)";

		public static String SELECT_CAIXA ="select nome, saldo from caixa where id = ?"; 
		public static String UPDATE_ALL  = "update caixa set saldo = ? where id = ?";

	}
	public static class Contas_receber {
		public static String INSERT_ALL = "insert into contas_receber(valor, id_caixas, id_paciente, parcelas)"+
				"values(?,?,?,?)";
		public static String SELECT_SOMA_VALOR = "select SUM(valor) from contas_receber";
		public static String SELECT_SOMA_VALOR_PAGO = "select SUM(valor_pago) from contas_receber";
		public static String SELECT_ALL = "select contas_receber.id,paciente.nome,caixa.saldo,contas_receber.valor,contas_receber.valor_pago,contas_receber.parcelas from contas_receber,paciente,caixa where contas_receber.id_paciente = paciente.id and contas_receber.id_caixas=caixa.id and paciente.nome ilike ? order by contas_receber.id";
		public static String UPDATE_ALL = "update contas_receber set  parcelas = ?, valor_pago = ? where id = ? ";
		public static String SELECT_CONTA_RECEBER ="select valor_pago from contas_receber where id = ?";
	}
	public static class Despesa {
		public static String INSERT_ALL = "insert into despesa(categoria, valor, data_vencimento)"+
				"values(?,?,?)";

	}
	public static class Contas_pagar {
		public static String UPDATE_ALL = "update contas_pagar set valor_pago = ?, parcelas = ?, parcelas_total = ? where id = ?";
		public static String INSERT_ALL = "insert into contas_pagar(valor, id_caixas, id_item_produto,parcelas)"+
				"values(?,?,?,?)";
		public static String SELECT_ALL = "select contas_pagar.id,valor,fornecedor.nome,produto.nome,quantidade,valor_pago,parcelas,parcelas_total from contas_pagar,item_produto,caixa,produto,fornecedor where\n" + 
				"contas_pagar.id_item_produto = item_produto.id and contas_pagar.id_caixas = caixa.id and item_produto.id_produto = produto.id and produto.id_fornecedor = fornecedor.id and (produto.nome ilike ? or fornecedor.nome ilike ?) order by contas_pagar.id";
	}

	public static class ItemProduto{
		public static String INSERT_ALL = "insert into item_produto(id_produto,data_compra,data_vencimento,preco_compra,quantidade)"
				+"values(?,?,?,?,?)";
		public static String SELECT_ALL = "select id,id_produto,data_vencimento,preco_compra,quantidade from item_produto order by id";
		public static String SELECT_ALL_POR_ID_PRODUTO = "select id,id_produto,data_compra,data_vencimento,preco_compra,quantidade from item_produto where id_produto = ? order by id";
		public static String SELECT_ALL_POR_ID = "select item_produto.id,id_produto,data_compra,data_vencimento,preco_compra,quantidade,produto.nome  from item_produto,produto where item_produto.id = ? and item_produto.id_produto=produto.id order by item_produto.id";
		public static String UPDATE_ALL = "update item_produto set id_produto = ?,data_compra = ?,data_vencimento = ?,preco_compra = ?,quantidade = ? where id = ? ";
		public static String UPDATE_QTD ="update item_produto set quantidade = ? where id =?";
		public static String SELECT_SOMA = "select SUM(quantidade) from item_produto";
		public static String DELET = "delete from item_produto where id = ?";
	}

	private SQLUtil() {

	}

}
