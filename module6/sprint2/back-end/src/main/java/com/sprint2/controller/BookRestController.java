package com.sprint2.controller;

import com.sprint2.model.Book;
import com.sprint2.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public/api/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookRestController {
    @Autowired
    private IBookService iBookService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Book>> findAllBook() {
//        List<Book> bookList = iBookService.findAllBook();
//        if (bookList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(bookList, HttpStatus.OK);
//    }
        @GetMapping("/list")
    public ResponseEntity<List<Book>> findAllBook() {
        List<Book> bookPage = iBookService.findAllBook();
        if (bookPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        iBookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<FieldError> saveBook(@RequestBody Book book) {
        this.iBookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody Book book){
        this.iBookService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
