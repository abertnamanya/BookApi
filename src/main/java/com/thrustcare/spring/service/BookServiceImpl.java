package com.thrustcare.spring.service;

import com.thrustcare.spring.dao.BookDAO;
import com.thrustcare.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public long save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    @Transactional
    public Book get(long id) {
        return bookDAO.get(id);
    }

    @Override
    @Transactional
    public List<Book> list() {
        return bookDAO.list();
    }

    @Override
    @Transactional
    public void update(Book book, long id) {
        bookDAO.update(book, id);
    }

    @Override
    public void delete(long id) {

    }
}
