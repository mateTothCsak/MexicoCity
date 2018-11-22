package com.codecool.mexicocity.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManager {

    private static MyEntityManager ourInstance = new MyEntityManager();

    public static MyEntityManager getInstance() {
        return ourInstance;
    }

    private MyEntityManager() {
    }


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mexicocity");

    private javax.persistence.EntityManager em = emf.createEntityManager();

    public javax.persistence.EntityManager getEm(){
        return em;
    }

}
