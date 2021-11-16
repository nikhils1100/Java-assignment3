package Dao;

import model.Sales;

import java.util.List;

public interface ISalesDao {
    Sales findOne(int id);

    List<Sales> findAll();

    Sales update(Sales entity);

    void delete(Sales entity);

    void deleteById(int entityId);
}
