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

    public Rooster getRoosterById(Long id) {
        return (Rooster) this.roosterDao.getObjectById(id);
    }

    public List<Rooster> getAllRooster() {
        return this.roosterDao.getAllObjects("Rooster");
    }

    public Rooster createRooster(){
        Rooster rooster = new Rooster();
        add(rooster);
        return rooster;
    }

    public List<Rooster> getTopRoosters() {
        return this.roosterDao.getTopRoosters();
    }
}
