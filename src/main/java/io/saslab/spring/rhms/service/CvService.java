package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Cv;
import io.saslab.spring.rhms.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvService {
    @Autowired
    private CvRepository cvRepository;

    public Cv saveCv(Cv cv){

        return cvRepository.save(cv);
    }
    public List<Cv> saveCvs(List<Cv> cv){

        return cvRepository.saveAll(cv);
    }
    public List<Cv> getCvs(){

        return cvRepository.findAll();
    }
    public Cv getCvById(Integer id){

        return cvRepository.findById(id).orElse(null);
    }
    public Cv getCvByCompetance(String competance){
        return cvRepository.findByCompetance(competance);
    }
    public String deleteCvById(int id){
        cvRepository.deleteById(id);
        return "Cv removed !"+id;
    }
    public Cv updateCv(Cv cv){
        Cv existingCv=cvRepository.findById(cv.getId()).orElse(null);
        existingCv.setCompetance(cv.getCompetance());
        return cvRepository.save(existingCv);
    }

}
