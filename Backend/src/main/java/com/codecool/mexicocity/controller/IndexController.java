package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.io.IOException;


@RestController
public class IndexController extends HttpServlet {

    private UserService userService;

    @Autowired
    private IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loadMain(){
        return "OK";
    }

    @PostMapping("/")
    public void sendLogIn(@RequestBody User user) throws IOException {
        System.out.println("[USER] " + user);
        userService.tryLogIn(user.getEmail(), user.getPassword());
    }

}