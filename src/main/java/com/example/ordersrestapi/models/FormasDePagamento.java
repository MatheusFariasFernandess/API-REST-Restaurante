package com.example.ordersrestapi.models;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormasDePagamento that = (FormasDePagamento) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
