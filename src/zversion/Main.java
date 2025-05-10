package zversion;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ola seja bem vindo.");
		System.out.println("Insira o usuário: ");
		String usuario = input.nextLine();
		
		System.out.println("Insira sua senha: ");
		String senha = input.nextLine();
		
		Administrador adm = new Administrador(); 
		Aluno aluno0 = new Aluno();
		Professor prof = new Professor();
		
		if (usuario.equals("adm") && senha.equals("adm")) {
			MenuAdmin.menu(input, adm);
		}
			
		else if (usuario.equals("alunos") && senha.equals("alunos")){
			MenuAluno.menu(input, aluno0);
	    }
	            
		else if(usuario.equals("prof") && senha.equals("prof")) {
			MenuProfessor.menu(input, prof);
		}
		
		else {
			System.out.println("Invalido!");
		}
		
	}
}