package pacotes.modelo;

import java.util.ArrayList;

public class Turma extends Disciplina {

    private int id;
    private String semestre;
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidade;
    private ArrayList<Aluno> alunosMatriculados;
    private Avaliacao avaliacao;
    private String professorResponsavel;
    private String codigoDisciplina;

    public Turma() {
        this.alunosMatriculados = new ArrayList<>();
    }

    public Turma(String nome, String codigo, String semestre, boolean presencial, String sala, String horario,
                 int capacidade, Avaliacao avaliacao, String professorResponsavel, String codigoDisciplina) {
        super(nome, codigo);
        this.semestre = semestre;
        this.presencial = presencial;
        this.sala = sala;
        this.horario = horario;
        this.capacidade = capacidade;
        this.avaliacao = avaliacao;
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

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(ArrayList<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
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
}
