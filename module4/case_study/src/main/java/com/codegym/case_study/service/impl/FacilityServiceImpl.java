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
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }
    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findFacilityByName(String keyword, Pageable pageable) {
        return iFacilityRepository.findByNameContaining(keyword, pageable);
    }
}
