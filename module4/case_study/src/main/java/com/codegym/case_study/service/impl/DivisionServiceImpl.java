package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.Division;
import com.codegym.case_study.repository.IDivisionRepository;
import com.codegym.case_study.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
