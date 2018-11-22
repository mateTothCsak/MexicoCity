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


    private List<Item> addItemsToFreeShop(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Item> items = new ArrayList<>();

        Item stick = new Item("Pimp Stick", "Nice pimp stick", 100, "image/pimpStick.jpg", Category.FEATHER);
        em.persist(stick);

        Rooster rooster = new Rooster();
        em.persist(rooster);

        User user = new User("admin","admin",rooster);
        em.persist(user);

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
