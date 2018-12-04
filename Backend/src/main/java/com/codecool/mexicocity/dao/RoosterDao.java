package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Rooster;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.util.List;

public class RoosterDao {

    private EntityManagerFactory emf;
    private EntityTransaction transaction;


    public RoosterDao(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        this.emf = emf;
        this.transaction = em.getTransaction();
    }


    public void add(Rooster rooster){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(rooster);
        transaction.commit();
        em.close();
    }
//
//    public void remove(Rooster rooster) {
//        transaction.begin();
//        entityManager.remove(rooster);
//        transaction.commit();
//        entityManager.close();
//    }
//
//    public Rooster getRoosterById(Long id) {
//        transaction.begin();
//        Rooster user = entityManager.find(Rooster.class,id);
//        transaction.commit();
//        entityManager.close();
//        return user;
//    }
//
//    public List<Rooster> getAllRooster() {
//        transaction.begin();
//        String hql = "SELECT r FROM Rooster AS r";
//        Query query = (Query) entityManager.createQuery(hql);
//        List roosters = query.list();
//        return roosters;
//    }


}
