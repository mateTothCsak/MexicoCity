package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.util.TransactionHandler;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

public class RoosterDao extends BaseDao {


    public RoosterDao(EntityManagerFactory emf) {
        super(Rooster.class, emf);
    }

    public List<Rooster> getTopRoosters() {
        EntityManager em = emf.createEntityManager();
        String hql = "SELECT r FROM Rooster AS r ORDER BY wonMatches DESC";
        Query query = (Query) em.createQuery(hql);
        em.close();
        return query.list();

    }

    public void updateRoosterGold(Rooster rooster, int gold) {
        rooster.setGold(rooster.getGold() + gold);
        update(rooster);
    }

    public void updateExperience(Rooster rooster, int experience) {
        rooster.setExperience(rooster.getExperience()+experience);
        update(rooster);
    }


    public void updateLevel(Rooster rooster, int level) {
        rooster.setLevel(rooster.getLevel()+level);
        update(rooster);
    }

    public int getRoosterLevel(Rooster rooster) {
        return rooster.getLevel();
    }

    public int getRoosterExperience(Rooster rooster) {
        return rooster.getExperience();
    }


    public void setExperienceToZero(Rooster rooster) {
        rooster.setExperience(0);
        update(rooster);
    }

    public void updateImage(Rooster rooster) {
        String image = "resources/img/pipi"+rooster.getLevel()+ ".jpg";
        rooster.setImage(image);
        update(rooster);
    }


    public void updateRoosterWonMatches(Rooster rooster) {
        rooster.setWonMatches(rooster.getWonMatches()+1);
        update(rooster);
    }


    public void updateRoosterLostMatches(Rooster rooster) {
        rooster.setLostMatches(rooster.getLostMatches()+1);
        update(rooster);
    }


    public void updateRoosterWinRatio(Rooster rooster) {
        float totalMatches = rooster.getLostMatches() + rooster.getWonMatches();
        float ratio = rooster.getWonMatches()/totalMatches;
        rooster.setWinRatio((int) (ratio * 100));
        update(rooster);
    }



}
