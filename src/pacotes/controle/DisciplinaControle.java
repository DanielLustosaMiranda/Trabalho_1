package pacotes.controle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import pacotes.modelo.Disciplina;

public class DisciplinaControle {

    public static Disciplina criarDisciplina() {
    	Scanner input = new Scanner(System.in);
        System.out.print("Nome da disciplina: ");
        String nome = input.nextLine();

        System.out.print("Código da disciplina: ");
        String codigo = input.nextLine();

        System.out.print("Carga horária (ex: 60h): ");
        String cargaHoraria = input.nextLine();

        System.out.print("Presencial? (true/false): ");
        boolean presencial = false;
        while (true) {
            String p = input.nextLine().trim().toLowerCase();
            if (p.equals("true") || p.equals("false")) {
                presencial = Boolean.parseBoolean(p);
                break;
            } else {
                System.out.print("Digite 'true' ou 'false': ");
            }
        }

        System.out.print("Capacidade de alunos: ");
        int capacidadeAlunos = 0;
        while (true) {
            try {
                capacidadeAlunos = Integer.parseInt(input.nextLine().trim());
                if (capacidadeAlunos >= 0) break;
                else System.out.print("Digite um número inteiro positivo: ");
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Digite um inteiro: ");
            }
        }

        System.out.print("Número da sala: ");
        int sala = 0;
        while (true) {
            try {
                sala = Integer.parseInt(input.nextLine().trim());
                if (sala >= 0) break;
                else System.out.print("Digite um número inteiro positivo: ");
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Digite um inteiro: ");
            }
        }

        ArrayList<Disciplina> preRequisitos = new ArrayList<>(); // vazio por enquanto, pode ser implementado depois

        Disciplina d = new Disciplina();
        d.setNome(nome);
        d.setCodigo(codigo);
        d.setCargaHoraria(cargaHoraria);
        d.setPresencial(presencial);
        d.setCapacidadeAlunos(capacidadeAlunos);
        d.setSala(sala);
        d.setPreRequisitos(preRequisitos);
        
        return d;
    }

    public static void salvarEmArquivo(Disciplina d) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplina.csv", true))) {
            String preReqs = "";
            if (d.getPreRequisitos() != null && !d.getPreRequisitos().isEmpty()) {
                preReqs = d.getPreRequisitos().stream()
                        .map(Disciplina::getCodigo)
                        .collect(Collectors.joining(";"));
            }

            String linha = d.getId() + "," +
                           d.getNome() + "," +
                           d.getCodigo() + "," +
                           d.getCargaHoraria() + "," +
                           (d.isPresencial() ? "Sim" : "Não") + "," +
                           d.getCapacidadeAlunos() + "," +
                           d.getSala() + "," +
                           preReqs;

            writer.write(linha);
            writer.newLine();
            System.out.println("Disciplina " + d.getNome() + " salva no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplina no arquivo: " + e.getMessage());
        }
    }
}

