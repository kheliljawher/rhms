package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Contrat;
import io.saslab.spring.rhms.repository.ContratRepository;
import io.saslab.spring.rhms.service.ContratService;
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
@RequestMapping(value = "/api/v1/contrats")
@Tag(name = "Contrat", description = "CRUD contrat")
public class ContratController {

    @Autowired
    private ContratService contratService;
    private ContratRepository contratRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Contrat controller ...";
    }


    @PostMapping("/contrats/{id}")
    @ApiOperation(value = "Add an contrats", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an contrats"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat con) {
        return  ResponseEntity.ok( contratService.addContrat(con));
    }

    @PostMapping("/contrats")
    @ApiOperation(value = "Add all contrats", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all contrats"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Contrat addContrats(@RequestBody Contrat contrats){
        return contratService.addContrat(contrats);

    }

    @GetMapping("/contrats")
    @ApiOperation(value = "View all contrats", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all contrats"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Contrat> findAllContrats(){
        return contratService.getContrats();
    }

    @GetMapping("/contrats/{id}")
    @ApiOperation(value = "View contrat by id", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all contrat by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Contrat findContratById(@PathVariable long id){
        return contratService.getContratById(id);
    }

    @GetMapping("/contrats/types/{type}")
    @ApiOperation(value = "View contrat by type", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved contrat by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Contrat findContratBynom(String type){
        return contratService.getContratByType(type);
    }

    @PutMapping("/contrats/{id}")
    @ApiOperation(value = "update an existing contrats", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an contrats"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updateContrat (@RequestBody Contrat contrat, @PathVariable @Parameter(description = "The reference of the article to update.") long id){
        return contratService.updatecontrat(id,contrat);
    }

    @DeleteMapping("/contrats/{id}")
    @ApiOperation(value = "Deletes specific contrat with the supplied contrat id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific contrat"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteContratById(@PathVariable @Parameter(description = "The reference of the contrat to delete.")long id)  {

        contratService.deleteContratById(id);

    }

}
