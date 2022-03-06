package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    Section findByTitre(String titre);
}
