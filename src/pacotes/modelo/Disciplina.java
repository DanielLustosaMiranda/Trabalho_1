package pacotes.modelo;

import java.util.ArrayList;

public class Disciplina {

    private int id;
    private String nome;
    private String codigo;
    private ArrayList<Disciplina> preRequisitos = new ArrayList<>();
    private String cargaHoraria;

    public Disciplina() {
    }

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina ID: ").append(id)
          .append(" | Nome: ").append(nome)
          .append(" | Código: ").append(codigo)
          .append(" | Carga Horária: ").append(cargaHoraria)
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
