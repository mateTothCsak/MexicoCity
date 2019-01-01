package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManagerFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class MyProfileController extends HttpServlet {

    private UserService userService;

    public MyProfileController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Long id = Long.parseLong(request.getParameter("id"));
        Optional<User> user = userService.getUserById(id);
        System.out.println(user);
        String userJsonString = JsonHandler.getInstance().jsonify(user);

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();

        out.print(userJsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


}
