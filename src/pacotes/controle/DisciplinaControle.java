package pacotes.controle;
import pacotes.modelo.Disciplina;
import java.io.*;
import java.util.Scanner;


public class DisciplinaControle {
    Scanner input = new Scanner(System.in);

	public void imprimirDiciplinas() {
        String caminhoArquivo = "turma.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
	}
}
