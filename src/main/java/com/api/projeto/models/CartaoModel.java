package com.api.projeto.models;

import com.api.projeto.models.ContaModel;
import jakarta.persistence.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

@Entity
@Table(name = "tbl_cartao")
public class CartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer idCartao;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    ContaModel contaCartao;
    Long numeroCartao;
    Integer cvvCartao;
    Date validadeCartao;
    boolean creditoCartao;
    double limiteCartao;

    public CartaoModel() {

        Random random = new Random();

        int ano = random.nextInt(20) + 2023;
        int mes = random.nextInt(12) + 1;
        Date calendar = new Date(ano, mes, 1);

        this.numeroCartao = random.nextLong(999999999);
        this.cvvCartao = random.nextInt(999);
        this.validadeCartao = calendar;
        this.creditoCartao = false;
        this.limiteCartao = 0;

    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public ContaModel getContaCartao() {
        return contaCartao;
    }

    public void setContaCartao(ContaModel contaCartao) {
        this.contaCartao = contaCartao;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getCvvCartao() {
        return cvvCartao;
    }

    public void setCvvCartao(Integer cvvCartao) {
        this.cvvCartao = cvvCartao;
    }

    public Date getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(Date validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public boolean isCreditoCartao() {
        return creditoCartao;
    }

    public void setCreditoCartao(boolean creditoCartao) {
        this.creditoCartao = creditoCartao;
    }

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }
}
