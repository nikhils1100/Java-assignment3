package Service.Impl;

import Dao.Impl.BookDao;
import model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {


    private BookDao bookDao;

    @Override
    public void addBook(Book input) {
        bookDao.create(input);
    }

    @Override
    public void updateBook(Book input) {
        bookDao.update(input);
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.findOne(id);
    }

    @Override
    public void removeBookById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public void removeBook(Book book){
        bookDao.delete(book);
    }

    @Override
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
