package com.example.ordersrestapi.models;

import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

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

    @UpdateTimestamp
    @Column(name = "restaurante_data_atualização")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "restaurante")
    private List<Cozinha>cozinhas;

    public Restaurante() {
    }

    public Restaurante(Long id, String nome, BigDecimal taxaFrete, Boolean ativo, Boolean aberto, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao) {
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

    public List<Cozinha> getCozinhas() {
        return cozinhas;
    }

    public void setCozinhas(List<Cozinha> cozinhas) {
        this.cozinhas = cozinhas;
    }

    public void setCozinhaIndividual(Cozinha cozinha){
        this.cozinhas.add(cozinha);
    }

    public static final class builder {
        private Long id;
        @NotEmpty
        private String nome;
        private BigDecimal taxaFrete;
        @NotNull
        private Boolean ativo;
        @NotNull
        private Boolean aberto;
        @CreationTimestamp
        private LocalDateTime dataCadastro;
        @UpdateTimestamp
        private LocalDateTime dataAtualizacao;

        private builder() {
        }

        public static builder aRestaurante() {
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

        public builder taxaFrete(BigDecimal taxaFrete) {
            this.taxaFrete = taxaFrete;
            return this;
        }

        public builder ativo(Boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public builder aberto(Boolean aberto) {
            this.aberto = aberto;
            return this;
        }

        public builder dataCadastro(LocalDateTime dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }

        public builder dataAtualizacao(LocalDateTime dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
            return this;
        }

        public Restaurante build() {
            Restaurante restaurante = new Restaurante();
            restaurante.setId(id);
            restaurante.setNome(nome);
            restaurante.setTaxaFrete(taxaFrete);
            restaurante.setAtivo(ativo);
            restaurante.setAberto(aberto);
            restaurante.setDataCadastro(dataCadastro);
            restaurante.setDataAtualizacao(dataAtualizacao);
            return restaurante;
        }
    }
}
