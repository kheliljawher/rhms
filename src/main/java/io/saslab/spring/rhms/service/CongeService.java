package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Conge;
import io.saslab.spring.rhms.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CongeService {

    @Autowired
    private CongeRepository congeRepository;

    public Conge addConge(Conge conge) {
        return congeRepository.save(conge);


    }

    public List<Conge> addConges(List<Conge> conge) {
        return congeRepository.saveAll(conge);
    }

    public List<Conge> getConges() {
        return congeRepository.findAll();
    }

    public Conge getCongeById(long id) {
        return congeRepository.findById(id).orElse(null);
    }

    public void deleteCongeById(long id) {

        Conge cong =
                congeRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conge not found"));
        congeRepository.delete(cong);
    }

    public ResponseEntity<Object> updateConge(long id, Conge conge) {

        congeRepository
                .findById(id)
                .ifPresentOrElse(cong -> {
                    cong.setDate_debut(conge.getDate_debut());
                    cong.setDate_fin(conge.getDate_fin());
                    congeRepository.save(cong);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conge not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Conge");

    }


}
