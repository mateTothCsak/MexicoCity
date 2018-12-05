package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.FightService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.util.JsonHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FightController extends HttpServlet {

    FightService fightService;
    RoosterService roosterService;

    public FightController(FightService fightService, RoosterService roosterService) {
        this.fightService = fightService;
        this.roosterService = roosterService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String jsonStringList = JsonHandler.getInstance().jsonifyList(fightService.generateFight());
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.print(jsonStringList);

    }

}
