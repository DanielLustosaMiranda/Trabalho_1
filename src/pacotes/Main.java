package pacotes;

import java.util.Scanner;

import pacotes.modos.ModoAluno;
import pacotes.modos.ModoCriacao;
import pacotes.modos.ModoTurma;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
        	
            System.out.println("== Bem vindo ==");
            System.out.println("1 - Modo Aluno");
            System.out.println("2 - Modo Turma");
            System.out.println("3 - Modo criação");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String opcaoStr = input.nextLine().trim();
            int opcao;

            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    ModoAluno.modoAluno();
                    break;
                case 2:
                    ModoTurma.modoTurma();
                    break;
                case 3:
                	ModoCriacao.menuCriacao();
                	break;
                case 0:
                    System.out.println("Encerrando");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }
        
        }
    }
}
