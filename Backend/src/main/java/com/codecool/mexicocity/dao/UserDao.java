package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.User;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDao {

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public UserDao(EntityManager entityManager, EntityTransaction transaction) {
        this.entityManager = entityManager;
        this.transaction = transaction;
    }

    public void add(User user){
//        transaction.begin();
        entityManager.persist(user);
//        transaction.commit();
//        entityManager.close();
    }

    public void remove(User user) {
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
        entityManager.close();
    }

    public User getUserById(Long id) {
        transaction.begin();
        User user = entityManager.find(User.class,id);
        transaction.commit();
        entityManager.close();
        return user;
    }

    public List<User> getAllUser() {
        transaction.begin();
        String hql = "SELECT p FROM User AS p";
        Query query = (Query) entityManager.createQuery(hql);
        List users = query.list();
        return users;
    }


    public void updateUserPassword(User user, String pw) {
        user.setPassword(pw);
    }

    public void updateUserEmail(User user, String email) {
        transaction.begin();
        user.setEmail(email);
        transaction.commit();
    }


}
