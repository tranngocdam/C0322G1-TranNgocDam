package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value="select * from blog", nativeQuery=true)
    Page<Blog> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value="insert into blog(title, category_id, day_start, author)" +
            "value (:title, :category, :dayStart, :author)", nativeQuery=true)
    void saveBlog(@Param("author") String author,
                  @Param("dayStart") String dayStart,
                  @Param("title") String title,
                  @Param("category") Integer category);

    @Query(value="select * from blog where `title` like :title", nativeQuery=true)
    Page<Blog>findTitleBlog(@Param("title") String title, Pageable pageable);
}
