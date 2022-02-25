package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    Equipe findByNom(String nom);
}
