package pessoa;

public class Cliente {
	public String nome;
	public String cpf;
	int idade;
	String dataNascimento;
	String nomeDaMae;
	double saldo;
	
	public Cliente(String nome, String cpf, int idade, String dataNascimento, String nomeDaMae) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.nomeDaMae = nomeDaMae;
		saldo = 0.0f;
	}
}
