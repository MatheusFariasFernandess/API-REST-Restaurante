package com.example.ordersrestapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "restaurante_tb")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


//    @NotBlank
    @Column(name = "restaurante_nome")
    private String nome;

//    @NotBlank
    @Column(name= "restaurante_taxa_frete")
    private BigDecimal taxaFrete;

//    @NotNull
    private Boolean ativo;

//    @NotNull
    private Boolean aberto;

    @CreationTimestamp
    @Column(name = "restaurante_data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "restaurante")
    private List<Produtos>produtos=new ArrayList<>();

    @UpdateTimestamp
    @Column(name = "restaurante_data_atualização")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    private Cozinha cozinha;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "restaurante_formas_de_pagamento_tb"
            ,joinColumns=@JoinColumn(name = "restaurante_id")
            ,inverseJoinColumns = @JoinColumn(name= "forma_de_pagamento_id"))
    public List<FormasDePagamento>formasDePagamentos = new ArrayList<>();

    public Restaurante() {
    }

    public Restaurante(Long id, String nome, BigDecimal taxaFrete, Boolean ativo, Boolean aberto, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao,Cozinha cozinha,Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.cozinha = cozinha;
        this.endereco=endereco;
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

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAberto() {
        return aberto;
    }

    public void setAberto(Boolean aberto) {
        this.aberto = aberto;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    public void setCozinha(Cozinha cozinha) {
        this.cozinha = cozinha;
    }

    public List<FormasDePagamento> getFormasDePagamentos() {
        return formasDePagamentos;
    }

    public void setFormasDePagamentos(List<FormasDePagamento> formasDePagamentos) {
        this.formasDePagamentos = formasDePagamentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(taxaFrete, that.taxaFrete) && Objects.equals(ativo, that.ativo) && Objects.equals(aberto, that.aberto) && Objects.equals(dataCadastro, that.dataCadastro) && Objects.equals(produtos, that.produtos) && Objects.equals(dataAtualizacao, that.dataAtualizacao) && Objects.equals(cozinha, that.cozinha) && Objects.equals(endereco, that.endereco) && Objects.equals(formasDePagamentos, that.formasDePagamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, taxaFrete, ativo, aberto, dataCadastro, produtos, dataAtualizacao, cozinha, endereco, formasDePagamentos);
    }
}
