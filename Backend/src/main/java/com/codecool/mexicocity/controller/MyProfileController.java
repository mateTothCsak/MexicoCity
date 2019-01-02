package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.Optional;

@RestController
public class MyProfileController extends HttpServlet {

    private UserService userService;

    @Autowired
    public MyProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/myprofile")
    public Optional<User> loadProfile(@RequestParam Long id){
        Optional<User> theUser = userService.getUserById(id);
        return theUser;
    }


}
