package zversion;
import java.util.Scanner;

public class MenuProfessor {
    public static void menu(Scanner input, Professor professor) {
        while (true) {
            System.out.println("Menu Professor:");
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
                    professor.cadastrarAluno(input);
                    break;
                case 2:
                    System.out.println("Cadastrando disciplina...");
                    professor.criarDisciplina();
                    break;
                case 3:
                    System.out.println("Aprovando alunos...");
                    break;
                case 4:
                    System.out.println("Transferindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        }
    }
}
