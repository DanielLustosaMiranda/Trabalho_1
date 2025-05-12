package pacotes.controle;

import pacotes.modelo.Professor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorControle {

    // Lista de professores, que seria carregada a partir de um arquivo CSV
    private List<Professor> professores;

    public ProfessorControle() {
        professores = new ArrayList<>();
        carregarProfessores();
    }

    // Carregar professores a partir de um arquivo
    private void carregarProfessores() {
        try (BufferedReader reader = new BufferedReader(new FileReader("professor.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                Professor professor = new Professor();
                professor.setId(Integer.parseInt(campos[0]));
                professor.setNome(campos[1]);
                professor.setSenha(campos[2]);
                professor.setDisciplinaDada(campos[3]);
                professor.setDisciplinaResponsavel(campos[4]);
                
                professores.add(professor);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar professores: " + e.getMessage());
        }
    }

    // Método para adicionar um professor
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
        salvarProfessorEmArquivo(professor);
    }

    // Método para remover um professor
    public void removerProfessor(int id) {
        professores.removeIf(professor -> professor.getId() == id);
        atualizarProfessoresNoArquivo();
    }

    // Método para buscar um professor pelo ID
    public Professor buscarProfessorPorId(int id) {
        for (Professor professor : professores) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

    // Método para listar todos os professores
    public void listarProfessores() {
        for (Professor professor : professores) {
            System.out.println("ID: " + professor.getId() + " | Nome: " + professor.getNome() + " | Disciplina dada: " + professor.getDisciplinaDada());
        }
    }

    // Método para salvar um professor no arquivo
    private void salvarProfessorEmArquivo(Professor professor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("professor.csv", true))) {
            writer.write(professor.getId() + "," +
                    professor.getNome() + "," +
                    professor.getSenha() + "," +
                    professor.getDisciplinaDada() + "," +
                    professor.getDisciplinaResponsavel());
            writer.newLine();
            System.out.println("Professor " + professor.getNome() + " salvo no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar professor no arquivo: " + e.getMessage());
        }
    }

    // Método para atualizar os professores no arquivo
    private void atualizarProfessoresNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("professor.csv"))) {
            for (Professor professor : professores) {
                writer.write(professor.getId() + "," +
                        professor.getNome() + "," +
                        professor.getSenha() + "," +
                        professor.getDisciplinaDada() + "," +
                        professor.getDisciplinaResponsavel());
                writer.newLine();
            }
            System.out.println("Professores atualizados no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar professores no arquivo: " + e.getMessage());
        }
    }
}
