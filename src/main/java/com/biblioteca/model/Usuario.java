package com.biblioteca.model;

public class Usuario extends Pessoa {

    private String telefone;

    public Usuario(Long id, String nome, String email, String telefone) {

        super(id, nome, email);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;

    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;

    }
    @Override
    public void exibirInformacoes() {

        System.out.println("------------------------");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());


    }


}
