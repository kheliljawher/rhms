package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Section;
import io.saslab.spring.rhms.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public Section addSection(Section section) {
        return sectionRepository.save(section);


    }

    public List<Section> addSections(List<Section> section) {
        return sectionRepository.saveAll(section);
    }

    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public Section getSectionByTitre(String titre) {
        return sectionRepository.findByTitre(titre);
    }

    public void deleteSectionById(long id) {

        Section sec =
                sectionRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found"));
        sectionRepository.delete(sec);
    }

    public ResponseEntity<Object> updateSection(long id, Section section) {

        sectionRepository
                .findById(id)
                .ifPresentOrElse(sec -> {
                    sec.setTitre(section.getTitre());
                    sectionRepository.save(sec);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Section");

    }


}
