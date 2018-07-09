package br.com.pauloAlves_felipeAntonio.projeto_fbd.app;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Medico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.Fachada;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.fachada.IFachada;

public class App {
	public static void main(String[] args) {
		IFachada fachada = Fachada.getInstance();
		
		try {
			Medico medico = new Medico();
			
			medico.setCpf("12345678910");
			medico.setNome("DR. Aristoteles");
			medico.setEndereco(new 	br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco());
			medico.getEndereco().setBairro("Não Tem");
			medico.getEndereco().setCep("56820000");
			medico.getEndereco().setCidade("Carnaiba");
			medico.getEndereco().setEstado("PE");
			medico.getEndereco().setLogradouro("Não Tem");
			medico.getEndereco().setNumero(59);
			medico.getEndereco().setPais("Brasil");
			medico.getEndereco().setRua("Rua 2");
			fachada.salvarMedico(medico);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario funcionario = new  br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Funcionario();
//			Cargo cargo = new Cargo();
//			cargo.setDescricao_cargo("ATENDENTE RESPOSAVEL POR ATENDER");
//			cargo.setNome("Atendente");
//			funcionario.setAdmim("Não");
//			funcionario.setCpf("123490");
//			Calendar ca = Calendar.getInstance();
//			funcionario.setData_acesso(ca.getTime());
//			funcionario.setNome("João");
//			funcionario.setNome_usuario("Joao das Pilhas");
//			funcionario.setRg("12345");
//			funcionario.setId_clinicas(1);
//			funcionario.setSenha("12345");
//			funcionario.setTelefone(99898989);
//			funcionario.setCargo(cargo);
//			funcionario.setTelefone(12345);
//			funcionario.setEndereco(new 	br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Endereco());
//			funcionario.getEndereco().setBairro("Não Tem");
//			funcionario.getEndereco().setCep("56820000");
//			funcionario.getEndereco().setCidade("Carnaiba");
//			funcionario.getEndereco().setEstado("PE");
//			funcionario.getEndereco().setLogradouro("Não Tem");
//			funcionario.getEndereco().setNumero(59);
//			funcionario.getEndereco().setPais("Brasil");
//			funcionario.getEndereco().setRua("Rua 2");
//
//			DaoFuncionario f = new DaoFuncionario();
//			f.salvar(funcionario);
//			//Calendar c = Calendar.getInstance();//Para inserir a data
//			//c.set(Calendar.YEAR, 1984);
//			//c.set(Calendar.MONTH, 9);//janeiro é 0
//			//c.set(Calendar.DAY_OF_MONTH, 17);
//			//Altualizar medico, fornecedor ,clinica, medico com o end
//			//			br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Paciente p = daoPaciente.buscarPorCpf("123456");
//			//
//			//			System.out.println("ID:"+p.getId());
//			//			System.out.println("NOME:"+p.getNome());
//			//			System.out.println("RG:"+p.getRg());
//			//			System.out.println("CPF:"+p.getCpf());
//			//			System.out.println("TELEFONE:"+p.getTelefone());
//			//			System.out.println("NOME MAE:"+p.getNome_mae());
//			//			System.out.println("NOME PAI:"+p.getNome_pai());
//			//
//			//			System.out.println("NOME CEP:"+p.getEndereco().getCep());
//			//			System.out.println("NOME BAIRRO:"+p.getEndereco().getBairro());
//			//			System.out.println("NOME CIDADE:"+p.getEndereco().getCidade());
//			//			System.out.println("NOME COMPLEMENTO:"+p.getEndereco().getComplemento());
//			//			System.out.println("NOME RUA:"+p.getEndereco().getRua());
//			//			System.out.println("NOME PAIS:"+p.getEndereco().getPais());
//			//			System.out.println("NOME NUMERO CASA:"+p.getEndereco().getNumero());
//
//		} catch (DaoException e) {
//
//			e.printStackTrace();
//		}


	}

}
