package com.case_study.demo.service;

import com.case_study.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> findAll(Pageable pageable);

    Facility save(Facility facility);
}
