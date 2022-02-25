package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Equipe;
import io.saslab.spring.rhms.repository.EquipeRepository;
import io.saslab.spring.rhms.service.EquipeService;
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
@RequestMapping(value = "/api/v1/equipes")
@Api(produces = "application/json", value = "equipe v1 service in the application")
public class EquipeController {


    @Autowired
    private EquipeService equipeService;
    private EquipeRepository equipeRepository;

    @PostMapping("/addEquipe")
    @ApiOperation(value = "Create a new Equipe", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Equipe"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeService.saveEquipe(equipe);

    }

    @PostMapping("/addEquipes")
    @ApiOperation(value = "Add all Equipe", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Equipes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Equipe> addEquipes(@RequestBody List<Equipe> equipes){
        return equipeService.saveequipes(equipes);

    }

    @PostMapping("/equipes")
    @ApiOperation(value = "View all equipes", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Equipe"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Equipe> findAllEquipes(){
        return equipeService.getEquipes();
    }

    @PostMapping("/Equipe/{id}")
    @ApiOperation(value = "View Equipe by id", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Equipe by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Equipe findEquipeById(int id){
        return equipeService.getEquipeById(id);
    }

    @PostMapping("/Equipe/{nom_Equipe}")
    @ApiOperation(value = "View Equipe by nom_Equipe", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Equipe by nom_Equipe"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    private Equipe findEquipeByNom(String nom){
        return equipeService.getEquipeByNom(nom);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an Equipe information", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated Equipe information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Equipe updateEquipe (@RequestBody Equipe equipe){
        return equipeService.updateEquipe(equipe);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific Equipe with the supplied Equipe id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific Equipe"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteEquipeById(int id)  {

        Equipe equipe= equipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "equipe not found"));
        equipeRepository.delete(equipe);

    }

}
