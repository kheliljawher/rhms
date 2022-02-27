package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat findByType(String type);
}
