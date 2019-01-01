package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.UserDao;
import com.codecool.mexicocity.dao.UserRepository;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.util.JsonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {


    private UserRepository userRepository;

    public UserService(){ }

    @Autowired
    public UserService(UserRepository userDao) {
        this.userRepository = userDao;
    }

    public void add(User user) {
        this.userRepository.save(user);
    }

    public void remove(User user) {
        this.userRepository.delete(user);
    }

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public User getUserByEmail(String email){
        return (User) this.userRepository.findUserByEmail(email);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }


    public void createUser(String email, String password, Rooster rooster) {
        User user = new User(email, password, rooster);
        add(user);
    }

    public String tryLogIn(String enteredEmail, String enteredPassword) throws IOException {
        String userJsonString = "";
        User user = getUserByEmail(enteredEmail);
        if (user != null) {
            String realPassword = user.getPassword();
            String salt = user.getSalt();
            if (realPassword.equals(user.generateHash(enteredPassword, salt))) {
                userJsonString = JsonHandler.getInstance().jsonify(user);
            }
        }
        System.out.println("[TryLogIn] " + userJsonString);
        return userJsonString;
    }
}
