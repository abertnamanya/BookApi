package com.thrustcare.spring.controller;

import com.thrustcare.spring.model.Book;
import com.thrustcare.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    //get all the books
    @GetMapping(name = "/api/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> list = bookService.list();
        return ResponseEntity.ok().body(list);
    }

    //save the book record
    @PostMapping("/api/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        long id = bookService.save(book);
        return ResponseEntity.ok().body("Book created with id" + id);
    }

    //get a single record
    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") long id) {
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    //update the book record
    @PutMapping("/api/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
        bookService.update(book, id);
        return ResponseEntity.ok().body("Book has been updated");
    }
}
