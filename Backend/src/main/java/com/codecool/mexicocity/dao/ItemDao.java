package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Item;

import javax.persistence.EntityManagerFactory;

public class ItemDao extends BaseDao {

    public ItemDao(EntityManagerFactory emf) {
        super(Item.class, emf);
    }

}
