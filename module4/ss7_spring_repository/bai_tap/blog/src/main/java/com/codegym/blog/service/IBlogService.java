package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    public List<Blog> findAll();

    public Blog findById(Integer id);

    void save(Blog blog);

    public void delete(Integer id);

    //    Page<Blog> findAll(Pageable pageable);
//    List<Blog> getAllBlogByKeyword(@Param("keyword") String abc);
}
