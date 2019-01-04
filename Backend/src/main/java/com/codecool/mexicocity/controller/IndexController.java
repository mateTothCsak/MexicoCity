package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    private UserService userService;

    @Autowired
    private IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loadMain(){
        return "Welcome to MexicoCity";
    }

    @PostMapping("/")
    public String sendLogIn(@RequestBody User user) {
        System.out.println("[USER] " + user.getEmail() + " " + user.getPassword());

        User loginUser = userService.tryLogIn(user.getEmail(), user.getPassword());

        if (loginUser != null){
            return "Welcome " + user.getName();
        }
        else {
            return "LogIn failed";
        }
    }

}