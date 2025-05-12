package pacotes.vizualizacao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import pacotes.controle.CriadorPrincipal;
import pacotes.modelo.Aluno;
import pacotes.modelo.Disciplina;
import pacotes.modelo.Professor;
import pacotes.modelo.Turma;

public class MenuAll extends AlunoMenu{
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        MenuAll menu = new MenuAll();
        menu.displayLogin(); // Chama o login quando o sistema rodar
    }

    public void displayLogin() {
        System.out.println("Olá, seja bem-vindo.");
        System.out.println("Digite o tipo de usuário (Admin, Aluno, Prof): ");
        String tipo = input.nextLine();

        System.out.println("Insira o nome de usuário: ");
        String nome = input.nextLine();

        System.out.println("Insira sua senha: ");
        String senha = input.nextLine();

        switch (tipo.toLowerCase()) {
            case "admin" -> {
                boolean autenticado = verificarCredenciais(nome, senha, "admin.csv");
                if (autenticado) {
                    System.out.println("Login realizado com sucesso!");
                    displayCriationOptions();
                } else {
                    System.out.println("Nome ou senha incorretos.");
                }
            }
            case "aluno" -> {
                Aluno aluno = verificarAluno(nome, senha);
                if (aluno != null) {
                    System.out.println("Login realizado com sucesso!");
                    // Chama o menu do aluno após a autenticação
                    AlunoMenu alunoMenu = new AlunoMenu();
                    alunoMenu.exibirMenuAluno(aluno);
                } else {
                    System.out.println("Nome ou senha incorretos.");
                }
            }
            case "prof" -> {
                boolean autenticado = verificarCredenciais(nome, senha, "professor.csv");
                if (autenticado) {
                    System.out.println("Login realizado com sucesso!");
                    // Aqui você pode adicionar menu do professor futuramente
                } else {
                    System.out.println("Nome ou senha incorretos.");
                }
            }
            default -> System.out.println("Tipo de usuário inválido.");
        }
    }

    private boolean verificarCredenciais(String nome, String senha, String arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length >= 3) {
                    String nomeArquivo = campos[1];
                    String senhaArquivo = campos[2];
                    if (nome.equals(nomeArquivo) && senha.equals(senhaArquivo)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }

    private Aluno verificarAluno(String nome, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader("aluno.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length >= 6) {
                    String nomeArquivo = campos[1];
                    String senhaArquivo = campos[2];
                    if (nome.equals(nomeArquivo) && senha.equals(senhaArquivo)) {
                        return new Aluno(campos[0], campos[1], campos[3], campos[4], Boolean.parseBoolean(campos[5]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    public void displayCriationOptions() {
        CriadorPrincipal criador = new CriadorPrincipal();

        System.out.println("1- Criar aluno ");
        System.out.println("2- Criar prof ");
        System.out.println("3- Criar disciplina ");
        System.out.println("4- Criar turma");

        int resposta = input.nextInt();
        input.nextLine(); // limpa o \n do buffer

        if (resposta == 1) {
            Aluno aluno = criador.criarAluno();
            criador.salvarAlunoEmArquivo(aluno);
        } else if (resposta == 2) {
            Professor professor = criador.criarProfessor();
            criador.salvarProfessorEmArquivo(professor);
        } else if (resposta == 3) {
            Disciplina disciplina = criador.criarDisciplina();
            criador.salvarDisciplinaEmArquivo(disciplina);
        } else if (resposta == 4) {
            Turma turma = criador.criarTurma();
            criador.salvarTurmaEmArquivo(turma);
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
