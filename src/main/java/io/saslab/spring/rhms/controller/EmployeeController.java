package io.saslab.spring.rhms.controller;

import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.EmployeeRepository;
import io.saslab.spring.rhms.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees")
@Api(produces = "application/json", value = "employee v1 service in the application")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    @ApiOperation(value = "Create a new employee", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created a new employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )


   /* @Transactional
    public ResponseEntity<Object> addEmployee(Employee employee, int id) {

        employeeService.saveEmployee(employee).ifPresentOrElse(emp -> { emp.(getEmployees).add(employee);
            employeeRepository.save(employee);
            }
            ,
                () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
                }
                );
        return ResponseEntity.accepted().body("Successfully Created Employee");
    }*/

    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }

    @PostMapping("/addEmployees")
    @ApiOperation(value = "Add all employees", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employees"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);

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

    @PutMapping("/update")
    @ApiOperation(value = "Update an employee information", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated employee information"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public Employee updateEmployee (@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
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
