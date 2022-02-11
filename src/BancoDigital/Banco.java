package BancoDigital;

import java.util.ArrayList;
import pessoa.*;

public class Banco {
	public Banco() {
		
	}
	
	ArrayList<Cliente> clientes;
	
	public int criaCliente(String nome, String cpf, int idade, String dataNascimento, String nomeDaMae) {
		if(!validaCpf(cpf)) return 0;
		Cliente novoCliente = new Cliente(nome, cpf, idade, dataNascimento, nomeDaMae);
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
}	
