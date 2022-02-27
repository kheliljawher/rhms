package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Departement;
import io.saslab.spring.rhms.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;



    public Departement saveDepartement(Departement departement){
        return departementRepository.save(departement);
    }
    public List<Departement> saveDepartements(List<Departement> departement){
        return departementRepository.saveAll(departement);
    }
    public List<Departement> getDepartements(){
        return departementRepository.findAll();
    }
    public Departement getDepartementById(Integer id){
        return departementRepository.findById(id).orElse(null);
    }
    public Departement getDepartementByNom(String nom_dep){
        return departementRepository.findByNomDep(nom_dep);
    }
    public String deleteDepartementById(int id){
        departementRepository.deleteById(id);
        return "Departement removed !"+id;
    }
    public Departement updateDepartement(Departement departement){
        Departement existingDepartement=departementRepository.findById(departement.getId()).orElse(null);
        existingDepartement.setNom_dep(departement.getNom_dep());
        return departementRepository.save(existingDepartement);
    }

}
