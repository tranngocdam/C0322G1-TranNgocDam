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
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void saveOrUpdate(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllByAuthorContaining(String keyword, Pageable pageable) {
        return iBlogRepository.findAllByAuthorContaining(keyword, pageable);
    }

    @Override
    public Page<Blog> searchByAuthorAndType(String author, Long categoryId, Pageable pageable) {
        return iBlogRepository.searchByAuthorAndType("%"+author+"%", categoryId, pageable);
    }
}
