package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManagerFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoggedInMainPageController extends HttpServlet {

    private RoosterService roosterService;

    public LoggedInMainPageController(RoosterService roosterService) {
        this.roosterService = roosterService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Rooster> topRoosters = roosterService.getTopRoosters();

        String jsonStringList = JsonHandler.getInstance().jsonifyList(topRoosters);
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        response.setHeader("Access-Control-Allow-Origin", "*");
        out.print(jsonStringList);
    }

}
