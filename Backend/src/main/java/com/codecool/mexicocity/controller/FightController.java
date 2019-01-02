package com.codecool.mexicocity.controller;

import com.codecool.mexicocity.model.Fight;
import com.codecool.mexicocity.model.Quiz;
import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.service.FightService;
import com.codecool.mexicocity.service.RoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class FightController {

    FightService fightService;
    RoosterService roosterService;

    @Autowired
    public FightController(FightService fightService, RoosterService roosterService) {
        this.fightService = fightService;
        this.roosterService = roosterService;
    }

    @GetMapping("/fight")
    public Fight loadFight(@RequestParam long roosterId) throws Exception {
        List<Quiz> quizes = fightService.generateQuizes();
        Rooster rooster = roosterService.getRoosterById(roosterId);
        Fight fight = new Fight(rooster, quizes);
        fightService.add(fight);
        return fight;
    }

    @PostMapping("/fight")
    public void sendFight(@RequestBody Fight fight) throws Exception {
        fightService.endOfFightUpdate(fight);
    }

}
