package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {

    public Page<Blog> findAll(Pageable pageable);

    public void saveOrUpdate(Blog blog);

    public void delete(Integer id);

    public Blog findById(Integer id);

    public Page<Blog> findAllByAuthorContaining(String keyword,Pageable pageable);

    public Page<Blog> searchByAuthorAndType(String author, Long categoryId, Pageable pageable);
}
