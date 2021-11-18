package com.thrustcare.spring.service;

import com.thrustcare.spring.model.Book;

import java.util.List;

public interface BookService {
    /* save thew record   */
    long save(Book book);
    /*  get a single record book   */
    Book get(long id);
    /* get all the records */
    List<Book> list();
    /* update the record */
    void update(Book book,long id);
    // delete record
    void delete(long id);
}
