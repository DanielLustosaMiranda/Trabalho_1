package pacotes.modelo;

public class Turma {
    private int id;
    private String semestre;
    private String formaDeAvaliacao;
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidadeMaxima;
    private String professorResponsavel;
    private String codigoDisciplina;
    
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
	public String getFormaDeAvaliacao() {
		return formaDeAvaliacao;
	}
	public void setFormaDeAvaliacao(String formaDeAvaliacao) {
		this.formaDeAvaliacao = formaDeAvaliacao;
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
	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
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
    
    
}
