package com.case_study.demo.repository;

import com.case_study.demo.model.Customer;
import com.case_study.demo.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select * from customer", nativeQuery=true)
    Page<Customer> findAllCustomer(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value="insert into customer(address, day_of_birth, email, gender, id_card, name, phone_number, customer_type_id)" +
            "value(:address, :dayOfBirth, :email, :gender, :idCard, :name, :phoneNumber, :customerType)", nativeQuery=true)
    void saveCustomer(@Param("address") String address,
                      @Param("dayOfBirth") String dayOfBirth,
                      @Param("email") String email,
                      @Param("gender") String gender,
                      @Param("idCard") String idCard,
                      @Param("name") String name,
                      @Param("phoneNumber") String phoneNumber,
                      @Param("customerType")CustomerType customerType);

    @Query(value="select * from customer c where c.id =:id", nativeQuery=true)
    Customer findByIdCustomer(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value="delete from customer c  where c.id=:id", nativeQuery=true)
    void deleteCustomer(@Param("id") Integer id);

    @Query(value="select * from customer where `name` like :name ",nativeQuery=true)
    Page<Customer> findCustomerByName(@Param("name") String name, Pageable pageable);
}
