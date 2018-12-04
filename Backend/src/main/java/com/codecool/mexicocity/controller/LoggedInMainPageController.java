package com.codecool.mexicocity.controller;

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

@WebServlet(urlPatterns = {"/home"})
public class LoggedInMainPageController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = MyEntityManagerFactory.getInstance().createEntityManager();

        //long id = Long.parseLong(request.getParameter("id"));
        //Rooster rooster = em.find(Rooster.class, id);

        String hql = "SELECT r FROM Rooster AS r ORDER BY wonMatches DESC";
        Query query = (Query) em.createQuery(hql);
        List roosters = query.list();


        //String jsonString = JsonHandler.getInstance().jsonify(rooster);

        String jsonStringList = JsonHandler.getInstance().jsonifyList(roosters);
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        response.setHeader("Access-Control-Allow-Origin", "*");
        out.print(jsonStringList);
    }

}
