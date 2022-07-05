package com.codegym.case_study.repository;

import com.codegym.case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value="select * from facility", nativeQuery=true)
    public List<Facility> findAll();
}
