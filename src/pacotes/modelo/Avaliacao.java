package pacotes.modelo;

public class Avaliacao {
	
    public enum TipoAvaliacao {
        SIMPLES, PONDERADA
    }

    private double p1, p2, p3, listas, seminario;
    private int totalAulas;
    private int presencas;
    private TipoAvaliacao tipo;

    public Avaliacao() {
    	
    }
    public Avaliacao(TipoAvaliacao tipo) {
        this.tipo = tipo;
    }
    
    public TipoAvaliacao getTipo() {
		return tipo;
	}
    
	public void setTipo(TipoAvaliacao tipo) {
		this.tipo = tipo;
	}

	public void lancarNotas(double p1, double p2, double p3, double listas, double seminario) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.listas = listas;
        this.seminario = seminario;
    }

    public void registrarFrequencia(int totalAulas, int presencas) {
        this.totalAulas = totalAulas;
        this.presencas = presencas;
    }

    public double calcularMedia() {
        if (tipo == TipoAvaliacao.SIMPLES) {
            return (p1 + p2 + p3 + listas + seminario) / 5.0;
        } else {
            return (p1 + p2 * 2 + p3 * 3 + listas + seminario) / 8.0;
        }
    }

    public double getFrequencia() {
        return (presencas * 100.0) / totalAulas;
    }

    public String getStatus() {
        double media = calcularMedia();
        double freq = getFrequencia();

        if (freq < 75.0) return "Reprovado por falta";
        else if (media < 5.0) return "Reprovado por nota";
        else return "Aprovado";
    }

    public void exibirRelatorio() {
        System.out.printf("Média: %.2f\n", calcularMedia());
        System.out.printf("Frequência: %.2f%%\n", getFrequencia());
        System.out.println("Status: " + getStatus());
    }
    
    @Override
    public String toString() {
        return tipo != null ? tipo.toString().toLowerCase() : "indefinido";
    }

}
