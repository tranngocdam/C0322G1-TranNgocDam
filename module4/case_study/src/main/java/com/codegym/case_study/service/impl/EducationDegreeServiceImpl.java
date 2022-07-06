package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.EducationDegree;
import com.codegym.case_study.repository.IEducationDegreeRepository;
import com.codegym.case_study.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService{
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
