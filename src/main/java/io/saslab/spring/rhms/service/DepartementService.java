package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Departement;
import io.saslab.spring.rhms.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);


    }

    public List<Departement> addDepartements(List<Departement> departement) {
        return departementRepository.saveAll(departement);
    }

    public List<Departement> getDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    public Departement getDepartementByNom(String nom) {
        return departementRepository.findByNom(nom);
    }

    public void deleteDepartementById(long id) {

        Departement dep =
                departementRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departement not found"));
        departementRepository.delete(dep);
    }

    public ResponseEntity<Object> updateDepartement(long id, Departement departement) {

        departementRepository
                .findById(id)
                .ifPresentOrElse(dep -> {
                    dep.setNom(departement.getNom());
                    departementRepository.save(dep);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departement not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Departement");

    }


}
