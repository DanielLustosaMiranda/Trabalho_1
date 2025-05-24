package pacotes.modelo;

import java.util.ArrayList;

public class Disciplina {

    private int id;
    private String nome;
    private String codigo;
    private ArrayList<Disciplina> preRequisitos = new ArrayList<>();
    private String cargaHoraria;
    private boolean presencial;
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

    public ArrayList<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }
    public void setPreRequisitos(ArrayList<Disciplina> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isPresencial() {
        return presencial;
    }
    public void setPresencial(boolean presencial) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina ID: ").append(id)
          .append(" | Nome: ").append(nome)
          .append(" | Código: ").append(codigo)
          .append(" | Carga Horária: ").append(cargaHoraria)
          .append(" | Presencial: ").append(presencial ? "Sim" : "Não")
          .append(" | Capacidade: ").append(capacidadeAlunos)
          .append(" | Sala: ").append(sala)
          .append("\nPré-requisitos (").append(preRequisitos.size()).append("):");

        if (preRequisitos.isEmpty()) {
            sb.append(" Nenhum");
        } else {
            for (Disciplina d : preRequisitos) {
                sb.append("\n- ").append(d.getNome()).append(" (Código: ").append(d.getCodigo()).append(")");
            }
        }

        return sb.toString();
    }
}
