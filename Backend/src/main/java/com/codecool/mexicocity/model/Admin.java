package com.codecool.mexicocity.model;

import com.codecool.mexicocity.controller.JettyServer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.startJettyServer();

        admin.createDBConnection();
    }


    private void startJettyServer(){
        JettyServer server = new JettyServer();
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private List<Item> initDatabase(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Item> items = new ArrayList<>();

        //Items:
        //PIMP

        Item stick = new Item("Pimp Stick", "Nice pimp stick", 1000, "image/pimpStick.jpg", Category.WEAPON);
        em.persist(stick);
        Item hat = new Item("Pimp Hat", "Beautiful pimp hat", 2500, "image/pimpHat.jpg", Category.HEADGEAR);
        em.persist(hat);
        Item fur = new Item("Pimp Fur", "Nice pimp warm coat", 1000, "image/pimpFur.jpg", Category.ARMOR);
        em.persist(fur);
        Item sealRing = new Item("Seal-Ring", "", 1000, "image/seal-ring.jpg", Category.RINGS);
        em.persist(sealRing);

        //Soldier

        Item helmet = new Item("Soldier helmet", "It is useful sometimes", 100, "image/soldierHelmet.jpg", Category.HEADGEAR);
        em.persist(helmet);
        Item kalasnikov = new Item("Soldier Kalasnikov", "Bumm Bumm", 1000, "image/kalasnikov.jpg", Category.WEAPON);
        em.persist(kalasnikov);
        Item vest = new Item("Soldier Vest", "Prrrotection 100", 450, "image/vest.jpg", Category.ARMOR);
        em.persist(vest);

        //Roosters

        Rooster rooster1 = new Rooster();
        em.persist(rooster1);
        Rooster rooster2 = new Rooster();
        em.persist(rooster2);
        Rooster rooster3 = new Rooster();
        em.persist(rooster3);
        Rooster rooster4 = new Rooster();
        em.persist(rooster4);

        //Users

        User tocsi = new User("tocsi","admin",rooster1);
        em.persist(tocsi);
        User mate = new User("mate","admin",rooster2);
        em.persist(mate);
        User henry = new User("henry","admin",rooster3);
        em.persist(henry);
        User stefan = new User("stefan","admin",rooster4);
        em.persist(stefan);

        transaction.commit();
        items.add(stick);
        return items;
    }

    private void createShop(EntityManager em) {
        FreeShop freeShop = new FreeShop();
        freeShop.addShopItems(initDatabase(em));
    }



    private void createDBConnection(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mexicocity");
        EntityManager em = emf.createEntityManager();

        createShop(em);
        em.clear();

        em.close();
        emf.close();
    }
}
