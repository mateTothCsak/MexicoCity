package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.UserRepository;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    public void createUser(String email, String name, String password, Rooster rooster) {
        User user = new User(email, name, password, rooster);
        add(user);
    }


    public User tryLogIn(String email, String password){
        User user = getUserByEmail(email);
        if(user != null){
            String realPassword = user.getPassword();
            String salt = user.getSalt();

            if(realPassword.equals(user.generateHash(password, salt))){
                return user;
            }
        }
        System.out.println("[TryLogIn] " + user);
        return null;
    }
}
