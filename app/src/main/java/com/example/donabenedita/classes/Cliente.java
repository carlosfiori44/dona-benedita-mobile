package com.example.donabenedita.classes;

import java.io.Serializable;

public class Cliente  implements Serializable {
    //Declarando as variáveis
    private String email, senha, nome, cep, cidade, logradouro, bairro;

    public Cliente(String email, String senha, String nome, String cep, String cidade, String logradouro, String bairro) { //Criando o construtor
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cep = cep;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    //Getters
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }
}
