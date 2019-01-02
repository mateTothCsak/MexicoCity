package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.FightRepository;
import com.codecool.mexicocity.model.Fight;
import com.codecool.mexicocity.model.Quiz;
import com.codecool.mexicocity.model.Rooster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FightService {

    private FightRepository fightRepository;
    private RoosterService roosterService;

    public FightService(){ }

    @Autowired
    public FightService(FightRepository fightRepository, RoosterService roosterService) {
        this.fightRepository = fightRepository;
        this.roosterService = roosterService;
    }

    public void add(Fight fight) {
        this.fightRepository.save(fight);
    }

    public void remove(Fight fight) {
        this.fightRepository.delete(fight);
    }

    public void getFightById(Long id) {
        this.fightRepository.findById(id);
    }

    public List<Fight> getAllFight() {
        return this.fightRepository.findAll();
    }

    public List<Quiz> generateQuizes() {
        List<Quiz> quizzes = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            quizzes.add(new Quiz(i));
        }
        return quizzes;
    }

    public void endOfFightUpdate(Fight fight) throws Exception {
        int gold = fight.getGold();
        int experience = fight.getExperience();
        Rooster wonRooster = fight.getWonRooster();
        Rooster lostRooster = fight.getLostRooster();

        roosterService.updateRoosterGold(wonRooster, gold);
        roosterService.updateRoosterExperience(wonRooster,experience);
        roosterService.checkLevelUp(wonRooster);
        roosterService.updateWonMatches(wonRooster);

        roosterService.updateLostMatches(lostRooster);
    }



}
