package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Equipe findByNom(String nom);
}
