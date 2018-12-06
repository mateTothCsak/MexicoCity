package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.UserDao;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.util.Globals;
import com.codecool.mexicocity.util.JsonHandler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public User getUserById(Long id) {
        return (User) this.userDao.getObjectById(id);
    }

    public User getUserByEmail(String email){
        return (User) this.userDao.getObjectByField(User.class, "email", email);
    }

    public List<User> getAllUser() {
        return this.userDao.getAllObjects("User");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(String email, String password, Rooster rooster) {
        User user = new User(email, password, rooster);
        add(user);
    }

    public void tryLogIn(String enteredEmail, String enteredPassword, HttpServletResponse response) throws IOException {
        if(getUserByEmail(enteredEmail) != null) {
            User user = getUserByEmail(enteredEmail);
            String realPassword = user.getPassword();
            String salt = user.getSalt();

            if (realPassword.equals(user.generateHash(enteredPassword, salt))) {
                String userJsonString = JsonHandler.getInstance().jsonify(user);
                response.setContentType("application/json;charset=UTF-8");
                ServletOutputStream out = response.getOutputStream();
                out.print(userJsonString);
            } else {
                System.out.println("Email does not exist or wrong password");
                ServletOutputStream out = response.getOutputStream();
                out.print("");
            }
        } else {
            System.out.println("Email does not exist or wrong password");
            ServletOutputStream out = response.getOutputStream();
            out.print("");
        }
    }
}
