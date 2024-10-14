import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo;
    String autor;
    boolean disponivel;

    Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }
}

class Usuario {
    String nome;
    ArrayList<Livro> livrosEmprestados;

    Usuario(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }
}

public class Biblioteca {
    ArrayList<Livro> livros;
    ArrayList<Usuario> usuarios;

    Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    void adicionarLivro(String titulo, String autor) {
        livros.add(new Livro(titulo, autor));
        System.out.println("Livro adicionado: " + titulo);
    }

    void registrarUsuario(String nome) {
        usuarios.add(new Usuario(nome));
        System.out.println("Usuário registrado: " + nome);
    }

    void emprestarLivro(String titulo, String nomeUsuario) {
        Livro livro = encontrarLivro(titulo);
        Usuario usuario = encontrarUsuario(nomeUsuario);
        if (livro != null && usuario != null) {
            if (livro.disponivel) {
                livro.disponivel = false;
                usuario.livrosEmprestados.add(livro);
                System.out.println("Livro emprestado: " + titulo + " para " + nomeUsuario);
            } else {
                System.out.println("Livro não disponível: " + titulo);
            }
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    void devolverLivro(String titulo, String nomeUsuario) {
        Usuario usuario = encontrarUsuario(nomeUsuario);
        if (usuario != null) {
            for (Livro livro : usuario.livrosEmprestados) {
                if (livro.titulo.equals(titulo)) {
                    livro.disponivel = true;
                    usuario.livrosEmprestados.remove(livro);
                    System.out.println("Livro devolvido: " + titulo + " de " + nomeUsuario);
                    return;
                }
            }
            System.out.println("O usuário não tem este livro emprestado.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    Livro encontrarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.titulo.equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    Usuario encontrarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.nome.equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    void listarLivros() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            System.out.println("- " + livro.titulo + " (Autor: " + livro.autor + ") " + (livro.disponivel ? "(Disponível)" : "(Indisponível)"));
        }
    }

    void listarUsuarios() {
        System.out.println("Usuários registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario.nome + " (Livros emprestados: " + usuario.livrosEmprestados.size() + ")");
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Registrar usuário");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Listar livros");
            System.out.println("6. Listar usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.adicionarLivro(titulo, autor);
                    break;
                case 2:
                    System.out.print("Nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.registrarUsuario(nomeUsuario);
                    break;
                case 3:
                    System.out.print("Título do livro: ");
                    String tituloEmprestimo = scanner.nextLine();
                    System.out.print("Nome do usuário: ");
                    String usuarioEmprestimo = scanner.nextLine();
                    biblioteca.emprestarLivro(tituloEmprestimo, usuarioEmprestimo);
                    break;
                case 4:
                    System.out.print("Título do livro: ");
                    String tituloDevolucao = scanner.nextLine();
                    System.out.print("Nome do usuário: ");
                    String usuarioDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(tituloDevolucao, usuarioDevolucao);
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
}
