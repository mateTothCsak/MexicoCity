package com.codecool.mexicocity.model;

import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    RoosterService roosterService;
    UserService userService;


    public Admin() {
        this.roosterService = new RoosterService();
        this.userService = new UserService();
    }



    private List<Item> initDatabase(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();

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


        //Users


//        transaction.commit();
        items.add(stick);
        return items;
    }

    private void createShop(EntityManager em) {
        FreeShop freeShop = new FreeShop();
        freeShop.addShopItems(initDatabase(em));
    }


}
