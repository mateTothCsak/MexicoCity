package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.JsonHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
//@RequestMapping
public class IndexController extends HttpServlet {

    private UserService userService;

    @Autowired
    private IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showMain(){
        return "OK";
    }

    @PostMapping("/")
    public void registration(@RequestBody User user) throws IOException {
        System.out.println("[USER] " + user);
        userService.tryLogIn(user.getEmail(), user.getPassword());
    }

    /*
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

        userService.tryLogIn(enteredEmail, enteredPassword, response);

    }
    */
}