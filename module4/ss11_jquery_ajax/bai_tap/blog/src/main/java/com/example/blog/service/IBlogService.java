package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> findAllCategoryId(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    void update(Blog blog);

    Blog getBlog(Integer id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByName(String keyword, Pageable pageable);
}
