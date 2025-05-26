package pacotes.criadores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeradorCodigos {
	
    public static int getProximoId(String arquivo) {
        int id = 1; 
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                id++; 
            }
            System.out.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return id;
    }
   
}
