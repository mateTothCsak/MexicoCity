package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.FightDao;
import com.codecool.mexicocity.dao.FightRepository;
import com.codecool.mexicocity.model.Fight;
import com.codecool.mexicocity.model.Quiz;

import java.util.ArrayList;
import java.util.List;

public class FightService {

    private FightRepository fightRepository;

    public FightService(){ }

    public FightService(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
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

    public List<Quiz> generateFight() {
        List<Quiz> quizzes = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            quizzes.add(new Quiz(i));
        }
        return quizzes;
    }



}
