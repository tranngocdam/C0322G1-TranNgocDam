package com.case_study.demo.repository;

import com.case_study.demo.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer>  {
//
}
