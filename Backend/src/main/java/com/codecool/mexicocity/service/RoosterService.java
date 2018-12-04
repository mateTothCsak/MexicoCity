package com.codecool.mexicocity.service;

import com.codecool.mexicocity.dao.RoosterDao;
import com.codecool.mexicocity.model.Rooster;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RoosterService {
    private RoosterDao roosterDao;

    public RoosterService(){ }


    public RoosterService(RoosterDao roosterDao) {
        this.roosterDao = roosterDao;
    }

    public void add(Rooster rooster) {
        this.roosterDao.add(rooster);
    }

    public void remove(Rooster rooster) {
        this.roosterDao.remove(rooster);
    }

    public void getRoosterById(Long id) {
        this.roosterDao.getObjectById(id);
    }

    public List<Rooster> getAllRooster() {
        return this.roosterDao.getAllObjects("Rooster");
    }

    public void setRoosterDao(RoosterDao roosterDao) {
        this.roosterDao = roosterDao;
    }



    public Rooster createRooster(EntityManagerFactory emf){
        Rooster rooster = new Rooster();
        RoosterDao roosterDao = new RoosterDao(emf);
        RoosterService roosterService = new RoosterService(roosterDao);
        roosterService.add(rooster);
        return rooster;
    }
}
