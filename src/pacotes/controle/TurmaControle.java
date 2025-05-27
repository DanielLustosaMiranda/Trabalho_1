package pacotes.controle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pacotes.criadores.GeradorCodigos;
import pacotes.modelo.Avaliacao;
import pacotes.modelo.Avaliacao.TipoAvaliacao;
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
            if (presencialStr.equals("true")) {
            	
            	System.out.print("Sala: ");
                turma.setSala(input.nextLine().trim());
                
                turma.setPresencial(true);
                break;
            } else if (presencialStr.equals("false")) {
            	turma.setPresencial(false);
            	turma.setSala("-1");
            	break;
            }
            else {
            	System.out.print("Digite 'true' ou 'false': ");
            }
        }

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

        System.out.println("Forma de avaliação: ");
        System.out.println("1- simples");
        System.out.println("2- ponderada");
        
        int avaliacao = (input.nextInt());
        Avaliacao avalia = new Avaliacao();
        
        switch (avaliacao) {
	        case 1:
	        	avalia.setTipo(TipoAvaliacao.SIMPLES);
	        	turma.setAvaliacao(avalia);
	        	break;
	        case 2:
	        	avalia.setTipo(TipoAvaliacao.PONDERADA);
	        	turma.setAvaliacao(avalia);
        }
        input.nextLine(); 
        
        System.out.print("Professor responsável: ");
        turma.setProfessorResponsavel(input.nextLine().trim());

        System.out.print("Código da disciplina: ");
        turma.setCodigoDisciplina(input.nextLine().trim());

        turma.setId(GeradorCodigos.getProximoId("turmas.csv"));

        System.out.println("Turma criada com sucesso!");
        
        return turma;
    }
    
    public static void salvarTurmaEmArquivo(Turma turma) {
    	
    	int id = GeradorCodigos.getProximoId("turma.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("turma:" + turma.getCodigoDisciplina()+ ".csv", true))) {
            writer.write(id + "," +
                         turma.getSemestre() + "," +
                         turma.isPresencial() + "," +
                         turma.getSala() + "," +
                         turma.getHorario() + "," +
                         turma.getCapacidade() + "," +
                         turma.getAvaliacao() + "," +
                         turma.getProfessorResponsavel() + "," +
                         turma.getCodigoDisciplina());
            writer.newLine();
            System.out.println("Turma salva com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar turma: " + e.getMessage());
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("turma.csv", true))) {
            writer.write(id + "," +
                         turma.getSemestre() + "," +
                         turma.isPresencial() + "," +
                         turma.getSala() + "," +
                         turma.getHorario() + "," +
                         turma.getCapacidade() + "," +
                         turma.getAvaliacao() + "," +
                         turma.getProfessorResponsavel() + "," +
                         turma.getCodigoDisciplina());
            writer.newLine();
            System.out.println("Turma salva com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar turma: " + e.getMessage());
        }
    }
    
    public static void exibirAlunos(String codigo) {

    	String arquivoTurma = "turma:" + codigo + ".csv";

        try (Scanner scanner = new Scanner(new java.io.File(arquivoTurma))) {
            System.out.println("=== Alunos matriculados na turma " + codigo + " ===");
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                
                String[] partes = linha.split(",");
                if (partes.length >= 3) {
                	String id = partes[0];
                    String nome = partes[1];
                    String matricula = partes[2];
                    System.out.println("ID: " + id + " | Nome: " + nome + " | Matrícula: " + matricula);
                } else {
                    System.out.println("Linha com formato inesperado: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo da turma: " + e.getMessage());
        }
    	
    }

    public static void matricularAluno() {
    	Scanner input = new Scanner(System.in);

        System.out.print("\nDigite a matrícula do aluno para matricular: ");
        String matriculaBuscada = input.nextLine().trim();

        System.out.print("Digite o código da disciplina (da turma) para matricular o aluno: ");
        String codigoDisciplina = input.nextLine().trim();

        boolean alunoEncontrado = false;
        String nomeAluno = "";

        try {
            java.io.File arquivoOriginal = new java.io.File("alunos.csv");
            java.io.File arquivoTemp = new java.io.File("aluno_temp.csv");

            try (Scanner scanner = new Scanner(arquivoOriginal);
                 BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemp))) {

                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] partes = linha.split(",");

                    if (partes.length >= 5) {
                        String id = partes[0];
                        String nome = partes[1];
                        String matricula = partes[2];
                        String materiasCursadas = partes[3];
                        String especial = partes[4];
                        String codigoTurma = partes.length >= 6 ? partes[5] : "";

                        if (matricula.equals(matriculaBuscada)) {
                            alunoEncontrado = true;
                            codigoTurma = codigoDisciplina;
                            nomeAluno = nome;
                            System.out.println("Aluno '" + nome + "' matriculado na disciplina: " + codigoDisciplina);
                        }

                        writer.write(id + "," + nome + "," + matricula + "," + materiasCursadas + "," + especial + "," + codigoTurma);
                        writer.newLine();
                    } else {
                        writer.write(linha);
                        writer.newLine();
                    }
                }
            }

            if (!arquivoOriginal.delete()) {
                System.out.println("Erro ao deletar o arquivo original.");
                return;
            }
            if (!arquivoTemp.renameTo(arquivoOriginal)) {
                System.out.println("Erro ao renomear o arquivo temporário.");
                return;
            }

            if (!alunoEncontrado) {
                System.out.println("Aluno com matrícula '" + matriculaBuscada + "' não encontrado.");
                return;
            }

            String nomeArquivoTurma = "turma:" + codigoDisciplina + ".csv";
            try (BufferedWriter writerTurma = new BufferedWriter(new FileWriter(nomeArquivoTurma, true))) {
                writerTurma.write(GeradorCodigos.getProximoId(nomeArquivoTurma) + "," + nomeAluno + "," + matriculaBuscada);
                writerTurma.newLine();
                System.out.println("Aluno adicionado no arquivo da turma: " + nomeArquivoTurma);
            } catch (IOException e) {
                System.out.println("Erro ao salvar aluno no arquivo da turma: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Erro ao editar o arquivo de alunos: " + e.getMessage());
        }
    
    }
    
    public static void listarTurmas() {
        String nomeArquivo = "turma.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            
            System.out.println("\n=== Lista de Turmas ===");
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 9) {
                    String id = partes[0];
                    String semestre = partes[1];
                    String presencial = partes[2].equals("true") ? "Presencial" : "Remota";
                    String sala = partes[3].equals("-1") ? "N/A" : partes[3];
                    String horario = partes[4];
                    String capacidade = partes[5];
                    String avaliacao = partes[6];
                    String professor = partes[7];
                    String codigoDisciplina = partes[8];
                                       
                    System.out.println("ID: " + id);
                    System.out.println("Semestre: " + semestre);
                    System.out.println("Modalidade: " + presencial);
                    System.out.println("Sala: " + sala);
                    System.out.println("Horário: " + horario);
                    System.out.println("Capacidade: " + capacidade);
                    System.out.println("Tipo de Avaliação: " + avaliacao);
                    System.out.println("Professor Responsável: " + professor);
                    System.out.println("Código da Disciplina: " + codigoDisciplina);
                    System.out.println("-------------------------");
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void listarAlunos() {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Código da Disciplina:");
    	String codigoDisciplina = input.nextLine().trim();
        String nomeArquivo = "turma:" + codigoDisciplina + ".csv";

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            boolean primeiraLinha = true;
            System.out.println("\n=== Detalhes da Turma ===");

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                if (primeiraLinha && partes.length >= 9) {
                    String id = partes[0];
                    String semestre = partes[1];
                    String presencial = partes[2].equals("true") ? "Presencial" : "Remota";
                    String sala = partes[3].equals("-1") ? "N/A" : partes[3];
                    String horario = partes[4];
                    String capacidade = partes[5];
                    String avaliacao = partes[6];
                    String professor = partes[7];
                    String codigo = partes[8];

                    System.out.println("ID: " + id);
                    System.out.println("Semestre: " + semestre);
                    System.out.println("Modalidade: " + presencial);
                    System.out.println("Sala: " + sala);
                    System.out.println("Horário: " + horario);
                    System.out.println("Capacidade: " + capacidade);
                    System.out.println("Tipo de Avaliação: " + avaliacao);
                    System.out.println("Professor Responsável: " + professor);
                    System.out.println("Código da Disciplina: " + codigo);
                    System.out.println("\n=== Alunos Matriculados ===");
                    primeiraLinha = false;
                } else if (partes.length >= 3) {
                    String idAluno = partes[0];
                    String nomeAluno = partes[1];
                    String matricula = partes[2];
                    System.out.println("ID: " + idAluno + " | Nome: " + nomeAluno + " | Matrícula: " + matricula);
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
