package com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {

    private Long id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Long id, Livro livro, Usuario usuario) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();

    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void finalizarEmprestimo() {
        this.dataEmprestimo = LocalDate.now();

    }

    public boolean estaAtivo() {
        return dataDevolucao == null;

    }

    public void exibirInformacoes() {

        System.out.println("--------------------");
        System.out.println("Empréstimo: " + id);
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Data de Empréstimo: " + dataEmprestimo);

        if (dataDevolucao == null) {
            System.out.println("Situação ATIVO");
        } else {
            System.out.println("Devolvido em: " + dataDevolucao);
        }

    }

}
