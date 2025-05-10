package pacotes.modelo;

public class Professor extends Identificação{
	
	private String disciplinaDada;
	private String disciplinaResponsavel;
	
	public String getDisciplinaDada() {
		return disciplinaDada;
	}
	public void setDisciplinaDada(String disciplinaDada) {
		this.disciplinaDada = disciplinaDada;
	}
	public String getDisciplinaResponsavel() {
		return disciplinaResponsavel;
	}
	public void setDisciplinaResponsavel(String disciplinaResponsavel) {
		this.disciplinaResponsavel = disciplinaResponsavel;
	}
	
}
