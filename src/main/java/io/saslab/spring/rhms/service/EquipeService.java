package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Equipe;
import io.saslab.spring.rhms.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);


    }

    public List<Equipe> addEquipes(List<Equipe> equipe) {
        return equipeRepository.saveAll(equipe);
    }

    public List<Equipe> getEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    public Equipe getEquipeByNom(String nom) {
        return equipeRepository.findByNom(nom);
    }

    public void deleteEquipeById(long id) {

        Equipe eq =
                equipeRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipe not found"));
        equipeRepository.delete(eq);
    }

    public ResponseEntity<Object> updateEquipe(long id, Equipe equipe) {

        equipeRepository
                .findById(id)
                .ifPresentOrElse(eq -> {
                    eq.setNom(equipe.getNom());
                    equipeRepository.save(eq);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipe not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Equipe");

    }


}
