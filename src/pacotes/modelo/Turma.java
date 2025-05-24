package pacotes.modelo;

import java.util.ArrayList;

import pacotes.criadores.GeradorCodigos;

public class Turma {
	
    private int id;
    private String semestre;
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidade;
    private ArrayList<Aluno> alunosMatriculados;  
    private String formaDeAvaliacao;
    private String professorResponsavel;
    private String codigoDisciplina;

    public Turma() {
        this.alunosMatriculados = new ArrayList<>();
    }

    public Turma(String semestre, boolean presencial, String sala, String horario,
            int capacidade, String formaDeAvaliacao, String professorResponsavel, String codigoDisciplina) {
	    int id = GeradorCodigos.getProximoId("alunos.csv");
	   this.id = id;
	   this.semestre = semestre;
	   this.presencial = presencial;
	   this.sala = sala;
	   this.horario = horario;
	   this.capacidade = capacidade;
	   this.formaDeAvaliacao = formaDeAvaliacao;
	   this.professorResponsavel = professorResponsavel;
	   this.codigoDisciplina = codigoDisciplina;
	   this.alunosMatriculados = new ArrayList<>();
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getFormaDeAvaliacao() {
        return formaDeAvaliacao;
    }

    public void setFormaDeAvaliacao(String formaDeAvaliacao) {
        this.formaDeAvaliacao = formaDeAvaliacao;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(ArrayList<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public void adicionarAluno(Aluno aluno) {
        if (alunosMatriculados.size() < capacidade) {
            alunosMatriculados.add(aluno);
        } else {
            System.out.println("Capacidade máxima atingida!");
        }
    }

    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma ID: ").append(id)
          .append(" | Semestre: ").append(semestre)
          .append(" | Presencial: ").append(presencial ? "Sim" : "Não")
          .append(" | Sala: ").append(sala)
          .append(" | Horário: ").append(horario)
          .append(" | Capacidade: ").append(capacidade)
          .append(" | Forma de Avaliação: ").append(formaDeAvaliacao)
          .append(" | Professor: ").append(professorResponsavel)
          .append(" | Código Disciplina: ").append(codigoDisciplina)
          .append("\nAlunos Matriculados (").append(alunosMatriculados.size()).append("):");

        if (alunosMatriculados.isEmpty()) {
            sb.append(" Nenhum aluno matriculado.");
        } else {
            for (Aluno aluno : alunosMatriculados) {
                sb.append("\n- ").append(aluno.getNome())
                  .append(" (").append(aluno.getMatricula()).append(")");
            }
        }

        return sb.toString();
    }

}
