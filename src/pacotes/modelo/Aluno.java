package pacotes.modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private String curso;
    private boolean especial;
    private Turma turma;
    private int materiasMatriculadas;
    private List<String> materiasCursadas;
    private List<Integer> notas;

    public Aluno(int id, String nome, String matricula, String curso, boolean especial) {
    	super(id, nome, matricula);
        this.curso = curso;
        this.especial = especial;
        this.materiasCursadas = new ArrayList<>();
    }

    public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getMateriasMatriculadas() {
		return materiasMatriculadas;
	}

	public void setMateriasMatriculadas(int materiasMatriculadas) {
		this.materiasMatriculadas = materiasMatriculadas;
	}

	public List<String> getMateriasCursadas() {
		return materiasCursadas;
	}

	public void setMateriasCursadas(List<String> materiasCursadas) {
		this.materiasCursadas = materiasCursadas;
	}
	
	public List<Integer> getNotas() {
		return notas;
	}

	public void setNotas(List<Integer> notas) {
		this.notas = notas;
	}

	public void adicionarMateria(String materia) {
	    materiasCursadas.add(materia);
	    materiasMatriculadas = materiasCursadas.size();
	}

	public void removerMateria(String materia) {
	    materiasCursadas.remove(materia);
	    materiasMatriculadas = materiasCursadas.size();
	}

	public String getTipo() {
        return especial ? "Especial" : "Normal";
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
               ", Nome: " + getNome() +
               ", Matrícula: " + getMatricula() +
               ", Curso: " + curso +
               ", Tipo: " + getTipo() +
               ", Materias Cursadas: " + materiasCursadas;
    }
}
