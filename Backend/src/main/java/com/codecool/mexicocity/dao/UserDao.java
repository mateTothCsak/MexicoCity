package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.User;
import org.hibernate.query.Query;

import javax.persistence.*;


import java.util.List;

public class UserDao {

//    @PersistenceContext(unitName = "player")
    private EntityManagerFactory emf;


    public UserDao(EntityManagerFactory emf) {
        this.emf = emf;
    }


    public void add(User user){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(user);

        transaction.commit();
        em.close();
    }


//    public void remove(User user) {
//        transaction.begin();
//        entityManager.remove(user);
//        transaction.commit();
//        entityManager.close();
//    }
//
//    public User getUserById(Long id) {
//        transaction.begin();
//        User user = entityManager.find(User.class,id);
//        transaction.commit();
//        entityManager.close();
//        return user;
//    }
//
//    public List<User> getAllUser() {
//        transaction.begin();
//        String hql = "SELECT p FROM User AS p";
//        Query query = (Query) entityManager.createQuery(hql);
//        List users = query.list();
//        return users;
//    }

//
//    public void updateUserPassword(User user, String pw) {
//        user.setPassword(pw);
//    }
//
//    public void updateUserEmail(User user, String email) {
//        transaction.begin();
//        user.setEmail(email);
//        transaction.commit();
//    }


}
