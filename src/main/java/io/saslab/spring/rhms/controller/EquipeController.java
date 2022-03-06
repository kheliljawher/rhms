package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Equipe;
import io.saslab.spring.rhms.repository.EquipeRepository;
import io.saslab.spring.rhms.service.EquipeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/equipes")
@Tag(name = "Equipe", description = "CRUD equipe")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;
    private EquipeRepository equipeRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Equipe controller ...";
    }


    @PostMapping("/equipes/{id}")
    @ApiOperation(value = "Add an equipes", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an equipes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe eq) {
        return  ResponseEntity.ok( equipeService.addEquipe(eq));
    }

    @PostMapping("/equipes")
    @ApiOperation(value = "Add all equipes", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all equipes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Equipe addEquipes(@RequestBody Equipe equipes){
        return equipeService.addEquipe(equipes);

    }

    @GetMapping("/equipes")
    @ApiOperation(value = "View all equipes", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all equipes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Equipe> findAllEquipes(){
        return equipeService.getEquipes();
    }

    @GetMapping("/equipes/{id}")
    @ApiOperation(value = "View equipe by id", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all equipe by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Equipe findEquipeById(@PathVariable long id){
        return equipeService.getEquipeById(id);
    }

    @GetMapping("/equipes/nom/{nom}")
    @ApiOperation(value = "View equipe by nom", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved equipe by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Equipe findEquipeBynom(String nom){
        return equipeService.getEquipeByNom(nom);
    }

    @PutMapping("/equipes/{id}")
    @ApiOperation(value = "update an existing equipes", response = Equipe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an equipes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updateEquipe (@RequestBody Equipe equipe, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return equipeService.updateEquipe(id,equipe);
    }

    @DeleteMapping("/equipes/{id}")
    @ApiOperation(value = "Deletes specific equipe with the supplied equipe id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific equipe"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteEquipeById(@PathVariable @Parameter(description = "The reference of the equipe to delete.")long id)  {

        equipeService.deleteEquipeById(id);

    }

}
