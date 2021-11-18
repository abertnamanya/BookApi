package com.thrustcare.spring.dao;

import com.thrustcare.spring.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    @Override
    public Book get(long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);

    }

    @Override
    public List<Book> list() {
        List<Book> bookList = sessionFactory.getCurrentSession().createQuery("from Book").list();
        return bookList;
    }

    @Override
    public void update(Book book, long id) {
        Session session = sessionFactory.getCurrentSession();
        Book oldBook = session.byId(Book.class).load(id);
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        session.flush();
    }

    @Override
    public void delete(long id) {

    }
}
