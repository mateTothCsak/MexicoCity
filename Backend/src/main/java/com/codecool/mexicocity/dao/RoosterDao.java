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
        transaction.begin();
        rooster.setGold(rooster.getGold()+gold);
        transaction.commit();
    }

    public void updateExperience(Rooster rooster, int experience) {
        transaction.begin();
        rooster.setExperience(rooster.getExperience()+experience);
        transaction.commit();
    }


    public void updateLevel(Rooster rooster, int level) {
        transaction.begin();
        rooster.setLevel(rooster.getLevel()+level);
        transaction.commit();
    }

    public int getRoosterLevel(Rooster rooster) {
        return rooster.getLevel();
    }

    public int getRoosterExperience(Rooster rooster) {
        return rooster.getExperience();
    }


    public void setExperienceToZero(Rooster rooster) {
        transaction.begin();
        rooster.setExperience(0);
        transaction.commit();
    }

    public void updateImage(Rooster rooster) {
        transaction.begin();
        String image = "resources/img/pipi"+rooster.getLevel()+ ".jpg";
        rooster.setImage(image);
        transaction.commit();
    }


    public void updateRoosterWonMatches(Rooster rooster) {
        transaction.begin();
        rooster.setWonMatches(rooster.getWonMatches()+1);
        transaction.commit();
    }


    public void updateRoosterLostMatches(Rooster rooster) {
        transaction.begin();
        rooster.setLostMatches(rooster.getLostMatches()+1);
        transaction.commit();
    }


    public void updateRoosterWinRatio(Rooster rooster) {
        transaction.begin();
        rooster.setWinRatio(rooster.getWonMatches()/rooster.getLostMatches());
        transaction.commit();
    }



}
