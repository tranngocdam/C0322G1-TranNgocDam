package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        this.iBlogRepository.deleteById(id);
    }

//    @Override
//    public List<Blog> getAllBlogByKeyword(String abc) {
//        return null;
//    }

//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return this.iBlogRepository.findAll(pageable);
//    }
}
