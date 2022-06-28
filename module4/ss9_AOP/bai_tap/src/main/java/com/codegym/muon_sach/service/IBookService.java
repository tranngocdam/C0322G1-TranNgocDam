package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);

    Book findById(Integer id);

    void save(Book book);
}
