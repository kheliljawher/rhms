package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Section;
import io.saslab.spring.rhms.repository.SectionRepository;
import io.saslab.spring.rhms.service.SectionService;
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
@RequestMapping(value = "/api/v1/sections")
@Tag(name = "Section", description = "CRUD section")
public class SectionController {

    @Autowired
    private SectionService sectionService;
    private SectionRepository sectionRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Section controller ...";
    }


    @PostMapping("/sections/{id}")
    @ApiOperation(value = "Add an sections", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an sections"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Section> addSection(@RequestBody Section sec) {
        return  ResponseEntity.ok( sectionService.addSection(sec));
    }

    @PostMapping("/sections")
    @ApiOperation(value = "Add all sections", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all sections"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Section addSections(@RequestBody Section sections){
        return sectionService.addSection(sections);

    }

    @GetMapping("/sections")
    @ApiOperation(value = "View all sections", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all sections"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Section> findAllSections(){
        return sectionService.getSections();
    }

    @GetMapping("/sections/{id}")
    @ApiOperation(value = "View section by id", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all section by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Section findSectionById(@PathVariable long id){
        return sectionService.getSectionById(id);
    }

    @GetMapping("/sections/titre/{titre}")
    @ApiOperation(value = "View section by nom", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved section by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Section findSectionByTitre(String titre){
        return sectionService.getSectionByTitre(titre);
    }

    @PutMapping("/sections/{id}")
    @ApiOperation(value = "update an existing sections", response = Section.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an sections"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updateSection (@RequestBody Section section, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return sectionService.updateSection(id,section);
    }

    @DeleteMapping("/sections/{id}")
    @ApiOperation(value = "Deletes specific section with the supplied section id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific section"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteSectionById(@PathVariable @Parameter(description = "The reference of the section to delete.")long id)  {

        sectionService.deleteSectionById(id);

    }

}
