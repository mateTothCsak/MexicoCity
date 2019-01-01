package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Fight;
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

        String fightJsonString = JsonHandler.getInstance().jsonify(new Fight());

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.print(fightJsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ObjectNode node = JsonHandler.getInstance().buildObjectFromJson(request);

        Fight fight = (Fight) JsonHandler.getInstance().objectFromJson(node.toString(), Fight.class);
        fightService.add(fight);

        int gold = node.get("gold").intValue();
        int experience = node.get("experience").intValue();

        String wonRoosterJson = node.get("wonRooster").toString();

        Rooster wonRooster = (Rooster) JsonHandler.getInstance().objectFromJson(wonRoosterJson,Rooster.class);
/*
        roosterService.updateRoosterGold(wonRooster,gold);
        roosterService.updateRoosterExperience(wonRooster,experience);

        roosterService.checkLevelUp(wonRooster);
        roosterService.updateWonMatches(wonRooster);

        String lostRoosterJson = node.get("lostRooster").toString();

        Rooster lostRooster = (Rooster) JsonHandler.getInstance().objectFromJson(lostRoosterJson,Rooster.class);

        roosterService.updateLostMatches(lostRooster);
*/

    }


}
