package br.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
    
    public static EntityManager getConnection() {
        return emf.createEntityManager();
    }
    
}
