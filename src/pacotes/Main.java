package pacotes;

import java.util.Scanner;

import pacotes.controle.AlunoControle;
import pacotes.controle.DisciplinaControle;
import pacotes.controle.ProfessorControle;
import pacotes.controle.TurmaControle;
import pacotes.modelo.Aluno;
import pacotes.modelo.Disciplina;
import pacotes.modelo.Professor;
import pacotes.modelo.Turma;

public class Main {

    public static void main(String[] args) {
       
    	Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar Disciplina");
            System.out.println("2 - Criar Professor");
            System.out.println("3 - Criar Turma");
            System.out.println("4 - Criar Aluno");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String opcao = input.nextLine().trim();

            switch (opcao) {
                case "1":
                    Disciplina disciplina = DisciplinaControle.criarDisciplina();
                    DisciplinaControle.salvarEmArquivo(disciplina);
                    System.out.println("Disciplina criada:\n" + disciplina);
                    break;
                case "2":
                    Professor professor = ProfessorControle.criarProfessor();
                    ProfessorControle.salvarProfessorEmArquivo(professor);
                    System.out.println("Professor criado:\n" + professor);
                    break;
                case "3":
                    Turma turma = TurmaControle.criarTurma();
                    TurmaControle.salvarTurmaEmArquivo(turma);
                    System.out.println("Turma criada:\n" + turma);
                    break;
                case "4":
                    Aluno aluno = AlunoControle.criarAluno();
                    AlunoControle.salvarAlunoEmArquivo(aluno);
                    System.out.println("Aluno criado:\n" + aluno);
                    break;
                case "0":
                    System.out.println("Programa encerrado.");
                    input.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
       
    }
}
