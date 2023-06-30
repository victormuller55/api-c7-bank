package com.api.projeto.apic7bank.repository;

import com.api.projeto.models.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaModel, Integer> {
    ContaModel findByNumeroConta(Integer numeroConta);
}
