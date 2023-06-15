package com.api.projeto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Random;

@Entity
@Table(name = "tbl_conta")
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    Integer idConta;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    ClienteModel clienteConta;

    @JsonProperty("saldo_conta")
    double saldoConta;
    @JsonProperty("agencia_conta")
    String agenciaConta;

    @JsonProperty("numero_conta")
    String numeroConta;

    @JsonProperty("ativo")
    boolean ativo;

    public ContaModel() {}
    public ContaModel(ClienteModel clienteConta) {

        Random random = new Random();

        this.clienteConta = clienteConta;
        this.saldoConta = 0;
        this.agenciaConta = String.valueOf(random.nextInt(99999));
        this.numeroConta = String.valueOf(random.nextInt(99999));
        this.ativo = false;

    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public ClienteModel getClienteConta() {
        return clienteConta;
    }

    public void setClienteConta(ClienteModel clienteConta) {
        this.clienteConta = clienteConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoCliente) {
        this.saldoConta = saldoCliente;
    }

    public String getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(String agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}