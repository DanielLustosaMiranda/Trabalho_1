package pacotes.modos;

import java.util.Scanner;

public class ModoAvaliacao {
	
	public static void modoAvaliacao(){
		
		Scanner input = new Scanner(System.in);
		int resposta;
		

		System.out.println("Escolha: ");
		
		System.out.println("1- Lançar Notas");
		System.out.println("2- Listar os alunos cadastrados");
		System.out.println("3- Matricular alunos");
		System.out.println("4- Trancar semestre e disciplinas");
		
		resposta = input.nextInt();
		
		switch(resposta) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				
		}
		
	}
}
