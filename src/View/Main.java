package View;

import BancoDigital.Banco;

public class Main {

	private static Menu menu;
	
	
	public static void main(String[] args) {

//	menu = new Menu();
		
		Banco banco = new Banco();
		banco.criaCliente("Herick","069.514.561-43", 22, "22/07/1999", "Rosangela");
		banco.criaCliente("Wesley","463.948.630-84", 22, "22/07/1999", "Rosangela");
		banco.criaCliente("Rosangela","986.796.310-51", 22, "22/07/1999", "Rosangela");
		banco.criaCliente("Marina","119.706.540-74", 22, "22/07/1999", "Rosangela");
		banco.criaCliente("Dennis","426.928.120-00", 22, "22/07/1999", "Rosangela");
		banco.criaCliente("Nathan","901.512.410-82", 22, "22/07/1999", "Rosangela");
		
		
		System.out.println(banco.extrato("Herick", 0));
		banco.pix("069.514.561-43", 25);
		System.out.println(banco.extrato("Herick", 0));
		
		//implemetnar medodos dos clientes, login, exceçoes e interface grafica
	}

}
