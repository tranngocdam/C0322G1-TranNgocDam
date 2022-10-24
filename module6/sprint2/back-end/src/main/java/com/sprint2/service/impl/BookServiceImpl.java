package com.sprint2.service.impl;

import com.sprint2.model.Book;
import com.sprint2.repository.IBookRepository;
import com.sprint2.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllBook(Pageable pageable, String keyword) {
        return this.iBookRepository.findAllBook(pageable, keyword);
    }

//    @Override
//    public List<Book> findAllBook() {
//        return iBookRepository.findAllBook();
//    }

    @Override
    public void delete(Integer id) {
        iBookRepository.delete(id);
    }

    @Override
    public void saveBook(Book book) {
        iBookRepository.saveBook(book.getAmount(), book.getAuthor(), book.getCode(),
                book.getCreateDate(), book.getDescription(), book.getImage(), book.getName(),
                book.getNumberOfPage(), book.getPrice(), book.getSize(), book.getCategory(), book.getCompany(), book.getDiscount());
    }

    @Override
    public void updateBook(Book book) {
        iBookRepository.updateBook(book.getAmount(), book.getAuthor(), book.getCode(),
                book.getCreateDate(), book.getDescription(), book.getImage(), book.getName(),
                book.getNumberOfPage(), book.getPrice(), book.getSize(), book.getCategory(),
                book.getCompany(), book.getDiscount(), book.getId());
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findByIdBook(id);
    }

    @Override
    public Page<Book> findAllHistoryBook(Pageable pageable, Integer id) {
        return iBookRepository.findAllHistoryBook(pageable, id);
    }
}
