package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Cv;
import io.saslab.spring.rhms.repository.CvRepository;
import io.saslab.spring.rhms.service.CvService;
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
@RequestMapping(value = "/api/v1/cvs")
@Tag(name = "Cv", description = "CRUD cv")
public class CvController {

    @Autowired
    private CvService cvService;
    private CvRepository cvRepository;


    @GetMapping("/")

    public String getMessage() {
        return "cv controller ...";
    }


    @PostMapping("/cvs/{id}")
    @ApiOperation(value = "Add an cvs", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an cvs"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Cv> addCv(@RequestBody Cv cv) {
        return  ResponseEntity.ok( cvService.addCv(cv));
    }

    @PostMapping("/cvs")
    @ApiOperation(value = "Add all cvs", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cvs"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Cv addCvs(@RequestBody Cv cvs){
        return cvService.addCv(cvs);

    }

    @GetMapping("/cvs")
    @ApiOperation(value = "View all cvs", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cvs"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Cv> findAllCvs(){
        return cvService.getCvs();
    }

    @GetMapping("/cvs/{id}")
    @ApiOperation(value = "View cv by id", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all cv by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Cv findCvById(@PathVariable long id){
        return cvService.getCvById(id);
    }

    @GetMapping("/cvs/competances/{competance}")
    @ApiOperation(value = "View cv by competance", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Cv by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Cv findCvByCompetance(String competance){
        return cvService.getCvByCompetance(competance);
    }

    @PutMapping("/cvs/{id}")
    @ApiOperation(value = "update an existing cvs", response = Cv.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an cvs"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updateCv (@RequestBody Cv cv, @PathVariable @Parameter(description = "The reference of the article to update.") long id){
        return cvService.updatecv(id,cv);
    }

    @DeleteMapping("/cvs/{id}")
    @ApiOperation(value = "Deletes specific cv with the supplied cv id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific cv"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteCvById(@PathVariable @Parameter(description = "The reference of the cv to delete.")long id)  {

        cvService.deleteCvById(id);

    }

}
