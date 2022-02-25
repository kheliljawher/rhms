package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Equipe;
import io.saslab.spring.rhms.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;



    public Equipe saveEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public List<Equipe> saveequipes(List<Equipe> equipe){
        return equipeRepository.saveAll(equipe);
    }
    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }
    public Equipe getEquipeById(Integer id){
        return equipeRepository.findById(id).orElse(null);
    }
    public Equipe getEquipeByNom(String nom){
        return equipeRepository.findByNom(nom);
    }
    public String deleteEquipeById(int id){
        equipeRepository.deleteById(id);
        return "Equipe removed !"+id;
    }
    public Equipe updateEquipe(Equipe equipe){
        Equipe existingEquipe=equipeRepository.findById(equipe.getId()).orElse(null);
        existingEquipe.setNom(equipe.getNom());
        return equipeRepository.save(existingEquipe);
    }
}
