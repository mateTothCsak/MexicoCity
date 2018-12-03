package com.codecool.mexicocity.model;

import com.codecool.mexicocity.controller.*;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.MyEntityManager;

import com.codecool.mexicocity.util.MyEntityManager;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    public static void main(String[] args) {
        Admin admin = new Admin();
        //admin.createDBConnection();
        EntityManager em = MyEntityManager.getInstance().getEm();

        admin.createShop(em);
        em.clear();

        admin.startJettyServer();
        //em.close();

    }


    private void startJettyServer(){
        //JettyServer server = new JettyServer();
        Server server = new Server(8090);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(IndexController.class, "/");
        handler.addServlet(LoggedInMainPageController.class, "/home");
        handler.addServlet(FreeShopController.class, "/freeshop");
        handler.addServlet(MyProfileController.class, "/myprofile");
        handler.addServlet(RegistrationController.class, "/register");


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

        createNewUser(em, "tocsi", "admin1");
        createNewUser(em, "stefan", "admin2");
        createNewUser(em, "henry", "admin3");
        createNewUser(em, "mate", "admin4");

        transaction.commit();
        items.add(stick);
        return items;
    }

    private void createShop(EntityManager em) {
        FreeShop freeShop = new FreeShop();
        freeShop.addShopItems(initDatabase(em));
    }



    private void createDBConnection(){
        EntityManager em = MyEntityManager.getInstance().getEm();

        createShop(em);

        em.clear();

        em.close();
    }

    public void createNewUser(EntityManager entityManager, String email, String password){
        Rooster rooster = new Rooster();
        entityManager.persist(rooster);
        User user = new User(email, password, rooster);
        UserService userService = new UserService();
        userService.add(user);
        entityManager.persist(user);
    }
}
