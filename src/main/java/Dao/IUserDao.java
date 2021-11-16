package Dao;

import model.User;

import java.util.List;

public interface IUserDao {
    User findOne(int id);

    List<User> findAll();

    User update(User entity);

    void delete(User entity);

    void deleteById(int entityId);
}
