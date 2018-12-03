package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.User;
import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"myprofile"})
public class MyProfileController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();

        Long id = Long.parseLong(request.getParameter("id"));
        User user = em.find(User.class, id);

        String userJsonString = JsonHandler.getInstance().jsonify(user);

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();

        out.print(userJsonString);
    }


}
