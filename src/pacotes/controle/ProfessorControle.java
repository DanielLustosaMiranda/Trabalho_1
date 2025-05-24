package pacotes.controle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pacotes.modelo.Disciplina;
import pacotes.modelo.Professor;

public class ProfessorControle {

        public static Professor criarProfessor() {
        
        Scanner input = new Scanner(System.in);
        Professor professor = new Professor();

        System.out.print("Nome do professor: ");
        professor.setNome(input.nextLine());

        System.out.print("Nome da disciplina do professor (ou deixe vazio para nenhuma): ");
        String nomeDisciplina = input.nextLine();
        if (!nomeDisciplina.isEmpty()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nomeDisciplina);
            professor.setDisciplina(disciplina);
        }

        return professor;
    }

    public static void salvarProfessorEmArquivo(Professor professor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("professor.csv", true))) {
            String linha = professor.getId() + "," +
                           professor.getNome() + "," +
                           (professor.getDisciplina() != null ? professor.getDisciplina().getNome() : "") + "," +
                           (professor.getTurma() != null ? professor.getTurma().getId() : "");

            writer.write(linha);
            writer.newLine();

            System.out.println("Professor " + professor.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar professor no arquivo: " + e.getMessage());
        }
    }
}
