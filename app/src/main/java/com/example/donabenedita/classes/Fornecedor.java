package com.example.donabenedita.classes;

import java.io.Serializable;

public class Fornecedor implements Serializable {
    //Declarando as variáveis
    private String cnpj, nome;
    private int[] id_produtos_entegres;

    public Fornecedor(String cnpj, String nome) { //Criando o construtor
        this.cnpj = cnpj;
        this.nome = nome;
    }

    //Getters
    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public int[] getId_produtos_entegres() {
        return id_produtos_entegres;
    }

    public void setId_produtos_entegres(int[] id_produtos_entegres) {
        this.id_produtos_entegres = id_produtos_entegres;
    }
}

