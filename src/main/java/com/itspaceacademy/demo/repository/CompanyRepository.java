package com.itspaceacademy.demo.repository;

import com.itspaceacademy.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
