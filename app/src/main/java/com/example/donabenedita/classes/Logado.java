package com.example.donabenedita.classes;

import java.io.Serializable;

public class Logado implements Serializable {
    //Variáveis
    private String identificacao, nome;

    //Construtor
    public Logado(String identificacao, String nome) {
        this.identificacao = identificacao;
        this.nome = nome;
    }

    //Getters e Setters

    public String getIdentificacao() {
        return identificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

