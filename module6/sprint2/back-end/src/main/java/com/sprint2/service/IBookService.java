package com.sprint2.service;

import com.sprint2.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {

//    List<Book> findAllBook();

    Page<Book> findAllBook(Pageable pageable, String keyword);

    void delete(Integer id);

    void saveBook(Book book);

    void updateBook(Book book);

    Book findById(Integer id);

    Page<Book> findAllHistoryBook(Pageable pageable, Integer id);
}
