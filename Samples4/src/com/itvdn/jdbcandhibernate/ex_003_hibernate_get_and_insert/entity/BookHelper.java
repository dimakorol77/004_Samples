package com.itvdn.jdbcandhibernate.ex_003_hibernate_get_and_insert.entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList(){
        Session session = sessionFactory.openSession();

        Criteria cb = session.createCriteria(Book.class);

        List<Book> bookList = cb.list();

        session.close();

        return bookList;
    }

    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id);
        return book;
    }

    public Book addBook(Book book){

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();

        session.close();

        return book;


    }
}
