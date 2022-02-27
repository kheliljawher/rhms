package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosteRepository extends JpaRepository<Poste, Integer> {
    Poste findByNom(String nom);
}
