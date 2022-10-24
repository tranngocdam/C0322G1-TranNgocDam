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
import java.util.Optional;

@RestController
@RequestMapping("/api/public/api/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookRestController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> findAllBook(@PageableDefault(value = 6) Pageable pageable,
                                                  @RequestParam Optional<String> keyword) {
        Page<Book> book= iBookService.findAllBook(pageable, keyword.orElse(""));
        if (book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
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
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        this.iBookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findByIdBook(@PathVariable Integer id){
            Book book = iBookService.findById(id);
            if (book == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping("/history/{id}")
    public ResponseEntity<Page<Book>> findAllHistoryBook(@PageableDefault(value = 9) Pageable pageable, @PathVariable Integer id){
        Page<Book> bookPage = iBookService.findAllHistoryBook(pageable, id);
        if (bookPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }
}
