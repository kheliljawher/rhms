package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Conge;
import io.saslab.spring.rhms.repository.CongeRepository;
import io.saslab.spring.rhms.service.CongeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/conges")
@Api(produces = "application/json", value = "conge v1 service in the application")
public class CongeController {


    @Autowired
    private CongeService congeService;
    private CongeRepository congeRepository;

    @PostMapping("/addConge")
    @ApiOperation(value = "Create a new Conge", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Conge"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Conge addConge(@RequestBody Conge conge){
        return congeService.saveConge(conge);

    }

    @PostMapping("/addConges")
    @ApiOperation(value = "Add all Conge", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Conge> addConges(@RequestBody List<Conge> conges){
        return congeService.saveConges(conges);

    }

    @PostMapping("/conges")
    @ApiOperation(value = "View all conge", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all conge"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Conge> findAllConges(){
        return congeService.getConges();
    }

    @PostMapping("/conge/{id}")
    @ApiOperation(value = "View conge by id", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all conge by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Conge findCongeById(int id){
        return congeService.getCongeById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an conge information", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated cv information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Conge updateConge (@RequestBody Conge conge){
        return congeService.updateConge(conge);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific conge with the supplied conge id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific conge"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteCongeById(int id)  {

        Conge con= congeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conge not found"));
        congeRepository.delete(con);

    }

}
