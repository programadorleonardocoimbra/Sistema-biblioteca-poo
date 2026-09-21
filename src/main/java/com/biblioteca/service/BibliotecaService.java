package com.biblioteca.service;

import com.biblioteca.enums.StatusLivro;
import com.biblioteca.exception.LivroIndisponivelException;
import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private final List<Livro> livros = new ArrayList<>();

    private final List<Usuario> usuarios = new ArrayList<>();

    private final List<Emprestimo> emprestimos = new ArrayList<>();


    public void cadastrarLivro(Livro livro) {

        livros.add(livro);

        System.out.println(
                "Livro cadastrado com sucesso!"
        );
    }


    public void cadastrarUsuario(Usuario usuario) {

        usuarios.add(usuario);

        System.out.println(
                "Usuário cadastrado com sucesso!"
        );
    }


    public void listarLivros() {

        if (livros.isEmpty()) {

            System.out.println(
                    "Nenhum livro cadastrado."
            );

            return;
        }

        System.out.println();
        System.out.println("===== LIVROS =====");

        livros.forEach(
                Livro::exibirInformacoes
        );
    }


    public void listarUsuarios() {

        if (usuarios.isEmpty()) {

            System.out.println(
                    "Nenhum usuário cadastrado."
            );

            return;
        }

        System.out.println();
        System.out.println("===== USUÁRIOS =====");

        usuarios.forEach(
                Usuario::exibirInformacoes
        );
    }


    public void realizarEmprestimo(
            long idEmprestimo,
            Livro livro,
            Usuario usuario) {

        if (livro.getStatus() == StatusLivro.EMPRESTADO) {

            throw new LivroIndisponivelException(
                    "O livro '" +
                            livro.getTitulo() +
                            "' não está disponível."
            );
        }

        livro.emprestar();

        Emprestimo emprestimo =
                new Emprestimo(
                        idEmprestimo,
                        livro,
                        usuario
                );

        emprestimos.add(emprestimo);

        System.out.println();
        System.out.println(
                "Livro emprestado com sucesso!"
        );
    }


    public void listarEmprestimos() {

        if (emprestimos.isEmpty()) {

            System.out.println(
                    "Nenhum empréstimo encontrado."
            );

            return;
        }

        System.out.println();
        System.out.println("===== EMPRÉSTIMOS =====");

        emprestimos.forEach(
                Emprestimo::exibirInformacoes
        );
    }


    public void devolverLivro(
            Emprestimo emprestimo) {

        if (!emprestimo.estaAtivo()) {

            System.out.println(
                    "Este empréstimo já foi finalizado."
            );

            return;
        }

        emprestimo.finalizarEmprestimo();

        emprestimo
                .getLivro()
                .devolver();

        System.out.println();
        System.out.println(
                "Livro devolvido com sucesso!"
        );
    }


    public List<Emprestimo> getEmprestimos() {

        return emprestimos;
    }
}