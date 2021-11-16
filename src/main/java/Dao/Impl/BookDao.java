package Dao.Impl;

import Dao.Generics.AbstractJpaDao;
import Dao.IBookDao;
import model.Book;

import javax.persistence.EntityManager;

public class BookDao extends AbstractJpaDao<Book> implements IBookDao {
    public BookDao(EntityManager em){
        super(em);
        setClazz(Book.class);
    }
}
