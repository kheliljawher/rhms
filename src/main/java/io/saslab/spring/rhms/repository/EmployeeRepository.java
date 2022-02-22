package io.saslab.spring.rhms.repository;

import io.saslab.spring.rhms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByNom(String nom);

    Employee findByPrenom(String prenom);
}
