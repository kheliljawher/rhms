package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.EmployeeRepository;
import io.saslab.spring.rhms.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees")
@Tag(name = "Employee", description = "CRUD employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Employee controller ...";
    }


    @PutMapping("/addEmployee/{id}")
    @Operation(
            summary = "Add an employee",
            description = "Create a new employee.",
            tags = { "Employee" },
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )

    public ResponseEntity<Object> addEmployee(@RequestBody Employee emp, @PathVariable("id")  @Parameter(description = "The Id of the employee") int id) {
        return  employeeService.addEmployee(emp, id);
    }

    @PostMapping("/addEmployees")
    @ApiOperation(value = "Add all employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.addEmployees(employees);

    }

    @PostMapping("/employees")
    @ApiOperation(value = "View all employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Employee> findAllEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employee/{id}")
    @ApiOperation(value = "View employee by id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employee by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Employee findEmployeeById(int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee/{nom}")
    @ApiOperation(value = "View employee by nom", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee by nom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Employee findEmployeeBynom(String nom){
        return employeeService.getEmployeeByNom(nom);
    }

    @PostMapping("/employee/{prenom}")
    @ApiOperation(value = "View employee by prenom", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee by prenom"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Employee findEmployeeByprenom(String prenom){
        return employeeService.getEmployeeByPrenom(prenom);
    }

    @PutMapping("/updateEmployee/{id}")
    @Operation(
            summary = "Update an employee",
            description = "Update an existing employee.",
            tags = { "Employee" },
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Object> updateEmployee (@RequestBody Employee employee, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes specific employee with the supplied employee id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    @Transactional

    public void deleteEmployeeById(int id)  {

        Employee emp= employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employeeRepository.delete(emp);

    }

}
