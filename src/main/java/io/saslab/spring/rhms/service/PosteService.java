package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Poste;
import io.saslab.spring.rhms.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService {

    @Autowired
    private PosteRepository posteRepository;

    public Poste savePoste(Poste poste){
        return posteRepository.save(poste);
    }
    public List<Poste> savePostes(List<Poste> poste){
        return posteRepository.saveAll(poste);
    }
    public List<Poste> getPostes(){
        return posteRepository.findAll();
    }
    public Poste getPosteById(Integer id){
        return posteRepository.findById(id).orElse(null);
    }
    public Poste getPosteByNom(String nom){
        return posteRepository.findByNom(nom);
    }
    public String deletePosteById(int id){
        posteRepository.deleteById(id);
        return "poste removed !"+id;
    }
    public Poste updatePoste(Poste poste){
        Poste existingPoste=posteRepository.findById(poste.getId()).orElse(null);
        existingPoste.setNom(poste.getNom());
        return posteRepository.save(existingPoste);
    }


}
