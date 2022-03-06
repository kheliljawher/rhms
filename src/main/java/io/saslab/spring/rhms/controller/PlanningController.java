package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Planning;
import io.saslab.spring.rhms.repository.PlanningRepository;
import io.saslab.spring.rhms.service.PlanningService;
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
@RequestMapping(value = "/api/v1/plannings")
@Tag(name = "Planning", description = "CRUD planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;
    private PlanningRepository planningRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Planning controller ...";
    }


    @PostMapping("/plannings/{id}")
    @ApiOperation(value = "Add an plannings", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an plannings"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Planning> addPlanning(@RequestBody Planning pln) {
        return  ResponseEntity.ok( planningService.addPlanning(pln));
    }

    @PostMapping("/plannings")
    @ApiOperation(value = "Add all plannings", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all plannings"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Planning addPlannings(@RequestBody Planning plannings){
        return planningService.addPlanning(plannings);

    }

    @GetMapping("/plannings")
    @ApiOperation(value = "View all plannings", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all plannings"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Planning> findAllPlannings(){
        return planningService.getPlannings();
    }

    @GetMapping("/plannings/{id}")
    @ApiOperation(value = "View planning by id", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Planning by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Planning findPlanningById(@PathVariable long id){
        return planningService.getPlanningById(id);
    }

    @GetMapping("/plannings/nom/{nom}")
    @ApiOperation(value = "View planning by nom", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved planning by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Planning findPlanningBynom(String nom){
        return planningService.getPlanningByNom(nom);
    }

    @PutMapping("/plannings/{id}")
    @ApiOperation(value = "update an existing plannings", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an plannings"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updatePlanning (@RequestBody Planning planning, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return planningService.updatePlanning(id,planning);
    }

    @DeleteMapping("/plannings/{id}")
    @ApiOperation(value = "Deletes specific planning with the supplied planning id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific planning"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deletePlanningById(@PathVariable @Parameter(description = "The reference of the planning to delete.")long id)  {

        planningService.deletePlanningById(id);

    }

}
