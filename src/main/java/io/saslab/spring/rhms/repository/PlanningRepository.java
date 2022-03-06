package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {
     Planning findByNom(String nom);
}
