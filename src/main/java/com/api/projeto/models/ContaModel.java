package com.api.projeto.models;

import jakarta.persistence.*;
import java.util.Random;

@Entity
@Table(name = "tbl_conta")
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idConta;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    ClienteModel clienteConta;
    double saldoConta;
    int agenciaConta;
    int numeroConta;
    boolean ativo;

    public ContaModel(ClienteModel clienteConta) {

        Random random = new Random();

        this.clienteConta = clienteConta;
        this.saldoConta = 0;
        this.agenciaConta = random.nextInt(99999);
        this.numeroConta = random.nextInt(99999);
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

    public int getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(int agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}