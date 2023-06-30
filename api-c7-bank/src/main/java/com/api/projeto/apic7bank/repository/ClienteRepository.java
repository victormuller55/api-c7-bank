package com.api.projeto.apic7bank.repository;

import com.api.projeto.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {}