package pessoa;

public class Cliente {
	private final String nome;
	private final String cpf;
	private final int idade;
	private final String dataNascimento;
	private final String nomeDaMae;
	private double saldo;
	private String senha;
	private int permissoes;
	
	public Cliente(String nome, String cpf, int idade, String dataNascimento, String nomeDaMae, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.nomeDaMae = nomeDaMae;
		this.senha = senha;
		this.saldo = 0.0f;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public double setSaldo(double saldo) {
		this.saldo += saldo;
		return this.saldo;
	}

	public String getCPF() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public String getDataNascimento() {
		return this.dataNascimento;
	}

	public String getNomeDaMae() {
		return this.nomeDaMae;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(int permissoes) {
		this.permissoes = permissoes;
	}
}
