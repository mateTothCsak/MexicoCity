package com.codecool.mexicocity.controller;


import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServlet;




@RestController
public class RegistrationController{
    RoosterService roosterService;
    UserService userService;

    @Autowired
    public RegistrationController(RoosterService roosterService, UserService userService) {
        this.roosterService = roosterService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String sendRegistration(@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();

        Rooster rooster = roosterService.createRooster();
        userService.createUser(email, password, rooster);
        return email + " was successfully registered";
    }


}

