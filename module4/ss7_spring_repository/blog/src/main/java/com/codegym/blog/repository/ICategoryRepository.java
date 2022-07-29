package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value="select * from category", nativeQuery=true)
    List<Category> findAll();

    @Query(value="select * from Category c where c.id =:id", nativeQuery=true)
    Category findId(@Param("id") Integer id);
}
