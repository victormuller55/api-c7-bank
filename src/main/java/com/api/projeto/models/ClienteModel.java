package com.api.projeto.models;

import com.api.projeto.models.ContaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nomeCliente;
    private Long cpfCliente;
    private String senhaCliente;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "clienteConta")
    private ContaModel contaCliente;

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

    public Long getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Long cpfCliente) {
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
