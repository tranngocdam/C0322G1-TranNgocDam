package com.codegym.case_study.repository;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select * from customer where name like :keyword", nativeQuery=true)
    List<Customer> findCustomerByName(@Param("keyword") String nameCustomer);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    @Query(value="select * from customer", nativeQuery=true)
    public Page<Customer> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM customer\n" +
            "JOIN contract ON contract.customer_id = customer.customer_id\n" +
            "JOIN service ON service.service_id = contract.service_id\n" +
            "LEFT JOIN contract_detail ON contract_detail.contract_id = contract.contract_id\n" +
            "LEFT JOIN attach_service ON attach_service.attach_service_id = contract_detail.attach_service_id\n" +
            "WHERE contract_start_date REGEXP :date\n",nativeQuery = true)
    Page<Customer> findAllByDate(Pageable pageable);
}
