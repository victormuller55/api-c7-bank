package com.api.projeto.repository;

import com.api.projeto.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    ClienteModel findByCpfCliente(String cpfCliente);
}