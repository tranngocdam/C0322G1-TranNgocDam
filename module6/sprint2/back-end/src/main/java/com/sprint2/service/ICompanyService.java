package com.sprint2.service;

import com.sprint2.model.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> findAllCompany();

    Company findById(Integer id);
}
