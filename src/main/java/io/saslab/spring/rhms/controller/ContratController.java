package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Contrat;
import io.saslab.spring.rhms.repository.ContratRepository;
import io.saslab.spring.rhms.service.ContratService;
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
@RequestMapping(value = "/api/v1/contrats")
@Api(produces = "application/json", value = "contrat v1 service in the application")
public class ContratController {

    @Autowired
    private ContratService contratService;
    private ContratRepository contratRepository;

    @PostMapping("/addContrat")
    @ApiOperation(value = "Create a new contrat", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new contrat"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Contrat addContrat(@RequestBody Contrat contrat){
        return contratService.saveContrat(contrat);

    }

    @PostMapping("/addContrats")
    @ApiOperation(value = "Add all contrats", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all contrats"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Contrat> addContrats(@RequestBody List<Contrat> contrats){
        return contratService.saveContrats(contrats);

    }

    @PostMapping("/contrats")
    @ApiOperation(value = "View all contrats", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Contrats"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Contrat> findAllContrats(){
        return contratService.getContrats();
    }

    @PostMapping("/contrat/{id}")
    @ApiOperation(value = "View contrat by id", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all contrat by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Contrat findContratById(int id){
        return contratService.getContratById(id);
    }

    @PostMapping("/contrat/{type}")
    @ApiOperation(value = "View contrat by type", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved contrat by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Contrat findContratByType(String type){
        return contratService.getContratByType(type);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an contrat information", response = Contrat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated contrat information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Contrat updateContrat (@RequestBody Contrat contrat){
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific contrat with the supplied contrat id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific contrat"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteContratById(int id)  {

        Contrat emp= contratRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "contrat not found"));
        contratRepository.delete(emp);

    }

}
