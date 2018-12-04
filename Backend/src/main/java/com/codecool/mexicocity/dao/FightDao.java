package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Fight;
import javax.persistence.EntityManagerFactory;

public class FightDao extends BaseDao {

    public FightDao(EntityManagerFactory emf) {
        super(Fight.class, emf);
    }
}
