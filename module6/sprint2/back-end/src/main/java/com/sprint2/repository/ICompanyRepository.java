package com.sprint2.repository;

import com.sprint2.model.Category;
import com.sprint2.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {
    @Query(value = "select * from company where status = 0", nativeQuery=true)
    List<Company> findAllCompany();

    @Query(value = "select * from company where id = :id", nativeQuery = true)
    Company findByIdCompany(@Param("id")Integer id);
}
