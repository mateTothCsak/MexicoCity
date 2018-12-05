package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.dao.UserDao;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManagerFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IndexController extends HttpServlet {
    UserService userService;

    // For some reason this will be implemented, no matter if we pass in arguments
    public IndexController(){
        this.userService = new UserService(new UserDao(MyEntityManagerFactory.getInstance()));
    }

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().println("{ \"status\": \"ok\"}");
        response.getWriter().println("Home Page \n Info about the site \n Images");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectNode node = JsonHandler.getInstance().buildObjectFromJson(request);

        String enteredEmail = node.get("email").textValue();
        String enteredPassword = node.get("password").textValue();

        User user = userService.getUserByEmail(enteredEmail);
        String realPassword = user.getPassword();

    }
}