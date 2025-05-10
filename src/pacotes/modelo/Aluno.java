package pacotes.modelo;

public class Aluno extends Identificação {
	
	private String matricula;
	private String cursoDeGraduacao;
	private String materiasCursadas;
	private boolean especial;
	
	public Aluno() {
		this.matricula = "";
		this.cursoDeGraduacao = "";
		this.materiasCursadas = "";
		this.especial = false;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCursoDeGraduacao() {
		return cursoDeGraduacao;
	}
	public void setCursoDeGraduacao(String cursoDeGraduacao) {
		this.cursoDeGraduacao = cursoDeGraduacao;
	}
	public String getMateriasCursadas() {
		return materiasCursadas;
	}
	public void setMateriasCursadas(String materiasCursadas) {
		this.materiasCursadas = materiasCursadas;
	}
	public boolean getEspecial() {
		return especial;
	}
	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	
}
