package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Conge;
import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.CongeRepository;
import io.saslab.spring.rhms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeService {


    @Autowired
    private CongeRepository congeRepository;



    public Conge saveConge(Conge conge){
        return congeRepository.save(conge);
    }
    public List<Conge> saveConges(List<Conge> conges){
        return congeRepository.saveAll(conges);
    }
    public List<Conge> getConges(){
        return congeRepository.findAll();
    }
    public Conge getCongeById(Integer id){
        return congeRepository.findById(id).orElse(null);
    }
    public String deleteCongeById(int id){
        congeRepository.deleteById(id);
        return "Conge removed !"+id;
    }
    public Conge updateConge(Conge conge){
        Conge existingConge=congeRepository.findById(conge.getId()).orElse(null);
        existingConge.setDate_debut(conge.getDate_debut());
        existingConge.setDate_fin(conge.getDate_fin());
        return congeRepository.save(existingConge);
    }


}
