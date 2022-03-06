package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Poste;
import io.saslab.spring.rhms.repository.PosteRepository;
import io.saslab.spring.rhms.service.PosteService;
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
@RequestMapping(value = "/api/v1/postes")
@Tag(name = "Poste", description = "CRUD poste")
public class PosteController {

    @Autowired
    private PosteService posteService;
    private PosteRepository posteRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Poste controller ...";
    }


    @PostMapping("/postes/{id}")
    @ApiOperation(value = "Add an postes", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an postes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Poste> addPoste(@RequestBody Poste pst) {
        return  ResponseEntity.ok( posteService.addPoste(pst));
    }

    @PostMapping("/postes")
    @ApiOperation(value = "Add all postes", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all postes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Poste addPostes(@RequestBody Poste postes){
        return posteService.addPoste(postes);

    }

    @GetMapping("/postes")
    @ApiOperation(value = "View all postes", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all postes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Poste> findAllpostes(){
        return posteService.getPostes();
    }

    @GetMapping("/postes/{id}")
    @ApiOperation(value = "View poste by id", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all poste by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Poste findPosteById(@PathVariable long id){
        return posteService.getPosteById(id);
    }

    @GetMapping("/postes/nom/{nom}")
    @ApiOperation(value = "View poste by nom", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Poste by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Poste findPosteBynom(String nom){
        return posteService.getPosteByNom(nom);
    }

    @PutMapping("/postes/{id}")
    @ApiOperation(value = "update an existing postes", response = Poste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an postes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updatePoste (@RequestBody Poste poste, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return posteService.updatePoste(id,poste);
    }

    @DeleteMapping("/postes/{id}")
    @ApiOperation(value = "Deletes specific poste with the supplied poste id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific poste"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deletePosteById(@PathVariable @Parameter(description = "The reference of the poste to delete.")long id)  {

        posteService.deletePosteById(id);

    }

}
