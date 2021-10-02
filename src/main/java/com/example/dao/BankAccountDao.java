package com.example.dao;


import com.example.entity.BankAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BankAccountDao {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("my");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BankAccount create(BankAccount bankAccount) {

        EntityManager em = null;
        
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // persist object into DB
            em.persist(bankAccount);

            em.getTransaction().commit();
            
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
        
        return bankAccount;
    }

}
