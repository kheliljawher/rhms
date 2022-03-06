package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Poste;
import io.saslab.spring.rhms.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PosteService {

    @Autowired
    private PosteRepository posteRepository;

    public Poste addPoste(Poste poste) {
        return posteRepository.save(poste);


    }

    public List<Poste> addPostes(List<Poste> poste) {
        return posteRepository.saveAll(poste);
    }

    public List<Poste> getPostes() {
        return posteRepository.findAll();
    }

    public Poste getPosteById(Long id) {
        return posteRepository.findById(id).orElse(null);
    }

    public Poste getPosteByNom(String nom) {
        return posteRepository.findByNom(nom);
    }

    public void deletePosteById(long id) {

        Poste pst =
                posteRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poste not found"));
        posteRepository.delete(pst);
    }

    public ResponseEntity<Object> updatePoste(long id, Poste poste) {

        posteRepository
                .findById(id)
                .ifPresentOrElse(pst -> {
                    pst.setNom(poste.getNom());
                    posteRepository.save(pst);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Poste not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Poste");

    }


}
