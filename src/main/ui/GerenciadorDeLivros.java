package main.ui;

import main.logic.Biblioteca;
import java.util.Scanner;

public class GerenciadorDeLivros {
    private Biblioteca biblioteca;
    private Scanner scanner;
    private boolean rodando;

    public GerenciadorDeLivros() {
        biblioteca = new Biblioteca();
        scanner = new Scanner(System.in);
        rodando = true;
    }

    public void iniciar() {
        while (rodando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    adicionarLivro(scanner, biblioteca);
                    break;
                case 2:
                    registrarUsuario(scanner, biblioteca);
                    break;
                case 3:
                    emprestarLivro(scanner, biblioteca);
                    break;
                case 4:
                    devolverLivro(scanner, biblioteca);
                    break;
                case 5:
                    biblioteca.listarLivros();
                    break;
                case 6:
                    biblioteca.listarUsuarios();
                    break;
                case 7:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Registrar usuário");
        System.out.println("3. Emprestar livro");
        System.out.println("4. Devolver livro");
        System.out.println("5. Listar livros");
        System.out.println("6. Listar usuários");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void adicionarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();
        biblioteca.adicionarLivro(titulo, autor);
    }

    private void registrarUsuario(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        biblioteca.registrarUsuario(nomeUsuario);
    }

    private void emprestarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Título do livro: ");
        String tituloEmprestimo = scanner.nextLine();
        System.out.print("Nome do usuário: ");
        String usuarioEmprestimo = scanner.nextLine();
        biblioteca.emprestarLivro(tituloEmprestimo, usuarioEmprestimo);
    }

    private void devolverLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Título do livro: ");
        String tituloDevolucao = scanner.nextLine();
        System.out.print("Nome do usuário: ");
        String usuarioDevolucao = scanner.nextLine();
        biblioteca.devolverLivro(tituloDevolucao, usuarioDevolucao);
    }

}
