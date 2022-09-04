package com.example.ordersrestapi.models.DTO;

import com.example.ordersrestapi.models.Cozinha;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RestauranteDTO {
    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private Boolean ativo;
    private Boolean aberto;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "restauranteDTO")
    private List<CozinhaDTO> cozinhasDTO;

    public RestauranteDTO() {
    }

    public RestauranteDTO(Long id, String nome, BigDecimal taxaFrete, Boolean ativo, Boolean aberto, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
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

//    public List<CozinhaDTO> getCozinhas() {
//        return cozinhasDTO;
//    }
//
//    public void setCozinhas(List<CozinhaDTO> cozinhasDTO) {
//        this.cozinhasDTO = cozinhasDTO;
//    }


}
