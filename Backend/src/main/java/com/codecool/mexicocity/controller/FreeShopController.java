package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.util.JsonHandler;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FreeShopController extends HttpServlet {

    private ItemService itemService;

    public FreeShopController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List items = itemService.getAllItem();

        String jsonStringList = JsonHandler.getInstance().jsonifyList(items);
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.print(jsonStringList);
    }

}
