package com.itspaceacademy.demo.controller;

import com.itspaceacademy.demo.model.Company;
import com.itspaceacademy.demo.model.Employee;
import com.itspaceacademy.demo.repository.CompanyRepository;
import com.itspaceacademy.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/employee")
    public String employee(ModelMap modelMap) {
        System.out.println("hasav String EMPLOYEE METHOD");
        List<Employee> all = employeeRepository.findAll();
        modelMap.addAttribute("employee", all);
        System.out.println("GETMapping String employee FIND_ALL()"+all);
        return "employee";
    }
    @GetMapping("/employee/add")
    public String addEmployee(ModelMap modelMap) {
        List<Company> allCompany= companyRepository.findAll();
        modelMap.addAttribute("company",allCompany);
        System.out.println("@GETMAPPING public String addEmployee()");
        return "addEmployee";
    }
    @PostMapping("/employee/add")
    public String addEmployeePost(@ModelAttribute Employee employee) {
        System.out.println("@POSTMAPPING public String addEmployeePost()");
        employeeRepository.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}")
    public String singleEmployee(@PathVariable("id") int id,
                                ModelMap modelMap) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            return "redirect:/";
        }
        modelMap.addAttribute("singleEmployee", employeeOptional.get());
//        Company company=companyRepository.getById(id);
        return "singleEmployee";

    }
    @GetMapping("/singleEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        System.out.println("deleteEmployee");

        System.out.println(id);
        employeeRepository.deleteById(id);
        return "redirect:/employee";

    }


}