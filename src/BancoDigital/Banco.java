package BancoDigital;

import java.util.ArrayList;
import pessoa.*;

public class Banco {
	ArrayList<Cliente> clientes;

	private Cliente usuarioLogado;

	public Banco() {
		clientes = new ArrayList<Cliente>();
		criaCliente("admin", "123.456.789-09", 99, "00", "maeAdmin", "admin");
		buscaCliente("admin", 2).setPermissoes(3);
		usuarioLogado = null;
	}
	
	public boolean criaCliente(String nome, String cpf, int idade, String dataNascimento, String nomeDaMae, String senha) {
		if (usuarioLogado.getPermissoes() < 2) return false;

		if(!validaCpf(cpf)) return false;
		
		Cliente novoCliente = new Cliente(nome, cpf, idade, dataNascimento, nomeDaMae, senha);
		clientes.add(novoCliente);
		
		return true;
	}
	
	public boolean deletaCliente(String nome, String cpf, String senha) {
		if (usuarioLogado.getPermissoes() < 3) return false;

		if (!validaCpf(cpf)) return false;

		Cliente clienteASerDeletado = buscaCliente(nome, 2);

		if (clientes.isEmpty()) return false;
		if (clienteASerDeletado == null) return false;

		clientes.remove(clienteASerDeletado);
		
		return true;
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

	public Cliente buscaCliente(String busca, int tipo) {
		if(tipo == 1) {	// busca por CPF
			for (Cliente cliente : clientes) {
				if(cliente.getCPF() == busca) {
					return cliente;
				}
			}
		} else {	// busca por nome
			for (Cliente cliente : clientes) {
				if(cliente.getNome() == busca) {
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
			return false;
		}
		
		Cliente cliente = buscaCliente(chavePix, 1);
		
		double valorNovo = usuarioLogado.getSaldo() - valor;

		usuarioLogado.setSaldo(valorNovo);
		
		valor = cliente.getSaldo() + valor;

		cliente.setSaldo(valor);
		
		return true;
	}

	public boolean login(String usuario, String senha) {
		if (buscaCliente(usuario, 2) == null) return false;
		if (buscaCliente(usuario, 2).getSenha() != senha) return false;

		usuarioLogado = buscaCliente(usuario, 2);
		
		return true;
	}

	public void logoff() {
		usuarioLogado = null;
	}

}	
