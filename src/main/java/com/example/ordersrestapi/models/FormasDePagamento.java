package com.example.ordersrestapi.models;

import javax.persistence.*;

@Entity
@Table(name = "forma_de_pagamentos_tb")
public class FormasDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public FormasDePagamento() {
    }

    public FormasDePagamento(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
