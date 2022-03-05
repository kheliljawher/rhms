package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {
}
