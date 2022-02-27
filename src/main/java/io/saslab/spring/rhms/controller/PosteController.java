package io.saslab.spring.rhms.controller;


import io.saslab.spring.rhms.entity.Poste;
import io.saslab.spring.rhms.repository.PosteRepository;
import io.saslab.spring.rhms.service.PosteService;
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
@RequestMapping(value = "/api/v1/postes")
@Api(produces = "application/json", value = "poste v1 service in the application")
public class PosteController {


    @Autowired
    private PosteService posteService;
    private PosteRepository posteRepository;

    @PostMapping("/addPoste")
    @ApiOperation(value = "Create a new poste", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new poste"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Poste addPoste(@RequestBody Poste poste){
        return posteService.savePoste(poste);

    }

    @PostMapping("/addPostes")
    @ApiOperation(value = "Add all postes", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all postes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Poste> addPostes(@RequestBody List<Poste> postes){
        return posteService.savePostes(postes);

    }

    @PostMapping("/postes")
    @ApiOperation(value = "View all postes", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all postes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Poste> findAllPostes(){
        return posteService.getPostes();
    }

    @PostMapping("/poste/{id}")
    @ApiOperation(value = "View poste by id", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Poste by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Poste findPosteById(int id){
        return posteService.getPosteById(id);
    }

    @PostMapping("/poste/{nom}")
    @ApiOperation(value = "View poste by nom", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved poste by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Poste findPosteBynom(String nom){
        return posteService.getPosteByNom(nom);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an poste information", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated poste information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Poste updatePoste (@RequestBody Poste poste){
        return posteService.updatePoste(poste);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific poste with the supplied poste id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific poste"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deletePosteById(int id)  {

        Poste emp= posteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poste not found"));
        posteRepository.delete(emp);

    }

}
