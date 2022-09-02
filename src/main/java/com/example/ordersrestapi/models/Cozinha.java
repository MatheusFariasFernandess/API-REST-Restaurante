package com.example.ordersrestapi.models;

import javax.persistence.*;

@Entity
@Table(name = "cozinha_tb")
public class Cozinha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cozinha_nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    public Cozinha() {
    }

    public Cozinha(Long id, String nome, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }



    public static final class builder {
        private Long id;
        private String nome;
        private Restaurante restaurante;

        private builder() {
        }

        public static builder aCozinha() {
            return new builder();
        }

        public builder id(Long id) {
            this.id = id;
            return this;
        }

        public builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public builder restaurante(Restaurante restaurante) {
            this.restaurante = restaurante;
            return this;
        }

        public Cozinha build() {
            Cozinha cozinha = new Cozinha();
            cozinha.setId(id);
            cozinha.setNome(nome);
            cozinha.setRestaurante(restaurante);
            return cozinha;
        }
    }
}
