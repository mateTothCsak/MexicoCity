package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.util.TransactionHandler;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class BaseDao<T> {

    protected EntityManagerFactory emf;
    protected EntityTransaction transaction;

    Class<T> classType;

    BaseDao (Class<T> classType, EntityManagerFactory emf) {
        this.classType = classType;
        this.emf = emf;
        this.transaction = emf.createEntityManager().getTransaction();
    }

    public void add(T object){
        TransactionHandler.handleTransactionVoid(em -> em.persist(object));
    }

    public void remove(T object){ TransactionHandler.handleTransactionVoid(em -> em.remove(object)); }

    public List<Object> getAllObjects(String entityName) {
        EntityManager em = emf.createEntityManager();
        transaction.begin();
        String hql = "SELECT p FROM " + entityName + " AS p";
        Query query = (Query) em.createQuery(hql);
        List objects = query.list();
        transaction.commit();
        em.close();
        return objects;
    }

    public Object getObjectById(Long id) {
        EntityManager em = emf.createEntityManager();
        transaction.begin();
        Object object = em.find(classType, id);
        transaction.commit();
        em.close();
        return object;
    }


}
