package com.codecool.mexicocity.model;

import com.codecool.mexicocity.controller.IndexController;
import com.codecool.mexicocity.controller.JettyServer;
import com.codecool.mexicocity.controller.LoggedInMainPageController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.createDBConnection();
        admin.startJettyServer();


    }


    private void startJettyServer(){
        //JettyServer server = new JettyServer();
        Server server = new Server(8090);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(IndexController.class, "/");
        handler.addServlet(LoggedInMainPageController.class, "/home");
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


        //Users

        createNewUser(em, "tocsi", "admin");
        createNewUser(em, "stefan", "admin");
        createNewUser(em, "henry", "admin");
        createNewUser(em, "mate", "admin");

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

    public void createNewUser(EntityManager entityManager, String email, String password){
        Rooster rooster = new Rooster();
        entityManager.persist(rooster);
        User user = new User(email, password, rooster);
        entityManager.persist(user);
    }
}
