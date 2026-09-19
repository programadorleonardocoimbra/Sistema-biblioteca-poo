package com.biblioteca.model;

import com.biblioteca.enums.StatusLivro;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private StatusLivro status;

    public Livro(Long id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.status = StatusLivro.DISPONIVEL;

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void emprestar() {
        status = StatusLivro.EMPRESTADO;

    }

    public void devolver() {
        status = StatusLivro.DISPONIVEL;

    }

    public void exibirInformacoes() {

        System.out.println("--------------------");
        System.out.println("Código: " + id);
        System.out.println("Livro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + status);

    }


}
