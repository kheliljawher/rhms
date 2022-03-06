package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Departement;
import io.saslab.spring.rhms.repository.DepartementRepository;
import io.saslab.spring.rhms.service.DepartementService;
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
@RequestMapping(value = "/api/v1/departements")
@Tag(name = "Departement", description = "CRUD departement")
public class DepartementController {

    @Autowired
    private DepartementService departementService;
    private DepartementRepository departementRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Departement controller ...";
    }


    @PostMapping("/departements/{id}")
    @ApiOperation(value = "Add an departements", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an departements"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Departement> addDepartement(@RequestBody Departement dep) {
        return  ResponseEntity.ok( departementService.addDepartement(dep));
    }

    @PostMapping("/departements")
    @ApiOperation(value = "Add all departements", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all departements"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Departement addDepartements(@RequestBody Departement departements){
        return departementService.addDepartement(departements);

    }

    @GetMapping("/departements")
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

    @GetMapping("/departements/{id}")
    @ApiOperation(value = "View departement by id", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all departement by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Departement findDepartementById(@PathVariable long id){
        return departementService.getDepartementById(id);
    }

    @GetMapping("/departements/nom/{nom}")
    @ApiOperation(value = "View departement by nom", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved departement by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Departement findDepartementBynom(String nom){
        return departementService.getDepartementByNom(nom);
    }

    @PutMapping("/departements/{id}")
    @ApiOperation(value = "update an existing departements", response = Departement.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an departements"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updateDepartement (@RequestBody Departement departement, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return departementService.updateDepartement(id,departement);
    }

    @DeleteMapping("/departements/{id}")
    @ApiOperation(value = "Deletes specific departement with the supplied departement id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific departement"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteDepartementById(@PathVariable @Parameter(description = "The reference of the departement to delete.")long id)  {

        departementService.deleteDepartementById(id);

    }

}
