package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Admin;
import com.codecool.mexicocity.util.JsonHandler;
import com.codecool.mexicocity.util.MyEntityManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"register"})
public class RegistrationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        String jsonstring = sb.toString();

        final ObjectNode node = new ObjectMapper().readValue(jsonstring, ObjectNode.class);
        String email = node.get("email").textValue();
        String password = node.get("password").textValue();






        EntityManager em = MyEntityManager.getInstance().getEm();
        EntityTransaction transaction = em.getTransaction();
        Admin admin = new Admin();
        transaction.begin();
        admin.createNewUser(em, email, password);
        transaction.commit();

    }

}
