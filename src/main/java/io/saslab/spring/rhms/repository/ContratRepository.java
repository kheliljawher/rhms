package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
    Contrat findByType(String type);
}
