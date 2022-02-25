package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
    Section findByTitre(String titre);
}
