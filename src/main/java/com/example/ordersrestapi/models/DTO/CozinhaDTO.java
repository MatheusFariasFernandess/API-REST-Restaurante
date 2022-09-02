package com.example.ordersrestapi.models.DTO;

import javax.persistence.ManyToOne;

public class CozinhaDTO {

    private Long id;

    private String nome;

    @ManyToOne
    private CozinhaDTO cozinhaDTO;

    public CozinhaDTO() {
    }

    public CozinhaDTO(Long id, String nome, CozinhaDTO cozinhaDTO) {
        this.id = id;
        this.nome = nome;
        this.cozinhaDTO = cozinhaDTO;
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

    public CozinhaDTO getCozinhaDTO() {
        return cozinhaDTO;
    }

    public void setCozinhaDTO(CozinhaDTO cozinhaDTO) {
        this.cozinhaDTO = cozinhaDTO;
    }
}
