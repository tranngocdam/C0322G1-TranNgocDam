package com.sprint2.repository;

import com.sprint2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update customer set address = :address, day_of_birth = :dayOfBirth, email = :email, `name` = :name, " +
            "phone = :phone  where id = :id", nativeQuery = true)
    void editCustomer(@Param("address") String address,
                      @Param("dayOfBirth") LocalDate dayOfBirth,
                      @Param("email") String email,
                      @Param("name") String name,
                      @Param("phone") String phone,
                      @Param("id") Integer id);

    @Query(value = "select * from customer where user_id = :userId", nativeQuery = true)
    Customer findByUserId(@Param("userId") Integer userId);
}
