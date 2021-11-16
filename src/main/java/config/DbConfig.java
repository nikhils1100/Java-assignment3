package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConfig {
    public EntityManager getEntity(String tenant){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(tenant);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        return  em;
    }
}
