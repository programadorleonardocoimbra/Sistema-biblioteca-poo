package com.biblioteca;

import com.biblioteca.exception.LivroIndisponivelException;
import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.BibliotecaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BibliotecaService biblioteca = new BibliotecaService();


        Livro livro1 = new Livro(
                1L,
                "Clean Code",
                "Robert C. Martin",
                "9780132350884"
        );

        Livro livro2 = new Livro(
                2L,
                "Effective Java",
                "Joshua Bloch",
                "9780134685991"
        );

        Usuario usuario1 = new Usuario(
                1L,
                "Leonardo Coimbra",
                "leonardo@email.com.br",
                "(21)99999-9999"
        );

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        biblioteca.cadastrarUsuario(usuario1);

        int opcao;

        do {

            System.out.println();
            System.out.println("============================");
            System.out.println("    SISTEMA DE BIBLIOTECA");
            System.out.println("============================");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Listar empréstimos");
            System.out.println("5 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.println("============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1 -> biblioteca.listarLivros();

                case 2 -> biblioteca.listarUsuarios();

                case 3 -> {

                    try {

                        long idEmprestimo =
                                biblioteca.getEmprestimos().size() + 1L;

                        biblioteca.realizarEmprestimo(
                                idEmprestimo,
                                livro1,
                                usuario1
                        );

                    } catch (LivroIndisponivelException e) {

                        System.out.println(
                                "Atenção: " + e.getMessage()
                        );
                    }
                }

                case 4 -> biblioteca.listarEmprestimos();

                case 5 -> {

                    if (biblioteca.getEmprestimos().isEmpty()) {

                        System.out.println(
                                "NENHUM empréstimo encontrado."
                        );

                    } else {

                        Emprestimo emprestimo =
                                biblioteca
                                        .getEmprestimos()
                                        .get(0);

                        biblioteca.devolverLivro(emprestimo);
                    }
                }

                case 0 ->
                        System.out.println(
                                "Sistema encerrado."
                        );

                default ->
                        System.out.println(
                                "Opção inválida."
                        );
            }

        } while (opcao != 0);

        scanner.close();
    }
}