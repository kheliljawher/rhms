package io.saslab.spring.rhms.service;

import io.saslab.spring.rhms.entity.Employee;
import io.saslab.spring.rhms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> saveEmployees(List<Employee> employee){
        return employeeRepository.saveAll(employee);
    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee getEmployeeByNom(String nom){
        return employeeRepository.findByNom(nom);
    }
    public Employee getEmployeeByPrenom(String prenom){
        return employeeRepository.findByPrenom(prenom);
    }
    public String deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
        return "Employee removed !"+id;
    }
    public Employee updateEmployee(Employee employee){
        Employee existingEmployee=employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setNom(employee.getNom());
        existingEmployee.setPrenom(employee.getPrenom());
        return employeeRepository.save(existingEmployee);
    }


}
