package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Contrat;
import io.saslab.spring.rhms.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;



    public Contrat saveContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }
    public List<Contrat> saveContrats(List<Contrat> contrat){
        return contratRepository.saveAll(contrat);
    }
    public List<Contrat> getContrats(){
        return contratRepository.findAll();
    }
    public Contrat getContratById(Integer id){
        return contratRepository.findById(id).orElse(null);
    }
    public Contrat getContratByType(String type){
        return contratRepository.findByType(type);
    }
    public String deleteContratById(int id){
        contratRepository.deleteById(id);
        return "Contrat removed !"+id;
    }
    public Contrat updateContrat(Contrat contrat){
        Contrat existingContrat=contratRepository.findById(contrat.getId()).orElse(null);
        existingContrat.setType(contrat.getType());
        return contratRepository.save(existingContrat);
    }

}
