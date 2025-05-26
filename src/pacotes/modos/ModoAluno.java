package pacotes.modos;

import java.util.Scanner;

import pacotes.controle.AlunoControle;
import pacotes.controle.TurmaControle;
import pacotes.modelo.Aluno;

public class ModoAluno {
   
	private static void exibirOpcoes() {
    	System.out.println("===== Modo Aluno =====");
        System.out.println("1- Cadastrar aluno");
        System.out.println("2- Buscar aluno");
        System.out.println("3- Listar os alunos cadastrados");
        System.out.println("4- Matricular alunos");
        System.out.println("0- Voltar");
        System.out.print("Escolha: ");
    }

    public static void modoAluno() {
        Scanner input = new Scanner(System.in); 
        int resposta;

        while (true) {
        	
        	exibirOpcoes();
        	
            try {
                resposta = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (resposta) {
                case 1:
                    Aluno aluno = AlunoControle.criarAluno();
                    AlunoControle.salvarAlunoEmArquivo(aluno);
                    break;
                case 2:
                    AlunoControle.buscarAlunoPorMatricula();
                    break;
                case 3:
                    AlunoControle.listarAlunos();
                    break;
                case 4:
                    TurmaControle.matricularAluno();
                    break;
                case 0:
                    return; 
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    

}
