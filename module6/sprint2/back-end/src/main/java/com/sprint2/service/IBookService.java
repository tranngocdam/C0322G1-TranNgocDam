package com.sprint2.service;

import com.sprint2.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAllBook();

    void delete(Integer id);

    void saveBook(Book book);

    void updateBook(Integer id, Book book);
}
