package com.codecool.mexicocity;


import com.codecool.mexicocity.controller.*;
import com.codecool.mexicocity.dao.FightDao;
import com.codecool.mexicocity.dao.ItemDao;
import com.codecool.mexicocity.dao.RoosterDao;
import com.codecool.mexicocity.dao.UserDao;
import com.codecool.mexicocity.service.FightService;
import com.codecool.mexicocity.util.InitializeShop;
import com.codecool.mexicocity.service.ItemService;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.MyEntityManagerFactory;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Application implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory emf = MyEntityManagerFactory.getInstance();

        RoosterService roosterService = new RoosterService(new RoosterDao(emf));
        UserService userService = new UserService(new UserDao(emf));
        ItemService itemService = new ItemService(new ItemDao(emf));
        FightService fightService = new FightService(new FightDao(emf));

        //Shop fill up
        InitializeShop initializeShop = new InitializeShop(roosterService, userService , itemService);
        initializeShop.initDatabase();

        ServletContext context = sce.getServletContext();
        context.addServlet("Index", new IndexController(userService)).addMapping("/");
        context.addServlet("LoggedInHome", new LoggedInMainPageController()).addMapping("/home");
        context.addServlet("MyProfile", new MyProfileController()).addMapping("/myprofile");
        context.addServlet("FreeShop", new FreeShopController(itemService, emf)).addMapping("/shop");
        context.addServlet("Registration", new RegistrationController(roosterService, userService)).addMapping("/register");
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}