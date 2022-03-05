package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public ResponseEntity<Object> addEmployee(Employee employee, int id) {

        employeeRepository
                .findById(id)
                .ifPresentOrElse(emp -> {
                    employeeRepository.save(employee);
                },() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
                });

        return ResponseEntity.accepted().body("Successfully Created Employee");

    }

    public List<Employee> addEmployees(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByNom(String nom) {
        return employeeRepository.findByNom(nom);
    }

    public Employee getEmployeeByPrenom(String prenom) {
        return employeeRepository.findByPrenom(prenom);
    }

    @Transactional
    public void deleteEmployeeById(int id) {

        Employee emp =
                employeeRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employeeRepository.delete(emp);
    }

    @Transactional
    public ResponseEntity<Object> updateEmployee(int id, Employee employee) {

        employeeRepository
                .findById(id)
                .ifPresentOrElse(emp -> {
                    emp.setNom(employee.getNom());
                    emp.setPrenom(employee.getPrenom());
                    employeeRepository.save(emp);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
                });


        return ResponseEntity.accepted().body("Successfully updated Employee");

    }


}
