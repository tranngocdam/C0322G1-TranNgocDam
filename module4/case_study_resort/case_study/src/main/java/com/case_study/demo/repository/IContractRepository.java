package com.case_study.demo.repository;

import com.case_study.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {


    @Query(value="select * from contract where customer_id like :customer ", nativeQuery=true)
    Page<Contract> findContractByCustomer(@Param("customer") String customer, Pageable pageable);
}
