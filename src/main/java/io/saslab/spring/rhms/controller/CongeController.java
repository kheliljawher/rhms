package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Conge;
import io.saslab.spring.rhms.repository.CongeRepository;
import io.saslab.spring.rhms.service.CongeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/conges")
@Tag(name = "Conge", description = "CRUD Conge")
public class CongeController {

    @Autowired
    private CongeService congeService;
    private CongeRepository congeRepository;


    @GetMapping("/")

    public String getMessage() {
        return "conge controller ...";
    }


    @PostMapping("/conges/{id}")
    @ApiOperation(value = "Add an conge", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an conges"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Conge> addConge(@RequestBody Conge con) {
        return  ResponseEntity.ok( congeService.addConge(con));
    }

    @PostMapping("/conges")
    @ApiOperation(value = "Add all conges", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all conges"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Conge addConges(@RequestBody Conge conges){
        return congeService.addConge(conges);

    }

    @GetMapping("/conges")
    @ApiOperation(value = "View all conges", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all conges"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Conge> findAllConges(){
        return congeService.getConges();
    }

    @GetMapping("/conges/{id}")
    @ApiOperation(value = "View conge by id", response = Conge.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all conge by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @PutMapping("/conges/{id}")
    @Operation(
            summary = "Update an conge",
            description = "Update an existing conge.",
            tags = { "Conge" },
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Conge.class))
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Object> updateConge (@RequestBody Conge conge, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return congeService.updateConge(id,conge);
    }

    @DeleteMapping("/conges/{id}")
    @ApiOperation(value = "Deletes specific conge with the supplied conge id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific conge"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteCongeById(@PathVariable @Parameter(description = "The reference of the conge to delete.")long id)  {

        congeService.deleteCongeById(id);

    }

}
