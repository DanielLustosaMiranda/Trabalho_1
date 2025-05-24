package pacotes.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeradorCodigos {
	
    public static int getProximoId(String arquivo) {
        int id = 1;  // Começa com o ID 1, se o arquivo estiver vazio ou não existir
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                id++;  // A cada linha lida, incrementamos o ID
            }
            System.out.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return id;
    }
}
