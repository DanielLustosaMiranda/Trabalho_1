package pacotes.vizualizacao;
import java.util.Scanner;
import pacotes.controle.*;
import pacotes.modelo.*;

public class ProfessorMenu {
	private Scanner input = new Scanner(System.in);
    private ProfessorControle professorControle = new ProfessorControle();

	public void exibirMenuProfessor(Professor professor) {
        boolean sair = false;
        while (!sair) {
            System.out.println("Opções de Aluno:");
            System.out.println("1 - Matricular disciplina");
            System.out.println("2 - Trancar disciplina ou semestre");
            System.out.println("3 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = input.nextInt();
            input.nextLine();  // Limpa o buffer

            switch (opcao) {
                case 1:
                	professorControle.
                    break;
                case 2:
                    alunoControle.trancarDisciplina(aluno);
                    break;
                case 3:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
