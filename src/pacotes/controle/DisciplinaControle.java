package pacotes.controle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import pacotes.criadores.GeradorCodigos;
import pacotes.modelo.Disciplina;

public class DisciplinaControle {

	public static Disciplina criarDisciplina() {
	    Scanner input = new Scanner(System.in);

	    System.out.print("Nome da disciplina: ");
	    String nome = input.nextLine().trim();

	    System.out.print("Código da disciplina: ");
	    String codigo = input.nextLine().trim();

	    System.out.print("Carga horária (ex: 60h): ");
	    String cargaHoraria = input.nextLine().trim();

	    ArrayList<Disciplina> preRequisitos = new ArrayList<>();
	    String requisito;
	    String codigoR;

	    do {
	        System.out.println("\nDigite 'fim' para terminar.");

	        System.out.print("Nome do Pré-requisito: ");
	        requisito = input.nextLine().trim();

	        if (!requisito.equalsIgnoreCase("fim")) {
	            System.out.print("Código do Pré-requisito: ");
	            codigoR = input.nextLine().trim();

	            preRequisitos.add(new Disciplina(requisito, codigoR));
	            System.out.println("Pré-requisito adicionado!");
	        }

	    } while (!requisito.equalsIgnoreCase("fim"));

	    Disciplina d = new Disciplina();
	    d.setNome(nome);
	    d.setCodigo(codigo);
	    d.setCargaHoraria(cargaHoraria);
	    d.setPreRequisitos(preRequisitos);

	    return d;
	}
    public static void salvarEmArquivo(Disciplina d) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplina.csv", true))) {
            String preReqs = "";
            if (d.getPreRequisitos() != null && !d.getPreRequisitos().isEmpty()) {
                preReqs = d.getPreRequisitos().stream()
                        .map(Disciplina::getCodigo)
                        .collect(Collectors.joining(";"));
            }
            
            int id = GeradorCodigos.getProximoId("disciplina.csv");
            String linha =  id + "," +
                           d.getNome() + "," +
                           d.getCodigo() + "," +
                           d.getCargaHoraria() + "," +
                           preReqs;

            writer.write(linha);
            writer.newLine();
            System.out.println("Disciplina " + d.getNome() + " salva no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplina no arquivo: " + e.getMessage());
        }
    }
}

