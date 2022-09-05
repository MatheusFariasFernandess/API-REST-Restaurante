package com.example.ordersrestapi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grupo_tb")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomme;

    @ManyToMany
    @JoinTable(name = "grupo_permissoes",
    joinColumns = @JoinColumn(name = "grupo_id"),
    inverseJoinColumns = @JoinColumn(name = "permissoes_id"))
    private List<Permissao>permissaos = new ArrayList<>();

    public Grupo() {
    }

    public Grupo(Long id, String nomme, List<Permissao> permissaos) {
        this.id = id;
        this.nomme = nomme;
        this.permissaos = permissaos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomme() {
        return nomme;
    }

    public void setNomme(String nomme) {
        this.nomme = nomme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(id, grupo.id) && Objects.equals(nomme, grupo.nomme) && Objects.equals(permissaos, grupo.permissaos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomme, permissaos);
    }
}
