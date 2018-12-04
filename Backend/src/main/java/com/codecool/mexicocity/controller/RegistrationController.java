package com.codecool.mexicocity.controller;


import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.JsonHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class RegistrationController extends HttpServlet {
    RoosterService roosterService;
    UserService userService;
    EntityManagerFactory emf;


    public RegistrationController(EntityManagerFactory emf, RoosterService roosterService, UserService userService) {
        this.roosterService = roosterService;
        this.userService = userService;
        this.emf = emf;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectNode node = JsonHandler.getInstance().buildObjectFromJson(request);

        String email = node.get("email").textValue();
        String password = node.get("password").textValue();

        createProfile(emf, email, password);
    }



    public void createProfile(EntityManagerFactory emf, String email, String password){
        Rooster rooster = roosterService.createRooster(emf);
        userService.createUser(emf, email, password, rooster);
    }

}
