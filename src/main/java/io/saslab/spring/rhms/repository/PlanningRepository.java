package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<Planning, Integer> {
     Planning findByNomPlan(String nom_plan);
}
