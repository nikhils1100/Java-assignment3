package Service.Impl;

import Dao.Impl.BookDao;
import model.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book input);

    void updateBook(Book input);

    List<Book> listBooks();

    Book getBookById(int id);

    void removeBookById(int id);

    void removeBook(Book book);

    void setBookDao(BookDao bookDao);
}
