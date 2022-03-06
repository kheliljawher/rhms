package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {
    Poste findByNom(String nom);
}
