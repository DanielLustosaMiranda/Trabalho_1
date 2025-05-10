package zversion;
import java.util.Scanner;

public class MenuAdmin {
    public static void menu(Scanner input, Administrador adm) {
        while (true) {
            System.out.println("Menu Administrador:");
            System.out.println("1. Cadastrar Alunos");
            System.out.println("2. Cadastrar Disciplinas");
            System.out.println("3. Aprovar Alunos");
            System.out.println("4. Transferência");
            System.out.println("5. Exit");

            int resposta = input.nextInt();
            input.nextLine();

            if (resposta == 5) break;

            switch (resposta) {
                case 1:
                    System.out.println("Cadastrando aluno...");
                    break;
                case 2:
                    System.out.println("Cadastrando disciplina...");
                    break;
                case 3:
                    System.out.println("Aprovando alunos...");
                    break;
                case 4:
                    System.out.println("Realizando transferência...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        }
    }
}
