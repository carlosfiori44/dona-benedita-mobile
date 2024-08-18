package com.example.donabenedita.classes;

import java.io.Serializable;

public class Produto implements Serializable {
    //Declarando as variáveis
    private int quantidade;
    private float preco;
    private String fornecedor, descricao;

    public Produto(int quantidade, float preco, String fornecedor, String descricao) { //Construtor
        this.quantidade = quantidade;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
    }

    //Getters
    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }
}
