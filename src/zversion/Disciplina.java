package zversion;

public class Disciplina {
	private String nome;
	private String codigo;
	private int cargaHoraria;
	private String preRequisitos;
	private boolean ehPresencial;
	private int sala;
	private int quantidadeDeAlunos;
	private int maxAlunos;
	
	public Disciplina() {
		this.nome = "";
		this.codigo = "";
		this.cargaHoraria = 0;
		this.preRequisitos = "";
		this.ehPresencial = false;
		this.sala = 0;
		this.quantidadeDeAlunos = 0;
		this.maxAlunos = 0;
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

	public int getCargaHoraria() {
	    return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
	    this.cargaHoraria = cargaHoraria;
	}

	public String getPreRequisitos() {
	    return preRequisitos;
	}
	public void setPreRequisitos(String preRequisitos) {
	    this.preRequisitos = preRequisitos;
	}

	public boolean isEhPresencial() {
	    return ehPresencial;
	}
	public void setEhPresencial(boolean ehPresencial) {
	    this.ehPresencial = ehPresencial;
	}

	public int getSala() {
	    return sala;
	}
	public void setSala(int sala) {
	    this.sala = sala;
	}

	public int getQuantidadeDeAlunos() {
	    return quantidadeDeAlunos;
	}
	public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
	    this.quantidadeDeAlunos = quantidadeDeAlunos;
	}

	public int getMaxAlunos() {
	    return maxAlunos;
	}
	public void setMaxAlunos(int maxAlunos) {
	    this.maxAlunos = maxAlunos;
	}

	void exibirInfo() {
			System.out.println(nome);
			System.out.println(codigo);
			System.out.println(cargaHoraria);
			System.out.println(preRequisitos);
			System.out.println(ehPresencial);
			System.out.println(sala);
			System.out.println(quantidadeDeAlunos);
			System.out.println(maxAlunos);
	}
	
	
}
