package main.logic;

import main.entities.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor) {
        livros.add(new Livro(titulo, autor));
        System.out.println("Livro adicionado: " + titulo);
    }

    public void registrarUsuario(String nome) {
        usuarios.add(new Usuario(nome));
        System.out.println("Usuário registrado: " + nome);
    }

    public void emprestarLivro(String titulo, String nomeUsuario) {
        Livro livro = encontrarLivro(titulo);
        Usuario usuario = encontrarUsuario(nomeUsuario);
        if (livro != null && usuario != null) {
            if (livro.isDisponivel()) {
                livro.setDisponivel(false);
                usuario.emprestarLivro(livro);
                System.out.println("Livro emprestado: " + titulo + " para " + nomeUsuario);
            } else {
                System.out.println("Livro não disponível: " + titulo);
            }
        } else {
            System.out.println("Livro ou usuário não encontrado.");
        }
    }

    public void devolverLivro(String titulo, String nomeUsuario) {
        Usuario usuario = encontrarUsuario(nomeUsuario);
        if (usuario != null) {
            Livro livro = encontrarLivro(titulo);
            if (livro != null && usuario.getLivrosEmprestados().contains(livro)) {
                livro.setDisponivel(true);
                usuario.devolverLivro(livro);
                System.out.println("Livro devolvido: " + titulo + " de " + nomeUsuario);
            } else {
                System.out.println("O usuário não tem este livro emprestado ou livro não encontrado.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private Livro encontrarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    private Usuario encontrarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public void listarLivros() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            System.out.println("- " + livro);
        }
    }

    public void listarUsuarios() {
        System.out.println("Usuários registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario);
        }
    }
}