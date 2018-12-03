package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.UserDao;
import com.codecool.mexicocity.model.User;

import java.util.List;

public class UserService {

    private UserDao userDao;


    public UserService(){
    }


    public void add(User user) {
        this.userDao.add(user);
    }

    public void remove(User user) {
        this.userDao.remove(user);
    }

    public void getUserById(Long id) {
        this.userDao.getUserById(id);
    }

    public List<User> getAllUser() {
        return this.userDao.getAllUser();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
