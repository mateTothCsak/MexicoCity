package com.codecool.mexicocity.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mexicocity");

    public static EntityManagerFactory getInstance() {
        return emf;
    }

    private MyEntityManagerFactory() {
    }



    public javax.persistence.EntityManager getEm(){
        return emf.createEntityManager();
    }

}
