package com.codegym.case_study.repository;

import com.codegym.case_study.model.AttachFacility;
import com.codegym.case_study.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value="select * from contract", nativeQuery=true)
    public List<AttachFacility> findAll();
}
