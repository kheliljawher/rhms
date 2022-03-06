package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {

    Departement findByNom(String nom);
}
