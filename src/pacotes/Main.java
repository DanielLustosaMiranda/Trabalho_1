package pacotes;
//import pacotes.controle.*;
import pacotes.vizualizacao.*;
//import pacotes.modelo.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	   
    	Scanner input = new Scanner(System.in);
    	MenuAll menu = new MenuAll();
    	
    	int repeat = 0;
    	while (repeat !=1 ) {
        	menu.displayCriationOptions();
        	System.out.println("Sair? ");
        	repeat = input.nextInt();
    	}

  
    	menu.displayLogin();
    	
    }
}
