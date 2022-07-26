package com.codegym.muon_sach.service.impl;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.DetailBook;
import com.codegym.muon_sach.repository.IBookRepository;
import com.codegym.muon_sach.repository.IDetailBookRepository;
import com.codegym.muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }
}
