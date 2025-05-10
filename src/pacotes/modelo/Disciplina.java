package pacotes.modelo;

public class Disciplina {
	private int id;
	private String nome;
	private String codigo;
	private String profResponsavel;
	private String preRequisitos;
	private String cargaHoraria;
	private int presencial;
	private int capacidadeAlunos;
	private int sala;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getProfResponsavel() {
		return profResponsavel;
	}
	public void setProfResponsavel(String profResponsavel) {
		this.profResponsavel = profResponsavel;
	}
	public String getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(String preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public int getPresencial() {
		return presencial;
	}
	public void setPresencial(int presencial) {
		this.presencial = presencial;
	}
	public int getCapacidadeAlunos() {
		return capacidadeAlunos;
	}
	public void setCapacidadeAlunos(int capacidadeAlunos) {
		this.capacidadeAlunos = capacidadeAlunos;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}

	
}
