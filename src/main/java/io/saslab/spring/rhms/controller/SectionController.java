package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Section;
import io.saslab.spring.rhms.repository.SectionRepository;
import io.saslab.spring.rhms.service.SectionService;
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
@RequestMapping(value = "/api/v1/sections")
@Api(produces = "application/json", value = "section v1 service in the application")
public class SectionController {


    @Autowired
    private SectionService sectionService;
    private SectionRepository sectionRepository;

    @PostMapping("/addSection")
    @ApiOperation(value = "Create a new Section", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Section"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public Section addSection(@RequestBody Section section){
        return sectionService.saveSection(section);

    }

    @PostMapping("/addSections")
    @ApiOperation(value = "Add all Section", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Sections"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Section> addSections(@RequestBody List<Section> sections){
        return sectionService.saveSections(sections);

    }

    @PostMapping("/sections")
    @ApiOperation(value = "View all sections", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all section"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Section> findAllSections(){
        return sectionService.getSections();
    }

    @PostMapping("/section/{id}")
    @ApiOperation(value = "View section by id", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all section by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Section findSectionByCompetance(String titre){
        return sectionService.getSectionByTitre(titre);
    }

    @PostMapping("/section/{titre}")
    @ApiOperation(value = "View section by competance", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all Section by competance"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Section findSectionById(int id){
        return sectionService.getSectionById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an section information", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated section information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Section updateSection (@RequestBody Section section){
        return sectionService.updateSection(section);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific section with the supplied section id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific section"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteSectionById(int id)  {

        Section section= sectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "section not found"));
        sectionRepository.delete(section);

    }


}
