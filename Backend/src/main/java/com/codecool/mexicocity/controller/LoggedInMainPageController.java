package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.util.JasonHandler;
import com.codecool.mexicocity.util.MyEntityManager;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home"})
public class LoggedInMainPageController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = MyEntityManager.getInstance().getEm();
        long id = Long.parseLong(request.getParameter("id"));
        Rooster rooster = em.find(Rooster.class, id);

        System.out.println(rooster.toString());


        String jsonString = JasonHandler.getInstance().jsonify(rooster);


        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.print(jsonString);
    }
}
