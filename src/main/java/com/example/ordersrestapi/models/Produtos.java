package com.example.ordersrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

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

    @ManyToOne
    @JsonIgnore
    private Restaurante restaurante;

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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return id == produtos.id && Objects.equals(nome, produtos.nome) && Objects.equals(descricao, produtos.descricao) && Objects.equals(preco, produtos.preco) && Objects.equals(ativo, produtos.ativo) && Objects.equals(restaurante, produtos.restaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, ativo, restaurante);
    }
}
