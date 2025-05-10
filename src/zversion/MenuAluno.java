package zversion;
import java.util.Scanner;

public class MenuAluno {
	
    public static void menu(Scanner input, Aluno aluno) {
        int resposta;

        do {
            System.out.println("Menu Aluno:");
            System.out.println("1. Altera Senha");
            System.out.println("2. Matricular-se em uma disciplina");
            System.out.println("3. Gerar boletim");
            System.out.println("4. Trancamento");
            System.out.println("5. Exit");

            resposta = input.nextInt();
            input.nextLine();

            switch (resposta) {
                case 1:
                    System.out.println("Alterando senha...");
                    break;
                case 2:
                    System.out.println("Matriculando...");
                    break;
                case 3:
                    System.out.println("Gerando boletim...");
                    break;
                case 4:
                    System.out.println("Trancando matrícula...");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        } while (resposta != 5);
    }
}
