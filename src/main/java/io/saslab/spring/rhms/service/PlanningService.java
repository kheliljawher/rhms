package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Planning;
import io.saslab.spring.rhms.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;

    public Planning addPlanning(Planning planning) {
        return planningRepository.save(planning);


    }

    public List<Planning> addPlannings(List<Planning> planning) {
        return planningRepository.saveAll(planning);
    }

    public List<Planning> getPlannings() {
        return planningRepository.findAll();
    }

    public Planning getPlanningById(Long id) {
        return planningRepository.findById(id).orElse(null);
    }

    public Planning getPlanningByNom(String nom) {
        return planningRepository.findByNom(nom);
    }

    public void deletePlanningById(long id) {

        Planning pln =
                planningRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Planning not found"));
        planningRepository.delete(pln);
    }

    public ResponseEntity<Object> updatePlanning(long id, Planning planning) {

        planningRepository
                .findById(id)
                .ifPresentOrElse(pln -> {
                    pln.setNom(planning.getNom());
                    pln.setPlan_Jour(planning.getPlan_Jour());
                    planningRepository.save(pln);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Employee");

    }


}
