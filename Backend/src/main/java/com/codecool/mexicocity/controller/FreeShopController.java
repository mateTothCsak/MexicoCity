package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManager;
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

@WebServlet(urlPatterns = {"/freeshop"})
public class FreeShopController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = MyEntityManager.getInstance().getEm();

        String hql = "SELECT i FROM Item AS i ORDER BY category ASC";
        Query query = (Query) em.createQuery(hql);
        List items = query.list();

        String jsonStringList = JsonHandler.getInstance().jsonifyList(items);
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.print(jsonStringList);
    }

}
