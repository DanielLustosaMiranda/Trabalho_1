package pacotes.controle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pacotes.modelo.Aluno;

public class AlunoControle {
    Scanner input = new Scanner(System.in);
    DisciplinaControle disciplinaControle = new DisciplinaControle();
    
    public static Aluno criarAluno() {
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do aluno: ");
        String nome = input.nextLine();

        System.out.print("Matrícula: ");
        String matricula = input.nextLine();

        System.out.print("Matérias cursadas (separadas por vírgula): ");
        String materiasCursadas = input.nextLine();

        System.out.print("Aluno especial? (true/false): ");
        boolean especial = false;
        while (true) {
            String resposta = input.nextLine().trim().toLowerCase();
            if (resposta.equals("true") || resposta.equals("false")) {
                especial = Boolean.parseBoolean(resposta);
                break;
            } else {
                System.out.print("Digite 'true' ou 'false' para especial: ");
            }
        }
        return new Aluno(nome, matricula, materiasCursadas, especial);
    }
    
    public static void salvarAlunoEmArquivo(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("aluno.csv", true))) {
            writer.write(aluno.getId() + "," +
                         aluno.getNome() + "," +
                         aluno.getMatricula() + "," +
                         aluno.getMateriasCursadas() + "," +
                         aluno.getEspecial());
            writer.newLine();
            System.out.println("Aluno " + aluno.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar aluno no arquivo: " + e.getMessage());
        }
    }
    		
    public void matricularDisciplina(Aluno aluno) {

    }

    public void trancarDisciplina(Aluno aluno) {

    }

}
