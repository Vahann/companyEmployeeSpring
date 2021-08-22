package com.itspaceacademy.demo.controller;

import com.itspaceacademy.demo.model.Company;
import com.itspaceacademy.demo.repository.CompanyRepository;
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
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/company")
    public String company(ModelMap modelMap) {
        List<Company> all = companyRepository.findAll();
        System.out.println(all);
        modelMap.addAttribute("company", all);
//        getCompanyNameById(1);
        return "company";
    }

    //    public String getCompanyNameById(int companyId){
//
//        Optional<Company> companies=companyRepository.findById(companyId);
//        String v=companies.get().getName();
//        System.out.println(v);
//        return v;
//    }
    @GetMapping("/addCompany")
    public String addCompany() {
        System.out.println("@GETMAPPING public String addCompany()");
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company) {
        System.out.println("@POSTMAPPING public String addCompanyPost()");
        companyRepository.save(company);
        return "redirect:/company";
    }

    @GetMapping("/company/{id}")
    public String singleCompany(@PathVariable("id") int id,
                                ModelMap modelMap) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (!companyOptional.isPresent()) {
            return "redirect:/";
        }
        modelMap.addAttribute("singleCompany", companyOptional.get());
//        Company company=companyRepository.getById(id);
        return "singleCompany";

    }

    @GetMapping("/singleCompany/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        System.out.println("deleteCompany");
        System.out.println(id);
        companyRepository.deleteById(id);
        return "redirect:/company";

    }
}
