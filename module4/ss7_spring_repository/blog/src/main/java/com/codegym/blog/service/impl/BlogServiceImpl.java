package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
//        this.iBlogRepository.saveBlog(blog.getTitle(),blog.getAuthor(),  blog.getDayStart(), blog.getCategory().getId());
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findTitle(String title, Pageable pageable) {
        return iBlogRepository.findTitleBlog(title, pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }


}
