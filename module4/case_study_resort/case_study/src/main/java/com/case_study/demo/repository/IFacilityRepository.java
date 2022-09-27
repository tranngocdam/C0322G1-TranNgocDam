package com.case_study.demo.repository;

import com.case_study.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value="select * from facility", nativeQuery=true)
    Page<Facility> findAllFacility(Pageable pageable);


    @Query(value="insert into facility(name, area, cost, maxPeople, standarRoom, descriptionOtherConvenience, poolArea," +
            "numberOfFloors, rentType, facilityType)", nativeQuery=true)
    Facility saveHouse(@Param("name") String name,
                       @Param("area") Integer area);

    @Query(value="select * from facility where `name` like :name ", nativeQuery=true)
    Page<Facility> findFacility(@Param("name") String name, Pageable pageable);
}
