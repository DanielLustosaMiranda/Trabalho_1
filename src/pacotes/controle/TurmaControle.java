package pacotes.controle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pacotes.modelo.Turma;

public class TurmaControle {
    Scanner input = new Scanner(System.in);
	
    public static Turma criarTurma() {
        Scanner input = new Scanner(System.in);
        Turma turma = new Turma();

        System.out.print("Semestre (ex: 2025.1): ");
        turma.setSemestre(input.nextLine().trim());

        System.out.print("Turma presencial? (true/false): ");
        while (true) {
            String presencialStr = input.nextLine().trim().toLowerCase();
            if (presencialStr.equals("true") || presencialStr.equals("false")) {
                turma.setPresencial(Boolean.parseBoolean(presencialStr));
                break;
            } else {
                System.out.print("Digite 'true' ou 'false': ");
            }
        }

        System.out.print("Sala: ");
        turma.setSala(input.nextLine().trim());

        System.out.print("Horário (ex: 19:00 - 21:00): ");
        turma.setHorario(input.nextLine().trim());

        System.out.print("Capacidade (número inteiro): ");
        while (true) {
            try {
                int capacidade = Integer.parseInt(input.nextLine().trim());
                if (capacidade >= 0) {
                    turma.setCapacidade(capacidade);
                    break;
                } else {
                    System.out.print("Digite um número inteiro positivo: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Digite um inteiro: ");
            }
        }

        System.out.print("Forma de avaliação: ");
        turma.setFormaDeAvaliacao(input.nextLine().trim());

        System.out.print("Professor responsável: ");
        turma.setProfessorResponsavel(input.nextLine().trim());

        System.out.print("Código da disciplina: ");
        turma.setCodigoDisciplina(input.nextLine().trim());

        turma.setId(pacotes.criadores.GeradorCodigos.getProximoId("turmas.csv"));

        System.out.println("Turma criada com sucesso!");
        
        return turma;
    }
    
    public static void salvarTurmaEmArquivo(Turma turma) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("turmas.csv", true))) {
            writer.write(turma.getId() + "," +
                         turma.getSemestre() + "," +
                         turma.isPresencial() + "," +
                         turma.getSala() + "," +
                         turma.getHorario() + "," +
                         turma.getCapacidade() + "," +
                         turma.getFormaDeAvaliacao() + "," +
                         turma.getProfessorResponsavel() + "," +
                         turma.getCodigoDisciplina());
            writer.newLine();
            System.out.println("Turma salva com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar turma: " + e.getMessage());
        }
    }

}
