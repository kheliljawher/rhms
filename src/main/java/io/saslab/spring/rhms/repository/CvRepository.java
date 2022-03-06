package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
    Cv findByCompetance(String competance);
}
