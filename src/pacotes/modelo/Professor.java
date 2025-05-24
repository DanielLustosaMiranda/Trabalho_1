package pacotes.modelo;

public class Professor extends Pessoa {

    private Disciplina disciplina;
    private Turma turma;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        String nome = super.getNome();
        String nomeDisciplina = (disciplina != null) ? disciplina.getNome() : "Sem disciplina";
        String infoTurma = (turma != null) ? "Turma ID: " + turma.getId() : "Sem turma";
        
        return "Professor: " + nome + " | Disciplina: " + nomeDisciplina + " | " + infoTurma;
    }

}
