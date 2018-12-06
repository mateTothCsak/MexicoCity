package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Item;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.util.JsonHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
    private RoosterService roosterService;

    public FreeShopController(ItemService itemService, RoosterService roosterService) {
        this.itemService = itemService;
        this.roosterService = roosterService;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectNode node = JsonHandler.getInstance().buildObjectFromJson(request);

        String itemJson = node.get("item").toString();
        String roosterJson = node.get("rooster").toString();

        Item item = (Item) JsonHandler.getInstance().objectFromJson(itemJson, Item.class);
        Rooster rooster = (Rooster) JsonHandler.getInstance().objectFromJson(roosterJson, Rooster.class);

        roosterService.buyItem(rooster, item);
    }

}
