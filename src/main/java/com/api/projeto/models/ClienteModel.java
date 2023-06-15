package com.api.projeto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer idCliente;

    @JsonProperty("nome_cliente")
    private String nomeCliente;

    @JsonProperty("cpf_cliente")
    private String cpfCliente;

    @JsonProperty("senha_cliente")
    private String senhaCliente;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "clienteConta")
    private ContaModel contaCliente;

    public ClienteModel() {}

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public ContaModel getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(ContaModel contaCliente) {
        this.contaCliente = contaCliente;
    }
}
