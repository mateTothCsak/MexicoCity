package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.UserDao;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserService {

    private UserDao userDao;


    public UserService(){ }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        this.userDao.add(user);
    }

    public void remove(User user) {
        this.userDao.remove(user);
    }

    public void getUserById(Long id) {
        this.userDao.getObjectById(id);
    }

    public List<User> getAllUser() {
        return this.userDao.getAllObjects("User");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(EntityManagerFactory emf, String email, String password, Rooster rooster) {
        User user = new User(email, password, rooster);
        UserDao userDao = new UserDao(emf);
        UserService userService = new UserService(userDao);
        userService.add(user);
    }
}
