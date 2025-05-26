package pacotes.modos;

import java.util.Scanner;

import pacotes.controle.DisciplinaControle;
import pacotes.controle.TurmaControle;
import pacotes.modelo.Disciplina;
import pacotes.modelo.Turma;

public class ModoTurma {
	
	private static void exibirOpcoes() {
		System.out.println("Modo Turma");
		
		System.out.println("1- Cadastrar Disciplinas");
		System.out.println("2- Criar Turmas");
		System.out.println("3- Listar Turmas");
		System.out.println("4- Listar alunos em uma turma");
		System.out.println("0- Voltar");
	}

	public static void modoTurma() {
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			int resposta;
			
			exibirOpcoes();
			
			resposta = input.nextInt();
			
			switch(resposta) {
				case 1:
					Disciplina disciplina = DisciplinaControle.criarDisciplina();
					DisciplinaControle.salvarEmArquivo(disciplina);
					break;
				case 2:
					Turma turma = TurmaControle.criarTurma();
					TurmaControle.salvarTurmaEmArquivo(turma);
					break;
				case 3:
					TurmaControle.listarTurmas();
					break;
				case 4:
					TurmaControle.listarAlunos();
					break;
				case 0: 
					return;
				default:
		
			}
		}
		
	}
}
