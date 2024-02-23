package dao;

import java.util.List;

import domain.Book;

public interface BookDao {

    void create(Book book);
    Book readById(int id);
    List<Book> readAll();
    void update(Book book);
    void delete(Book book);
}
