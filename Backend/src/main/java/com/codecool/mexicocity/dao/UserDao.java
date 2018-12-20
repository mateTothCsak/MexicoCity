package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.*;


import java.util.List;

@Component
public class UserDao extends BaseDao {

    public UserDao(EntityManagerFactory emf) {
        super(User.class, emf);
    }


    public void updateUserPassword(User user, String password) {
        user.setPassword(password);
        update(user);
    }

    public void updateUserEmail(User user, String email) {
        user.setEmail(email);
        update(user);
    }


}
