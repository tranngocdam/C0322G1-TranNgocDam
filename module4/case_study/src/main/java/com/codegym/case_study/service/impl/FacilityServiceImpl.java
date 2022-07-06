package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.Facility;
import com.codegym.case_study.repository.IFacilityRepository;
import com.codegym.case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }
    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void delete(Integer id) {
        iFacilityRepository.deleteById(id);
    }
}
