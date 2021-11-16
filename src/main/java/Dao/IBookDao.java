package Dao;

import model.Book;

import java.util.List;

public interface IBookDao {
    Book findOne(int id);

    List<Book> findAll();

    Book update(Book entity);

    void delete(Book entity);

    void deleteById(int entityId);

}
