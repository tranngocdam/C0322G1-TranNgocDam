package com.case_study.demo.service.impl;

import com.case_study.demo.model.Division;
import com.case_study.demo.repository.IDivisionRepository;
import com.case_study.demo.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
