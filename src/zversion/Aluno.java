package zversion;

public class Aluno {
	
	private String usuario;
	private String senha;
	private String nome;
	private int nota;
	private String graduaçao;
	private String disciplinasCursadas;
	private int presenca;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getGraduaçao() {
		return graduaçao;
	}

	public void setGraduaçao(String graduaçao) {
		this.graduaçao = graduaçao;
	}

	public String getDisciplinasCursadas() {
		return disciplinasCursadas;
	}

	public void setDisciplinasCursadas(String disciplinasCursadas) {
		this.disciplinasCursadas = disciplinasCursadas;
	}

	public int getPresenca() {
		return presenca;
	}

	public void setPresenca(int presenca) {
		this.presenca = presenca;
	}

	//
	void exibirInfo() {
		System.out.println(usuario);
		System.out.println(senha);
		
	}
	
	void alterarSenha() {
		
	}
	void trancar() {
		
	}
	
	void gerarBoletim() {
		
	}
	
	void exibirTurmasCadastradas() {
		
	}
}
