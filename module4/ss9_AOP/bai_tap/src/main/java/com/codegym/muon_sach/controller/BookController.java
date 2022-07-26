package com.codegym.muon_sach.controller;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.DetailBook;
import com.codegym.muon_sach.service.IBookService;
import com.codegym.muon_sach.service.IDetailBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IDetailBookService iDetailBookService;

    @GetMapping("")
    public ModelAndView showBooks(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("list", "books", iBookService.findAll(pageable));
    }
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "book", new Book());
    }

    @PostMapping("/create")
    public ModelAndView create(Book book, @PageableDefault(value = 3) Pageable pageable) {
        iBookService.save(book);
        return new ModelAndView("list", "books", iBookService.findAll(pageable));

    }

    @GetMapping("/bookrental/{id}")
    public ModelAndView borrowBooks(@PathVariable Integer id) {
        Book book = iBookService.findById(id);
        if (book.getQuantity() > 0) {
            Optional<DetailBook> detailBookOptional;
            long code;
            do {
                code = (long) (Math.random() * 1000);
                detailBookOptional = iDetailBookService.findByCode(code);

            } while (detailBookOptional.isPresent());

            book.setQuantity(book.getQuantity() - 1);
            iBookService.save(book);
            DetailBook detailBook = new DetailBook();
            detailBook.setBook(book);
            detailBook.setCode(code);
            iDetailBookService.save(detailBook);
            ModelAndView modelAndView = new ModelAndView("book");
            modelAndView.addObject("code", code);
            return modelAndView;
        } else {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/returnbook")
    public ModelAndView returnBook() {
        return new ModelAndView("return_book");
    }

    @PostMapping("/returnbook")
    public ModelAndView returnBook(@RequestParam String code) {
        Long codeBook = Long.parseLong(code);
        Optional<DetailBook> detailBook = iDetailBookService.findByCode(codeBook);
        if (detailBook.isPresent()) {
            int quantity = detailBook.get().getBook().getQuantity();
            detailBook.get().getBook().setQuantity(quantity + 1);
            iDetailBookService.deleteByCode(codeBook);
            return new ModelAndView("book", "code", false);
        } else {
            return new ModelAndView("error");
        }
    }
}
