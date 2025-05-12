package pacotes.controle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pacotes.modelo.Aluno;
import pacotes.modelo.Disciplina;
import pacotes.modelo.Professor;
import pacotes.modelo.Turma;

public class CriadorPrincipal {
    Scanner input = new Scanner(System.in);
    
    int id = GeradorCodigos.getProximoId("aluno.csv");
    
    public Aluno criarAluno() {
        Aluno aluno = new Aluno();
        int id = GeradorCodigos.getProximoId("aluno.csv");
        aluno.setId(id);

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
    
    public void salvarAlunoEmArquivo(Aluno aluno) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("aluno.csv", true))) {
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
    
    public Professor criarProfessor() {
    	
        Professor prof = new Professor();
        int id = GeradorCodigos.getProximoId("professor.csv");
        prof.setId(id);

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
    
    public void salvarProfessorEmArquivo(Professor prof) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("professor.csv", true))) {
            writer.write(prof.getId() + "," +
                    prof.getNome() + "," +
            		prof.getSenha() + "," +
                    prof.getDisciplinaDada() + "," +
                    prof.getDisciplinaResponsavel());
            writer.newLine(); 
            System.out.println("Professor " + prof.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar professor no arquivo: " + e.getMessage());
        }
    }

    public Disciplina criarDisciplina() {
        Disciplina disciplina = new Disciplina();
        
        int id = GeradorCodigos.getProximoId("disciplina.csv");
        disciplina.setId(id);

        System.out.print("Digite o nome da disciplina: ");
        disciplina.setNome(input.nextLine());
        System.out.print("Digite o código da disciplina: ");
        disciplina.setCodigo(input.nextLine());
        System.out.print("Digite o professor da disciplina: ");
        disciplina.setProfResponsavel(input.nextLine());
        System.out.print("Digite os pré-requisitos da disciplina: ");
        disciplina.setPreRequisitos(input.nextLine());
        System.out.print("Digite a carga horária da disciplina: ");
        disciplina.setCargaHoraria(input.nextLine());
        System.out.print("Digite 1 se a disciplina é presencial, 0 se não: ");
        disciplina.setPresencial(input.nextInt());
        input.nextLine(); 
        System.out.print("Digite a capacidade de alunos da disciplina: ");
        disciplina.setCapacidadeAlunos(input.nextInt());
        input.nextLine(); 
        System.out.print("Digite a sala da disciplina: ");
        disciplina.setSala(input.nextInt());
        input.nextLine();

        return disciplina;
    }
    
    public void salvarDisciplinaEmArquivo(Disciplina disciplina) {
    	 try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplina.csv", true))) {
             writer.write(disciplina.getId() + "," +
                     disciplina.getNome() + "," +
                     disciplina.getCodigo() + "," +
                     disciplina.getProfResponsavel() + "," +
                     disciplina.getPreRequisitos() + "," +
                     disciplina.getCargaHoraria() + "," +
                     disciplina.getPresencial() + "," +
                     disciplina.getCapacidadeAlunos() + "," +
                     disciplina.getSala());
             writer.newLine(); 
             System.out.println("Disciplina " + disciplina.getNome() + " salva no arquivo.");
         } catch (IOException e) {
             System.out.println("Erro ao salvar disciplina no arquivo: " + e.getMessage());
         }
    }
    public Turma criarTurma() {
        Turma turma = new Turma();
        int id = GeradorCodigos.getProximoId("turma.csv");
        turma.setId(id);

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
            turma.setPresencial(false); 
        }
        
        System.out.print("Digite o horário da turma: ");
        turma.setHorario(input.nextLine());

        System.out.print("Digite a capacidade máxima de alunos da turma: ");
        turma.setCapacidadeMaxima(input.nextInt());
        input.nextLine();  

        System.out.print("Digite o nome do professor responsável pela turma: ");
        turma.setProfessorResponsavel(input.nextLine());

        System.out.print("Digite o código da disciplina da turma: ");
        turma.setCodigoDisciplina(input.nextLine());
        return turma;
    }
    
    public void salvarTurmaEmArquivo(Turma turma) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("turma.csv", true))) {
            writer.write(turma.getId() + "," + 
                    turma.getSemestre() + "," + 
                    turma.getFormaDeAvaliacao() + "," + 
                    turma.isPresencial() + "," + 
                    turma.getSala() + "," + 
                    turma.getHorario() + "," + 
                    turma.getCapacidadeMaxima() + "," + 
                    turma.getProfessorResponsavel() + "," + 
                    turma.getCodigoDisciplina());
            writer.newLine(); 
       		System.out.println("Turma " + turma.getCodigoDisciplina() + " salva no arquivo.");
       } catch (IOException e) {
    	   System.out.println("Erro ao salvar turma no arquivo: " + e.getMessage());
       }
    }
    
}
