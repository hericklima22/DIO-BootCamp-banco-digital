package BancoDigital;

import java.util.ArrayList;
import pessoa.*;

public class Banco {
	public Banco() {
		
	}
	
	ArrayList<Cliente> clientes;
	
	public int criaCliente(String nome, String cpf, int idade, String dataNascimento, String nomeDaMae) {
		
		
		return 1;
	}
	
	private boolean validaCpf(String cpf) {
		if(cpf.isEmpty()) {
			// TODO throws invalid error
		}
		
		return true;
	}
}	
