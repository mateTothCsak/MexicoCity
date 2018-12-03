package com.codecool.mexicocity;


import com.codecool.mexicocity.controller.RegistrationController;
import com.codecool.mexicocity.service.RoosterService;
import com.codecool.mexicocity.service.UserService;
import com.codecool.mexicocity.util.MyEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Application implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        RoosterService roosterService = new RoosterService();
        EntityManagerFactory em = MyEntityManager.getInstance();
        UserService userService = new UserService();

        ServletContext context = sce.getServletContext();
        context.addServlet("RegistrationController", new RegistrationController(em, roosterService, userService)).addMapping("/register");
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
