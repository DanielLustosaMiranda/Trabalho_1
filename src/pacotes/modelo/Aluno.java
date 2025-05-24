package pacotes.modelo;

import pacotes.criadores.GeradorCodigos;

public class Aluno extends Pessoa {
    private boolean especial;
    private Turma turma;
    private Avaliacao avaliacao;
    private String materiasCursadas;

    public Aluno(String nome, String matricula,
                 String materiasCursadas, boolean especial) {
        int id = GeradorCodigos.getProximoId("alunos.csv");
        super.setId(id);
        super.setNome(nome);
        super.setMatricula(matricula);
        this.materiasCursadas = materiasCursadas;
        this.especial = especial;
    }

    public boolean getEspecial() {
        return especial;
    }
    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public String getMateriasCursadas() {
        return materiasCursadas;
    }
    public void setMateriasCursadas(String materiasCursadas) {
        this.materiasCursadas = materiasCursadas;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno: " + super.getNome() +
               " | Matrícula: " + super.getMatricula() +
               " | Especial: " + (especial ? "Sim" : "Não") +
               " | Matérias Cursadas: " + materiasCursadas +
               " | Turma: " + (turma != null ? turma.toString() : "Nenhuma") +
               " | Avaliação: " + (avaliacao != null ? avaliacao.toString() : "Nenhuma");
    }


}
