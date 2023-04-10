package com.itvdn.jdbcandhibernate.ex_003_hibernate_get_and_insert.entity;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        String[] names = {"Zelenskiy1", "Zaluzhniy1", "Shevchenko1"};

        for (String name : names) {
            Author author = new Author();
            author.setName(name);
            ah.addAuthor(author);
        }

        Author author = new Author();
        author.setName("Mazepa");
        ah.addAuthor(author);

        BookHelper bh = new BookHelper();
        Book book1 = new Book();
        book1.setName("Rusalochka");
        book1.setAuthor(ah.getAuthorById(1));
        bh.addBook(book1);

        Book book2 = new Book();
        book2.setName("kolobok");
        book2.setAuthor(ah.getAuthorById(2));
        bh.addBook(book2);

        List<Book> bookList = bh.getBookList();
        for (Book book : bookList) {
            System.out.println(book.getId() + " " + " " + book.getAuthor().getName());
        }


    }
}