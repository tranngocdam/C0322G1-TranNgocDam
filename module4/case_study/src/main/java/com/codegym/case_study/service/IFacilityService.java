package com.codegym.case_study.service;

import com.codegym.case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFacilityService {
     Page<Facility> findAll(Pageable pageable);

     void save(Facility facility);

     Facility findById(Integer id);

     void delete(Integer id);

     Page<Facility> findFacilityByName(String keyword, Pageable pageable);
}
