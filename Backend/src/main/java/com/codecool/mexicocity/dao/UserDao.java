package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.User;
import org.hibernate.query.Query;

import javax.persistence.*;


import java.util.List;

public class UserDao extends BaseDao {

    public UserDao(EntityManagerFactory emf) {
        super(User.class, emf);
    }


    public void updateUserPassword(User user, String password) {
        transaction.begin();
        user.setPassword(password);
        transaction.commit();
    }

    public void updateUserEmail(User user, String email) {
        transaction.begin();
        user.setEmail(email);
        transaction.commit();
    }


}
