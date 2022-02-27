package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    Departement findByNomDep(String nom_dep);
}
