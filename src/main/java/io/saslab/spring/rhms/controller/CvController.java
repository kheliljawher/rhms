package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Conge;
import io.saslab.spring.rhms.entity.Cv;
import io.saslab.spring.rhms.repository.CvRepository;
import io.saslab.spring.rhms.service.CvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cvs")
@Api(produces = "application/json", value = "cv v1 service in the application")
public class CvController {

    @Autowired
    private CvService cvService;
    private CvRepository cvRepository;

    @PostMapping("/addCv")
    @ApiOperation(value = "Create a new Cv", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created CV"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Cv addCv(@RequestBody Cv cv){
        return cvService.saveCv(cv);

    }

    @PostMapping("/addCvs")
    @ApiOperation(value = "Add all cv", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cvs"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Cv> addCvs(@RequestBody List<Cv> cvs){
        return cvService.saveCvs(cvs);

    }

    @PostMapping("/cvs")
    @ApiOperation(value = "View all cvs", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cv"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Cv> findAllCvs(){
        return cvService.getCvs();
    }

    @PostMapping("/cv/{id}")
    @ApiOperation(value = "View cv by id", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cv by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Cv findCvByCompetance(String competance){
        return cvService.getCvByCompetance(competance);
    }

    @PostMapping("/cv/{competance}")
    @ApiOperation(value = "View cv by competance", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cv by competance"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Cv findCvById(int id){
        return cvService.getCvById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an cv information", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated cv information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Cv updateCv (@RequestBody Cv cv){
        return cvService.updateCv(cv);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific cv with the supplied cv id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific cv"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteCvById(int id)  {

        Cv cv= cvRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cv not found"));
        cvRepository.delete(cv);

    }

}
