package com.codecool.mexicocity.controller;


import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class RegistrationController{
    private RoosterService roosterService;
    private UserService userService;

    @Autowired
    public RegistrationController(RoosterService roosterService, UserService userService) {
        this.roosterService = roosterService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String sendRegistration(@RequestBody User user){
        String email = user.getEmail();
        String name = user.getName();
        String password = user.getPassword();

        if (userService.checkForExistingEmail(user)){
            return "Email: " + user.getEmail() + " already exists";
        } else if (userService.checkForExistingName(user)){
            return "User name: " + user.getName() + "already exists";
        }

        Rooster rooster = roosterService.createRooster();
        userService.createUser(email, name, password, rooster);
        return name + " was successfully registered";
    }


}

