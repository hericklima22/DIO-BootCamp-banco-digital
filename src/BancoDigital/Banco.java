package BancoDigital;

import java.util.ArrayList;
import pessoa.*;

public class Banco {
	public Banco() {
		
	}
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public int criaCliente(String nome, String cpf, int idade, String dataNascimento, String nomeDaMae) {
		if(!validaCpf(cpf)) return 0;
		
		Cliente novoCliente = new Cliente(nome, cpf, idade, dataNascimento, nomeDaMae);
		System.out.println(novoCliente.nome);
		clientes.add(novoCliente);
		
		return 1;
	}
	
	private boolean validaCpf(String cpf) {

		
		String verificadores = "";
		String finais = "";
		finais = finais.concat(String.valueOf((cpf.charAt(cpf.length() - 2))) + String.valueOf((cpf.charAt(cpf.length() - 1))));
		
		if(cpf.contains(".")) {
			cpf = cpf.replace(".", "");
		}
		
		if(cpf.contains("-")) {
			cpf = cpf.replace("-", "");
		}
		
		if(cpf.isEmpty()) {
			return false;
		}
		
		int resultado = 0;
		int multiplicador = 10;
		String digito;
		
		for(int i = 0; i < cpf.length() - 2; i++) {
			digito = String.valueOf(cpf.charAt(i));
			resultado += Integer.parseInt(digito) * multiplicador--;	
		}
		
		resultado *= 10;
		resultado %= 11;
		resultado = resultado == 10 ? 0 : resultado; 
		verificadores = verificadores.concat(String.valueOf(resultado));
		
		multiplicador = 11;
		resultado = 0;
		
		for(int i = 0; i < cpf.length() - 1; i++) {
			digito = String.valueOf(cpf.charAt(i));
			resultado += Integer.parseInt(digito) * multiplicador--;	
		}
		
		resultado *= 10;
		resultado %= 11;
		resultado = resultado == 10 ? 0 : resultado;
		verificadores = verificadores.concat(String.valueOf(resultado));
		
		return verificadores.equals(finais);
	}

	private Cliente buscaCliente(String busca, int tipo) {
		if(tipo == 1) {	// busca por CPF
			for (Cliente cliente : clientes) {
				if(cliente.cpf == busca) {
					return cliente;
				}
			}
		} else {	// busca por nome
			for (Cliente cliente : clientes) {
				if(cliente.nome == busca) {
					return cliente;
				}
			}
		}
		return null;
	}
	
	public double extrato(String busca, int tipo) {
		if(buscaCliente(busca, tipo) == null) {
			return -1;
		}
		
		return buscaCliente(busca, tipo).getSaldo();		
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public boolean pix(String chavePix, double valor) {
		if(buscaCliente(chavePix, 1) == null) {
			//TODO lança uma exceçao
			return false;
		}
		
		Cliente cliente = buscaCliente(chavePix, 1);
		
		cliente.setSaldo(valor);
		
		return true;
	}
}	
