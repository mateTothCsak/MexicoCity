package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.RoosterAndUserName;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.Optional;

@RestController
public class MyProfileController {

    private UserService userService;
    private RoosterService roosterService;

    @Autowired
    public MyProfileController(UserService userService, RoosterService roosterService) {
        this.userService = userService;
        this.roosterService = roosterService;
    }

    @GetMapping("/myprofile")
    public RoosterAndUserName loadProfile(@RequestParam Long id) throws Exception {
        String theUser = userService.getUserById(id).get().getName();
        Rooster theRooster = roosterService.getRoosterById(id);
        RoosterAndUserName roosterAndUserName = new RoosterAndUserName(theRooster, theUser);
        return roosterAndUserName;
    }


}
