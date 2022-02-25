package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv, Integer> {
    Cv findByCompetance(String competance);
}
