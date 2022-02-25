package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Section;
import io.saslab.spring.rhms.repository.SectionRepository;
import io.saslab.spring.rhms.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;



    public Section saveSection(Section section){
        return sectionRepository.save(section);
    }
    public List<Section> saveSections(List<Section> section){
        return sectionRepository.saveAll(section);
    }
    public List<Section> getSections(){
        return sectionRepository.findAll();
    }
    public Section getSectionById(Integer id){
        return sectionRepository.findById(id).orElse(null);
    }
    public Section getSectionByTitre(String titre){
        return sectionRepository.findByTitre(titre);
    }
    public String deleteSectionById(int id){
        sectionRepository.deleteById(id);
        return "Section removed !"+id;
    }
    public Section updateSection(Section section){
        Section existingSection=sectionRepository.findById(section.getId()).orElse(null);
        existingSection.setTitre(section.getTitre());
        return sectionRepository.save(existingSection);
    }

}
