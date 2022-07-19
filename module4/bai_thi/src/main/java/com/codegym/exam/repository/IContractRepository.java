package com.codegym.exam.repository;

import com.codegym.exam.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = " select * from contract where contract_code = :contractCode ", nativeQuery = true)
    Contract findById(@Param("contractCode") String contractCode);

//    @Query(value="select * from hop_dong", nativeQuery=true)
//    Page<Contract> findAll(Pageable pageable);

}
