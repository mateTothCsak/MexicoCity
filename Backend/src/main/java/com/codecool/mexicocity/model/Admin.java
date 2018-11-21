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


    private List<Item> addItemsToFreeShop(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Item> items = new ArrayList<>();

        Item stick = new Item("Pimp Stick", "Nice pimp stick", 100, "image/pimpStick.jpg", Category.FEATHER);
        em.persist(stick);

        transaction.commit();
        items.add(stick);
        return items;
    }

    private void createShop(EntityManager em) {
        FreeShop freeShop = new FreeShop();
        freeShop.addShopItems(addItemsToFreeShop(em));
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
