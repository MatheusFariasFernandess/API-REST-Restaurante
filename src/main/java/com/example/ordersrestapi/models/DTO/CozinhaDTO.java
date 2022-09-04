package com.example.ordersrestapi.models.DTO;

import net.minidev.json.annotate.JsonSmartAnnotation;

import javax.persistence.ManyToOne;

public class CozinhaDTO {

    private Long id;

    private String nome;

    @ManyToOne
    private RestauranteDTO restauranteDTO;

    public CozinhaDTO() {
    }

    public CozinhaDTO(Long id, String nome, RestauranteDTO restauranteDTO) {
        this.id = id;
        this.nome = nome;
        this.restauranteDTO = restauranteDTO;
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

    public RestauranteDTO getRestauranteDTO() {
        return restauranteDTO;
    }

    public void setRestauranteDTO(RestauranteDTO restauranteDTO) {
        this.restauranteDTO = restauranteDTO;
    }
}
