package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.FightDao;
import com.codecool.mexicocity.model.Fight;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class FightService {

    private FightDao fightDao;

    public FightService(){ }

    public FightService(FightDao fightDao) {
        this.fightDao = fightDao;
    }

    public void add(Fight fight) {
        this.fightDao.add(fight);
    }

    public void remove(Fight fight) {
        this.fightDao.remove(fight);
    }

    public void getFightById(Long id) {
        this.fightDao.getObjectById(id);
    }

    public List<Fight> getAllFight() {
        return this.fightDao.getAllObjects("Fight");
    }

    public void setFightDao(FightDao fightDao) {
        this.fightDao = fightDao;
    }

    public void saveFight(EntityManagerFactory emf, Fight fight){
        FightDao fightDao = new FightDao(emf);
        FightService fightService = new FightService(fightDao);
        fightService.add(fight);
    }

}
