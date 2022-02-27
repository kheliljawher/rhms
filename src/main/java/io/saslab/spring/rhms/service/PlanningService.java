package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Planning;
import io.saslab.spring.rhms.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;



    public Planning savePlanning(Planning planning){
        return planningRepository.save(planning);
    }
    public List<Planning> savePlannings(List<Planning> planning){
        return planningRepository.saveAll(planning);
    }
    public List<Planning> getPlannings(){
        return planningRepository.findAll();
    }
    public Planning getPlanningById(Integer id){
        return planningRepository.findById(id).orElse(null);
    }
    public Planning getPlanningByNom(String nom){
        return planningRepository.findByNom(nom);
    }
    public String deletePlanningById(int id){
        planningRepository.deleteById(id);
        return "planning removed !"+id;
    }
    public Planning updatePlanning(Planning planning){
        Planning existingPlanning=planningRepository.findById(planning.getId()).orElse(null);
        existingPlanning.setNom(planning.getNom());
        return planningRepository.save(existingPlanning);
    }

}
