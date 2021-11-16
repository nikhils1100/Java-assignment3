package Dao.Impl;

import Dao.Generics.AbstractJpaDao;
import Dao.IUserDao;
import model.User;

import javax.persistence.EntityManager;

public class UserDao extends AbstractJpaDao<User> implements IUserDao {
    public UserDao(EntityManager em){
        super(em);
        setClazz(User.class);
    }
}
