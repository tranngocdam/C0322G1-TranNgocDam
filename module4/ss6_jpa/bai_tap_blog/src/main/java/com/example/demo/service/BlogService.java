package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAllBlog();
    }

    @Override
    public Blog findById(Integer id) {
//        return iBlogRepository.findById(id).orElse(null);
        return iBlogRepository.findByIdBlog(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.saveBlog(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
