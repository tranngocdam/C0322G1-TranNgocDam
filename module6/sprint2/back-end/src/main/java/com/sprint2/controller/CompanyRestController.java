package com.sprint2.controller;

import com.sprint2.model.Company;
import com.sprint2.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/api/company")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyRestController {
    @Autowired
    private ICompanyService iCompanyService;
    @GetMapping("/list")
    public ResponseEntity<List<Company>> findAllCompany(){
        List<Company> companyList = iCompanyService.findAllCompany();
        if (companyList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Company> findById(@PathVariable Integer id){
        Company company = this.iCompanyService.findById(id);
        if(company==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
