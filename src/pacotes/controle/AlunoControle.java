package pacotes.controle;
import pacotes.controle.*;
import java.io.*;
import java.util.Scanner;

import pacotes.modelo.Aluno;

public class AlunoControle {
    Scanner input = new Scanner(System.in);
    DisciplinaControle disciplinaControle = new DisciplinaControle();
    		
    public void matricularDisciplina(Aluno aluno) {

        System.out.println("Escolha uma disciplina para matricular:");
        disciplinaControle.imprimirTurmas();
        

        System.out.print("Digite o código da disciplina que você deseja matricular: ");
        String codigoDisciplina = input.nextLine();

    }

    // Método para trancar uma disciplina
    public void trancarDisciplina(Aluno aluno) {
        System.out.println("1- Trancar disciplina");
        System.out.println("2- Trancar semestre");

        int opcao = input.nextInt();  // Lê a opção do usuário
        input.nextLine();  // Limpa o buffer do scanner

        if (opcao == 1) {
            System.out.print("Qual disciplina você deseja trancar? ");
            String disciplina = input.nextLine();
            aluno.setMateriasCursadas(aluno.getMateriasCursadas().replace(", " + disciplina, ""));
            System.out.println("Disciplina " + disciplina + " trancada com sucesso!");
        } else if (opcao == 2) {
            aluno.setMateriasCursadas("");  // Tranca o semestre inteiro
            System.out.println("Semestre trancado.");
        } else {
            System.out.println("Opção inválida.");
        }

        // Atualizar aluno no arquivo após trancamento
        atualizarAlunoEmArquivo(aluno);
    }

    // Método para atualizar aluno no arquivo
    public void atualizarAlunoEmArquivo(Aluno alunoModificado) {
        try {
            // Lê todas as linhas do arquivo
            BufferedReader reader = new BufferedReader(new FileReader("aluno.txt"));
            String linha;
            StringBuilder conteudoArquivo = new StringBuilder();
            while ((linha = reader.readLine()) != null) {
                String[] dadosAluno = linha.split(";");
                // Verifica se a matrícula é a mesma, para atualizar os dados do aluno
                if (dadosAluno[1].equals(alunoModificado.getMatricula())) {
                    // Substitui os dados antigos pelos novos
                    conteudoArquivo.append(alunoModificado.getNome() + ";" + alunoModificado.getMatricula() + ";"
                            + alunoModificado.getCursoDeGraduacao() + ";" + alunoModificado.getMateriasCursadas() + ";"
                            + alunoModificado.getEspecial() + "\n");
                } else {
                    // Caso não seja o aluno que queremos atualizar, mantemos a linha igual
                    conteudoArquivo.append(linha + "\n");
                }
            }
            reader.close();

            // Escreve novamente todas as linhas no arquivo (sobrescrevendo)
            BufferedWriter writer = new BufferedWriter(new FileWriter("aluno.txt"));
            writer.write(conteudoArquivo.toString());
            writer.close();
            System.out.println("Aluno atualizado no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }
}
