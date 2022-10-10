package com.sprint2.repository;

import com.sprint2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategotyRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category where status = 0", nativeQuery=true)
    List<Category> findAllCategory();

    @Query(value = "select * from category where id = :id", nativeQuery = true)
    Category findByIdCategory(@Param("id")Integer id);
}
