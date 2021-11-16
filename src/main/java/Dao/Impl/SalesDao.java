package Dao.Impl;

import Dao.Generics.AbstractJpaDao;
import Dao.ISalesDao;
import model.Sales;

import javax.persistence.EntityManager;

public class SalesDao extends AbstractJpaDao<Sales> implements ISalesDao {
    public SalesDao(EntityManager em){
        super(em);
        setClazz(Sales.class);
    }
}
