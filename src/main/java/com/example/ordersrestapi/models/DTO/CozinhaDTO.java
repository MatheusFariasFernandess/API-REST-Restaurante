package com.example.ordersrestapi.models.DTO;

import com.example.ordersrestapi.models.Restaurante;
import net.minidev.json.annotate.JsonSmartAnnotation;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class CozinhaDTO {

    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cozinha")
    private List<Restaurante>restaurantes=new ArrayList<>();

    public CozinhaDTO() {
    }

    public CozinhaDTO(String nome, List<Restaurante> restaurantes) {
        this.nome = nome;
        this.restaurantes = restaurantes;
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
//
//    public List<Restaurante> getRestaurantes() {
//        return restaurantes;
//    }
//
//    public void setRestaurantes(List<Restaurante> restaurantes) {
//        this.restaurantes = restaurantes;
//    }
}
