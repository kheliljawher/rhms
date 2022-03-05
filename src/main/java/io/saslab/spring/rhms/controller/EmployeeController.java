package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.EmployeeRepository;
import io.saslab.spring.rhms.service.EmployeeService;
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
@RequestMapping(value = "/api/v1/employee")
@Tag(name = "Employee", description = "CRUD employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;


    @GetMapping("/")

    public String getMessage() {
        return "Employee controller ...";
    }


    @PostMapping("/employees/{id}")
    @ApiOperation(value = "Add an employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add an employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        return  ResponseEntity.ok( employeeService.addEmployee(emp));
    }

    @PostMapping("/employees")
    @ApiOperation(value = "Add all employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Employee addEmployees(@RequestBody Employee employees){
        return employeeService.addEmployee(employees);

    }

    @GetMapping("/employees")
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

    @GetMapping("/employees/{id}")
    @ApiOperation(value = "View employee by id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employee by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Employee findEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/nom/{nom}")
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

    @GetMapping("/employees/prenom/{prenom}")
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

    @PutMapping("/employees/{id}")
    @ApiOperation(value = "update an existing employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update an employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity<Object> updateEmployee (@RequestBody Employee employee, @PathVariable @Parameter(description = "The reference of the article to update.") int id){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/employees/{id}")
    @ApiOperation(value = "Deletes specific employee with the supplied employee id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletes the specific employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )

    public void deleteEmployeeById(@PathVariable @Parameter(description = "The reference of the employee to delete.")long id)  {

        employeeService.deleteEmployeeById(id);

    }

}
