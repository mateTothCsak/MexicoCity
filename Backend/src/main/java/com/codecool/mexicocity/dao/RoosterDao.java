package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Rooster;
import com.codecool.mexicocity.util.TransactionHandler;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.util.List;

public class RoosterDao extends BaseDao {


    public RoosterDao(EntityManagerFactory emf) {
        super(Rooster.class, emf);
    }

}
