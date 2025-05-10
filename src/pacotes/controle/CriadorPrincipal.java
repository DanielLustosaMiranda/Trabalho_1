package pacotes.controle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pacotes.modelo.Aluno;
import pacotes.modelo.Disciplina;
import pacotes.modelo.Professor;
import pacotes.modelo.Turma;

import java.io.BufferedReader;
import java.io.FileReader;

public class CriadorPrincipal {
    Scanner input = new Scanner(System.in);

    // Método para obter o próximo ID baseado no arquivo CSV
    private int getProximoId(String arquivo) {
        int id = 1;  // Começa com o ID 1, se o arquivo estiver vazio ou não existir
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                id++;  // A cada linha lida, incrementamos o ID
            }
            System.out.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return id;
    }

    // Método para criar aluno
    public Aluno criarAluno() {
        Aluno aluno = new Aluno();
        aluno.setId(getProximoId("aluno.csv"));

        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(input.nextLine());
        System.out.print("Digite a senha do aluno: ");
        aluno.setSenha(input.nextLine());
        System.out.print("Digite a matrícula do aluno: ");
        aluno.setMatricula(input.nextLine());
        System.out.print("Digite o curso de graduação: ");
        aluno.setCursoDeGraduacao(input.nextLine());
        System.out.print("Digite as matérias cursadas: ");
        aluno.setMateriasCursadas(input.nextLine());

        return aluno;
    }

    // Método para salvar aluno no arquivo
    public void salvarAlunoEmArquivo(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("aluno.csv", true))) {
            // Salva os dados do aluno no formato CSV: id,nome,matricula,curso,materiasCursadas
            writer.write(aluno.getId() + "," +
                    aluno.getNome() + "," +
                    aluno.getMatricula() + "," +
                    aluno.getCursoDeGraduacao() + "," +
                    aluno.getMateriasCursadas());
            writer.newLine();
            System.out.println("Aluno " + aluno.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar aluno no arquivo: " + e.getMessage());
        }
    }

    // Método para criar professor
    public Professor criarProfessor() {
        Professor prof = new Professor();
        prof.setId(getProximoId("professor.csv"));

        System.out.print("Digite o nome do professor: ");
        prof.setNome(input.nextLine());
        System.out.print("Digite a senha do professor: ");
        prof.setSenha(input.nextLine());
        System.out.print("Digite a disciplina dada: ");
        prof.setDisciplinaDada(input.nextLine());
        System.out.print("Digite a disciplina responsável: ");
        prof.setDisciplinaResponsavel(input.nextLine());

        return prof;
    }

    // Método para salvar professor no arquivo
    public void salvarProfessorEmArquivo(Professor prof) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("professor.csv", true))) {
            // Salva os dados do professor no formato CSV: id,nome,disciplinaDada,disciplinaResponsavel
            writer.write(prof.getId() + "," +
                    prof.getNome() + "," +
            		prof.getSenha() + "," +
                    prof.getDisciplinaDada() + "," +
                    prof.getDisciplinaResponsavel());
            writer.newLine(); // Nova linha após gravar os dados
            System.out.println("Professor " + prof.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar professor no arquivo: " + e.getMessage());
        }
    }

    // Método para criar disciplina
    public Disciplina criarDisciplina() {
        Disciplina disciplina = new Disciplina();

        disciplina.setId(getProximoId("disciplina.csv"));

        System.out.print("Digite o nome da disciplina: ");
        disciplina.setNome(input.nextLine());
        System.out.print("Digite o código da disciplina: ");
        disciplina.setCodigo(input.nextLine());
        // Limpeza do buffer após nextInt()
        System.out.print("Digite o professor da disciplina: ");
        disciplina.setProfResponsavel(input.nextLine());
        System.out.print("Digite os pré-requisitos da disciplina: ");
        disciplina.setPreRequisitos(input.nextLine());
        System.out.print("Digite a carga horária da disciplina: ");
        disciplina.setCargaHoraria(input.nextLine());
        System.out.print("Digite 1 se a disciplina é presencial, 0 se não: ");
        disciplina.setPresencial(input.nextInt());
        input.nextLine(); // Limpeza do buffer após nextInt()
        System.out.print("Digite a capacidade de alunos da disciplina: ");
        disciplina.setCapacidadeAlunos(input.nextInt());
        input.nextLine(); // Limpeza do buffer após nextInt()
        System.out.print("Digite a sala da disciplina: ");
        disciplina.setSala(input.nextInt());
        input.nextLine(); // Limpeza do buffer após nextInt()

        return disciplina;
    }

    // Método para salvar disciplina no arquivo
    public void salvarDisciplinaEmArquivo(Disciplina disciplina) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplina.csv", true))) {
            // Salva os dados da disciplina no formato CSV
            writer.write(disciplina.getId() + "," +
                    disciplina.getNome() + "," +
                    disciplina.getCodigo() + "," +
                    disciplina.getProfResponsavel() + "," +
                    disciplina.getPreRequisitos() + "," +
                    disciplina.getCargaHoraria() + "," +
                    disciplina.getPresencial() + "," +
                    disciplina.getCapacidadeAlunos() + "," +
                    disciplina.getSala());
            writer.newLine(); // Nova linha após gravar os dados
            System.out.println("Disciplina " + disciplina.getNome() + " salva no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplina no arquivo: " + e.getMessage());
        }
    }
    
    public Turma criarTurma() {
        Turma turma = new Turma();

        // Solicitar dados da turma
        System.out.print("Digite o semestre da turma: ");
        turma.setSemestre(input.nextLine());

        System.out.print("Digite a forma de avaliação: media simples ou ponderada");
        turma.setFormaDeAvaliacao(input.nextLine());

        System.out.print("A turma é presencial? (true para sim, false para não): ");
        
        String presencialInput = input.nextLine().trim().toLowerCase();
        if (presencialInput.equals("sim")) {
            turma.setPresencial(true);
        } else if (presencialInput.equals("não")) {
            turma.setPresencial(false);
        } else {
            System.out.println("Entrada inválida, considerando como não presencial.");
            turma.setPresencial(false); // Default se entrada for inválida
        }
        

        System.out.print("Digite o horário da turma: ");
        turma.setHorario(input.nextLine());

        System.out.print("Digite a capacidade máxima de alunos da turma: ");
        turma.setCapacidadeMaxima(input.nextInt());
        input.nextLine();  // Consumir a nova linha pendente após nextInt()

        System.out.print("Digite o nome do professor responsável pela turma: ");
        turma.setProfessorResponsavel(input.nextLine());

        System.out.print("Digite o código da disciplina da turma: ");
        turma.setCodigoDisciplina(input.nextLine());

        // Gerar ID para a turma (assumindo que você tenha um método para isso)
        turma.setId(getProximoId("turma.csv"));

        return turma;
    }
    
    public void salvarTurmaEmArquivo(Turma turma) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("turma.csv", true))) {
            // Salva os dados da turma no formato CSV: id, semestre, formaDeAvaliacao, presencial, sala, horario, capacidadeMaxima, professorResponsavel, codigoDisciplina
            writer.write(turma.getId() + "," + 
                         turma.getSemestre() + "," + 
                         turma.getFormaDeAvaliacao() + "," + 
                         turma.isPresencial() + "," + 
                         turma.getSala() + "," + 
                         turma.getHorario() + "," + 
                         turma.getCapacidadeMaxima() + "," + 
                         turma.getProfessorResponsavel() + "," + 
                         turma.getCodigoDisciplina());
            writer.newLine(); // Nova linha após gravar os dados
            System.out.println("Turma " + turma.getCodigoDisciplina() + " salva no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar turma no arquivo: " + e.getMessage());
        }
    }

}
