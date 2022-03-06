package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Cv;
import io.saslab.spring.rhms.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CvService {

    @Autowired
    private CvRepository cvRepository;

    public Cv addCv(Cv cv) {
        return cvRepository.save(cv);


    }

    public List<Cv> addCvs(List<Cv> cv) {
        return cvRepository.saveAll(cv);
    }

    public List<Cv> getCvs() {
        return cvRepository.findAll();
    }

    public Cv getCvById(long id) {
        return cvRepository.findById(id).orElse(null);
    }

    public Cv getCvByCompetance(String competance) {
        return cvRepository.findByCompetance(competance);
    }

    public void deleteCvById(long id) {

        Cv cvs =
                cvRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cv not found"));
        cvRepository.delete(cvs);
    }

    public ResponseEntity<Object> updatecv(long id, Cv cv) {

        cvRepository
                .findById(id)
                .ifPresentOrElse(cvs -> {
                    cvs.setCompetance(cv.getCompetance());
                    cvRepository.save(cvs);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cv not found");
                });


        return ResponseEntity.accepted().body("Successfully updated cv");

    }


}
