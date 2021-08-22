package com.itspaceacademy.demo.repository;

import com.itspaceacademy.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
