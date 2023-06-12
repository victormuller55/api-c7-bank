package com.api.projeto.repository;

import com.api.projeto.models.ContaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContaRepository extends JpaRepository<ContaModel, Integer> {
    ContaModel findByNumeroConta(Integer numeroConta);
}
