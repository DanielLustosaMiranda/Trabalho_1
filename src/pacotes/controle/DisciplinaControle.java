package pacotes.controle;

import pacotes.modelo.Disciplina;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaControle {
    
    // Lista de disciplinas, que seria carregada a partir de um arquivo CSV
    private List<Disciplina> disciplinas;
    
    public DisciplinaControle() {
        disciplinas = new ArrayList<>();
        carregarDisciplinas();
    }
    
    // Carregar disciplinas a partir de um arquivo
    private void carregarDisciplinas() {
        try (BufferedReader reader = new BufferedReader(new FileReader("disciplina.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                Disciplina disciplina = new Disciplina();
                disciplina.setId(Integer.parseInt(campos[0]));
                disciplina.setNome(campos[1]);
                disciplina.setCodigo(campos[2]);
                disciplina.setProfResponsavel(campos[3]);
                disciplina.setPreRequisitos(campos[4]);
                disciplina.setCargaHoraria(campos[5]);
                disciplina.setPresencial(Boolean.parseBoolean(campos[6]));
                disciplina.setCapacidadeAlunos(Integer.parseInt(campos[7]));
                disciplina.setSala(Integer.parseInt(campos[8]));
                
                disciplinas.add(disciplina);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
        }
    }

    // Método para adicionar uma disciplina
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        salvarDisciplinaEmArquivo(disciplina);
    }

    // Método para remover uma disciplina
    public void removerDisciplina(int id) {
        disciplinas.removeIf(disciplina -> disciplina.getId() == id);
        atualizarDisciplinasNoArquivo();
    }

    // Método para buscar uma disciplina pelo código
    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    // Método para listar todas as disciplinas
    public void listarDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            System.out.println("ID: " + disciplina.getId() + " | Nome: " + disciplina.getNome() + " | Código: " + disciplina.getCodigo());
        }
    }

    // Método para salvar uma disciplina no arquivo
    private void salvarDisciplinaEmArquivo(Disciplina disciplina) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplina.csv", true))) {
            writer.write(disciplina.getId() + "," +
                    disciplina.getNome() + "," +
                    disciplina.getCodigo() + "," +
                    disciplina.getProfResponsavel() + "," +
                    disciplina.getPreRequisitos() + "," +
                    disciplina.getCargaHoraria() + "," +
                    disciplina.isPresencial() + "," +
                    disciplina.getCapacidadeAlunos() + "," +
                    disciplina.getSala());
            writer.newLine();
            System.out.println("Disciplina " + disciplina.getNome() + " salva no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplina no arquivo: " + e.getMessage());
        }
    }

    // Método para atualizar as disciplinas no arquivo
    private void atualizarDisciplinasNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplina.csv"))) {
            for (Disciplina disciplina : disciplinas) {
                writer.write(disciplina.getId() + "," +
                        disciplina.getNome() + "," +
                        disciplina.getCodigo() + "," +
                        disciplina.getProfResponsavel() + "," +
                        disciplina.getPreRequisitos() + "," +
                        disciplina.getCargaHoraria() + "," +
                        disciplina.isPresencial() + "," +
                        disciplina.getCapacidadeAlunos() + "," +
                        disciplina.getSala());
                writer.newLine();
            }
            System.out.println("Disciplinas atualizadas no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar disciplinas no arquivo: " + e.getMessage());
        }
    }
}
