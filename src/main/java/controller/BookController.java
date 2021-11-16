package controller;

import Dao.Impl.BookDao;
import Service.Impl.BookService;
import config.DbConfig;
import config.MultiTenantManager;
import model.Book;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;


@RestController
public class BookController {
    private BookDao bookDao;
    private BookService bookService;

    public BookController(){}

    public BookController(BookDao inputBookDao, BookService inputBookService){
        this.bookDao = inputBookDao;
        this.bookService = inputBookService;
    }

    @GetMapping("/{env}")
    public String connectToDb(@PathVariable String env) {
        try {
            String tenantStr = "tenant_book_" + env;
            StringBuilder responseStr = new StringBuilder();
            EntityManager em = new DbConfig().getEntity(tenantStr);
            this.bookService = new BookService();
            bookService.setBookDao(new BookDao(em));

            for(Book b :bookService.listBooks()){
                responseStr.append(b.bookId + " |" + b.bookName + " |" +b.author + System.lineSeparator());
            }
            System.out.println(responseStr.toString());

            return responseStr.toString();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Failure";
        }
    }
}
