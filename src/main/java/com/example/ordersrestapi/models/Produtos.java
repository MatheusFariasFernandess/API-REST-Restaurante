package com.example.ordersrestapi.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "produto_tb")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "produto_nome",length = 45)
    private String nome;

    @Column(name = "produto_descricao",length = 45)
    private String descricao;

    @NotNull
    @Column(name = "produto_preco")
    private Double preco;

    @NotNull
    @Column(name = "produto_ativo")
    private Boolean ativo = true;

    public Produtos() {
    }

    public Produtos(long id, String nome, String descricao, Double preco, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
