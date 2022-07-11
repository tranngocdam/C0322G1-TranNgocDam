package com.codegym.case_study.repository;

import com.codegym.case_study.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    @Query(value="select * from contract_detail", nativeQuery=true)
    Page<ContractDetail> findAll(Pageable pageble);
}
