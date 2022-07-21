package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog ", nativeQuery = true)
    List<Blog> findAllBlog();

    @Modifying
    @Transactional
    @Query(value = "insert into blog (id, title, content, day_start) " +
            "values (:#{#blog.id}, :#{#blog.title}, :#{#blog.content}, :#{#blog.dayStart})", nativeQuery = true)
    void saveBlog(Blog blog);

    @Query(value="select * from blog p where p.id =:id", nativeQuery=true)
    Blog findByIdBlog(@Param("id") Integer id);

}
