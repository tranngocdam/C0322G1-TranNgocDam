package com.codegym.blog.repository;

import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT * FROM blog_category JOIN blog ON blog.id = blog_category.blog_id " +
            "JOIN category ON category.id = blog_category.category_id WHERE category_id = :id", nativeQuery = true)
    public Page<Category> searchById(@Param("id") Long id, Pageable pageable);

    @Query(value ="select * from category where category_id=:id", nativeQuery=true)
    public Page<Category> foundById(@Param("id") Integer id, Pageable pageable);
}
