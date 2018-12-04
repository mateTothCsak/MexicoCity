package com.codecool.mexicocity;


import com.codecool.mexicocity.controller.IndexController;
import com.codecool.mexicocity.controller.LoggedInMainPageController;
import com.codecool.mexicocity.controller.MyProfileController;
import com.codecool.mexicocity.controller.RegistrationController;
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
        RoosterService roosterService = new RoosterService();
        EntityManagerFactory em = MyEntityManagerFactory.getInstance();
        UserService userService = new UserService();

        ServletContext context = sce.getServletContext();
        context.addServlet("Index", new IndexController()).addMapping("/");
        context.addServlet("LoggedInHome", new LoggedInMainPageController()).addMapping("/home");
        context.addServlet("MyProfile", new MyProfileController()).addMapping("/myprofile");
        context.addServlet("Registration", new RegistrationController(em, roosterService, userService)).addMapping("/register");}


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
