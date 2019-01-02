package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
//import com.codecool.mexicocity.service.PostgresDBDetailsService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManagerFactory;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
public class LoggedInMainPageController extends HttpServlet {

    private RoosterService roosterService;
    private UserService userService;

    @Autowired
    public LoggedInMainPageController(RoosterService roosterService, UserService userService) {
        this.roosterService = roosterService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public List<Rooster> loadUser() {
        List<Rooster> topRoosters = roosterService.getTopRoosters();
        return topRoosters;
    }


    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws UsernameNotFoundException {
        String email = user.getEmail();
        String password = user.getPassword();


        User userFound = userService.tryLogIn(email, password);
        if (userFound == null) {
            throw new UsernameNotFoundException("User was not found");
        }
        return userFound;
        // JWT token without session, by using header, provider Auth0
//        return detailsService.loadUserByUsername(email);
    }

}