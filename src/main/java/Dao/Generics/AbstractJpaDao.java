package Dao.Generics;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> {
    private Class<T> clazz;
    private EntityManager entityManager;

    public AbstractJpaDao(EntityManager em){
        entityManager = em;
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional
    public T findOne(final int id) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }
    @Transactional
    public void create(final T entity) {
        entityManager.persist(entity);
    }
    @Transactional
    public T update(final T entity) {
        T result = entityManager.merge(entity);
        return result;
    }
    @Transactional
    public void delete(final T entity) {
        entityManager.remove(entity);
    }
    @Transactional
    public void deleteById(final int entityId) {
        final T entity = findOne(entityId);
        if(entity!=null)
            delete(entity);
    }

}
