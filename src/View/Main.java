package View;

import java.util.Scanner;

import BancoDigital.Banco;

public class Main {

	private static final Banco banco = new Banco();

	private static String validaDado(String senha1, String senha2) {
		Scanner scan = new Scanner(System.in);
		while(senha1 != senha2) {
			System.err.println("As senhas nao combinam.");
			System.out.print("Digite a senha: ");
			senha1 = scan.nextLine();
			System.out.print("Confirme a senha: ");
			senha2 = scan.nextLine();
		}
		scan.close();
		return senha1;
	}

	private static String validaDado(String cpf) {
		Scanner scan = new Scanner(System.in);
		while(!banco.validaCpf(cpf)) {
			System.err.println("O cpf inserido e invalido. Digite novamente");
			cpf = scan.nextLine();
		}
		scan.close();
		return cpf;
	}
	public static void main(String[] args) {

		boolean exit = false;
		boolean login = false;
		int opcao;
		Scanner scan = new Scanner(System.in);
		

		banco.criaCliente("Herick","069.514.561-43", 22, "22/07/1999", "Rosangela", "1234");
		banco.criaCliente("Wesley","463.948.630-84", 22, "22/07/1999", "Rosangela", "1234");
		banco.criaCliente("Rosangela","986.796.310-51", 22, "22/07/1999", "Rosangela", "1234");
		banco.criaCliente("Marina","119.706.540-74", 22, "22/07/1999", "Rosangela", "1234");
		banco.criaCliente("Dennis","426.928.120-00", 22, "22/07/1999", "Rosangela", "1234");
		banco.criaCliente("Nathan","901.512.410-82", 22, "22/07/1999", "Rosangela", "1234");

		System.out.println(banco.buscaCliente("admin", 2).getNome());

		//implemetnar medodos dos clientes, login, exceçoes e interface grafica

		while(!exit) {
			while(!login) {
				System.out.println("Bem vindo ao banco digital");
				System.out.println("Ja possui conta?");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				System.out.println("0 - Sair");

				opcao = scan.nextInt();

				switch(opcao) {
					case 1:
						System.out.print("Nome ou cpf: ");
						String usuario = scan.nextLine();
						System.out.print("Senha: ");
						String senha = scan.nextLine();
						banco.login(usuario, senha);
						System.out.println("Usuario logado com sucesso");
						break;
					case 2:
						// cadastro
						System.out.print("Nome: ");
						String nome = scan.nextLine();

						//validaçao de senha
						System.out.print("Digite a senha: ");
						String senha1 = scan.nextLine();
						System.out.print("Confirme a senha: ");
						String senha2 = scan.nextLine();
						senha = validaDado(senha1, senha2);
						
						//validacao de cpf
						System.out.print("CPF: ");
						String cpf = scan.nextLine();
						cpf = validaDado(cpf);

						System.out.print("Idade: ");
						int idade = scan.nextInt();
						System.out.print("Data de nascimento: (dd/mm/aaaa)");
						String dataNascimento = scan.nextLine();
						System.out.print("Nome da mae: ");
						String nomeDaMae = scan.nextLine();

						banco.criaCliente(nome, cpf, idade, dataNascimento, nomeDaMae, senha);

						System.out.println("Usuario cadastrado com sucesso");
						banco.login(nome, senha);
						break;
					case 0:
						System.exit(1);
						break;
					default:
						System.out.println("Insira a opcao novamente");
						break;
				}
			}
			
		}
		scan.close();
	}

}
