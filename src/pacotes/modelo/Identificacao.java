package pacotes.modelo;

public class Identificação {
	private int id;
	private String nome;
	private String senha;
	private String tipo;
	
	public Identificação() {
		this.nome = "";
		this.senha = "";
		this.tipo = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	void trocarSenha() {
		System.out.println("Alterando Senha...");
	}
}
