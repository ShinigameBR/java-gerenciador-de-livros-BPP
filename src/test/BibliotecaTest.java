package test;

import main.logic.Biblioteca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca();
        System.setOut(new PrintStream(outputStream)); // Redirecionar saída padrão
        outputStream.reset(); // Limpar a saída capturada
    }

    @Test
    public void testAdicionarLivro() {
        biblioteca.adicionarLivro("Livro Teste", "Autor Teste");
        
        String output = outputStream.toString().trim();
        assertEquals("Livro adicionado: Livro Teste", output);
    }

    @Test
    public void testRegistrarUsuario() {
        biblioteca.registrarUsuario("Usuario Teste");
        
        String output = outputStream.toString().trim();
        assertEquals("Usuário registrado: Usuario Teste", output);
    }

    @Test
    public void testEmprestarLivro() {
        biblioteca.adicionarLivro("Livro Teste", "Autor Teste");
        biblioteca.registrarUsuario("Usuario Teste");

        outputStream.reset(); // Limpar a saída capturada
        biblioteca.emprestarLivro("Livro Teste", "Usuario Teste");

        String output = outputStream.toString().trim();
        assertEquals("Livro emprestado: Livro Teste para Usuario Teste", output);
    }

    @Test
    public void testEmprestarLivroIndisponivel() {
        biblioteca.adicionarLivro("Livro Teste", "Autor Teste");
        biblioteca.registrarUsuario("Usuario Teste");
        biblioteca.emprestarLivro("Livro Teste", "Usuario Teste"); // Empresta primeiro

        // Tentar emprestar novamente
        outputStream.reset(); // Limpar a saída capturada
        biblioteca.emprestarLivro("Livro Teste", "Usuario Teste");
        
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Livro não disponível: Livro Teste"));
    }

    @Test
    public void testDevolverLivro() {
        biblioteca.adicionarLivro("Livro Teste", "Autor Teste");
        biblioteca.registrarUsuario("Usuario Teste");
        biblioteca.emprestarLivro("Livro Teste", "Usuario Teste");

        outputStream.reset(); // Limpar a saída capturada
        biblioteca.devolverLivro("Livro Teste", "Usuario Teste");
        
        String output = outputStream.toString().trim();
        assertEquals("Livro devolvido: Livro Teste de Usuario Teste", output);
    }

    @Test
    public void testDevolverLivroInexistente() {
        biblioteca.adicionarLivro("Livro Teste", "Autor Teste");
        biblioteca.registrarUsuario("Usuario Teste");
        
        outputStream.reset(); // Limpar a saída capturada
        biblioteca.devolverLivro("Livro Teste", "Usuario Teste");
        
        String output = outputStream.toString().trim();
        assertEquals("O usuário não tem este livro emprestado ou livro não encontrado.", output);
    }

    @Test
    public void testListarLivros() {
        biblioteca.adicionarLivro("Livro Teste", "Autor Teste");
        biblioteca.adicionarLivro("Outro Livro", "Outro Autor");

        biblioteca.listarLivros();
        
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Livros disponíveis:"));
        assertTrue(output.contains("- Livro Teste"));
        assertTrue(output.contains("- Outro Livro"));
    }

    @Test
    public void testListarUsuarios() {
        biblioteca.registrarUsuario("Usuario Teste");
        biblioteca.registrarUsuario("Outro Usuario");

        biblioteca.listarUsuarios();
        
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Usuários registrados:"));
        assertTrue(output.contains("- Usuario Teste"));
        assertTrue(output.contains("- Outro Usuario"));
    }

}