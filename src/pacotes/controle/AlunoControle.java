package pacotes.controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import pacotes.criadores.GeradorCodigos;
import pacotes.modelo.Aluno;

public class AlunoControle {

    private static Scanner input = new Scanner(System.in);

    public static Aluno criarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = input.nextLine();

        System.out.print("Matrícula: ");
        String matricula = input.nextLine();

        System.out.print("Curso: ");
        String curso = input.nextLine();

        System.out.print("Aluno especial? (sim/nao): ");

        boolean especial = false;
        while (true) {
            String resposta = input.nextLine().trim().toLowerCase();
            if (resposta.equals("sim")) {
                especial = true;
                break;
            } else if (resposta.equals("nao")) {
                especial = false;
                break;
            } else {
                System.out.print("Digite 'sim' ou 'nao' para especial: ");
            }
        }
        int id = GeradorCodigos.getProximoId("alunos.csv");
        return new Aluno(id, nome, matricula, curso, especial);
    }

    public static void salvarAlunoEmArquivo(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("alunos.csv", true))) {
            List<String> materias = aluno.getMateriasCursadas();
            String materiasStr = " ";
            if (materias != null && !materias.isEmpty()) {
                materiasStr = String.join(";", materias);
            }

            writer.write(aluno.getId() + "," +
                         aluno.getNome() + "," +
                         aluno.getMatricula() + "," +
                         aluno.getCurso() + "," +
                         aluno.isEspecial() + "," +
                         materiasStr + ",");
            writer.newLine();
            System.out.println("Aluno " + aluno.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar aluno no arquivo: " + e.getMessage());
        }
    }
    public static void listarAlunos() {
        String nomeArquivo = "alunos.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            System.out.println("=== Alunos cadastrados ===");
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                if (partes.length >= 5) {
                    String id = partes[0].trim();
                    String nome = partes[1].trim();
                    String matricula = partes[2].trim();
                    String curso = partes[3].trim();                    
                    String especial = partes[4].trim();

                    String turma = partes.length >= 6 ? partes[5].trim() : "Não matriculado";
                    
                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Matrícula: " + matricula);
                    System.out.println("Curso: " + curso);
                    System.out.println("Aluno especial: " + especial);
                    System.out.println("Turma: " + turma);
                    System.out.println("-----------------------------");
                } else {
                    System.out.println("Linha com formato inesperado: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de alunos: " + e.getMessage());
        }
    }
 
    public static Aluno buscarAlunoPorMatricula() {
        System.out.print("\nDigite a matrícula do aluno para buscar: ");
        String matriculaBuscada = input.nextLine().trim();
        
        
        try (Scanner scanner = new Scanner(new File("alunos.csv"))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",");
          
                
                System.out.println("executei");
                if (partes.length >= 6) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nome = partes[1].trim();
                    String matricula = partes[2].trim();
                    String curso = partes[3].trim();
                    boolean especial = Boolean.parseBoolean(partes[4].trim());
                    String materiasStr = partes[5].trim();
                   
                    System.out.println("executei: mat= " + matricula);
                    if (matricula.equals(matriculaBuscada)) {
                        Aluno aluno = new Aluno(id, nome, matricula, curso, especial);
                        aluno.setId(id);

                       if (!materiasStr.isEmpty()) {
                            List<String> materias = Arrays.asList(materiasStr.split(";"));
                            aluno.setMateriasCursadas(new ArrayList<>(materias));
                        } else {
                            aluno.setMateriasCursadas(new ArrayList<>());
                        }
                       
                        System.out.println("\n=== Dados do Aluno Encontrado ===");
                        System.out.println(aluno.toString());

                        return aluno;
                    }
                }
            }

            System.out.println("\nAluno com matrícula '" + matriculaBuscada + "' não encontrado.");
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    public static void editarAluno(Aluno aluno) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Editar Aluno ===");
            System.out.println("Aluno: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
            System.out.println("1. Editar nome");
            System.out.println("2. Editar matrícula");
            System.out.println("3. Editar matérias cursadas");
            System.out.println("4. Editar tipo (especial/normal)");
            System.out.println("0. Sair da edição");
            System.out.print("Escolha uma opção: ");

            String entrada = input.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Novo nome: ");
                    String novoNome = input.nextLine();
                    if (!novoNome.trim().isEmpty()) {
                        aluno.setNome(novoNome);
                        System.out.println("Nome atualizado com sucesso.");
                    }
                    break;

                case 2:
                    System.out.print("Nova matrícula: ");
                    String novaMatricula = input.nextLine();
                    if (!novaMatricula.trim().isEmpty()) {
                        aluno.setMatricula(novaMatricula);
                        System.out.println("Matrícula atualizada com sucesso.");
                    }
                    break;

                case 3:
                    System.out.print("Quantas matérias deseja informar? ");
                    int quantidade = Integer.parseInt(input.nextLine());

                    List<String> novasMaterias = new ArrayList<>();

                    for (int i = 0; i < quantidade; i++) {
                        System.out.print("Digite o nome da matéria " + (i + 1) + ": ");
                        String materia = input.nextLine().trim();
                        if (!materia.isEmpty()) {
                            novasMaterias.add(materia);
                        }
                    }

                    if (!novasMaterias.isEmpty()) {
                        aluno.setMateriasCursadas(novasMaterias);
                        System.out.println("Matérias atualizadas com sucesso.");
                    } else {
                        System.out.println("Nenhuma matéria foi informada. Dados mantidos.");
                    }
                    break;

                case 4:
                    System.out.print("Aluno especial? (sim/nao): ");
                    while (true) {
                        String resposta = input.nextLine().trim().toLowerCase();
                        if (resposta.equals("sim")) {
                            aluno.setEspecial(true);
                            System.out.println("Tipo atualizado para especial.");
                            break;
                        } else if (resposta.equals("nao")) {
                            aluno.setEspecial(false);
                            System.out.println("Tipo atualizado para normal.");
                            break;
                        } else {
                            System.out.print("Digite 'sim' ou 'nao': ");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo da edição...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
   
}
