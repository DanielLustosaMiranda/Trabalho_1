package pacotes;
//import pacotes.controle.*;
import pacotes.vizualizacao.*;
//import pacotes.modelo.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	   
    	Scanner input = new Scanner(System.in);
    	MenuAll menu = new MenuAll();
    	
    	System.out.println("Login or create");
    	int resposta = input.nextInt();
    	
    	if (resposta == 1) {
    		menu.displayCriationOptions();
    	}
    	menu.displayLogin();
    	
    }
}
