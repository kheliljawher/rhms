package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Contrat;
import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;

    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);


    }

    public List<Contrat> addContrats(List<Contrat> contrat) {
        return contratRepository.saveAll(contrat);
    }

    public List<Contrat> getContrats() {
        return contratRepository.findAll();
    }

    public Contrat getContratById(long id) {
        return contratRepository.findById(id).orElse(null);
    }

    public Contrat getContratByType(String type) {
        return contratRepository.findByType(type);
    }

    public void deleteContratById(long id) {

        Contrat emp =
                contratRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "contrat not found"));
        contratRepository.delete(emp);
    }

    public ResponseEntity<Object> updatecontrat(long id, Contrat contrat) {

        contratRepository
                .findById(id)
                .ifPresentOrElse(con -> {
                    con.setDate_debut(contrat.getDate_debut());
                    con.setDate_fin(contrat.getDate_fin());
                    contratRepository.save(con);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrat not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Contrat");

    }


}
