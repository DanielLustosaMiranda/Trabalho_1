package zversion;
import java.util.Scanner;

public class Professor {
	private String usuario;
	private String senha;
	private String nome;
	private String disciplinaMinistrada;
	
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

	public String getDisciplinaMinistrada() {
		return disciplinaMinistrada;
	}

	public void setDisciplinaMinistrada(String disciplinaMinistrada) {
		this.disciplinaMinistrada = disciplinaMinistrada;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	Scanner input = new Scanner(System.in);
	
	void lançarNota() {
		
	}
	
	void lançarPresença() {
		
	}
    public void cadastrarAluno(Scanner input) {
        System.out.println("Digite o nome do aluno: ");
        setNome(input.nextLine());

        System.out.println("Digite o usuário: ");
        setUsuario(input.nextLine());

        System.out.println("Digite a senha: ");
        setSenha(input.nextLine());

        System.out.println("\nAluno cadastrado com sucesso!");
    }
	void criarDisciplina() {
		Disciplina _disciplina = new Disciplina();
		System.out.println("Nome da disciplina: ");
		_disciplina.getNome();
	}
}
