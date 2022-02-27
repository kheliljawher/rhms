package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Planning;
import io.saslab.spring.rhms.repository.PlanningRepository;
import io.saslab.spring.rhms.service.PlanningService;
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
@RequestMapping(value = "/api/v1/plannings")
@Api(produces = "application/json", value = "planning v1 service in the application")
public class PlanningController {

    @Autowired
    private PlanningService planningService;
    private PlanningRepository planningRepository;

    @PostMapping("/addPlanning")
    @ApiOperation(value = "Create a new planning", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new planning"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Planning addPlanning(@RequestBody Planning planning){
        return planningService.savePlanning(planning);

    }

    @PostMapping("/addPlannings")
    @ApiOperation(value = "Add all Plannings", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Plannings"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Planning> addPlannings(@RequestBody List<Planning> plannings){
        return planningService.savePlannings(plannings);

    }

    @PostMapping("/plannings")
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

    @PostMapping("/planning/{id}")
    @ApiOperation(value = "View planning by id", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Planning by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Planning findPlanningById(int id){
        return planningService.getPlanningById(id);
    }

    @PostMapping("/planning/{nom_Plan}")
    @ApiOperation(value = "View planning by nom", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved planning by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Planning findPlanningByNomPlan(String nom_Plan){
        return planningService.getPlanningByNomPlan(nom_Plan);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an planning information", response = Planning.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated planning information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Planning updatePlanning (@RequestBody Planning planning){
        return planningService.updatePlanning(planning);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific planning with the supplied planning id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific planning"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deletePlanningById(int id)  {

        Planning emp= planningRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Planning not found"));
        planningRepository.delete(emp);

    }


}
