package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Departement;
import io.saslab.spring.rhms.repository.DepartementRepository;
import io.saslab.spring.rhms.service.DepartementService;
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
@RequestMapping(value = "/api/v1/departements")
@Api(produces = "application/json", value = "departement v1 service in the application")

public class DepartementController {

    @Autowired
    private DepartementService departementService;
    private DepartementRepository departementRepository;

    @PostMapping("/addDepartement")
    @ApiOperation(value = "Create a new departement", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new departement"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Departement addDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);

    }

    @PostMapping("/addDepartements")
    @ApiOperation(value = "Add all departements", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all departements"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Departement> addDepartements(@RequestBody List<Departement> departements){
        return departementService.saveDepartements(departements);

    }

    @PostMapping("/departements")
    @ApiOperation(value = "View all departements", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all departements"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Departement> findAllDepartements(){
        return departementService.getDepartements();
    }

    @PostMapping("/departement/{id}")
    @ApiOperation(value = "View departement by id", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all departement by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Departement findDepartementById(int id){
        return departementService.getDepartementById(id);
    }

    @PostMapping("/departement/{nom}")
    @ApiOperation(value = "View departement by nom", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved departement by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Departement findByDepartementByNom(String nom_dep){
        return departementService.getDepartementByNom(nom_dep);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an departement information", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated departement information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Departement updateDepartement (@RequestBody Departement departement){
        return departementService.updateDepartement(departement);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific departement with the supplied departement id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific departement"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteDepartementById(int id)  {

        Departement dep= departementRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departement not found"));
        departementRepository.delete(dep);

    }


}
